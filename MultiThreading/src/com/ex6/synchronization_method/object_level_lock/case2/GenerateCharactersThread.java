package com.ex6.synchronization_method.object_level_lock.case2;

public class GenerateCharactersThread extends Thread {
    Display display;

    public GenerateCharactersThread(Display display) {
        this.display = display;
    }

    @Override
    public void run() {
        display.displayCharacters();
    }
}
