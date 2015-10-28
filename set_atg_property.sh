#!/bin/bash

############
#
#
# set_atg_property.sh
#
#	param1 - component you wish to change
#	param2 - prperty you wish to change
#	param3 - ne wvalue to set
#
# 1. Make sure you set the password for the environment you are changing
# 2. Make sure you set the space delimeted IP address in the @hosts variable for the environment you are changing
#
############
username=admin
password=admin1234
# hosts=(10.11.120.126 10.11.120.127 10.11.120.128 10.11.120.129 10.11.120.132 10.11.120.133 10.11.120.134 10.11.120.135 10.11.120.138 10.11.120.139 10.11.120.140 10.11.120.141 10.11.120.144 10.11.120.145 10.11.120.146 10.11.120.147)
hosts=(localhost)
port=8080
# prop=/dyn/admin/nucleus/uo/brand/BrandConfig/\?propertyName\=wishlistItemsPerPage\&newValue\=50
component=$1
prop=$2
value=$3


for host in "${hosts[@]}"
 do
 curl -u ${username}:${password} http://$host:${port}/dyn/admin/nucleus/${component}/\?propertyName\=${prop}\&newValue\=${value}
#       curl -u ${username}:${password} http://$host:${port}${prop}
 #      curl -u ${username}:${password} http://$host:${port}${prop1}
done
# curl -u admin:anthro1234 http://10.9.2.80:8080/dyn/admin/nucleus/uo/brand/BrandConfig/\?propertyName\=wishlistItemsPerPage\&newValue\=49