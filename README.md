# book-spring-aws

## 레퍼런스

- 스프링 부트와 AWS로 혼자 구현하는 웹 서비스

<img width="300" src="https://github.com/Chaedie/book-spring-aws/assets/88099590/c50edfc3-0bde-4303-881c-e8fa92bcc918"/>

### 배운 점

#### 테스트 코드

- 저자는 "개발 -> 테스트 코드 작성"을 한묶음으로 개발한다.
    - 첫번째 프로젝트에서 (Spring-Boards) 기본 기능을 여러 건 완성한 뒤 테스트 코드를 한번에 짜려니 생각보다 어려웠었다. 학습도 어려웠지만 어디서 부터 시작해야할지 막막한 느낌이었다.
    - 하지만 저자가 하는 방식대로 작은 단위부터 테스트 코드를 작성하는 것은 "이 정도 작은 기능이라면 나도 할 수 있을것 같다...!" 는 생각을 하게 되더라.
    - 또한 기능 추가 시 놓치는 부분이 생기기 마련인데, 이 때 기존 했던 방식은 서버를 키고 화면을 통해 직접 실행해보며 에러가 있는지 확인하는 방식이었다. 눈버깅이라고 하나..?
    - 이 과정이 꽤나 번거로운데 테스트 코드가 있다면 조금 더 안전하게 기능 추가가 가능하다는걸 제대로 배웠다.
    - 이 배움 하나만으로도 가치가 큰 책이라 생각한다.
    - 추가로 토스 슬래쉬에서 "테스트 커버리지 100%" 라는 영상을 본 적이 있는데, 기존에 존재하는 기능들에 대한 테스트 작성을 함으로써 100%를 달성한거다 보니 정말 대단한것 같다.

#### Entity, Dto 설계 (도메인 설계, 절제된 롬복 사용)

- 내 첫 프로젝트 코드와 비교하면 롬복 사용이 절제되어 있음을 느낀다.
    - 엔티티에서 세터를 사용하지 않음으로 엔티티를 보호하는 점
    - 당장 필요하지 않은 어노테이션은 달지 않는 점
    - 어노테이션을 달때도 핵심적인 부분을 Class명, Method명과 가까운 쪽으로 적는다는 원칙이 있는 점 등이 좋았다.
- 엔티티에 도메인 로직 메서드를 작성하더라.
    - setTitle 과 같은 단순 세터가 아니라 update() 와 같은 메서드를 만들어 엔티티를 수정하는 메서드를 만듬
    - 이를 통해 서비스 레이어가 객체 재조립, Repository 콜 등을 담당하는게 아니라 엔티티 메서드 실행, 흐름 제어 등을 담당하게 되었다.
    - 기존 알고 있던 레이어 구조랑 조금 달랐는데 어찌보면 이게 훨씬 비즈니스를 잘 담고있는걸지도 모르겠다.
    - 잘 짜여진 DDD 코드를 보고 싶다.

#### DDD

- 도메인 주도 개발이 무엇인지 알려주는 건 아니지만 기본 구조자체를 DDD 형태로 가지고 가니 간접경험이 되어서 좋다.
    - 막연하게 DDD 책을 먼저 보는것보단 이 책의 예제를 통해 느낌을 익힌 뒤 DDD책을 볼 수 있게 된 점이 좋았다.

#### API, View Controller 분리된 점

- View Template이 함께 있는 프로젝트라면 JSON 형태로 내려주는 API가 아니라 직접 Model에 담아서 내려줘야 한다고 생각했었다.
- 하지만 예제코드에선 View Controller와 API Controller를 별개로 가져갔고, View에선 Ajax를 통해 JSON을 내려 받는게 신기했다.
- 별거 아니고 당연한거라 생각할 수도 있지만, 백엔드 개발을 처음 한다면 나랑 비슷하게 생각하는 사람이 있을지도..?

#### CI/CD

- Travis CI, AWS S3, AWS CodeDeploy 를 활용해 CI/CD를 구축했다. 그 과정에 쉘 스크립트도 사용했고, yml 파일도 세팅했다. 물론 내가 다 알고 한건 아니고 예제에 있는걸 이해해보며 따라 쳤고, 계속 발생하는 문제를 해결하는 과정에서 작은 수정정도를 직접했다.
- 이전까진 배포 서비스에서 CICD 까지 모두 해준다던지 이미 CICD가 되어 있는 프로젝트에 참여하여 직접 CICD를 구축해본적은 없었다. Github CLI를 활용해 CICD를 해보려고 노력한적은 2번 있었는데 그떄마다 잘 안되었던 기억이 있다.
- 그러다 이 책을 통해 처음으로 성공했고, 이전엔 단순히 Github에서 yml만 예제대로 추가하면 된다고 생각했던게 여러 CI, 저장, deploy같은 여러 서비스를 거치면서 이루어지는 내부 작동원리를 몰라서 실패했다는걸 알게 되었다. 제대로 알지 못하고 단지 추상화된 겉모습만 보고 아 이렇게 넣으면 되겠지? 하고 겉핥기만 했었다는걸 깨닫게 되었다.
- 책으로 한번 성공한것 가지고 대단한 걸 배운듯 이야기하는것 같지만 보통 한번의 성공 경험이 끈기를 가지고 물고 늘어지는 디버깅 실력(멘탈?)을 만들어 주니까 아주 만족스럽다. ㅎㅎ

