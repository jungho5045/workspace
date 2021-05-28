package me.whiteship.di;

public class ContatinerService {

    // 1. getObject는 객체를 제네릭 타입으로 받아 객체를 return 하는 getObject를 만든다.
    // 2. TestCode에서는 SourceCode를 참조 할 수 있지만, 반대로 SourceCode에서는 TestCode를 참조할 수 없다.
    public static <T> T getObject (Class<T> classType){
        return null;
    }

}
