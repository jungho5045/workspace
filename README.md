# 1. 자바, JVM, JDK 그리고 JRE

![Untitled](https://user-images.githubusercontent.com/38093478/116171701-3abcd280-a744-11eb-8a3f-ccc1037a9d49.png)

## 1. **JVM (JAVA Virtual Machine)**

- 자바 가상 머신으로 자바 바이트 코드(.class 파일)를 OS에 특화된 코드로 변환(인터프리터와 JIT컴파일러)하여 실행한다.

    ex) [Hello.java](http://hello.java) 파일이 있다고 가정하자, Hello.java파일을 컴파일 하면 Hello.class파일이 생성된다. 이때 Hello.class 파일 안에 들어가 있는 것이 자바 바이트 코드이다.

    이 바이트코드는 인터프리터와 JIT를 이용하여 해당 OS맞는 기계어로 변환되어 실행된다.

- 바이트 코드를 실행하는 표준(JVM 자체는 표준)이자 구현체(특정 밴더가 구현한 JVM)다.
- JVM 스팩 : [https://docs.oracle.com/javase/specs/jvms/se11/html](https://docs.oracle.com/javase/specs/jvms/se11/html)
- JVM 밴더 : 오라클, 아마존, Azul, ...
- 특정 플랫폼에 종속적.

## 2. **JRE (JAVA Runtime Environment)**

- 자바 애플리케이션을 실행할 수 있도록 구성된 배포판.
- JVM과 핵심 라이브러리 및 자바 런타임 환경에서 사용하는 프로퍼티 세팅이나 리소스 파일을 가지고 있다.(JVM + 라이브러리)
- 개발 관련 도구는 포함하지 않는다. (그건 JDK에서 제공)

## 3. JDK (JAVA Development Kit)

- JRE + 개발에 필요한 툴
- 소스 코드를 작성할 때 사용하는 자바 언어는 플랫폼에 독립적.
- 오라클은 자바 11부터 JDK만 제공하며 JRE는 따로 제공하지 않는다.

## 4. 자바

- 프로그래밍 언어
- JDK에 들어있는 자바 컴파일러(javac)를 사용하여 바이트코드(.class 파일)로 컴파일 할 수 있다.
- 자바 유료화? 오라클에서 만든 Oracle JDK 11 버전부터 상용으로 사용할 때 유료.

## 5. JVM 언어

- JVM 기반으로 동작하는 프로그래밍 언어
- 클로저, 그루비, JRuby, Jython, Kotlin, Scala, ...




# 2. JVM 구조

![Untitled](https://user-images.githubusercontent.com/38093478/116171806-735cac00-a744-11eb-9cd5-7f974a90c6c7.png)

## 1. 클래스 로더 시스템

- .class 에서 바이트코드를 읽고 메모리에 저장
- 로딩 : 클래스 읽어오는 과정
- 링크 : 래퍼런스를 연결하는 과정
- 초기화 : static 값들 초기화 및 변수에 할당

## 2. 메모리

- 메소드 영역에는 클래스 수준의 정보 (클래스 이름, 부모 클래스 이름, 메소드, 변수) 저장. 공유자원이다.
- 힙 영역에는 객체를 저장. 공유자원이다.
- 스택 영역에는 쓰레드 마다 런타임 스택을 만들고, 그 안에 메소드 호출을 스택 프레임이라 부르는 블럭으로 쌓는다. 쓰레드 종료하면 런타임 스택도 사라진다.
- PC(Program Counter) 레지스터 : 쓰레드 마다 쓰레드 내 현재 실행할 instruction의 위치를 가리키는 포인터가 생성된다.
- 네이티브 메소드 스택
- [https://javapapers.com/core-java/java-jvm-run-time-data-areas/#Program_Counter_PC_Register](https://javapapers.com/core-java/java-jvm-run-time-data-areas/#Program_Counter_PC_Register)

## 3. 실행 엔진

- 인터프리터: 바이트 코드를 한줄 씩 실행.
- JIT 컴파일러: 인터프리터 효율을 높이기 위해, 인터프리터가 반복되는 코드를 발견하면 JIT 컴파일러로 반복되는 코드를 모두 네이티브 코드로 바꿔둔다. 그 다음부터 인터프리터는 네이티브 코드로 컴파일된 코드를 바로 사용한다.
- GC(Garbage Collector): 더이상 참조되지 않는 객체를 모아서 정리한다.

## 4. JNI(Java Native Interface)

- 자바 애플리케이션에서 C, C++, 어셈블리로 작성된 함수를 사용할 수 있는 방법 제공
- Native 키워드를 사용한 메소드 호출
- [https://medium.com/@bschlining/a-simple-java-native-interface-jni-example-in-java-and-scala-68fdafe76f5f](https://medium.com/@bschlining/a-simple-java-native-interface-jni-example-in-java-and-scala-68fdafe76f5f)

## 5. 네이티브 메소드 라이브러리

- C, C++로 작성 된 라이브러리!




# 3. 클래스 로더

![Untitled](https://user-images.githubusercontent.com/38093478/116171951-bfa7ec00-a744-11eb-9bd7-f95a7e0924e7.png)

## 1. 클래스 로더

- 로딩, 링크, 초기화 순으로 진행된다.
- 로딩
    - 클래스 로더가 .class 파일을 읽고 그 내용에 따라 적절한 바이너리 데이터를 만들고 “메소드” 영역에 저장.
    - 이때 메소드 영역에 저장하는 데이터
        - FQCN(Fully Qualified Class Name)
        - 클래스 | 인터페이스 | 이늄
        - 메소드와 변수
    - 로딩이 끝나면 해당 클래스 타입의 Class 객체를 생성하여 “힙" 영역에 저장.
- 링크
    - Verify, Prepare, Reolve(optional) 세 단계로 나눠져 있다.
    - 검증: .class 파일 형식이 유효한지 체크한다.
    - Preparation: 클래스 변수(static 변수)와 기본값에 필요한 메모리
    - Resolve: 심볼릭 메모리 레퍼런스를 메소드 영역에 있는 실제 레퍼런스로 교체한다.
- 초기화
    - Static 변수의 값을 할당한다. (static 블럭이 있다면 이때 실행된다.)
- 클래스 로더는 계층 구조로 이뤄져 있으면 기본적으로 세가지 클래스 로더가 제공된다.
    - 부트 스트랩 클래스 로더 - JAVA_HOME\lib에 있는 코어 자바 API를 제공한다. 최상위 우선순위를 가진 클래스 로더
    - 플랫폼(or 익스텐션) 클래스로더 - JAVA_HOME\lib\ext 폴더 또는 java.ext.dirs 시스템 변수에 해당하는 위치에 있는 클래스를 읽는다.
    - 애플리케이션 클래스로더 - 애플리케이션 클래스패스(애플리케이션 실행할 때 주는 -classpath 옵션 또는 java.class.path 환경 변수의 값에 해당하는 위치)에서 클래스를 읽는다.
