package me.whiteship.di;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ContatinerServiceTest {

    @Test
    public void getObject_BookRepository() {
        BookRepository bookRepository = ContatinerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }

    @Test
    public void getObject_BookService() {
        BookService bookService = ContatinerService.getObject(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }

}