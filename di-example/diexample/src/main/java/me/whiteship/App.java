package me.whiteship;

import me.whiteship.di.ContatinerService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AccountService accountService = ContatinerService.getObject(AccountService.class);
        accountService.join();
    }
}
