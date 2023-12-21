# Request Handling and Controller Annotation
<br>

## @Controller

**Spring MVC** 를 이용할 수 있게 하는 애노테이션. 컨트롤러 클래스를 만들어주고, 동시에 HTTP요청을 처리할 수 있음. 
일반적으로 **@Controller**나 **@RequestMapping** 을 사용해서 컨트롤러 클래스 안에 HTTP요청을 매핑 처리함.

<br>

## @RestController = *@Controller + @ResponseBody*

**REST API** (GET, PUT, POST, DELETE, 기타) 처리할 때 사용. 스프링 MVC를 사용한 웹서비스를 RESTful하게 만들 때 사용. 

<br>

## @ResquestMapping

- @GetMapping
- @PutMapping
- @PostMapping
- @PatchMapping
- @DeleteMapping

<br>

## @RequestParam

특정 컨트롤러 메서드의 request의 파라미터로 달려오는 데이터를 읽을 때 사용

```java
@RestController
public class MyController {
  @GetMapping("/authors")
  public String getAuthors(@RequestParam(name="authorName") String name) {
    // insert code here
  }
}
```


<br>


## @PathVariable

URL template의 path variable(경로 변수)를 추출할 때 사용.

```java
@RestController
public class MyController {
  @GetMapping("/author/{authorName}")
  public String getAuthor(@PathVariable(name="authorName") String name) {
    // insert code here
  }
}
```

<br>

## @RequestBody

Http 들어오는 요청이 **JSON** 포맷을 우리가 사용하는 도메인 객체(예를들면, UserDao)로 변환할 때 사용.

```java
@RestController
public class MyController {
  @GetMapping("/author")
  public String getAuthor(@RequestBody Author author) {
    // JSON으로 들어오는 데이터를 우리가 사용하는 Author 객체로 변환하여 가져옴
  }
}
```
<br>


## @ResponseBody

`@RequestBody`와 반대로 우리가 만든 객체를 JSON형태나 다른 text로 변환하여 HTTP response body에 리턴.

```java
//@RestController = @Controller + @ResponseBody 이므로 
// 굳이 @ResponseBody를 쓰기 위해 일반 @Controller만 사용한다.

@Controller
public class MyController {
  
  public @ResponseBody Author getAuthor() {
    Author author = new Author();
    author.setName("Kim");
    author.setAge(70);
    return author;
  }
}
```
<br>


## @ModelAttribute

Spring MVC에서 Model 객체를 언급할 때 사용. 

```java
@ModelAttribute("author")
public Author author () {
  // 우리는 모델에게 어떤 객체를 추가한다고 코딩할 필요가 없다 
  // (= 예를 들면, 굳이 모델 객체를 만들어서 model.setAttribute(author); 이렇게 써줄 필요가 없다는 말)
  // 자동적으로 객체를 그 모델의 특성(attribute)으로 들어갈 것이다. 
}
```

<br><br> 
출처 : https://geeksforgeeks.org/spring-boot-annotations
