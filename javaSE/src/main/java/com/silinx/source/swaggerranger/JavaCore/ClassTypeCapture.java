package com.silinx.source.swaggerranger.JavaCore;

public class ClassTypeCapture<T> {
    Class<?> kind;

    public ClassTypeCapture(Class<?> kind) {
        this.kind = kind;
    }

    public boolean f(Object obj) {
        return kind.isInstance(obj);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 =
                new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2 =
                new ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));

        Object[] objects = new Integer[5];

    }
}


class Building { }
class House extends Building { }