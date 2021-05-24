package me.whiteship;

@MyAnnotation("jungho")
public class Book {

    private static String B = "Book";

    private static final String C = "Book";

    @MyAnnotation
    private String a = "a";

    public String d = "d";

    protected String e = "e";

    public Book() {
    }

    @AnotherAnnotation
    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    @AnotherAnnotation
    public void g(){
        System.out.println("g");
    }

    public int h(){
        return 100;
    }
}
