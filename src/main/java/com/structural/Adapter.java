package com.structural;

import java.sql.Connection;
import java.sql.DriverManager;

interface Bird {
    public void makeSound();
}

class Duck implements Bird{
    @Override
    public void makeSound() {
        System.out.println("Bird is making sound");
    }
}

interface ToyBird {
    public void squeak();
}

class ToyDuck implements ToyBird {

    @Override
    public void squeak() {
        System.out.println("Bird is squeaking...");
    }
}

class BirdAdapter implements Bird {
    ToyBird tb;
    public BirdAdapter(ToyBird tb) {
        this.tb = tb;
    }

    @Override
    public void makeSound() {
        tb.squeak();
    }
}

public class Adapter {
    public static void main(String[] args) {
        Bird duck = new Duck();
        duck.makeSound();
        Bird toyDuck = new BirdAdapter(new ToyDuck());
        toyDuck.makeSound();
    }
}
