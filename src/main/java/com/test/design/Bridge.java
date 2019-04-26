package com.test.design;

public class Bridge {
    public static void main(String[] args) {
        Car bigTruck = new BigTruck();
        Car smallCar = new SmallCar();
        AbstractRoad way = new SpeedWay();
        way.setCar(bigTruck);
        way.run();

        way.setCar(smallCar);
        way.run();
    }
}

interface Car {
    void run();
}

abstract class AbstractRoad {
    protected Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public abstract void run();
}

class SpeedWay extends AbstractRoad {
    @Override
    public void run() {
        car.run();
        System.out.println("on SpeedWay");
    }
}

class Street extends AbstractRoad {
    @Override
    public void run() {
        car.run();
        System.out.println("on Street");
    }
}

class SmallCar implements Car {
    @Override
    public void run() {
        System.out.println("small car");
    }
}

class BigTruck implements Car {
    @Override
    public void run() {
        System.out.println("big truck");
    }
}

abstract class People {
    protected AbstractRoad abstractRoad;

    public void setAbstractRoad(AbstractRoad abstractRoad) {
        this.abstractRoad = abstractRoad;
    }

    public abstract  void run();
}

class Man extends People {
    @Override
    public void run() {
        System.out.println("Man drive");
    }
}