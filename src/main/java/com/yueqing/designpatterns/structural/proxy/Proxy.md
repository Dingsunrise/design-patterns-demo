# 代理模式

## 一 简介

意图
>为其他对象提供一个代理以控制对这个对象的访问。

**别名：** Surrogate
>
访问者模式允许一个或者多个操作应用到一组对象上，设计意图是解耦操作和对象本身，保持类职责单一、满足开闭原则以及应对代码的复杂性。

## 二 适用场景

1. 延迟初始化 （虚拟代理）。 如果你有一个偶尔使用的重量级服务对象， 一直保持该对象运行会消耗系统资源时， 可使用代理模式。你无需在程序启动时就
   创建该对象，可将对象的初始化延迟到真正有需要的时候。
2. 访问控制 （保护代理）。 如果你只希望特定客户端使用服务对象， 这里的对象可以是操作系统中非常重要的部分， 而客户端则是各种已启动的程序 
   （包括恶意程序）， 此时可使用代理模式。代理可仅在客户端凭据满足要求时将请求传递给服务对象。
3. 本地执行远程服务 （远程代理）。 适用于服务对象位于远程服务器上的情形。代理通过网络传递客户端请求，负责处理所有与网络相关的复杂细节。
4. 记录日志请求 （日志记录代理）。 适用于当你需要保存对于服务对象的请求历史记录时。代理可以在向服务传递请求前进行记录。
5. 缓存请求结果 （缓存代理）。 适用于需要缓存客户请求结果并对缓存生命周期进行管理时， 特别是当返回结果的体积非常大时。代理可对重复请求所需的
   相同结果进行缓存， 还可使用请求参数作为索引缓存的键值。
6. 智能引用。 可在没有客户端使用某个重量级对象时立即销毁该对象。代理会将所有获取了指向服务对象或其结果的客户端记录在案。 代理会时不时地遍历各个
   客户端， 检查它们是否仍在运行。 如果相应的客户端列表为空， 代理就会销毁该服务对象， 释放底层系统资源。代理还可以记录客户端是否修改了服务对象。
   其他客户端还可以复用未修改的对象。


## 三 实现方式

1. 静态代理
   组合模式，通过实现共同接口来实现
   继承模式，通过继承被代理类来实现

2. 动态代理
   运行的时候，动态地创建原始类对应的代理类，然后在系统中用代理类替换掉原始类，从而实现代理。

目前动态代理有java自带的Proxy类，类似的技术还有asm,cglib,javassist,byte-buddy
java中,动态代理的实现基于字节码生成技术(代码里就是newProxyInstance片段),可以在jvm运行时动态生成和加载字节码,平时编译java用的javac命令就是
字节码生成技术的"老祖宗"。
java中用到字节码生成技术的还有JSP编译器.AOP框架,反射等等。

深入理解java虚拟机第三版里对动态代理的描述:
动态代理中所说的"动态",是针对使用Java代码实际编写了代理类的"静态"代理而言的,它的优势不在于省去了编写代理类那一点编码工作量,而是实现了可以在
原始类和接口还未知的时候,就确定了代理类的行为,当代理类与原始类脱离直接联系后,就可以很灵活的重用于不同的应用场景之中
Java中的动态代理原理就是运行的时候通过asm在内存中生成一份字节码，而这个字节码就是代理类的字节码，通过
System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");设置可以保存这份字节码，反编译后看下其源码就
知道Java中的动态代理是什么原理了。
jdk动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。
而cglib动态代理是利用asm开源包，对被代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。   


## 四 优缺点

通过代理模式，可以在客户端毫无察觉的情况下控制服务对象。即使服务对象还未准备好或不存在，代理也可以正常工作。你可以在不对服务或客户端做出修改的
情况下创建新代理。但是代理模式也会使代码可能会变得复杂， 维护麻烦。

## 五 注意事项

代理模式会增加原代码的复杂度，如果代理比较多或层级比较深，会变的难以维护。

## 六 应用场景

**1 java中应用**
尽管代理模式在绝大多数 Java 程序中并不常见， 但它在一些特殊情况下仍然非常方便。 当你希望在无需修改客户代码的前提下于已有类的对象上增加额外行为
时，该模式是无可替代的。Java 标准程序库中的一些代理模式的示例：
java.lang.reflect.Proxy
java.rmi.*
javax.ejb.EJB （查看评论）
javax.inject.Inject （查看评论）
javax.persistence.PersistenceContext

**2 业务系统应用**
所以在业务系统中开发一些非功能性需求，比如：监控、统计、鉴权、限流、事务、幂等、日志等，比如Spring AOP;

**3 RPC框架**
另外RPC 框架也可以看作一种代理模式，

**4 Spring,缓存等**
代理模式也可以在缓存中得到应用，比如，针对获取用户个人信息的需求，我们可以开发两个接口，一个支持缓存，一个支持实时查询。对于需要实时数据的需求，
我们让其调用实时查询接口，对于不需要实时数据的需求，我们让其调用支持缓存的接口。那这个时候就可以使用动态代理，在应用启动的时候，我们从配置文件中
加载需要支持缓存的接口，以及相应的缓存策略（比如过期时间）等。当请求到来的时候，我们在 AOP 切面中拦截请求，如果请求中带有支持缓存的字段
（比如 http://…?..&cached=true），我们便从缓存（内存缓存或者 Redis 缓存等）中获取数据直接返回。

**识别方法：** 代理模式会将所有实际工作委派给一些其他对象。 除非代理是某个服务的子类， 否则每个代理方法最后都应该引用一个服务对象。


### 七 与其他模式关系

**适配器模式**
适配器模式能为被封装对象提供不同的接口， 代理模式能为对象提供相同的接口， 装饰模式则能为对象提供加强的接口。

**外观模式**
外观模式与代理的相似之处在于它们都缓存了一个复杂实体并自行对其进行初始化。 代理与其服务对象遵循同一接口， 使得自己和服务对象可以互换， 在这一点
上它与外观不同。

**装饰器模式**
装饰和代理有着相似的结构， 但是其意图却非常不同。 这两个模式的构建都基于组合原则， 也就是说一个对象应该将部分工作委派给另一个对象。 两者之间的
不同之处在于代理通常自行管理其服务对象的生命周期， 而装饰的生成则总是由客户端进行控制。