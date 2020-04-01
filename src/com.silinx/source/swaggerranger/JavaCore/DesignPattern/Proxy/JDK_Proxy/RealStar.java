package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Proxy.JDK_Proxy;

/**
 *  这个是真实类
 */
public class RealStar implements Star {

    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }

    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar.signContract()");
    }

    @Override
    public void sing() {
        System.out.println("RealStar(周杰伦本人).sing()");
    }



}
