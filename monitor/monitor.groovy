#!/usr/bin/env groovy

@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' )
@Grab(group='jfree', module='jfreechart', version='1.0.5')
@Grab(group='jfree', module='jcommon', version='1.0.9')

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.data.category.DefaultCategoryDataset
import org.jfree.chart.plot.PlotOrientation as Orientation
import groovy.swing.SwingBuilder
import javax.swing.WindowConstants as WC
import static javax.swing.JFrame.EXIT_ON_CLOSE
import java.util.timer.* 

import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import java.text.SimpleDateFormat
import org.apache.http.*
import org.apache.http.protocol.*


def servers = config('stores.groovy')
def env = servers['anthro']['philly']

def datasetPipe = new DefaultCategoryDataset()
def datasetTax = new DefaultCategoryDataset()
def datasetISD = new DefaultCategoryDataset()
def datasetAlt = new DefaultCategoryDataset()
def datasetFred = new DefaultCategoryDataset()
def datasetSterInv = new DefaultCategoryDataset()
def datasetStorInv = new DefaultCategoryDataset()
def datasetGift = new DefaultCategoryDataset()
def datasetOrdHist = new DefaultCategoryDataset()
def datasetSterPro = new DefaultCategoryDataset()
def datasetCent = new DefaultCategoryDataset()


def labelsPipe = ["OrderPipeline", "DateTime", "TimeSpent (millis)"]
def optionsPipe = [true, true, true]
def labelsTax = ["Tax (Vertex)", "DateTime", "TimeSpent (millis)"]
def optionsTax = [true, true, true]
def labelsISD = ["CC Auth", "DateTime", "TimeSpent (millis)"]
def optionsISD = [true, true, true]
def labelsCent = ["Centinel (Paypal)", "DateTime", "TimeSpent (millis)"]
def optionsCent = [true, true, true]
def labelsAlt = ["Alternate Payments", "DateTime", "TimeSpent (millis)"]
def optionsAlt = [true, true, true]
def labelsFred = ["Fredhopper", "DateTime", "TimeSpent (millis)"]
def optionsFred = [true, true, true]
def labelsSterInv = ["Sterling Inventory", "DateTime", "TimeSpent (millis)"]
def optionsSterInv = [true, true, true]
def labelsStorInv = ["Store Inventory", "DateTime", "TimeSpent (millis)"]
def optionsStorInv = [true, true, true]
def labelsGift = ["ISD Gift Card", "DateTime", "TimeSpent (millis)"]
def optionsGift = [true, true, true]
def labelsOrdHist = ["Order History", "DateTime", "TimeSpent (millis)"]
def optionsOrdHist = [true, true, true]

def chartPipe = ChartFactory.createLineChart(*labelsPipe, datasetPipe,
                Orientation.VERTICAL, *optionsPipe)
chartPipe.removeLegend()
def chartTax = ChartFactory.createLineChart(*labelsTax, datasetTax,
                Orientation.VERTICAL, *optionsTax)
chartTax.removeLegend()
def chartISD = ChartFactory.createLineChart(*labelsISD, datasetISD,
                Orientation.VERTICAL, *optionsISD)
chartISD.removeLegend()
def chartCent = ChartFactory.createLineChart(*labelsCent, datasetCent,
                Orientation.VERTICAL, *optionsCent)
chartCent.removeLegend()
def chartAlt = ChartFactory.createLineChart(*labelsAlt, datasetAlt,
                Orientation.VERTICAL, *optionsAlt)
chartAlt.removeLegend()
def chartFred = ChartFactory.createLineChart(*labelsFred, datasetFred,
                Orientation.VERTICAL, *optionsFred)
chartFred.removeLegend()
def chartSterInv = ChartFactory.createLineChart(*labelsSterInv, datasetSterInv,
                Orientation.VERTICAL, *optionsSterInv)
chartSterInv.removeLegend()
def chartStorInv = ChartFactory.createLineChart(*labelsStorInv, datasetStorInv,
                Orientation.VERTICAL, *optionsStorInv)
chartStorInv.removeLegend()
def chartGift = ChartFactory.createLineChart(*labelsGift, datasetGift,
                Orientation.VERTICAL, *optionsGift)
chartGift.removeLegend()
def chartOrdHist = ChartFactory.createLineChart(*labelsOrdHist, datasetOrdHist,
                Orientation.VERTICAL, *optionsOrdHist)
chartOrdHist.removeLegend()

