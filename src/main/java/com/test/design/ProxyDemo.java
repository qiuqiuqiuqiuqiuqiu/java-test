package com.test.design;

public class ProxyDemo {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("现在的名字是 " + p.getPrinterName() + "。");
        p.setPrinterName("Bob");
        System.out.println("现在的名字是 " + p.getPrinterName() + "。");
        p.print("Hello, world.");
    }
}

interface Printable {
    void setPrinterName(String name);
    String getPrinterName();
    void print(String string);
}

class Printer implements Printable {
    private String name;
    public Printer() {
        heavyJob("Printer的实例生成中 ");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("Printer 的实例生成中 （" + name + "）");
    }

    public void setPrinterName(String name) {
        this.name = name;
    }

    public String getPrinterName() {
        return name;
    }

    public void print(String str) {
        System.out.println("=== " + name + " ===");
        System.out.println(str);
    }

    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i=0; i< 5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("结束。");
    }
}

class PrinterProxy implements Printable {
    private String name;
    private Printer real;
    public PrinterProxy() {
    }

    public PrinterProxy(String name) {
        this.name = name;
    }

    public synchronized void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }
    public String getPrinterName() {
        return name;
    }
    public void print(String str) {
        realize();
        real.print(str);
    }
    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}