## ATG Dynamo Component Browser Controller Scripts

### Installation

These scritps use groovy to run if you have not installed groovy, you can use the [GVMTool](http://gvmtool.net) to install and maintain it.

To install GVM, open your favourite bash terminal and enter the following:


```
curl -s get.gvmtool.net | bash
```

Restart bash, then type:

```
gvm install groovy 2.2.2
```

That's it now you can run the ATG scripts provided here.

### Getting a property value

To get a property from a specific environment, type:

```
./getAtgProperty.groovy -b <brand> -d <environment> -c <component> -p <propertyName>
  -b = Brand
  -d = DC (prod)/Environment (others)
  -c = component to use
  -p property to display
```

Here is a concrete example:

```
./getAtgProperty.groovy -b urban -d philly -c /uo/api/service/SiteApiService -p loggingInfo

Property Listing for urban - philly - loggingInfo - /uo/api/service/SiteApiService

    UOPHLPAPP01-STORE01       10.9.2.120    -> true
    UOPHLPAPP01-STORE02       10.9.2.121    -> true
    UOPHLPAPP01-STORE03       10.9.2.122    -> true
    UOPHLPAPP01-STORE04       10.9.2.123    -> true
    UOPHLPAPP02-STORE01       10.9.2.125    -> true
...
```

### Setting a property value

To set a property in a specific environment, type:

```
./displayAtgProperty.groovy -b <brand> -d <environment> -c <component> -p <propertyName>
  -b = Brand
  -d = DC (prod)/Environment (others)
  -c = component to use
  -p = property to display
```

Here is a concrete example:

```
./displayAtgProperty.groovy -b urban -d philly -c /uo/api/service/SiteApiService -p loggingInfo -n false

Property Listing for urban - philly - /uo/api/service/SiteApiService - loggingInfo

    UOPHLPAPP01-STORE01       10.9.2.120    -> false
    UOPHLPAPP01-STORE02       10.9.2.121    -> false
    UOPHLPAPP01-STORE03       10.9.2.122    -> false
    UOPHLPAPP01-STORE04       10.9.2.123    -> false
    UOPHLPAPP02-STORE01       10.9.2.125    -> false
...
```

### To Invoke an ATG Method

To invoke an ATG Method, type:

```
./invokeAtgMethod.groovy -b <brand> -d <environment> -c <component> -m <methodName>
  -b = Brand
  -d = DC (prod)/Environment (others)
  -c = component to use
  -m = method to be called
```

Here is a concrete example:

```
./invokeAtgMethod.groovy -b urban -d uodev2 -c /atg/userprofiling/ProfileAdapterRepository -m invalidateCaches

Property Listing for urban - philly - /atg/userprofiling/ProfileAdapterRepository - invalidateCaches

    UOPHLPAPP01-STORE01       10.9.2.120    -> 200
    UOPHLPAPP01-STORE02       10.9.2.121    -> 200
    UOPHLPAPP01-STORE03       10.9.2.122    -> 200
    UOPHLPAPP01-STORE04       10.9.2.123    -> 200
    UOPHLPAPP02-STORE01       10.9.2.125    -> 200
...
```


### Conclusion and Contact Info

Hope these scritps help.  If you have any questions or would like to ask for some enhancements please contact me at paul@cp-soft.com

Cheers!

Paul Fortin<br>
Architect Urban Outfitters Inc<br>
Last edited: July 16, 2014 @1:16 PM

