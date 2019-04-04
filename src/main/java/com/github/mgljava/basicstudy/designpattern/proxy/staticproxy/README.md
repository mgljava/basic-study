### 代理模式 
代理模式是常用的java设计模式，他的特征是代理类与委托类有同样的接口，代理类主要负责为委托类预处理消息、过滤消息、
把消息转发给委托类，以及事后处理消息等。代理类与委托类之间通常会存在关联关系，一个代理类的对象与一个委托类的对象关联，
代理类的对象本身并不真正实现服务，而是通过调用委托类的对象的相关方法，来提供特定的服务。
分类：
   1. 静态代理：由程序员创建或特定工具自动生成源代码，再对其编译。在程序运行前，代理类的.class文件就已经存在了。
   2. 动态代理：在程序运行时，运用反射机制动态创建而成。
      2.1 InvocationHandler接口： 
      ```
      public interface InvocationHandler {   
          public Object invoke(Object proxy,Method method,Object[] args) throws Throwable;   
      }
      ```  
参数说明：   
* Object proxy：指被代理的对象。   
* Method method：要调用的方法   
* Object[] args：方法调用时所需要的参数可以将InvocationHandler接口的子类想象成一个代理的最终操作类，替换掉ProxySubject
Proxy类：Proxy类是专门完成代理的操作类，可以通过此类为一个或多个接口动态地生成实现类，此类提供了如下的操作方法：
---   
```
public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException
```
参数说明： 
* ClassLoader loader：类加载器 
* Class<?>[] interfaces：得到全部的接口 
* InvocationHandler h：得到InvocationHandler接口的子类实例 
* 动态代理类的字节码在程序运行时由Java反射机制动态生成