![image](https://github.com/Chaedie/book-spring-aws/assets/88099590/39a5a75b-f3d4-4177-8869-67dbf0034cd9)


##### CI/CD 성공하고 썼던 느낀점

- Travis CI, AWS CodeDeploy를 연동하고, CICD를 구축하면서 에러가 많이 발생했다.
    - 밤 동안 무수히 많은 수정을 거듭하고 빌드를 거듭하다 결국 성공해냈다.
    - 여기서 나는 무슨 레슨런을 했을까?
    - 1) 일단 Linux 명령어를 자유자재로 사용하고 싶다.
    - 2) 머리로는 알지만 손으로 직접 해본적 없으니 생각보다 막히는게 많았다. 다른 툴로 직접 해봐야겠다. 직접적인 경험을 쌓는게 시급한것 같다.
    - 3) 단순히 따라 치고 에러 생기면 디버깅하는 수준으로 공부해선 부족한점이 많다. 한줄 한줄 어떤 의미인지, 지금 내가 치는 명령어는 어떤 명령언지 알면서 치는게 훨씬 도움된다.
    - 4) AWS 공식문서를 처음으로 읽어봤다. 이전엔 UI도 별로고 불친절하다고 생각해서 블로그를 더 선호했다. 그런데 필요에 의해 막상 읽어보니 생각보다 읽을만 했고, 엄청 친절했다..!! 명령어만 적어둔 블로그는 결국 AWS 공식문서를 복붙한 outdated 한 캐싱문서일뿐이라는 생각이 들었다. 물론 디버깅 과정에서 블로그 글에서 도움을 많이 얻었다. 그러나 단순히 방법을 적은 글이 아닌 디버깅 과정을 적은 글이 도움이 되었다. 문제를 만났을 때 했던 생각, 디버깅 과정을 적은 글이 도움이 많이 되었다. 예를 들면 “이런 에러 메시지를 봤고, 예전에 이런 글을 읽어서 이게 생각이 났다. 그래서 이걸 검색해보니 이게 나왔고, 예상대로 이렇게 했더니 해결이 되었다.” 하는 식의 private한 글이 훨씬 도움이 되더라.


### 느낀 점

- 책에 대한 느낌
    - 솔찍히 영한님 강의를 보다 지루하고 잠이 와서 이 책을 샀다. 책을 살땐 단순히 CI/CD 내용까지 포함되어있다길래 살짝 무지성으로 샀다. (+ 유명한 분이고 유명한 책이니까)
    - 살짝 무심하고 당연하다는 듯, 그리고 더 자세한 내용은 알아서 책 찾아 보라는 듯한 느낌의 쿨한 책이었다.
    - 그런데 그런 이 책의 스타일이 엄청 마음에 들었다. 너무 세세해서 지루하지도 않고, 저자가 말했듯이 따라하면서 재밌게 배울수 있는 수준이었다. 그리고 다른 곳에선 못 배웠던 점들이
      많아서 좋았다. (배울점에 적은 내용들)
    - 책 출시 시점과 현재의 버젼차이가 어마무시해서 예제코드만으로 책 진행이 안된다. 이 점에서 저자가 의도한건 아니겠지만 개발을 처음 접한 사람이라면 에러메시지 읽는 법 검색하는 법을 자연스레 습득할 수
      있다. 물론 그 와중에 나가 떨어지는 사람도 많을 것 같다. 특히나 배포까진 괜찮은데 CI/CD, 무중단 배포에선 나도 안해본 영역이라 트러블 슈팅이 꽤 오래 걸렸다.. 책을 접하고 무중단 배포 성공까지
      딱 48시간 걸렸다. 48시간 동안 제대로 몰입했다. 재밌는 책이었다.
- 나에 대한 느낌
    - 웹 개발 공부 초기엔 영상으로 공부하는걸 선호했다.
    - 영상을 통해 단축키들이나 개발 진행하는 순서 (예를 들면 영한님의 메서드 호출부 먼저 적고, 인텔리제이 기능으로 변수 선언 하는것, 메서드 추출 리팩토링 기능 사용하는 것 등) 등을
      배울 수 있어서 좋았다.
    - 하지만 이제는 영상강의가 지루하다는 생각을 하게 된다.
    - 책을 통해 공부하면 내가 아는 부분은 슥삭 빠르게 훑을 수 있지만 영상은 알아들을 수 있는 최대한의 빠르기가 있기에 2배 3배로 빠르게 넘길수가 없다. 혹시나 중요한게 있진 않을까 하면서 모든 걸 다
      봐야하는
      단점이 있다.. 다 보고 나면 실망하는 경험을 너무 많이 했다..
    - 책 vs 인강을 말하고 싶은건 아니고, 지금의 나는 책으로 공부하는게 좋다.
    - 살면서 책을 많이 읽어둬서 독서 습관이 있었던게 정말 다행인 것 같다. 읽고 싶은 좋은 책들이 많아서 좋다.
