# numble-banking-api

# 뱅킹 서버 구축하기 가이드라인

## 목차

[기술 스택 가이드](https://www.notion.so/6c22773cf37e472b8bd47565a444a130)

[구현 필수기능](https://www.notion.so/6c22773cf37e472b8bd47565a444a130)

## 기술 스택 가이드

- Spring Boot를 사용합니다.
- 언어는 Java를 사용합니다. ( Kotlin 사용 가능 )
- DB는 MySQL 8버전을 사용합니다.
- DB 프레임워크로는 Spring Data JPA를 사용합니다. ( QueryDSL 사용 가능 )
- Test 프레임워크는 JUnit을 사용합니다. 이 외에 어떤 테스트 프레임워크를 사용하셔도 좋습니다만 근거와 이유가 문서에 명확히 명시되어야 합니다.


## 구현 필수 기능

- 친구 추가 API
- 내 친구 목록 조회 API
- **계좌 이체 API**
    - 계좌 이체는 친구끼리만 가능합니다.
    - 계좌 이체는 트랜잭션 원자성이 보장 되어야합니다.
    - 하나의 계좌에 동시에 돈이 입금되는 상황이 발생할 수 있습니다.
        - 이러한 상황의 동시성 문제를 해결하셔야합니다.
    - 계좌 이체가 완료된 이후에는 알람을 보냅니다.
        - 알람은 따로 서버가 있다고 가정하고 외부 API를 호출하는 Mocking 로직을 작성해두시면 되겠습니다.
        - 예시 : numbleAlarmService.notify(userId, message);
            - 실제 동작 : Thread.sleep(500);
- 계좌 조회 API (내 계좌만 조회 가능)
- 회원가입 API
    - 단순 ID/PW로 회원가입하는 API를 구현하는 것을 기본으로 합니다.
- 송금 및 알람 관련 구조도


### 테스트 결과

- 회원가입 API
    - Controller 테스트
        - 이미 가입된 ID 이면 실패 - O
        - 신규 가입 - X
    - Service 테스트
        - 신규 회원가입시 정상동작 - O
        - 이미 등록된 ID 일 경우 실패 - X
    - Repository 테스트
        - 등록된 ID, 비밀번호 입력시 정상적으로 조회 - O
        - 등록되지 않은 ID, 비밀번호 입력시 null - O
        - 정상적인 ID, PW, 이름을 입력하면 회원가입 완료 - O
    - 테스트 진행시 문제점
        - 각각의 테스트 진행시, JpaAuditingConfig 때문에 문제가 발생한다

- 친구 추가 API & 내 친구 목록 조회 API
    - Controller 테스트
        - 내 친구 목록 조회 - X
        - Client 가 아닌 친구 등록 시 null - X
        - 친구 추가 하기 - X
    - Service 테스트
        - 내 친구 목록 조회 - O
        - Client 가 아닌 친구 등록 시 null - O
        - 친구 추가 하기 - X
    - Repository 테스트
        - 내 친구 목록 조회 - O
        - 친구 추가 하기 - O
    - 테스트 진행시 문제점
        - Controller 테스트에서 문제 발생
            > Caused by: org.mockito.exceptions.base.MockitoException: 
            > Cannot mock/spy class org.springframework.test.web.servlet.MockMvc
            - record class로 작성된 Friends 객체를 모킹하려고 할때 record class는 불변 데이터 객체이기 때문에 모킹이 되지 않는 것이 문제
            - Mockito inline 의존성을 추가하기
                - testImplementation("org.mockito:mockito-inline:4.9.0")
        - Repository 테스트에서 문제 발생
            - @EnableJpaAuditing 분기 처리한 것 원복 시켜줘야함.
- 계좌 이체 API
    - Controller 테스트
    - Service 테스트
    - Repository 테스트
    - 테스트 진행시 문제점