SwingBuilder.build {  
   frame( title: "${env.name} Site(s) Performance", pack: true, show: true,  
          defaultCloseOperation: EXIT_ON_CLOSE ) {  
        gridLayout(cols: 1, rows: 3 ) 
        widget(new ChartPanel(chartPipe))  
        widget(new ChartPanel(chartTax))
        widget(new ChartPanel(chartISD))
        widget(new ChartPanel(chartCent))
        widget(new ChartPanel(chartAlt))
        widget(new ChartPanel(chartFred))
        widget(new ChartPanel(chartSterInv))  
        widget(new ChartPanel(chartStorInv))
        widget(new ChartPanel(chartGift))  
        widget(new ChartPanel(chartOrdHist))
   }  
}
/*
def swing = new SwingBuilder()
def frame = swing.frame(title:'UO Site Performance',
        defaultCloseOperation:WC.EXIT_ON_CLOSE) {
    panel(id:'canvas') { widget(new ChartPanel(chart)) }
}
frame.pack()
frame.show() */

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
            http.get(uri: "http://${server.host}:8080", 
                       path: "/dyn/admin/nucleus" + "/uo/commerce/integrations/CartIntegrationService",
                       contentType : TEXT,  query: [propertyName: "averageProcessingTime"]) { resp, reader ->
                retValue = reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
                datasetPipe.addValue(retValue.toDouble(), server.name, count)
                if(count > 10) {
                    datasetPipe.removeColumn(count-10)
                }
            } 
	        http.get(uri: "http://${server.host}:8080", 
	                   path: "/dyn/admin/nucleus" + "/uo/commerce/pricing/tax/TaxDutyServerProxy",
	                   contentType : TEXT,  query: [propertyName: "averageProcessingTime"]) { resp, reader ->
	        	retValue = reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
	        	datasetTax.addValue(retValue.toDouble(), server.name, count)
	        	if(count > 10) {
	        		datasetTax.removeColumn(count-10)
	        	}
	        }   
            http.get(uri: "http://${server.host}:8080", 
                       path: "/dyn/admin/nucleus" + "/uo/commerce/payment/ISDCreditCardProxy",
                       contentType : TEXT,  query: [propertyName: "averageProcessingTime"]) { resp, reader ->
                retValue = reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
                datasetISD.addValue(retValue.toDouble(), server.name, count)
                if(count > 10) {
                    datasetISD.removeColumn(count-10)
                }
            }  
            http.get(uri: "http://${server.host}:8080", 
                       path: "/dyn/admin/nucleus" + "/uo/commerce/order/CentinelServerProxy",
                       contentType : TEXT,  query: [propertyName: "averageProcessingTime"]) { resp, reader ->
                retValue = reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
                datasetCent.addValue(retValue.toDouble(), server.name, count)
                if(count > 10) {
                    datasetCent.removeColumn(count-10)
                }
            } 
            http.get(uri: "http://${server.host}:8080", 
                       path: "/dyn/admin/nucleus" + "/uo/services/worldpay/AlternatePaymentProxyService",
                       contentType : TEXT,  query: [propertyName: "averageProcessingTime"]) { resp, reader ->
                retValue = reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
                datasetAlt.addValue(retValue.toDouble(), server.name, count)
                if(count > 10) {
                    datasetAlt.removeColumn(count-10)
                }
            } 
            http.get(uri: "http://${server.host}:8080", 
                       path: "/dyn/admin/nucleus" + "/uo/search/FredhopperClient",
                       contentType : TEXT,  query: [propertyName: "averageProcessingTime"]) { resp, reader ->
                retValue = reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
                datasetFred.addValue(retValue.toDouble(), server.name, count)
                if(count > 10) {
                    datasetFred.removeColumn(count-10)
                }
            } 
            http.get(uri: "http://${server.host}:8080", 
                       path: "/dyn/admin/nucleus" + "/uo/commerce/inventory/SterlingInventoryReservationService",
                       contentType : TEXT,  query: [propertyName: "averageProcessingTime"]) { resp, reader ->
                retValue = reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
                datasetSterInv.addValue(retValue.toDouble(), server.name, count)
                if(count > 10) {
                    datasetSterInv.removeColumn(count-10)
                }
            }  
            http.get(uri: "http://${server.host}:8080", 
                       path: "/dyn/admin/nucleus" + "/uo/commerce/services/StoreInventoryService",
                       contentType : TEXT,  query: [propertyName: "averageProcessingTime"]) { resp, reader ->
                retValue = reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
                datasetStorInv.addValue(retValue.toDouble(), server.name, count)
                if(count > 10) {
                    datasetStorInv.removeColumn(count-10)
                }
            }   
            http.get(uri: "http://${server.host}:8080", 
                       path: "/dyn/admin/nucleus" + "/uo/commerce/giftcard/ISDGiftCardProxyServer",
                       contentType : TEXT,  query: [propertyName: "averageProcessingTime"]) { resp, reader ->
                retValue = reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
                datasetGift.addValue(retValue.toDouble(), server.name, count)
                if(count > 10) {
                    datasetGift.removeColumn(count-10)
                }
            }  
            http.get(uri: "http://${server.host}:8080", 
                       path: "/dyn/admin/nucleus" + "/uo/commerce/order/OrderStatusTools",
                       contentType : TEXT,  query: [propertyName: "averageProcessingTime"]) { resp, reader ->
                retValue = reader.text.readLines().find { it.contains('white-space:pre') }[30..-8]
                datasetOrdHist.addValue(retValue.toDouble(), server.name, count)
                if(count > 10) {
                    datasetOrdHist.removeColumn(count-10)
                }
            }   
	    } catch (IOException e) {
	    }
	}
} as TimerTask, 0, 30*1000) //magic numbers are initial-delay & repeat-interval 

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

