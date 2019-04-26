package com.test.design;

public class Singleton {
    public static void main(String[] args) {
        RecycleBin recy = RecycleBin.getInstance();
        recy.delete("video");
    }
}

class RecycleBin {
    private static RecycleBin recycle = null;
    private RecycleBin(){}

    /**
     * 单例模式，这种是懒汉单例模式，在首次getInstance的时候创建实例
     * 另外一种是饿汉单例模式，在声明类属性的时候就通过new来创建对象
     * 构造函数重写为private，不允许通过外部访问
     */
    public static RecycleBin getInstance(){
        if(recycle == null) recycle = new RecycleBin();
        return recycle;
    }

    public static void delete(String para) {
        System.out.println(para + " has been recycled.");
    }
}