SPRING源码基础学习的示例

### 初步使用 spring
要使用spring，只需要添加spring-context 的依赖包，然后就可以使用spring的基本的aop和aoc
比如这里@Component来注解了一个IndexService类，然后使用AnnotationConfigApplicationContext就可以获取到注入的bean
```java
AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        applicationContext.getBean(IndexService.class).index();
```
