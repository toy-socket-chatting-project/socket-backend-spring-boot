# socket-backend-spring-boot
[토이프로젝트]소켓통신 스프링부트 백엔드 서버

## 목차
1. [환경구성](#1-환경구성)
2. [API 문서](#2-API-문서)
3. [테스트 코드](#3-테스트-코드)

## 기타
99. [참고](#99-참고)
    1. [커밋 컨벤션](#1-커밋-컨벤션)
    2. [브랜치 전략 - Github flow](#2-브랜치-전략---github-flow)
---
## 1. 환경구성
- Spring Boot 2.7.0 / Gradle 8.0
- Jdk 15
- JUnit5
- Spring Data JPA(with. h2-MySQL8)

## 2. API 문서
- API 문서를 코드로 관리하기 위해 swagger 를 적용하였습니다.
- swagger-ui 3.0 / springdocs 디펜던시로 구현
- 추가 설정없이 사용가능한 sprigdocs 로 swagger3 구현함.
  ```text
  Spring Boot 2.6 이후 ControllerHandler 매핑 전략 기본값이 아래와 같이 변경됨에 따라
  springfox 디펜던시 기본 설정으로는 사용 불가

  ant_path_matcher -> path_pattern_parser
  ```

## 3. 테스트 코드
- Spring Boot 2.7.0 기준 spring-starter-test 에 JUnit5 가 내장되어 있어 JUnit5를 사용합니다.
- io.spring.dependency-management 에 의해 스프링 관련 디펜던시가 일괄 관리되기 때문에 위 디펜던시 버전은 변경하지 않습니다.
- [JUnit4 -> JUnit5 메소드 변경점 참고 블로그](https://theheydaze.tistory.com/218)

## 4. ERD CLOUD
- [ERD CLOUD 바로가기](https://www.erdcloud.com/d/6Jyy2YQDEpAqkMYcx)

## 5. 코드 포맷팅 - google java format
- 일관된 코드 스타일을 유지할 수 있도록 google java format 플러그인 사용
- 설치방법 - IntelliJ 기준
  1. plugins > google java format 설치
  2. help > Edit Custom VM Options 에 아래 설정 추가 후 재시작
     ```text
     --add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED
     --add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED
     --add-exports=jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED
     --add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED
     --add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED
     --add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED
     ```
     참고) [Intellij plugin 설치 후 VM Options 추가 가이드](https://github.com/google/google-java-format/blob/master/README.md#intellij-jre-config)
  3. [Optional]코드 수정 시 자동 포맷팅 되도록 설정
     * `cmd + option + L` 로 직접 포맷팅할 수 있으나 깜빡하고 포맷팅하지 않는 경우를 대비하여 자동 포맷팅을 권장함.
     * ![자동 포맷팅 설정 캡쳐](https://github.com/toy-socket-chatting-project/socket-backend-spring-boot/assets/43669379/d1cbb134-9a6e-489d-9b61-cbd7f6705baf)

## 99. 참고
### 1. 커밋 컨벤션
1. 커밋 종류   
   |type|desc|
   |--|--|
   |feat|새로운 기능 추가|
   |fix|버그 수정|
   |docs|문서 수정|
   |style|코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우|
   |refactor|코드 리팩토링|
   |test|테스트 코드, 리팩토링 테스트 코드 추가|
   |chore|빌드 업무 수정, 패키지 매니저 수정|
2. 제목(필수)
    - `이슈번호/커밋 종류: 커밋 내용` -> 50자 내외, 마침표 없이 작성
    - 부족할 경우, 본문에 상세한 내용 작성
    - `이슈 단위로 작업하며, 이슈에 커밋 히스토리를 연결하기 위해 이슈 번호를 기재한다.`
3. 본문(선택)
    - 제목에서 두 줄 띄고 작성 -> 깃에서 제목과 본문을 구분하는 방식
    - 한 줄당 72자 내로 작성
    - 최대한 상세하게 작성할 것
4. 예시
   ```
   #6/feat: 회원 테이블 구현

   JPA 로 구현함
   컬럼 - id, email, password, name
   컬럼은 필요최소한으로 구현했으며, 추후 변경될 여지가 있음.
   ```

### 2. 브랜치 전략 - GitHub Flow
- 이슈 단위의 간결한 코드 관리를 위해 GitHub Flow 로 선택함
- 명명규칙 `feature/#issue_number-issue-title`
- ***이슈 처리 과정에서 커밋되는 코드들을 관리하기 위함이기 때문에 반드시 이슈 발행 후 브랜치 작성할 것.***

