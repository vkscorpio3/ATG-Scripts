#!/usr/bin/env groovy
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.5.2' )

/* NAME
 * excuteCommand.groovy
 * 
 * DESCRIPTION  
 * A groovy script for listing the execute component browser commands on the Urban / Anthro production servers
 * 
 * PREREQUISITES
 * * Java installed. Preferably version 6 or higher.
 * * Groovy installed. Preferably version 2 or higher
 * * Internal network access to the production servers
 * * the file 'servers.groovy' in the same directory as this script. It has a groovy 
 *   config slurper formatted set of server ip numbers and credentials to log in to the 
 *   /dyn/admin interface of the production servers. 
 *
 * AUTHOR
 * Paul Fortin
 * pfortin@urbn.com
 * 
 * CREATED
 * 2013.Apr.23
 * 
 * USAGE
 * $ groovy executeCommand.groovy -b urban -c philly
 * $ groovy executeCommand.groovy (will print out command line help)
 *
 */

import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import java.text.SimpleDateFormat
import org.apache.http.*
import org.apache.http.protocol.*

int FIVESECONDS  = 5*1000;
int TENSECONDS   = 10*1000;

def opts = parseCommandLine(args)

// retrieve the full list of servers as a groovy config object
def servers = config('stores.groovy')

def dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss")
def outFile = new File("atg_locks_${dateFormat.format(new Date())}.snapshot")

// select the servers and auth credentials relevant for the command line args passed
def env = servers[opts.brand][opts.dc]

println ""
println "setAtgProperty: ${opts.brand} - ${opts.dc} - ${opts.component} - ${opts.property} - ${opts.newValue}"
println ""

def http = new HTTPBuilder('')
http.getClient().getParams().setParameter("http.connection.timeout", new Integer(FIVESECONDS))
http.getClient().getParams().setParameter("http.socket.timeout", new Integer(TENSECONDS))

// enable sending HTTP Basic auth credentials on first request (as opposed to the normal 
// request-fail-request-again handshake) to prevent error logging in the atg node logs. 
// Note that browsers do generally not do this which means an auth error log every time 
// you refresh a /dyn/admin page in a browser. 
enablePreemptiveAuthentication(http, env.creds)

// Iterate through the servers, print out the rmi server setting
env.servers.each { server ->  

  try {
    http.get(uri: "http://${server.host}:${env.port}", 
               path: "/dyn/admin/nucleus" + "${opts.component}",
               contentType : TEXT,  query: [propertyName: "${opts.property}", newValue: "${opts.newValue}"]) { resp, reader ->
      def host = "(${server.host})"
      println "    ${server.name.padRight(25)} ${server.host.padRight(13)} -> " + reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
    }      
  } catch (IOException e) {
    println "Failed to connect to server ${server.name} at ${server.host}, message: ${e.message}"
  }

}

println ""

// Script exits here 

def config(configFile) {
  new ConfigSlurper().parse(new File(configFile).toURL())  
}

def enablePreemptiveAuthentication(http, creds) {
  //we use both pre-emptive (interceptor) and on-request auth as the pre-emptive sometimes fails
  http.auth.basic creds.username, creds.password  
  http.client.addRequestInterceptor({ HttpRequest httpRequest, HttpContext httpContext ->
    httpRequest.addHeader('Authorization', 'Basic ' + "${creds.username}:${creds.password}".bytes.encodeBase64().toString())
    Thread.sleep(100)
  } as HttpRequestInterceptor)
}

def parseCommandLine(args) {
  def thisScript = new File(getClass().protectionDomain.codeSource.location.toURI()).name
  
  def cli = new CliBuilder(usage: "groovy $thisScript -b <urban|anthro> -d <reno|philly> -c <component> -p <property> -n <newValue>")
  cli.with {
      b longOpt: 'brand', args: 1, argName: "urban|anthro", "The brand to crawl servers for"
      d longOpt: 'dc',  args: 1, argName: "reno|philly", "The DC to crawl servers for."
	  c longOpt: 'component', args: 1, argName: "component", "The component to modify"
	  p longOpt: 'property', args: 1, argName: "property", "The Property to modify"
	  n longOpt: 'newValue', args: 1, argName: "value", "The new Value to set"
      h longOpt: 'help', 'Show usage information'
  }
  
  println ""
  def options = cli.parse(args)

  if (options.h) {
    cli.usage()
    println ""
    System.exit(1)
  }

  if (!options.b)                        failWithMessage(cli, "You need to provide the brand parameter (-b)!")
  if (!options.b in ['urban', 'anthro']) failWithMessage(cli, "Valid values for the brand (-b) switch are 'urban' and 'anthro'!")
  
  if (!options.d)                        failWithMessage(cli, "You need to provide the DC parameter (-d)!")
  if (options.d && 
      !options.d in ['reno', 'philly'])  failWithMessage(cli, "Valid values for the DC switch (-d) are 'reno' and 'philly'")

  if (!options.c)                        failWithMessage(cli, "You need to provide the Component parameter (-c)!")
  if (!options.p)                        failWithMessage(cli, "You need to provide the Property parameter (-p)!")
  if (!options.n)                        failWithMessage(cli, "You need to provide the newValue parameter (-n)!")

  if (!options) {
    println ""
    System.exit(1)
  }
  
  options
}

def failWithMessage(cli, msg) {
  println "ERROR: $msg"
  println ""
  cli.usage()
  println ""
  System.exit(1)    
}
