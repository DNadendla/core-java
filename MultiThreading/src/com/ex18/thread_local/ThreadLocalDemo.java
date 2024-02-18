package com.ex18.thread_local;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal(){
            @Override
            protected Object initialValue() {
                return "ABC";
            }
        };

        System.out.println("threadLocal = " + threadLocal.get());
        threadLocal.set(100);
        System.out.println("threadLocal = " + threadLocal.get());
        threadLocal.remove();
        System.out.println("threadLocal = " + threadLocal.get());

    }
}
