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
