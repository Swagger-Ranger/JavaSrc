package com.silinx.source.effectivejava.chapter2.item3.serializable;

import java.io.Serializable;

// Singleton with static factory (Page 17)
public class Elvis implements Serializable {
    //防止反序列化破坏单例，所有的实例字段都要设为transion的
    // readResolve method to preserve singleton property
    private Object readResolve() {
        // Return the one true com.silinx.source.effectivejava.chapter2.item3.serializable.Elvis and let the garbage collector
        // take care of the com.silinx.source.effectivejava.chapter2.item3.serializable.Elvis impersonator.
        return INSTANCE;
    }

    private static final Elvis INSTANCE = new Elvis();
    private Elvis() {
        //防止反射注入AccessibleObject.setAccessible;Method,Constructor 和 Fields都是其子类；constructor.newInstance();
        if (INSTANCE != null) {
            throw new IllegalStateException("单例不能实例化");
        }
    }
    public static Elvis getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}
