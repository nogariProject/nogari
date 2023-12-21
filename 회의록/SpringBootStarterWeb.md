# Spring Boot Starter Web

스프링부트는 스프링을 기반으로 만들어졌으며, 스프링의 모든 특징을 포함. 설정하다 죽는 스프링과 달리 로직에 충실할 수 있도록 빠르게 제품화 될 수 있는 환경을 제공함. 스프링부트는 microservice 기반의 프레임워크. 

- 무겁고 어려운 xml을 피할 수 있음
- 임베디드 *Tomcat-server* 포함
- 개발 또한 쉬움



## Spring Boot Starter Web

**Spring MVC** 기반의 **Restful**한 애플리케이션을 구축할 때 주로 사용. *Tomcat* 이 디폴트 임베디드 컨테이너임.

```xml
<dependency>   
  <groupId>org.springframework.boot</groupId>   
  <artifactId>spring-boot-starter-web</artifactId>   
  <version>2.2.2.RELEASE</version>   
</dependency>
```

`Spring MVC`, `REST`, `Tomcat`을 사용함. 웹 개발과 관련된 모든 dependencies들이 포함되어 있음. 

- org.springframework.boot:spring-boot-starter
- org.springframework.boot:spring-boot-starter-tomcat
- org.springframework.boot:spring-boot-starter-validation
- com.fasterxml.jackson.core:jackson-databind
- org.springframework:spring-web
- org.springframework:spring-webmvc



웹 개발에 필요한 것들을 자동 설정해준다.

- Dispatcher Servlet
- Error Page
- Embedded servlet container



톰캣 말고도 Jetty Server, Undertow Server도 가능하다.

```xml
<dependency> 
        <groupId>org.springframework.boot</groupId> 
        <artifactId>spring-boot-starter-web</artifactId> 
        <exclusions> 
            <exclusion> 
                <groupId>org.springframework.boot</groupId> 
                <artifactId>spring-boot-starter-tomcat</artifactId> 
            </exclusion> 
        </exclusions> 
</dependency>
```

우선, 톰캣을 해당 디펜던시에서 제외하고 아래에 추가한다.



출처 : https://www.geeksforgeeks.org/difference-between-spring-boot-starter-web-and-spring-boot-starter-tomcat/



