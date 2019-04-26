package com.test.design;

import java.util.ArrayList;
import java.util.List;

public class FactoryDemo {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        card1.use();
        card2.use();
        System.out.println(((IDCardFactory) factory).getOwners().toString());
    }
}

abstract class Product {
    public abstract void use();
}

abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    abstract Product createProduct(String owner);
    abstract void registerProduct(Product product);
}

class IDCard extends Product {
    private String owner;
    IDCard(String owner) {
        System.out.println("制作"+owner+"的ID卡。");
        this.owner = owner;
    }
    public void use(){
        System.out.println("使用"+owner+"的ID卡。");
    }
    public String getOwner() {
        return owner;
    }
}

class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    Product createProduct(String owner) {
        return new IDCard(owner);
    }
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }
    public List getOwners() {
        return owners;
    }
}