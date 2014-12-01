/*
 * Description
 * This file contains a list of server host names (only used for display) 
 * ip addresses, /dyn/admin credentials and information on whether a specific
 * server is a lock manager. The File is used by various production analysis scripts 
 * contained in this directory. 
 *
 */

urban { 
  uodev1 {
    creds { 
      username = 'admin'
      password = 'admin1234' //new String(System.console().readPassword("/dyn/admin password: "))
    }
     
    port = 8080    
    servers  = [
      [name: 'APP01-STORE01',       host: '10.9.8.27', lockClient: true],
      [name: 'APP01-STORE02',       host: '10.9.8.28', lockClient: true],
    ]
  }

  uodev2 {
    creds { 
      username = 'admin'
      password = 'admin1234' //new String(System.console().readPassword("/dyn/admin password: "))
    }
     
    port = 8080    
    servers  = [
      [name: 'APP01-STORE01',       host: '10.9.8.40', lockClient: true],
      [name: 'APP01-STORE02',       host: '10.9.8.41', lockClient: true],
    ]
  }

  uostage1 {
    creds { 
      username = 'admin'
      password = 'admin1234' //new String(System.console().readPassword("/dyn/admin password: "))
    }
     
    port = 8080    
    servers  = [
      [name: 'APP01-STORE01',       host: '10.11.120.32', lockClient: true],
      [name: 'APP01-STORE02',       host: '10.11.120.33', lockClient: true],
    ]
  }


  philly {
    creds { 
      username = 'admin'
      password = 'urban1234' //new String(System.console().readPassword("/dyn/admin password: "))
    }
     
    port = 8080    
    servers  = [
      [name: 'UOPHLPAPP01-STORE01',       host: '10.9.2.120', lockClient: true],
      [name: 'UOPHLPAPP01-STORE02',       host: '10.9.2.121', lockClient: true],
      [name: 'UOPHLPAPP01-STORE03',       host: '10.9.2.122', lockClient: true],
      [name: 'UOPHLPAPP01-STORE04',       host: '10.9.2.123', lockClient: true],

      [name: 'UOPHLPAPP02-STORE01',       host: '10.9.2.125', lockClient: true],
      [name: 'UOPHLPAPP02-STORE02',       host: '10.9.2.126', lockClient: true],
      [name: 'UOPHLPAPP02-STORE03',       host: '10.9.2.127', lockClient: true],
      [name: 'UOPHLPAPP02-STORE04',       host: '10.9.2.128', lockClient: true],

      [name: 'UOPHLPAPP03-STORE01',       host: '10.9.2.50',  lockClient: true],
      [name: 'UOPHLPAPP03-STORE02',       host: '10.9.2.51',  lockClient: true],
      [name: 'UOPHLPAPP03-STORE03',       host: '10.9.2.52',  lockClient: true],
      [name: 'UOPHLPAPP03-STORE04',       host: '10.9.2.53',  lockClient: true],

      [name: 'UOPHLPAPP04-STORE01',       host: '10.9.2.55',  lockClient: true],
      [name: 'UOPHLPAPP04-STORE02',       host: '10.9.2.56',  lockClient: true],
      [name: 'UOPHLPAPP04-STORE03',       host: '10.9.2.57',  lockClient: true],
      [name: 'UOPHLPAPP04-STORE04',       host: '10.9.2.58',  lockClient: true],

      [name: 'UOPHLPAPP06-STORE01',       host: '10.9.2.65',  lockClient: true],
      [name: 'UOPHLPAPP06-STORE02',       host: '10.9.2.66',  lockClient: true],
      [name: 'UOPHLPAPP06-STORE03',       host: '10.9.2.67',  lockClient: true],
      [name: 'UOPHLPAPP06-STORE04',       host: '10.9.2.68',  lockClient: true],

      [name: 'SHPHLPAPP01-UOSTORE01',       host: '10.9.3.11',  lockClient: true],
      [name: 'SHPHLPAPP01-UOSTORE02',       host: '10.9.3.12',  lockClient: true],
      [name: 'SHPHLPAPP01-UOSTORE03',       host: '10.9.3.13',  lockClient: true],
      [name: 'SHPHLPAPP01-UOSTORE04',       host: '10.9.3.14',  lockClient: true],

      [name: 'SHPHLPAPP02-UOSTORE01',       host: '10.9.3.21',  lockClient: true],
      [name: 'SHPHLPAPP02-UOSTORE02',       host: '10.9.3.22',  lockClient: true],
      [name: 'SHPHLPAPP02-UOSTORE03',       host: '10.9.3.23',  lockClient: true],
      [name: 'SHPHLPAPP02-UOSTORE04',       host: '10.9.3.24',  lockClient: true],

      [name: 'SHPHLPAPP03-UOSTORE01',       host: '10.9.3.31',  lockClient: true],
      [name: 'SHPHLPAPP03-UOSTORE02',       host: '10.9.3.32',  lockClient: true],
      [name: 'SHPHLPAPP03-UOSTORE03',       host: '10.9.3.33',  lockClient: true],
      [name: 'SHPHLPAPP03-UOSTORE04',       host: '10.9.3.34',  lockClient: true],

      [name: 'SHPHLPAPP04-UOSTORE01',       host: '10.9.3.41',  lockClient: true],
      [name: 'SHPHLPAPP04-UOSTORE02',       host: '10.9.3.42',  lockClient: true],
      [name: 'SHPHLPAPP04-UOSTORE03',       host: '10.9.3.43',  lockClient: true],
      [name: 'SHPHLPAPP04-UOSTORE04',       host: '10.9.3.44',  lockClient: true],
    ]
  }

  phillyeu {
    creds { 
      username = 'admin'
      password = 'urban1234' //new String(System.console().readPassword("/dyn/admin password: "))
    }
     
    port = 8080    
    servers  = [
      [name: 'UOPHLPEUAPP01-STORE01',       host: '10.9.2.235', lockClient: true],
      [name: 'UOPHLPEUAPP01-STORE02',       host: '10.9.2.236', lockClient: true],
      [name: 'UOPHLPEUAPP01-STORE03',       host: '10.9.2.243', lockClient: true],
      [name: 'UOPHLPEUAPP01-STORE04',       host: '10.9.2.233', lockClient: true],

      [name: 'UOPHLPEUAPP02-STORE01',       host: '10.9.2.238', lockClient: true],
      [name: 'UOPHLPEUAPP02-STORE02',       host: '10.9.2.239', lockClient: true],
      [name: 'UOPHLPEUAPP02-STORE03',       host: '10.9.2.160', lockClient: true],
      [name: 'UOPHLPEUAPP02-STORE04',       host: '10.9.2.161', lockClient: true],
    ]    
  }

  reno {
    creds { 
      username = 'admin'
      password = 'urban1234'
    }

    port = 8080    
    servers  = [
      [name: 'APP01-STORE01',             host: '10.11.120.126', lockClient: true],
      [name: 'APP01-STORE02',             host: '10.11.120.127', lockClient: true],
      [name: 'APP01-STORE03',             host: '10.11.120.128', lockClient: true],
      [name: 'APP01-STORE04',             host: '10.11.120.129', lockClient: true],

      [name: 'APP02-STORE01',             host: '10.11.120.132', lockClient: true],
      [name: 'APP02-STORE02',             host: '10.11.120.133', lockClient: true],
      [name: 'APP02-STORE03',             host: '10.11.120.134', lockClient: true],
      [name: 'APP02-STORE04',             host: '10.11.120.135', lockClient: true],

      [name: 'APP03-STORE01',             host: '10.11.120.138', lockClient: true],
      [name: 'APP03-STORE02',             host: '10.11.120.139', lockClient: true],
      [name: 'APP03-STORE03',             host: '10.11.120.140', lockClient: true],
      [name: 'APP03-STORE04',             host: '10.11.120.141', lockClient: true],

      [name: 'APP04-STORE01',             host: '10.11.120.144', lockClient: true],
      [name: 'APP04-STORE02',             host: '10.11.120.145', lockClient: true],
      [name: 'APP04-STORE03',             host: '10.11.120.146', lockClient: true],
      [name: 'APP04-STORE04',             host: '10.11.120.147', lockClient: true],

      [name: 'SHRNOPAPP01-UOSTORE01',             host: '10.11.120.11', lockClient: true],
      [name: 'SHRNOPAPP01-UOSTORE02',             host: '10.11.120.12', lockClient: true],
      [name: 'SHRNOPAPP01-UOSTORE03',             host: '10.11.120.13', lockClient: true],
      [name: 'SHRNOPAPP01-UOSTORE04',             host: '10.11.120.14', lockClient: true],

      [name: 'SHRNOPAPP02-UOSTORE01',             host: '10.11.120.41', lockClient: true],
      [name: 'SHRNOPAPP02-UOSTORE02',             host: '10.11.120.42', lockClient: true],
      [name: 'SHRNOPAPP02-UOSTORE03',             host: '10.11.120.43', lockClient: true],
      [name: 'SHRNOPAPP02-UOSTORE04',             host: '10.11.120.44', lockClient: true],

      [name: 'SHRNOPAPP03-UOSTORE01',             host: '10.11.120.211', lockClient: true],
      [name: 'SHRNOPAPP03-UOSTORE02',             host: '10.11.120.212', lockClient: true],
      [name: 'SHRNOPAPP03-UOSTORE03',             host: '10.11.120.213', lockClient: true],
      [name: 'SHRNOPAPP03-UOSTORE04',             host: '10.11.120.214', lockClient: true],

      [name: 'SHRNOPAPP04-UOSTORE01',             host: '10.11.120.231', lockClient: true],
      [name: 'SHRNOPAPP04-UOSTORE02',             host: '10.11.120.232', lockClient: true],
      [name: 'SHRNOPAPP04-UOSTORE03',             host: '10.11.120.233', lockClient: true],
      [name: 'SHRNOPAPP04-UOSTORE04',             host: '10.11.120.234', lockClient: true],
    ]
  }
}

