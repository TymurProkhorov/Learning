package annotationsLearning;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Простейшая аннотация
public @interface MyAnnotation {
}

// поинтереснее
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodInfo {
    String name() default "tim";
    int date() default 2022;
}
