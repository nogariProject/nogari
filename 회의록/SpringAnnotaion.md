# Spring Annotation - 설정편

![SpringBootApplication_annotation](https://media.geeksforgeeks.org/wp-content/uploads/20220127044052/SpringBoorAnnotation.jpg)
<br>
## @SpringBootApplication

스프링 부트 애플리케이션의 메인클래스에 사용. ***\*@SpringBootConfiguration\****, ***\*@EnableAutoConfiguration\****, ***\*@ComponentScan\**** 을 내장하고 있음.

<br><br>

### @SpringBootConnfiguration

Class 레벨의 스프링부트 프레임워크의 애노테이션. 이 애노테이션이 붙은 클래스는 스프링부트 애플리케이션의 설정정보를 제공하겠구나~ 하고 알 수 있다. 이 애노테이션은 스프링의 설정 기본 애노테이션인 ***\*@Configuration\**** 을 대체하여 사용할 수 있음. 


<br>

### @EnableAutoConfiguration

클래스패스(프로젝트의 최상단 위치)에 있는 beans의 스프링부트의 자동설정 애노테이션. 예를 들면, 우리가 `spring-boot-starter-web` dependency를 *pom.xml* 에 쓸 경우, 스프링부트는 자동으로 ***Tomcat***, ***Spring MVC***를 자동 설정. 이 애노테이션이 명시된 클래스의 패키지는 default 파일로 여겨짐. 따라서 해당 애노테이션은 root 패키지에 사용해야 그 하위의 패키지들까지 그 설정이 널리 적용됨.

<br>

### @ComponentScan

스프링에게 관리해야될 클래스들을 관리해야하는지 말해주는 애노테이션. 예를들어 *@Controller* 가 달린 클래스만 있다고 하여 스프링이 해당 클래스를 스프링 컨테이너로서 사용할 수 있는 것은 아님. 이 ***@ComponentScan***이 있어야 스프링이 설정/컨트롤러/서비스/기타 컴포턴트들을 스캔하여 제 기능을 할 수 있도록 하는 것. 일반적으로 해당 애노테이션은 *@Configuration* 과 함께 사용되며, 스프링이 컴포넌트들을 찾을 수 있게 명시해준다. 


<br>
출처 : https://www.geeksforgeeks.org/spring-boot-annotations/
