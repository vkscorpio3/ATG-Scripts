#!/usr/bin/env groovy
@GrabConfig(systemClassLoader=true)
@Grab('com.oracle:ojdbc6:11g')

import groovy.sql.Sql

def AutoState = "AUTO_RESENT_TO_EMS"
println "List of orderIds that are not submitted to EMS yet!"
def status = 'SUBMITTED'
def count = 0;
def listOfIds = []
def sql = null

sql = Sql.newInstance("jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = 10.9.3.15)(PORT = 1531))(LOAD_BALANCE = YES)(CONNECT_DATA = (SERVER = DEDICATED)(SERVICE_NAME = prd_urban_app_svc)(FAILOVER_MODE = (TYPE = SELECT)(METHOD = BASIC)(RETRIES = 180)(DELAY = 5))))", "ATG",
				  "IPY0oE4jZH", "oracle.jdbc.driver.OracleDriver")


sql.eachRow("select submitted_date, order_id, state from dcspp_order where state='SUBMITTED' and submitted_date >= to_date('2014/09/01:01:00:00AM', 'yyyy/mm/dd:hh:mi:ssam')") { 
	println "${++count} - orderId = ${it.order_id}, submittedDate = ${it.submitted_date}"
	//sql.execute("update dcspp_order set state=${AutoState} where state=${status}")
	listOfIds <<  it.order_id
}
println "There are " + listOfIds.size() + " orders in submitted status."

new File("Ids.txt").withWriter { out ->
	listOfIds.each() { 
		out.write("${it},")
	}
}