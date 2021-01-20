package com.silinx.source.swaggerranger.JavaCore.Enum;

/**
 * 枚举单例,枚举当中只有一个枚举实例
 * 访问：Enum.INSTANCE就能访问
 * 实例化：枚举的实例化是由编译器来操作的，其构造方法只能由编译器访问
 * 序列化：举枚序列化是由jvm保证的，每一个枚举类型和定义的枚举变量在JVM中都是唯一的，
 *         在枚举类型的序列化和反序列化上，Java做了特殊的规定：在序列化时Java仅仅是将枚举对象的name属性输出到结果中，
 *         反序列化的时候则是通过java.lang.Enum的valueOf方法来根据名字查找枚举对象。编译器是不允许任何对这种序列化机制的定制的
 *         并禁用了writeObject、readObject、readObjectNoData、writeReplace和readResolve等方法，从而保证了枚举实例的唯一性
 * 反射：反射无法创建枚举的实例，枚举的实例只能由编译器创造,在使用reflect 包中Constructor新建实例时源码中就明确判断是否为枚举类型，
 *       如果是枚举类型则无法新建实例
 *
 * 但缺点就是，枚举时占用的内存常常是静态变量的两倍还多
 */
public enum Enum_Advance_Singleton {
    INSTANCE;

    //下面如同一个正常类一样来定义实例的属性和方法
    private String name;

    public String getName() { return name; }
    public void setName( String name ) { this.name = name; }

    public static void main( String[] args ) {
        System.out.println(Enum_Advance_Singleton.INSTANCE);
        Enum_Advance_Singleton.INSTANCE.setName("Swagger-Ranger");
        System.out.println(Enum_Advance_Singleton.INSTANCE.getName());
    }
}
