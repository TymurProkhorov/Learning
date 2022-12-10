package reflectionAPILearning;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassesInJavaReflectAPI {
    Class<Person> personClass = Person.class;

    public void getMethodsFromPersonClass() {
        Method[] methods = this.personClass.getMethods();
        for(Method method: methods) {
            System.out.println(method.getName()
                    + ", "
                    + method.getReturnType()
                    + ", "
                    + Arrays.toString(method.getParameterTypes()));
        }
    }

    public void getFieldsFromPersonClass() {
        Field[] fields = this.personClass.getDeclaredFields(); // отображаются private поля, т.к. добавили declared
        for(Field field: fields) {
            System.out.println(field.getName() + ", " + field.getType());
        }
    }

    public void getAnnotationsFromPersonClass() {
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) { // если аннотация является экземпляром класса author, ...
                System.out.println("Yes");
            }
        }
    }
}
