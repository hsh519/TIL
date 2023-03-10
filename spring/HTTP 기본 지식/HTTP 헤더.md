# HTTP 헤더

과거의 HTTP 헤더는 General 헤더, Request 헤더, Response 헤더, Entity 헤더 이렇게 구성되었다. 그러나 HTTP 표준이 바뀌면서 Entity 헤더가 Representation(표현) 헤더로 바뀌게 되었다.

HTTP 헤더

- General 헤더: 메시지 전체에 적용되는 정보
- Request 헤더: 요청 정보
- Response 헤더: 응답 정보
- Representation 헤더: 메시지 본문 정보 -> 메시지 본문을 통해 표현 데이터가 전달되고 메시지 본문 안에는 전달할 표현 데이터가 들어있으며 표현 헤더에는 표현 데이터를 해석할 수 있는 정보를 제공

**표현 헤더**

- Content-Type: 표현 데이터의 형식 설명 -> ex) html이면 text/html; charset=utf-8, json이면 application/json, 이미지파일이면 image/png
- Content-Encoding: 표현 데이터를 압축하기 위해 사용. 데이터를 전달하는 측에서 압축했다면 데이터를 받는 쪽이 압축을 해제해야 하기 때문에 인코딩 헤더를 추가 -> gzip, deflate, identity
- Content-Language: 표현 데이터의 자연 언어를 표현 -> html을 한국어로 작성했다면 ko, 영어로 작성하면 en
- Content-Length: 표현 데이터의 길이. 바이트 단위로 세며 Transfer-Encoding을 사용하면 사용할 수 없다

**협상**

- 클라이언트가 선호하는 표현 데이터를 요청(Request 헤더)
- Accept: 클라이언트가 선호하는 표현 데이터의 형식 전달
- Accept-Charset: 클라이언트가 선호하는 문자 인코딩 방식 전달
- Accept-Encoding: 클라이언트가 선호하는 압축 인코딩
- Accpet-Language: 클라이언트가 선호하는 자연 언어

협상과 우선순위

- 만약 우리는 한국어를 선호한다고 요청했는데 서버가 지원하는 언어에는 한국어가 없어 우선적으로 지원하는 프랑스어로 응답해줬다면..?? 영어도 지원해서 차라리 영어로 응답해줬으면 좋았을텐데.. -> 우선순위 등장
- 우선순위 덕분에 클라이언트가 선호하는 표현 데이터 후보를 여려개 지정할 수 있음
- 1. 값;q=(0~1) 형태로 우선순위 지정. 숫자가 클수록 높은 우선순위. 생략하면 1
- 2. 구체적으로 적을 수록 높은 우선순위

**전송 방식**

- 단순 전송: 표현 데이터를 그대로 전송. Content-Length를 사용해도 된다
- 압축 전송: 표현 데이터를 압축헤서 전송. Content-Encoding이 필요하며, Content-Length를 사용해도 된다. 이떄 Content-Length 값은 압축한 표현 데이터의 바이트 길이다
- 분할 전송: 표현 데이터를 분할해서 전송. 즉, 범위 전송을 연속으로 하는 것. 덩어리로 보낼 경우 Transfer-Encoding: chuncked 사용. 이때 덩어리의 크기를 알수 없고 분할 전송할 때 덩어리의 바이트 길이도 전송하기 때문에 Contene-Length를 사용할 수 없다
- 범위 전송: Request 헤더에서 Range로 전송받을 범위를 지정하면 Response 헤더에서 Content-Range로 받은 데이터 길이/총 데이터 길이 형태로 전송한다. 이때 Content-Length는 (총 데이터 길이 - 받은 데이터 길이)다

**HTTP 헤더의 일반 정보**

