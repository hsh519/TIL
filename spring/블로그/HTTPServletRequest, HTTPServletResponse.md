## HTTPServletRequest, HTTPServletResponse 간단하게 정리

HTTPServletRequest

- HTTP 요청 메시지를 개발자 대신 파싱해서 얻은 결과를 HTTPServletRequest 객체에 담아 제공하는 역할
- HTTPServletRequest가 제공하는 기본 기능을 통해 START LINE, 헤더, 본문 데이터를 조회할 수 있다

HTTPServletResponse

- HTTP 응답 메시지를 개발자 대신 작성해주는데 그 안에 들어갈 내용은 개발자가 HTTPServletResponse 객체에 담아줘야 한다
- 담을수 있는 내용으로는 HTTP 상태코드, 헤더, 쿠키, 리다이렉트, 본문이 있다

[HTTPServletRequest 메서드와 HTTPServletResponse 메서드에 관한 자세한 내용는 블로그에 정리했습니다.](https://hsh519.tistory.com/52)
