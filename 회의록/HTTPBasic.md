# 간단한 API 만들고 HTTP 테스트하기
<br/>

```java
//@RestController = @Controller + @ResponseBody
//웹 응답이 만들어질 때, 메서드의 return type인 String을 보고 content-type을 자동으로 결정해줌.
//리턴 값이 그대로 response body로 들어감
@RestController
public class HelloController {
  @GetMapping("/hello")
  public String hello(String name) { // localhost:8080/hello?name=Spring
    return "Hello" + name;	// Hello Spring 이 화면에 띄워질 것임
  }
}
```

<br/>

### HTTP API 테스트

- 웹 개발자도구 (콘솔 F12)

- curl
- HTTPie
- Postman
- Unit Test
- IntelliJ IDEA Ultimate - http request


<br/>
마지막 인텔리제이 터미널을 사용

```shell
$ http -v ":8080/hello?name=Spring"
```

<br/>

## 🔥HTTP 요청과 응답 (중요! 외웁시당)🔥

#### Request

- Request Line : <u>Method(GET, POST..)</u>, Path, Http Version
- Headers
- Message Body

<br/>

#### Response

- StatusLine : Http Version, <u>Status Code</u>, Status Text
- Header (<u>Content-Type</u>....)
- Message Body



