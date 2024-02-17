package com.ex15.thread_group;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        System.out.println("child groupName = " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("parent groupName = " + Thread.currentThread().getThreadGroup().getParent().getName());

        //Create threadGroup
        ThreadGroup threadGroup1 = new ThreadGroup("Group-1");
        System.out.println("threadGroup = " + threadGroup1.getParent().getName());

        //Create threadGroup as a child of another ThreadGroup
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "Group-2");
        System.out.println("threadGroup2 = " + threadGroup2.getParent().getName());

        //Set Priority to Thread Group
        Thread.currentThread().getThreadGroup().setMaxPriority(10);
        threadGroup1.setMaxPriority(2);
        threadGroup2.setMaxPriority(1);

        //Create a Thread and assign to a Group
        Thread thread1 = new Thread(threadGroup1, "t-1");
        Thread thread2 = new Thread(threadGroup1, "t-2");
        Thread thread3 = new Thread(threadGroup1, "t-3");

        Thread thread4 = new Thread(threadGroup2, "t-4");
        Thread thread5 = new Thread(threadGroup2, "t-5");

        System.out.println("Main Group Priority = " + Thread.currentThread().getThreadGroup().getMaxPriority());
        System.out.println("threadGroup1 Priority = " + threadGroup1.getMaxPriority());
        System.out.println("threadGroup2Priority = " + threadGroup2.getMaxPriority());

        //Prints ThreadGroup and it's sub-ThreadGroup along with Threads
        threadGroup1.list();

        System.out.println("thread1 Priority= " + thread1.getPriority());
        System.out.println("thread2 Priority= " + thread2.getPriority());
        System.out.println("thread3 Priority= " + thread3.getPriority());

        System.out.println("thread4 Priority= " + thread4.getPriority());
        System.out.println("thread5 Priority= " + thread5.getPriority());

        Thread.currentThread().getThreadGroup().getParent().list();

    }
}
