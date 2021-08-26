package com.example.aopdemo.proxy;



import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println(obj.getClass().getName());
        long start = System.currentTimeMillis();

        Object result = proxy.invokeSuper(obj, args);

        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start));
        return result;
    }


//    @Override
//    public Object invoke(MethodInvocation invocation) throws Throwable {
//        return null;
//    }
}
