package me.whiteship;

import com.sun.jdi.Value;

import java.lang.annotation.*;

// 기본값은 @Retention(RetentionPolicy.CLASS) 이다.
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface MyAnnotation {

    // Value 키워드로 값을 설정하면 애노테이션 선언 시 타입을 명시하지 않아도 된다.
    // 단, Value 키워드 1개의 값만 사용할 경우이고 다른 타입의 값을 같이 사용할 경우 Value 타입의 값도 타입을 명시해야 한다.
    // String value() default "jungho";

    // default 값을 설정하지 않으면 애노테이션 선언 시 값을 설정해 줘야한다.
    String name() default "jungho";

    int number() default 100;

}