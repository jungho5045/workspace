package me.whiteship;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        /*
        1. .class를 이용하여 리플렉션 시작
        Book.class
        */

        /*
        2. 직접 Book을 참조할 수 없는 상태일 경우 .Class의 forName을 이용한다.
        - 기존에는 newInstance()를 이용하여 인스턴스를 바로 만들 수 있었지만 현재는 Deprecated 되었기 때문에, Constructor를 이용하는 방법을 사용한다.
        - getConstructor()의 매개변수로 Null을 지정할 경우 기본 생성자가 호출된다.
        - 만약 파라매터를 가지고 있는 생성자를 호출 할 경우, 그 생성자가 받는 파라매터를 입력해주면된다.
          bookClass.getConstructor(String.class);
        */
        Class<?> bookClass = Class.forName("me.whiteship.Book");
        Constructor<?> constructor = bookClass.getConstructor(String.class);

        Book book = (Book) constructor.newInstance("myBook");
        System.out.println(book);

        /*
        3. Field의 값을 가져오기 위해 .get()을 사용한다.
        - Book 클래스에 선언된 A 필드는 static 변수이기 때문에 a.get()의 매개변수는 null을 사용한다.
        - Book 클래스에 선언된 A 필드에 값을 지정하기 위해서는 a.set()을 사용하가 첫번째 매개변수는 null, 두번째 매개변수는 값을 설정한다.

        Field a = Book.class.getDeclaredField("A");
        System.out.println(a.get(null));
        a.set(null, "AAAAAAA");
        System.out.println(a.get(null));
        */

        /*
        4. Book에 선언된 A(static) 필드와 다르게 B 필드는 Book 클래스를 인스턴스화 해야 생성이 된다.
        - 그렇기 위해 b.get(book) 객체를 매개변수로 지정한다.
        - 또한 접근 지정자가 private이기 때문에 Accessible을 true로 설정한다.

        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true);
        System.out.println(b.get(book));
        b.set(book, "BBBBB");
        System.out.println(b.get(book));
        */

        /*
        5. Book에 선언된 private 매소드를 가져오기 위해 .invoke를 사용한다.
        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book);
        */

        /*
        6. Book에 선언된 public 매소드를 가져오기 위해 .invoke를 사용한다.
        */
        Method d = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) d.invoke(book, 1, 2);
        System.out.println(invoke);

    }
}