- From: 유저 에이전트의 이메일 정보. 거의 사용하지 않는다 (Request 헤더)
- Referer: 이전 페이지 주소. A->B로 이동할 때 B에게 요청하면서 Referer: A를 포함. 유입 경로를 분석할 수 있다 (Request 헤더)
- User-Agent: 클라이언트의 애플리케이션 정보. 웹 브라우저 정보도 들어 있어 어느 브라우저에서 장애가 발생하는지 파악 가능하다 (Reqeust 헤더)
- Server: 요청을 처리하는 ORIGIN 서버의 소프트웨어 정보. ORIGIN 서버는 클라이언트부터 서버까지 거처가는 많은 서버중 실제로 요청을 처리해주는 서버 (Response 헤더)
- Date: 메시지가 발생한 날짜와 시간 (Response 헤더)

**HTTP 헤더의 특별한 정보**

- HOST: 하나의 서버가 https 프로토콜을 사용하는 여러 도메인을 처리한다면 TCP/IP로는 부족하다. IP, PORT 모두 동일하고 모든 도메인이 request-target을 가지고 있다면 어떤 도메인의 결과를 응답으로 보내야할지 모른다. 따라서 요청한 도메인을 필수로 작성해야한다 (Reqeust 헤더)
- Location: 웹 브라우저가 201 응답 결과를 받으면 Location은 해당 리소스가 처리되어 생성된 URI를 알려주며, 3XX 응답 결과를 받으면 Location 위치로 자동 이동
- Allow: 허용 가능한 메서드를 알려줌. 405(Method Not Allowed) 상태코드를 사용할 때 응답에 포함해야 한다 (Response 헤더)
- Retry-After: 유저 에이전트(웹 브라우저)가 다음 요청을 하기까지 기다려야 하는 시간. 503 상태코드를 사용할 때 언제까지 서버가 불능인지를 알려줄 수 있다. (Response 헤더)

**인증**

- Authorization: 클라이언트 인증 정보를 서버에 전달 (Request 헤더)
- WWW-Authenticate: 리소스 접근시 필요한 인증 방법 정의. 401(Unauthorized) 상태코드와 함께 사용. (Response 헤더)

**쿠키**
HTTP는 무상태 프로토콜이기 떄문에 로그인을 하면 바로 연결이 끊어져 다른 페이지를 이용할 때 로그인이 안된 상태가 된다. 그렇다고 쿼리 스트링으로 사용자 정보를 포함시키면 개발자도 귀찮아질뿐더러 보안 문제도 심각해진다. 무상태 프로토콜이지만 상태 유지가 필요할 때는 쿠키를 사용한다.

쿠키

- Set-Cookie: 서버가 클라이언트에게 쿠키 전달 (Response 헤더)
- Cookie: 클라이언트가 서버에게 받은 쿠키를 저장하고, HTTP 요청시 자동 전달 (Request 헤더)

먼저 클라이언트가 로그인 요청을 하면 서버가 키-값 형태의 쿠키를 응답 메시지에 포함해 전달한다. 그러면 클라이언트는 그 쿠키를 쿠키 저장소에 저장한 후에 요청할 때마다 자동으로 쿠키를 요청 메시지에 넣어주면 서버가 쿠키를 적용한 결과를 응답으로 보낸다.

쿠키의 특징

- 쿠키도 결국 요청 메시지에 들어가므로 네트워크 트래픽을 추가 유발. 최소한의 정보만을 사용해 추가 유발을 최소화
- 민감한 데이터는 저장하지 않는 것이 좋다
- 만약 쿠키를 요청 메시지에 넣는걸 선택으로 하고싶다면 웹 스토리지를 이용

Set-Cookie

- sessionId: 키-값 형태의 대신에 사용할 쿠키. 클라이언트가 sessionId를 요청 헤더에 넣어주면 서버가 sessionId에 맞는 값을 가져와서 적용해준다. 쿠키에 직접적인 데이터가 들어가지 않아 안전하다
- expires: 쿠키의 생명주기. 만료 날짜를 생략하면 웹 브라우저 종료시까지만 유지되고, 입력하면 입력한 날짜까지 유지된다
- domain: 쿠키가 유효한 도메인. 도메인을 명시하면 명시한 도메인과 서브 도메인에서 유효하며, 생략하면 해당 도메인에서만 유효하다
- path: 쿠키가 유효한 경로. 명시한 경로를 포함한 하위 경로는 유효하다. 일반적으로 루트로 지정
- Secure: https인 경우에만 쿠키 전송

