package me.whiteship;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface AnotherAnnotation {

    String name() default "jungho";

    int number() default 100;

}
