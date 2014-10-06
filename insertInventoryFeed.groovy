#!/usr/bin/env groovy

@GrabConfig(systemClassLoader=true)
@Grab('com.oracle:ojdbc6:11g')

url= "jdbc:oracle:thin:@localhost:1521:LOCALATG"
username = "atg"
password = "localatg"
driver = "oracle.jdbc.driver.OracleDriver"

import groovy.sql.*

sql = Sql.newInstance(url, username, password, driver)
try {
	//sql.eachRow('select sku_id from atg.uoi_stl_inventory'){ row ->
	//    println row
	for(int skuid=0;skuid<5000;skuid++) {
		def date = new Date()
		def sqlTimestamp = date.toTimestamp()
    	sql.execute('insert into UOI_STL_INVENTORY (SKU_ID, STOCK_LEVEL, BACK_ORDER_LEVEL, AVAILABILITY, BACKORDERABLE, SHIPMENT_DATE, INVENTORY_TIME, SITE_ID) values (?,?,?,?,?,?,?,?)', [skuid, 2, 4, 'M', '1', sqlTimestamp, sqlTimestamp, 2])
	}
    //sql.execute("insert into people (firstName, lastName) values (${firstName}, ${lastName})")
}finally {
    sql.close()
}
