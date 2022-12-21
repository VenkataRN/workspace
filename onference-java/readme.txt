- applicationContext.xml is replaced by @Configuration

- @Configuration is at class level.
- adding @Configuration signifies, this file is for configuration purpose.

- Spring beans defined by @Bean.
- @Bean  at method level and singletons.


-----
Setter Injection in Beans

@Bean(name="customerService")
public Customerervice getCustomerService() {
 CustomerServiceImpl customerService = new CustomerServiceImpl();
 customerService.setCustomerRepository(getCustomerRepository()); //Setter Injection
 return customerService;
}
------
Setter injection and Constructor injection implementaion had some warnings:
/Users/venkat/pluralsight/workspace/onference-java/src/main/java/AppConfig.java
Warning:(9, 14) Application context not configured for this file
/Users/venkat/pluralsight/workspace/onference-java/pom.xml
Warning:(14, 22) Package 'org.springframework:spring-context' can be upgraded to version '6.0.2'

----
