package com.silinx.source.swaggerranger.JavaCore.varHandler;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class Test {

    public static void main(String[] args) {

        Account account = new Account();
        var inc = new Thread(new Incrementer(account));
        var dec = new Thread(new Decrementer(account));
        inc.start();
        dec.start();
        try {
            inc.join();
            dec.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("安全的属性操作：" + account.amount);
        System.out.println("非安全的属性操作：" + account.unsafeAmount);

        try {
            VarHandle handle = MethodHandles.lookup().in(Account.class).findVarHandle(Account.class, "amount",
                    double.class);
            // 读取变量，如同该值声明了volatile
            var amount = handle.getVolatile(account);
            // 读取变量，如同该值未声明volatile
            var amount2 = handle.get(account);
            // 读取变量，保证指令优化之前，后续的修改或访问该变量的指令不会被重排序
            var amount3 = handle.getAcquire(account);
            // 读取变量，保证当前线程中的指令不会重排序，但不保证其他线程。
            var amount4 = handle.getOpaque(account);
            System.out.println(amount + "," + amount2 + "," + amount3 + "," + amount4);
            VarHandle handle2 = MethodHandles.lookup().in(Account.class).findVarHandle(Account.class, "unsafeAmount",
                    double.class);
            var unsafeAmount = handle2.get(account);
            System.out.println(unsafeAmount);
            // 设置变量，如同该值未声明volatile
            handle2.set(account,999);
            System.out.println(handle2.get(account));
            // 设置变量，如同该值声明了volatile
            handle2.setVolatile(account,777);
            System.out.println(handle2.getVolatile(account));
            // 设置变量，保证指令优化之前，后续的修改或访问该变量的指令不会被重排序
            handle2.setRelease(account,666);
            System.out.println(handle2.getAcquire(account));
            // 设置变量，保证当前线程中的指令不会重排序，但不保证其他线程。
            handle2.setOpaque(account,555);
            System.out.println(handle2.getOpaque(account));
//			handle2.weakCompareAndSet(account,555.0,333);
//			handle2.compareAndSet(account,555.0,333);
//			System.out.println(handle2.get(account));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
