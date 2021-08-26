package com.example.aopdemo;

import com.example.aopdemo.origin.Animal;
import com.example.aopdemo.origin.Level;
import com.example.aopdemo.origin.Panda;
import com.example.aopdemo.proxy.AnimalInvocationHandler;
import com.example.aopdemo.proxy.CglibProxy;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Proxy;

@SpringBootTest
class JdkCglibProxyDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void jdkDynamicProxyTest(){
        Panda panda = new Panda("ming ming");
        AnimalInvocationHandler invocationHandler = new AnimalInvocationHandler(panda);
        Animal animal = (Animal) Proxy.newProxyInstance(Panda.class.getClassLoader(), Panda.class.getInterfaces(), invocationHandler);
        System.out.println(animal.getClass().getName());

        animal.eat("apple");
        System.out.println("----------------- eat --------------");
            animal.run();
        System.out.println("------------------ run -------------");
        String name = animal.getName();
        System.out.println(name);
        System.out.println("------------------ name ------------");

        Level level = (Level) Proxy.newProxyInstance(Panda.class.getClassLoader(), Panda.class.getInterfaces(), invocationHandler);
        System.out.println(level.getClass().getName());
        System.out.println(level.level());
    }

    @Test
    public void cglibTest(){
        CglibProxy cglibProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Panda.class);
        enhancer.setCallback(cglibProxy);
        Panda panda = (Panda) enhancer.create();
        System.out.println(panda.getClass().getName());
        panda.eat("apple");
        panda.run();
        System.out.println(panda.getName());
        System.out.println(panda.level());
        System.out.println("------------------------");
        System.out.println("toString():" + panda.toString());
        System.out.println("------------------------");
        System.out.println("hashCode():" + panda.hashCode());
        System.out.println("------------------------");
        System.out.println("class:" + panda.getClass());
    }

















}


























