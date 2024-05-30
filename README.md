@BackEnd   
# 프로그래밍 요구사항

- Java 17 이상  
- Spring Boot 3 이상을 사용할 것  
- MySQL 8 이상을 사용할 것  

---

# 시스템 요구사항
## 1 - 1
_음식 배달 플랫폼의 주문 플로우를 비슷하게 구현할 것 입니다._

<br>

### 구현해야하는 API
1. 주문 완료
2. 가게의 주문 확인 (페이징 X)

<br>

### 주문 완료 플로우
가게 선택 -> 메뉴 선택 -> 장바구니 담기 -> 주문 완료

<br>

### 상세 요구사항
1. 메뉴 안에는 옵션이 들어가고 상세 옵션이 있습니다.
2. 결제에 대해서는 신경쓰지 않습니다.  
3. 객체 지향에 고민해보고 객체 지향적으로 코드 구조를 설계해주세요.

<br>

### 제약사항
1. 장바구니 데이터는 서버에서 저장하지 않는다.
2. 도메인 별 구조는 확실하게 나눠야 합니다.
3. 객체 간 양방향 참조가 일어나면 안됩니다.
4. 요구사항을 구현을 위한 DB 설계는 직접해야 한다.
5. GitHub Repository는 delivery-server repository를 fork하여 사용합니다.

<br>

### 제출 결과물
1. 코드를 작성한 GitHub Repository 주소
2. ERD와 클래스 다이어그램이 들어간 발표자료

<br>

### 주의사항
요구사항에 적히지 않은 문제에 대해서는 스스로 정의하고 분석을 진행해주세요.

<br>

### 참고 영상
1. https://youtu.be/uzch3bilTvo?si=kQzD1Xgfq7R3dx7