# HTTP 상태코드

HTTP 상태코드는 클라이언트가 보낸 요청의 처리 상태를 응답에서 알려주는 코드다. HTTP 상태코드는 100번대 부터 500번대 까지 있다. 만약 미래에 HTTP 상태코드가 이제 막 추가되어 클라이언트가 아직 인식하지 못한다면 상위 상태코드로 바뀌서 처리한다. 예를 들어 상태코드 299가 새로 만들어졌지만 클라이언트가 인식을 못하면 299는 200번대 코드에 존재하므로 299번의 코드로 해석하는게 아니라 200번대 코드가 가지고 있는 의미로 해석해 처리한다. 물론 299번과 200번대 코드는 세세하게 따지면 다른 의미겠지만 결국 요청 정상 처리가 되었다는 건 동일하니 문제 없다.

HTTP 상태코드

- 1XX : 요청이 수신되어 처리중
- 2XX : 요청 정상 처리
- 3XX : 요청을 완료하려면 유저 에이전트의 추가 조치 필요. 여기서 유저 에이전트는 웹 브라우저라고 생각하면 된다
- 4XX : 클라이언트 오류. 서버가 요청을 수행 할 수 없음
- 5XX : 서버 오류. 서버가 정상 요청을 처리하지 못함

**1XX**

- 거의 사용하지 않음

**2XX**

- 200(OK) : 요청이 성공
- 201(Created) : 요청이 성공해서 새로운 리소스가 생성
- 202(Accepted) : 요청이 접수됬으나 처리가 완료되지 않았음 -> 요청 접수후 1시간 뒤에 배치 프로세스가 요청 처리
- 204(No Content) : 요청에 성공했지만 응답에서 보낼 본문 내용이 없음 -> 문서 편집시 저장 버튼

**3XX**

리다이렉션

- 3XX 응답에 Location 헤더가 있으면 웹 브라우저는 Location 위치로 자동 이동
- 영구 리다이렉션 : 특정 리소스의 URI가 영구적으로 이동. 따라서 원래 URL은 사용X
- 일시 리다이렉션 : 리소스의 URI가 일시적으로 변경. 사용 예로 주문완료 후 주문내역 화면 이동
- 만약 일시 리다이렉션을 안쓰고 200 상태코드를 쓰면 주문완료후 새로고침을 했을 때 POST 요청이 다시 들어가 중복 결제가 된다
- 따라서 일시 리다이렉션을 사용해 주문완료 후(POST) 리다이렉션한(Redirect) 다음 요청 메서드를 GET으로 바꿔(GET) 새로고침 해도 GET 요청이 되도록 한다 -> PRG
- 참고로 POST 요청은 멱등성을 가지지 않아 클라이언트가 새로 고침을 통해 재요청을 하면 큰일 난다
- 특수 리다이렉션 : 결과 대신 캐시를 사용

3XX

- 301(Moved Permanently) : 리다이렉트시 요청 메서드가 GET으로 변하고 본문이 제거될수 있음 (영구 리다이렉션)
- 302(Found) : 리다이렉트시 요청 메서드가 GET으로 변하고 본문이 제거될수 있음 (일시 리다이렉션)
- 303(See Other) : 리다이렉트시 요청 메서드가 GET (일시 리다이렉션)
- 304(Not Modified) : 캐시에 요청한 리소스가 남아있음을 알려주고 캐시로 리다이렉션 해줌 (기타 리다이렉션). 따라서 데이터를 제공하지 않기 때문에 응답에 본문을 포함하면 안된다
- 307(Temporary Redirect) : 리다이렉트시 요청 메서드와 본문 유지 (일시 리다이렉션)
- 308(Permanent Redirect) : 리다이렉트시 요청 메서드와 본문 유지 (영구 리다이렉션)

**4XX**

- 이건 클라이언트 잘못이기 때문에 똑같은 데이터로 재요청하면 계속 실패한다
- 400(bad Reqeust) : 클라이언트가 잘못된 요청으로 서버가 처리할 수 없음
- 401(Unauthorized) : 클라이언트가 해당 리소스에 대한 인증이 필요 -> ex) 본인이 누군지 확인할 수 있는 방법인 로그인을 안 한 경우
- 403(Forbidden) : 서버가 요청을 이해했지만 승인을 거부 -> ex) 로그인은 됬지만 관리자만 사용할 수 있는 리소스에 접근할 경우
- 404(Not Found) : 요청 리소스를 찾을 수 없음 -> 정말 요청한 리소스가 없거나 403 상태코드를 띄워야 하는 경우지만 클라이언트에게 없는 리소스라고 보여주고 싶을 때

**5XX**

- 이건 서버 잘못이기 떄문에 똑같은 데이터로 재요청하면 성공할 가능성이 있다
- 이 상태코드는 정말 서버 잘못인 경우에만 사용해야 한다. 클라이언트 잘못을 서버 잘못으로 알려주게 되면 클라이언트는 본인 잘못을 모르기 때문이다
- 500(Internal Server Error) : 서버 내부 문제로 오류 발생. 서버 잘못인데 어떤 상태코드를 써도 애매한 상황이라면 이 상태코드를 쓰면 된다
- 503(Service Unavailable) : 서버가 일시적인 과부하, 예정된 작업으로 요청을 처리할 수 없음 -> ex) 서버 점검 시간에 접속하는 경우