anthro { 
  andev1 {
    creds { 
      username = 'admin'
      password = 'admin' //new String(System.console().readPassword("/dyn/admin password: "))
    }
     
    port = 8080    
    servers  = [
      [name: 'APP01-STORE01',       host: '10.9.8.33', lockClient: true],
      [name: 'APP01-STORE02',       host: '10.9.8.34', lockClient: true],
    ]
  }

  andev2 {
    creds { 
      username = 'admin'
      password = 'admin123' //new String(System.console().readPassword("/dyn/admin password: "))
    }
     
    port = 8080    
    servers  = [
      [name: 'APP01-STORE01',       host: '10.9.8.122', lockClient: true],
      [name: 'APP01-STORE02',       host: '10.9.8.123', lockClient: true],
    ]
  }

  anstage1 {
    creds { 
      username = 'admin'
      password = 'anthro123' //new String(System.console().readPassword("/dyn/admin password: "))
    }
     
    port = 8080    
    servers  = [
      [name: 'APP01-STORE01',       host: '10.11.120.61', lockClient: true],
    ]
  }

  aneustage1 {
    creds { 
      username = 'admin'
      password = 'anthro123' //new String(System.console().readPassword("/dyn/admin password: "))
    }
     
    port = 8080    
    servers  = [
      [name: 'APP01-STORE01',       host: '10.11.120.171', lockClient: true],
    ]
  }

  reno {
    creds { 
      username = 'admin'
      password = 'anthro1234'
    }

    port = 8080    
    servers  = [
      [name: "APP01-STORE01",             host: "10.11.120.174", lockClient: true],
      [name: "APP01-STORE02",             host: "10.11.120.175", lockClient: true],
      [name: "APP01-STORE03",             host: "10.11.120.176", lockClient: true],
      [name: "APP01-STORE04",             host: "10.11.120.177", lockClient: true],

      [name: "APP02-STORE01",             host: "10.11.120.180", lockClient: true],
      [name: "APP02-STORE02",             host: "10.11.120.181", lockClient: true],
      [name: "APP02-STORE03",             host: "10.11.120.182", lockClient: true],
      [name: "APP02-STORE04",             host: "10.11.120.183", lockClient: true],

      [name: "APP03-STORE01",             host: "10.11.120.186", lockClient: true],
      [name: "APP03-STORE02",             host: "10.11.120.187", lockClient: true],
      [name: "APP03-STORE03",             host: "10.11.120.188", lockClient: true],
      [name: "APP03-STORE04",             host: "10.11.120.189", lockClient: true],

      [name: "APP04-STORE01",             host: "10.11.120.192", lockClient: true],
      [name: "APP04-STORE02",             host: "10.11.120.193", lockClient: true],
      [name: "APP04-STORE03",             host: "10.11.120.194", lockClient: true],
      [name: "APP04-STORE04",             host: "10.11.120.195", lockClient: true],

      [name: "SHRNOPAPP01-ANSTORE01",             host: "10.11.120.15", lockClient: true],
      [name: "SHRNOPAPP01-ANSTORE02",             host: "10.11.120.16", lockClient: true],
      [name: "SHRNOPAPP01-ANSTORE03",             host: "10.11.120.17", lockClient: true],
      [name: "SHRNOPAPP01-ANSTORE04",             host: "10.11.120.18", lockClient: true],

      [name: "SHRNOPAPP02-ANSTORE01",             host: "10.11.120.45", lockClient: true],
      [name: "SHRNOPAPP02-ANSTORE02",             host: "10.11.120.46", lockClient: true],
      [name: "SHRNOPAPP02-ANSTORE03",             host: "10.11.120.47", lockClient: true],
      [name: "SHRNOPAPP02-ANSTORE04",             host: "10.11.120.48", lockClient: true],

      [name: "SHRNOPAPP03-ANSTORE01",             host: "10.11.120.215", lockClient: true],
      [name: "SHRNOPAPP03-ANSTORE02",             host: "10.11.120.216", lockClient: true],
      [name: "SHRNOPAPP03-ANSTORE03",             host: "10.11.120.217", lockClient: true],
      [name: "SHRNOPAPP03-ANSTORE04",             host: "10.11.120.218", lockClient: true],

      [name: "SHRNOPAPP04-ANSTORE01",             host: "10.11.120.235", lockClient: true],
      [name: "SHRNOPAPP04-ANSTORE02",             host: "10.11.120.236", lockClient: true],
      [name: "SHRNOPAPP04-ANSTORE03",             host: "10.11.120.237", lockClient: true],
      [name: "SHRNOPAPP04-ANSTORE04",             host: "10.11.120.238", lockClient: true],
    ]
  }

  philly {
    creds {
      username = 'admin'
      password = 'anthro1234'      
    }

    port = 8080    
    servers = [
      //[name: "ANPHLPAPP01",               host: "10.9.2.11", lockClient: true]
      [name: "ANPHLPAPP01-STORE01",       host: "10.9.2.80", lockClient: true],
      [name: "ANPHLPAPP01-STORE02",       host: "10.9.2.81", lockClient: true],
      [name: "ANPHLPAPP01-STORE03",       host: "10.9.2.82", lockClient: true],
      [name: "ANPHLPAPP01-STORE04",       host: "10.9.2.83", lockClient: true],
      //[name: "ANPHLPAPP02",             host: "10.9.2.12", lockClient: true],
      [name: "ANPHLPAPP02-STORE01",       host: "10.9.2.85", lockClient: true],
      [name: "ANPHLPAPP02-STORE02",       host: "10.9.2.86", lockClient: true],
      [name: "ANPHLPAPP02-STORE03",       host: "10.9.2.87", lockClient: true],
      [name: "ANPHLPAPP02-STORE03",       host: "10.9.2.88", lockClient: true],
      //[name: "ANPHLPAPP03",             host: "10.9.2.13", lockClient: true],
      [name: "ANPHLPAPP03-STORE01",       host: "10.9.2.90", lockClient: true],
      [name: "ANPHLPAPP03-STORE02",       host: "10.9.2.91", lockClient: true],
      [name: "ANPHLPAPP03-STORE03",       host: "10.9.2.92", lockClient: true],
      [name: "ANPHLPAPP03-STORE04",       host: "10.9.2.93", lockClient: true],
      //[name: "ANPHLPAPP04",             host: "10.9.2.14", lockClient: true],
      [name: "ANPHLPAPP04-STORE01",       host: "10.9.2.95", lockClient: true],
      [name: "ANPHLPAPP04-STORE02",       host: "10.9.2.96", lockClient: true],
      [name: "ANPHLPAPP04-STORE03",       host: "10.9.2.97", lockClient: true],
      [name: "ANPHLPAPP04-STORE04",       host: "10.9.2.98", lockClient: true],

      [name: 'SHPHLPAPP01-ANSTORE01',       host: '10.9.3.15',  lockClient: true],
      [name: 'SHPHLPAPP01-ANSTORE02',       host: '10.9.3.16',  lockClient: true],
      [name: 'SHPHLPAPP01-ANSTORE03',       host: '10.9.3.17',  lockClient: true],
      [name: 'SHPHLPAPP01-ANSTORE04',       host: '10.9.3.18',  lockClient: true],

      [name: 'SHPHLPAPP02-ANSTORE01',       host: '10.9.3.25',  lockClient: true],
      [name: 'SHPHLPAPP02-ANSTORE02',       host: '10.9.3.26',  lockClient: true],
      [name: 'SHPHLPAPP02-ANSTORE03',       host: '10.9.3.27',  lockClient: true],
      [name: 'SHPHLPAPP02-ANSTORE04',       host: '10.9.3.28',  lockClient: true],

      [name: 'SHPHLPAPP03-ANSTORE01',       host: '10.9.3.35',  lockClient: true],
      [name: 'SHPHLPAPP03-ANSTORE02',       host: '10.9.3.36',  lockClient: true],
      [name: 'SHPHLPAPP03-ANSTORE03',       host: '10.9.3.37',  lockClient: true],
      [name: 'SHPHLPAPP03-ANSTORE04',       host: '10.9.3.38',  lockClient: true],

      [name: 'SHPHLPAPP04-ANSTORE01',       host: '10.9.3.45',  lockClient: true],
      [name: 'SHPHLPAPP04-ANSTORE02',       host: '10.9.3.46',  lockClient: true],
      [name: 'SHPHLPAPP04-ANSTORE03',       host: '10.9.3.47',  lockClient: true],
      [name: 'SHPHLPAPP04-ANSTORE04',       host: '10.9.3.48',  lockClient: true],
    ]
  }

  phillyeu {
    creds {
      username = 'admin'
      password = 'anthro1234'      
    }

    port = 8080    
    servers = [
      //[name: "ANPHLPAPP01",               host: "10.9.2.11", lockClient: true]
      [name: "ANPHLPEUAPP01-STORE01",       host: "10.9.2.100", lockClient: true],
      [name: "ANPHLPEUAPP01-STORE02",       host: "10.9.2.101", lockClient: true],
      [name: "ANPHLPEUAPP02-STORE01",       host: "10.9.2.104", lockClient: true],
      [name: "ANPHLPEUAPP02-STORE02",       host: "10.9.2.105", lockClient: true],
    ]
  }
}