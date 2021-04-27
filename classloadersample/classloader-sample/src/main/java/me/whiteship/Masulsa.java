package me.whiteship;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {

    public static void main(String[] args){
        ClassLoader classLoader = Masulsa.class.getClassLoader();
        TypePool typePool = TypePool.Default.of(classLoader);
        try {
            new ByteBuddy().redefine(
                    typePool.describe("me.whiteship.Moja").resolve(),
                    ClassFileLocator.ForClassLoader.of(classLoader))
                    .method(named("pullOut")).intercept(FixedValue.value("Rebbit!"))
                    .make().saveIn(new File("C:\\Users\\Jungho\\IdeaProjects\\whiteship\\classloadersample\\classloader-sample\\target\\classes\\"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(new Moja().pullOut());
    }
}