**검증 헤더**

캐시
캐시란 응답 결과를 웹 브라우저에 저장하는 저장소다. 캐시가 없을 경우 같은 페이지를 요청할 때마다 서버에서 데이터를 다운받아야 하는데 캐시를 사용하면 첫 요청에만 서버에서 데이터를 다운받고 그 이후에는 해당 데이터가 캐시에 유효하다면 캐시에서 꺼내서 사용할 수 있다.

캐시가 없을 때

- 요청할 때마다 서버에서 데이터를 계속 다운받아야 한다
- 브라우저 로딩 속도가 느리다
- 느린 사용자 경험
- 인터넷 네트워크는 매우 느리고 비싸다

캐시가 있을 때

- 캐시 가능 시간(데이터가 캐시에 유효하는 시간)동안에는 서버에서 데이터를 다운 받을 필요가 없다
- 브라우저 로딩 속도가 빠르다
- 빠른 사용자 경험
- 인터넷 네트워크 사용량을 줄일수 있다
- 캐시 가능 시간이 지나면 서버를 통해서 다시 다운 받아 사용한다

캐시의 한계
캐시가 인터넷 네트워크 사용량을 줄일 수 있지만 캐시 유효 시간이 지나버리면 서버 데이터의 변경 유무와 상관없이 다시 서버에서 다운받아 사용한다. 만약 서버 데이터가 바뀌면 당연히 캐시에 있는 데이터(유효 시간이 지난 데이터)를 사용하면 안되지만 서버 데이터가 안바뀌면 굳이 서버에서 다시 다운받지 않고 캐시에 있는 데이터의 유효 시간을 연장하는 게 더 효율적으로 보인다. -> 검증 헤더의 탄생

검증 헤더

- 캐시 유효 시간이 초괴했을 때, 서버의 데이터가 변경되었는지 확인
- 먄약 변경되지 않았다면 -> 304(Not Modified) 상태코드 + HTTP 헤더(본문X) 응답
- 클라이언트가 서버 데이터가 변경되지 않았다는 응답을 받으면 그 응답 메시지로 캐시에 있는 데이터를 갱신한다(재활용)
- 결국 서버에서 다시 다운 받지만 본문이 없는 응답을 받았기 때문에 적은 용량으로 캐시 데이터를 재사용할 수 있는 것이다
- 매우 실용적인 해결책
- Last-Modified, ETag

Last-Modified

- 캐시 데이터의 최종 수정일이랑 서버 데이터의 최종 수정일이 같은지 검증할수 있는 헤더
- If-Modified-Since 조건부 요청 사용(데이터가 수정되었니?) -> 수정되면 200, 그대로면 304
- 캐시 데이터의 최종 수정일을 요청 메시지에 담아 조건부 요청을 보내면 서버는 서버 데이터의 최종 수정일과 캐시 데이터의 최종 수정일을 비교해 수정되었으면 200 상태코드와 함께 서버 데이터를 보내며, 그대로면 304 상태코드와 함께 HTTP 헤더만 보낸다
- 최종 수정일을 시,분,초까지만 보여주기 때문에 초 이하 단위로 수정일 비교는 불가능하므로 만약 1초 이내로 서버 데이터가 변경됐다면 캐시 데이터와 서버 데이터가 달라도 서버에서 다운받지 않고 캐시 데이터를 사용하게 된다
- 만약 서버가 A->B->A로 데이터를 변경했다면 사실상 데이터는 변하지 않았지만 최종 수정일이 달라 같은 데이터를 서버에서 다운받게 된다

