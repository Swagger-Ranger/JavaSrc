# JDK动态代理
动态代理类 （以下简称为代理类 ）是一个实现在类创建时在运行时指定的接口列表的类，具有如下所述的行为。 代理接口是由代理类实现的接口。 代理实例是代理类的一个实例。 每个代理实例都有一个关联的调用处理程序对象，它实现了接口InvocationHandler 。 通过其代理接口之一的代理实例上的方法调用将被分派到实例调用处理程序的invoke方法，传递代理实例， java.lang.reflect.Method被调用方法的java.lang.reflect.Method对象以及包含参数的类型Object Object的数组。 调用处理程序适当地处理编码方法调用，并且返回的结果将作为方法在代理实例上调用的结果返回。

JDK动态代理涉及两个JDK的类和接口：
1.java.lang.reflect包下的Interface InvocationHandler
2.java.lang.reflect.Proxy。

### InvocationHandler接口
`public interface InvocationHandler`
InvocationHandler只有一个invoke方法，代理类必须实现本接口，并重写incoke()方法，invoke方法就是用来自定义你需要代理对象的实际行为
```
Object invoke(Object proxy, Method method, Object[] args)
       throws Throwable
```


### Proxy类
Proxy提供了创建动态代理类和实例的静态方法，它也是由这些方法创建的所有动态代理类的超类。并实现了Serializable序列化接口
`public class Proxy extends Object implements Serializable`

#### Proxy方法
Proxy类的方法都是静态方法
| 方法 |解释|
|---|---|
|static InvocationHandler     |     getInvocationHandler(Object proxy) 返回指定代理实例的调用处理程序。  |
|static Class<?>              |     getProxyClass(ClassLoader loader, Class<?>... interfaces) 给出类加载器和接口数组的代理类的 java.lang.Class对象。  |
|static boolean               |     isProxyClass(CLass<?> cl) 如果且仅当使用 getProxyClass方法或 newProxyInstance方法将指定的类动态生成为代理类时，则返回true。  |
|static Object                |     newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) 返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序。 |

#### 生成代理对象

方法一：
```Java
InvocationHandler handler = new MyInvocationHandler(...);
     Class<?> proxyClass = Proxy.getProxyClass(Foo.class.getClassLoader(), Foo.class);
     Foo f = (Foo) proxyClass.getConstructor(InvocationHandler.class).
                     newInstance(handler);
```
方法二：
```Java
Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),new Class<?>[] { Foo.class },  handler); 
```

### Proxy代理类的属性
代理类具有以下属性：
1. 代理类是公共的，最终的，而不是抽象的，如果所有代理接口都是公共的。
2. 如果任何代理接口是非公开的，代理类是非公开的，最终的，而不是抽象的 。
3. 代理类的不合格名称未指定。 然而，以字符串"$Proxy"开头的类名空间应该保留给代理类。
4. 一个代理类扩展了java.lang.reflect.Proxy 。
5. 代理类完全按照相同的顺序实现其创建时指定的接口。
6. 如果一个代理类实现一个非公共接口，那么它将被定义在与该接口相同的包中。 否则，代理类的包也是未指定的。 请注意，程序包密封不会阻止在运行时在特定程序包中成功定义代理类，并且类也不会由同一类加载器定义，并且与特定签名者具有相同的包。
7. 由于代理类实现了在其创建时指定的所有接口， getInterfaces在其类对象上调用getInterfaces将返回一个包含相同列表接口的数组（按其创建时指定的顺序），在其类对象上调用getMethods将返回一个数组的方法对象，其中包括这些接口中的所有方法，并调用getMethod将在代理接口中找到可以预期的方法。
8. Proxy.isProxyClass方法将返回true，如果它通过代理类 - 由Proxy.getProxyClass返回的类或由Proxy.newProxyInstance返回的对象的类 - 否则为false。
9. 所述java.security.ProtectionDomain代理类的是相同由引导类装载程序装载系统类，如java.lang.Object ，因为是由受信任的系统代码生成代理类的代码。 此保护域通常将被授予java.security.AllPermission 。
10. 每个代理类有一个公共构造一个参数，该接口的实现InvocationHandler ，设置调用处理程序的代理实例。 而不必使用反射API来访问公共构造函数，也可以通过调用Proxy.newProxyInstance方法来创建代理实例，该方法将调用Proxy.getProxyClass的操作与调用处理程序一起调用构造函数。

