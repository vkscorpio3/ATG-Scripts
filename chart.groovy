#!/usr/bin/env groovy
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' )
@Grab(group='jfree', module='jfreechart', version='1.0.5')
@Grab(group='jfree', module='jcommon', version='1.0.9')

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.data.category.DefaultCategoryDataset
import org.jfree.chart.plot.PlotOrientation as Orientation
import org.jfree.chart.plot.XYPlot
import org.jfree.util.ShapeUtilities
import org.jfree.chart.renderer.xy.XYItemRenderer
import java.awt.Shape
import groovy.swing.SwingBuilder
import javax.swing.WindowConstants as WC
import java.util.timer.* 

import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import java.text.SimpleDateFormat
import org.apache.http.*
import org.apache.http.protocol.*

def servers = config('stores.groovy')
def env = servers['urban']['philly']
def dataset = new DefaultCategoryDataset()
/*
dataset.addValue(2620.0, "UOPHLPAPP01-STORE04", "Time 1")
dataset.addValue(2620.0, "UOPHLPAPP01-STORE04", "Time 2")
dataset.addValue(2620.0, "UOPHLPAPP01-STORE04", "Time 3")
dataset.with{
    addValue 2620.0, "UOPHLPAPP01-STORE01", "Time 1"
    addValue 2476.0, "UOPHLPAPP01-STORE01", "Time 2"
    addValue 2408.0, "UOPHLPAPP01-STORE01", "Time 3"
    addValue 3571.0, "UOPHLPAPP01-STORE02", "Time 1"
    addValue 3571.0, "UOPHLPAPP01-STORE02", "Time 2"
    addValue 3571.0, "UOPHLPAPP01-STORE02", "Time 3"
    addValue 1892.0, "UOPHLPAPP01-STORE03", "Time 1"
    addValue 2829.0, "UOPHLPAPP01-STORE03", "Time 2"
    addValue 2829.0, "UOPHLPAPP01-STORE03", "Time 3"
} */


def labels = ["OrderPipeline Performance", "DateTime", "TimeSpent (millis)"]
def options = [true, true, true]
def chart = ChartFactory.createLineChart(*labels, dataset,
                Orientation.VERTICAL, *options)

def swing = new SwingBuilder()
def frame = swing.frame(title:'UO Site Performance',
        defaultCloseOperation:WC.EXIT_ON_CLOSE) {
    panel(id:'canvas') { widget(new ChartPanel(chart)) }
}
frame.pack()
frame.show()

def count = 0
def data = 0
def http = new HTTPBuilder('')
http.getClient().getParams().setParameter("http.connection.timeout", 5000)
http.getClient().getParams().setParameter("http.socket.timeout", 5000)
enablePreemptiveAuthentication(http, env.creds)
new Timer().schedule({
	count++;
	retValue = 0
	env.servers.each { server ->  
		try {
			println server.name + "/" + server.host
	        http.get(uri: "http://${server.host}:8080", 
	                   path: "/dyn/admin/nucleus" + "/uo/memcached/springapi/ApiMemcachedCacheAdapter",
	                   contentType : TEXT,  query: [propertyName: "hitRatio"]) { resp, reader ->
	        	retValue = reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
	        	dataset.addValue(retValue.toDouble(), server.name, count)
	        	if(count > 10) {
	        		dataset.removeColumn(count-10)
	        	}
	        }    
	    } catch (IOException e) {
	    }
	}
} as TimerTask, 0, 30000) //magic numbers are initial-delay & repeat-interval 

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

