# 객체지향 쿼리언어와 JPQL

객체지향 쿼리언어

- JPQL
- JPA Criteria
- QueryDSL
- 네이티브 SQL
- JDBC API를 직접 사용(MyBatis, SpringJdbcTemplate)

JPQL 소개

- JPQL은 엔티티 객체를 대상으로 쿼리
- 특정 SQL에 의존 X

JPQL 기본 문법과 쿼리 API

- 엔티티와 속성 > 대소문자 구분
- JPQL 키워드 > 대소문자 구분 X
- 테이블 이름이 아닌 엔티티 이름 사용. 별칭은 필수
- JPQL은 파라미터 바인딩이 가능해 동적 쿼리 작성 가능
- TypeQuery는 반환 타입이 명확할 때, Query는 반환 타입이 명확하지 않을 때 사용
- getResultList는 결과가 하나 이상일 때, getSingleResult는 결과가 정확히 하나일 때 사용
- getResultList는 결과가 없으면 빈 리스트 반환
- getSingleResult는 결과가 하나가 아니면 예외 발생

프로젝션

- SELECT 절에 조회할 대상을 지정하는 것
- 프로젝션 대상은 엔티티, 임베디드 타입, 스칼라 타입
- 조회 대상이 여러 개일 경우 new 명령어로 조회

페이징 API

- setFirstResult > 조회 시작 위치
- setMaxResults > 조회할 데이터 수

조인

- 내부 조인 > inner join, 외부 조인 > left outer join, 세타 조인
- on절을 활용한 조인으로 조인 대상 필터링, 연관관계 없는 엔티티 외부 조인이 가능

서브 쿼리

- SQL과 동일
- JPA 구현체중 하이버네이트는 SELECT 절도 서브쿼리 지원
- 하이버네이트6부터 FROM 절에도 서브쿼리 지원

조건식

- 기본 케이스식과 단순 케이스식, coalesce, nullif가 있다

자세한 내용은 블로그에 정리했습니다.
[(1)](https://hsh519.tistory.com/112)

## REFERENCE

- [자바 ORM 표준 JPA 프로그래밍 - 기본편](https://www.inflearn.com/course/ORM-JPA-Basic/dashboard)
