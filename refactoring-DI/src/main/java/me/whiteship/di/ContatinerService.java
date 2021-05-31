package me.whiteship.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContatinerService {

    // 1. <T> type은 제네릭 타입으로 메소드를 리턴할 때 Object type으로 나오는 것이 아니라 매스드 파라매터로 넘겨주는 class type으로 리턴을 해준다.
    // 2. TestCode에서는 SourceCode를 참조 할 수 있지만, 반대로 SourceCode에서는 TestCode를 참조할 수 없다.
    public static <T> T getObject (Class<T> classType){
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
            if (f.getAnnotation(Inject.class) != null){
                Object fieldinstance = createInstance(f.getType());
                f.setAccessible(true);
                try {
                    f.set(instance, fieldinstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return instance;
    }

    private static <T> T createInstance(Class<T> classType){
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
