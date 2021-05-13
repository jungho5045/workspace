package me.whiteship;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
            f.
        });

        // constructor를 가져오기 위한 stream\
//        Class<Book> bookClass = Book.class;
//        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        // methods를 가져오기 위한 stream
//        Class<Book> bookClass = Book.class;
//        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        // field를 가져오기 위한 stream
//        Class<Book> bookClass = Book.class;
//        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
//            try{
//                f.setAccessible(true);
//                System.out.printf("%s %s\n", f, f.get(book));
//            } catch (IllegalAccessException e){
//                e.printStackTrace();
//            }
//        });

//        // 타입을 통할 때는 .class
//        Class<Book> bookClass = Book.class;
//
//        //getFields는 public만 리턴한다.
//        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
//
//        //getDeclaredFields()를 이용하면 모든 Field를 리턴한다.
//        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
//
//        Book book = new Book();

//        // 인스턴스를 이용할 때는 getClass()
//        Book book = new Book();
//        Class<? extends Book> aClass = book.getClass();
//
//        //풀패키지 경로 문자열만 알 경우 .forName()
//        Class<?> aClass2 = Class.forName("me.whiteship.Book");

    }
}