ETag

- 그래서 Last-Modified 단점을 보완한 ETag가 등장
- 고유한 이름이 동일한지 검증할 수 있는 헤더
- 데이터를 Hash에 넣어 나온 고유한 이름을 데이터에 달아놓는다
- 즉, 데이터가 같으면 ETag가 동일하고 다르면 ETag가 다르다
- If-None-Match 조건부 요청 사용(ETag가 수정되었니?) -> 수정되면 200, 그대로면 304
- 캐시 데이터의 ETag를 요청 메시지에 담아 조건부 요청을 보내면 서버는 서버 데이터의 ETag와 비교해서 수정되었으면 200 상태코드와 함께 서버 데이터를 보내며, 그대로면 304 상태코드와 함께 HTTP 헤더만 보낸다

**캐시 제어 헤더**

- Cache-Control: 캐시 제어
- Cache-Control: max-age -> 캐시 유효 시간을 초단위로 지정
- Cache-Control: no-cache -> 데이터를 캐시해도 되지만, 항상 원서버에 검증하고 사용
- Cache-Control: no-store -> 데이터에 민감한 정보가 있으므로 저장하면 안됨
- Pragma: HTTP 1.0 에서 캐시 제어
- Expires: HTTP 1.0 에서 캐시 만료일 지정. Cache-Control: max-age와 함께 사용되면 무시된다

**프록시 캐시**

만약 원 서버가 다른 나라에 있다면 처음 데이터를 다운받거나 조건부 요청을 할 때 시간이 걸린다. 클라이언트 서버 사이에서 대리로 통신해주는 프록시 서버를 사용해 원서버랑 통신을 하는 것이 아닌 프록시 서버와 통신하도록 하면 시간이 줄어든다. 거기에 프록시 서버가 원서버에 데이터 요청을 해 데이터를 캐시하고 있다면 클라이언트는 프록시 캐시 서버와도 조건부 요청이 가능하다. 이때 프록시 캐시 서버는 누구나 접근할 수 있도록 public 캐시가 되어야하며, 클라이언트 캐시는 본인만 사용할 수 있도록 private 캐시가 되어야 한다. -> 헤더에 Cache-Control 사용해서 접근 제한자 지정

- Cache-Control: public -> 응답이 public 캐시에 저장되어도 됨
- Cache-Control: private -> 응답이 해당 클라이언트만을 위한 것이라서 private 캐시에 저장해야 함(기본값)
- Cache-Control: s-maxage -> 프록시 캐시에만 적용되는 max-age

**캐시 무효화**

- 확실한 캐시 무효화 응답을 위해선 Cache-Control: no-cache, no-store, must-revalidate 와 Pragma: no-cache 를 헤더에 추가해야 한다
- Cache-Control: must-revalidate -> 캐시 만료후 최초 조회시 원 서버에 검증해야 한다
- 어짜피 no-cache로 항상 원 서버에 검증하고 사용하는데 must-revalidate가 필요할까?
- no-cache는 원서버에 접근이 불가할 경우 프록시 캐시 서버가 200 상태코드와 함께 오래된 캐시를 응답으로 보내준다
- 반면 must-revalidate는 원서버에 접근이 불가할 경우 프록시 캐시 서버가 504 상태코드를 응답으로 보내준다
- 만약 no-cache만 있다면 내가 통장 잔고를 보기 위해 요청했을떄 원서버에 접근할텐데 네트워크 오류로 접근이 불가능할 경우 프록시 캐시가 예전 통장 잔고를 보여주기 때문에 문제가 발생한다. 이럴땐 오류를 보여주는게 훨 낫기 때문에 must-revalidate를 사용하는 것이다. (참고로 원서버에 접근하지 못할 때 응답에 200을 포함하지 않고 504를 포함한다)
- Pragma: no-cache는 HTTP 1.0 버전을 위해 있다
