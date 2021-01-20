package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.AtomicClass.AtomicRefrenceDemo;

/**
 * @author ext.liufei5
 * @Description
 * @date 2021-01-20
 */
public class BankCard {

    private final String accountName;
    private final int money;

    // 构造函数初始化 accountName 和 money
    public BankCard(String accountName,int money){
        this.accountName = accountName;
        this.money = money;
    }
    // 不提供任何修改个人账户的 set 方法，只提供 get 方法
    public String getAccountName() {
        return accountName;
    }
    public int getMoney() {
        return money;
    }
    // 重写 toString() 方法， 方便打印 BankCard
    @Override
    public String toString() {
        return "BankCard{" +
                "accountName='" + accountName + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
