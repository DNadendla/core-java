package com.ex6.synchronization_method.object_level_lock.case2;

public class SynchronizedDemo {

    public static void main(String[] args) {
        Display display = new Display();

        GenerateNumbersThread numbersThread = new GenerateNumbersThread(display);
        numbersThread.start();

        GenerateCharactersThread charactersThread = new GenerateCharactersThread(display);
        charactersThread.start();


    }

}
