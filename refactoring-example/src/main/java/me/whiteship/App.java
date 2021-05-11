package me.whiteship;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        // 타입을 통할 때는
        Class<Book> bookClass = Book.class;

        // 인스턴스를 이용할 때는 getClass()
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

    }
}
