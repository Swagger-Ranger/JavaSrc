package com.silinx.source.swaggerranger.JavaCore.Enum;

/**
 * 枚举类实现接口
 * 这个示例使用了一个枚举类套实现接口的枚举类来将事物根据其运动方式来进行做了一个列表
 */
public enum Enum_Advance_Interface {

    REPTILIA(Run.reptilia.class),
    BIRD(Run.birds.class);

    private Run[] values;

    private Enum_Advance_Interface( Class<? extends Run> kind ) {

        //通过Class来获取对象枚举实例
        values = kind.getEnumConstants();

    }

    public static void main( String[] args ) {
        for (Enum_Advance_Interface e:Enum_Advance_Interface.values()) System.out.println(e);
    }

}

interface Run {
    void move();

    enum reptilia implements Run{
        MAN,
        DOG,
        CAT,
        BIG
        ;

        @Override
        public void move() {
            System.out.println("walk");
        }
    }

    enum birds implements Run {
        CROW,
        EAGLE,
        BAT
        ;

        @Override
        public void move() {
            System.out.println("fly");
        }
    }
}
