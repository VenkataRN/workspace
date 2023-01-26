# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.8/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.8/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.8/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)



TODO:
@JsonIgnore (Added to avoid nested infinite - details in Speaker.java)
Serialization
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  * The above is added (What is the bytecode error - In this project I did not get..but in presenters demo it has come , and he added to avoid that)
  * Presenter got an error mentioning 
    * "org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor" nested exception
    * No Serializer found for class and no properties discovered to create Bean Serializer 
    * (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS