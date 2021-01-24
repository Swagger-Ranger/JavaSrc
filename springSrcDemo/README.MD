SPRING源码基础学习的示例

### 初步使用 spring
要使用spring，只需要添加spring-context 的依赖包，然后就可以使用spring的基本的aop和aoc
比如这里@Component来注解了一个IndexService类，然后使用AnnotationConfigApplicationContext就可以获取到注入的bean
```java
AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        applicationContext.getBean(IndexService.class).index();
```

### spring的面向切面
[spring文档](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop)
#### 面向切面的几个基本概念
- Aspect: 切面：即你要切入进去的功能的集合，也就是一个类 -- @Aspect 类上
- Join point: 连接点，与切点关联，切点是指具体要做的操作，而链接点就是定义要做操作的位置  @Pointcut(execution(代码位置)) 方法上
- Advice: 通知：具体要增强的业务逻辑的时机，@Before @After

- Pointcut: 切点：切面中具体的操作，也就是切面类中的一个方法

- Introduction: 

- Target object: 目标对象，被代理的对象

- AOP proxy: 代理对象，为执行代理操作而动态生成的对象

- Weaving:  编织

##### spring中启动用AspectJ的支持
*注意spring中没有使用aspectJ的切面实现，只是使用了aspectJ的定义和语法* 
spring中使用切面需要加入切面的支持配置：
```java 
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
}
```
或者xml中
```xml
<aop:aspectj-autoproxy/>
```

### spring的aop

#### 如何阅读源码
阅读源码很关键的一点是，代码太多完全不知道该读哪里，不该读哪里，而在不重要的地方花费了太多的时间；如何提升阅读效率避免在代码中迷路呢：
从关键代码点进去，然后判断代码的上下文是否对当前代码要实现有影响，比如我要返回一个对象，那么只是对条件做判断的代码就没必要去看，
而相应的那些会返回我们对象的代码就应该点进去看，同时呢，使用断点的技巧进去，判断evaluate expression来判断当前的代码分支是否返回了我们的代码，
这样就能避免去看当前不重要的代码分支；

#### spring的实现例子
这里使用的spring源码是5.1.x
从源码入手去阅读spring的源码

##### 自定義spring的動態注入





