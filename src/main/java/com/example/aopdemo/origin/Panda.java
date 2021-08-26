package com.example.aopdemo.origin;

public class Panda implements Animal,Level {
    private String name;
    private String level = "level-1";

    public Panda() {
    }

    public Panda(String name) {
        this.name = name;
    }

    @Override
    public void eat(String something) {
        System.out.println("Panda have lunch.");
    }

    @Override
    public void run() {
        System.out.println("Panda run...");
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String level() {
        return level;
    }
}
