/**
 *     代理是做什么的,个人理解代理模式主要来解决代码复用的问题,即需要使用某个类的方法时,如何能做到解耦,直接的
 * 理解就是使用继承来获取要调用类的方法
 *     但继承不应该成为你一谈到代码复用就试图倚靠的万精油。比如，从一个拥有100个方法及
 * 字段的类进行继承就不是个好主意，因为这其实会引入不必要的复杂性。你完全可以使用代理
 * 有效地规避这种窘境，即创建一个方法通过该类的成员变量直接调用该类的方法。这就是为什
 * 么有的时候我们发现有些类被刻意地声明为final类型：声明为final的类不能被其他的类继
 * 承，避免发生这样的反模式，防止核心代码的功能被污染。
 *
 * 动态代理的3种方式
 * @author Swagger-Ranger
 * @since 2020/1/20 21:34
 */
package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Proxy;

