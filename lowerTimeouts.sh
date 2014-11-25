#!/bin/bash
./set_atg_property.sh /uo/commerce/payment/ISDCreditCardProxy tibcoTimeOutSeconds 1  >/dev/null 2>/dev/null
./set_atg_property.sh /uo/profile/sterling/SterlingProfileProxyServer connectTimeout 100  >/dev/null 2>/dev/null
./set_atg_property.sh /uo/profile/sterling/SterlingProfileProxyServer readTimeout 100  >/dev/null 2>/dev/null
./set_atg_property.sh /uo/commerce/pricing/tax/TaxDutyService timeout 50  >/dev/null 2>/dev/null
./set_atg_property.sh /uo/commerce/order/OrderStatusTools connectTimeout 100 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/commerce/order/OrderStatusTools readTimeout 100 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/brand/BrandConfig centinelMinTimeout 100 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/brand/BrandConfig centinelMaxTimeout 101 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/commerce/giftcard/ISDGiftCardProxyServer ISDTimeOutSeconds 1 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/brand/BrandConfig qasEnabled false >/dev/null 2>/dev/null
./set_atg_property.sh /uo/search/FredhopperClient retryEnabled false >/dev/null 2>/dev/null
./set_atg_property.sh /uo/search/FredhopperClient readTimeout 1000 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/search/FredhopperClient connectionTimeout 1000 >/dev/null 2>/dev/null
./set_atg_property.sh /atg/dynamo/service/SMTPEmail waitForConnectionMillis 1000 >/dev/null 2>/dev/null