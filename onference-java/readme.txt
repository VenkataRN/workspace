- applicationContext.xml is replaced by @Configuration

- @Configuration is at class level.
- adding @Configuration signifies, this file is for configuration purpose.

- Spring beans defined by @Bean.
- @Bean  at method level.


-----
Setter Injection in Beans

@Bean(name="customerService")
public Customerervice getCustomerService() {
 CustomerServiceImpl customerService = new CustomerServiceImpl();
 customerService.setCustomerRepository(getCustomerRepository()); //Setter Injection
 return customerService;
}
------
