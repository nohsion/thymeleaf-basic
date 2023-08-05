# ThymeLeaf

## ThymeLeaf란?
- 서버 사이드 Java 템플릿 엔진
- HTML, XML, JavaScript, CSS 등의 정적인 파일을 동적으로 생성하기 위해 사용
- Spring Framework에서 권장하는 템플릿 엔진
- JSP, Freemarker, Velocity 등의 템플릿 엔진과 비교했을 때, 자바 코드와 템플릿 코드의 분리가 쉽다는 장점이 있다.
- ThymeLeaf는 서버 사이드 템플릿 엔진이기 때문에, 클라이언트 사이드 템플릿 엔진인 React, Vue.js 등과 함께 사용할 수 있다.

### 타임리프 유틸리티 객체들
- `#message`: 메시지, 국제화 처리
- `#uris`: URI 이스케이프 처리
- `#dates`: `java.util.Date` 서식 지원 (날짜 관련 객체)
- `#calendars`: `java.util.Calendar` 서식 지원 (날짜 관련 객체)
- `#temporals`: Java8 날짜 서식 지원 (날짜 관련 객체)
- `#numbers`: 숫자 서식 지원
- `#strings`: 문자 관련 편의 기능
- `#objects`: 객체 관련 편의 기능
- `#bools`: boolean 관련 기능 제공
- `#arrays`: 배열 관련 기능 제공
- `#lists`, `#sets`, `#maps`: 컬렉션(List, Set, Map) 관련 기능 제공
- `#ids`: 아이디 처리 관련 기능 제공

## Reference
- [ThymeLeaf 공식 문서](https://www.thymeleaf.org/)
- [공식 매뉴얼 - 기본 기능](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)
- [공식 매뉴얼 - 스프링 통합](https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html)
- [타임리프 유틸리티 객체](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#expression-utility-objects)
