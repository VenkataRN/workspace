
To create a effective POM file in IntelliJ , Right click on pom.xml file and select Maven-> Generate Effective POM file
which will have all the dependencies are as a standalone are listed here
----
if you see the base code, there is no autowire or beans or components or injections in the java code. All are like POJOs
--
------------------------------------------------------------------------------------------------------------------
                                            Using XML configuration for spring:
------------------------------------------------------------------------------------------------------------------

applicationContext.xml
- root of spring applicatoin
- name is not to be named mandatorily applicationContext.xml (this is just default name)
- we defines objects are name/value  (sort of pair in hashmap). this acts like a Registry
- They are all stored in registry where we can look up
- xML configuration starts with this file.
- namespaces help in configuration/validation

--

add in src/main/java/resources

---
add bean in beans block in xml
---

beans are just classes ..POJOs..
replaces keyword new
replace all new ones in xml configuration need to be thought
Define a class but use interface
it can also have some properties that are related to Bean.
---

Declare Beans in applicationContext.xml accordingly
--
As beans are defined in applicationContext.xml file now we should integrate this in the App
so that it loads applicationcontext xml.



