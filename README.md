# spring-resolver-test
### HandlerMethodArgumentResolver test

### 사용 목적
- front에서 back으로 파라미터를 넘기는 일반적인 방식(query string or form submit) 외에  
  HTTPHeader등 HttpRequest에서 특정 데이터를 여러 request에서 사용해야 하는 경우에 사용한다.
- controller에서 다른 request parameter와 동일한 방식으로 데이터에 접근하여 비지니스 로직을 처리할 수 있다.
- 반복적인 작업을 Resolver 객체 메소드 한 곳에서 처리한다.

### 본 프로젝트 구현에 사용한 class 및 interface
- HandlerInterceptor
  - 인증 토큰을 복호화하여 유저 정보를 생성하고, reqeust 객체에 등록한다.
  - 본 프로젝트에서는 토큰을 사용하지 않았고, 요청시 header에 `user-info`라는 이름으로 `userId`를 사용하여 인터셉터에서 `user-info`라는 이름으로 헤더에 접근하였다.
- custom annotation
  - resolver의 supportParameter 메소드에서 resolver가 실행되어야하는 파라미터가 맞는지 확인하는 용으로 생성
- HandlerMethodArgumentResolver
  - interceptor에서 등록한 유저 정보를 request 속성에서 가져와 유저 인스턴스로 만든 뒤 리턴
- WebMvcConfigurer
  - interceptor 및 resolver 등록
- Controller
  - 유저 및 request dto를 가지고 서비스를 호출
