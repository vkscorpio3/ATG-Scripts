#!/bin/bash
./set_atg_property.sh /uo/commerce/payment/ISDCreditCardProxy tibcoTimeOutSeconds 14  >/dev/null 2>/dev/null
./set_atg_property.sh /uo/profile/sterling/SterlingProfileProxyServer connectTimeout 4000  >/dev/null 2>/dev/null
./set_atg_property.sh /uo/profile/sterling/SterlingProfileProxyServer readTimeout 10000  >/dev/null 2>/dev/null
./set_atg_property.sh /uo/commerce/pricing/tax/TaxDutyService timeout 3000  >/dev/null 2>/dev/null
./set_atg_property.sh /uo/commerce/order/OrderStatusTools connectTimeout 4000 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/commerce/order/OrderStatusTools readTimeout 10000 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/brand/BrandConfig centinelMinTimeout 5000 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/brand/BrandConfig centinelMaxTimeout 10000 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/commerce/giftcard/ISDGiftCardProxyServer ISDTimeOutSeconds 10 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/brand/BrandConfig qasEnabled true >/dev/null 2>/dev/null
./set_atg_property.sh /uo/search/FredhopperClient retryEnabled true >/dev/null 2>/dev/null
./set_atg_property.sh /uo/search/FredhopperClient readTimeout 2500 >/dev/null 2>/dev/null
./set_atg_property.sh /uo/search/FredhopperClient connectionTimeout 2500 >/dev/null 2>/dev/null
./set_atg_property.sh /atg/dynamo/service/SMTPEmail waitForConnectionMillis 10000 >/dev/null 2>/dev/null