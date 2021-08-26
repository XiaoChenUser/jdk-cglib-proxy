package com.example.aopdemo.proxy;

import com.example.aopdemo.origin.Animal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnimalInvocationHandler implements InvocationHandler {
    private Object target;

    public AnimalInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 对业务方法 weaving（织入）计时逻辑
     * @param proxy 以“$Proxy”开头，表示依据委托类生成的代理类的实例
     * @param method 委托类的方法信息组成的对象
     * @param args 委托类方法执行时需要传入的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy instanceof Animal);
        long start = System.currentTimeMillis();

        Object result = method.invoke(target, args);

        long end = System.currentTimeMillis();
        System.out.println(method.getName() + " cost " + (end - start) + " milliseconds.");
        return result;
    }
}
