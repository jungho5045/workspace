package me.whiteship.di;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContatinerServiceTest {

    @Test
    public void getObject() {
        BookRepository bookRepository = ContatinerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }

}