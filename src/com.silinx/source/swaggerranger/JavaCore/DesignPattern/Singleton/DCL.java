package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Singleton;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description 单例模式-双重检验加锁
 * @since 2020/7/1 9:25
 */

public class DCL {

    //关键点：变量必须用volitile来修饰，避免指令重排序，来导致可能在双重检验时
    /**
     * 防止new Singleton时指令重排序导致其他线程获取到未初始化完的对象。instance = new DCL()这句，这并非是一个原子操作，在JVM中大概做了下面3件事情。
     * 1.给 instance 分配内存
     * 2.调用 Singleton 的构造函数来初始化成员变量
     * 3.将instance对象指向分配的内存空间（执行完这步instance就为非 null 了）
     * 但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后报错
     *
     */
    private static volatile DCL instance;

    //关键点：构造函数私有
    private DCL() {

    }

    public static DCL getInstance() {

        // 关键点：这里先判断是否已经存中而不是先加锁，这样能提升性能
        if (null == instance) {
            synchronized (DCL.class) {
                // 关键点：这里还需要判断是否为空，因为可能在判断时别的线程已经构造了一个实例
                if (null == instance) {
                    instance = new DCL();
                }
            }
        }
        return instance;
    }


}
