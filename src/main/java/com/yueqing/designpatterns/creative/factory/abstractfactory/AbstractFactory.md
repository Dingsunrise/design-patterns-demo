# 抽象工厂模式

## 一 简介

意图
>提供一个接口以创建一系列相关或相互依赖的对象，而无须指定它们具体的类。

别名
> kit


## 二 适用场景

抽象工厂是专门用来生成一系列相关的产品或产品家族，这些产品需要有着共同的生成方式。比如制作披萨，不同的披萨店铺制作出来的披萨都是不同的，
各种口味，调料都相差很大。但是这些披萨都有着共同的制作过程，所以可以使用抽象工厂，将制作过程抽象出来，再将制作使用的各种调料等，封装成
各个工厂方法，进行调用。

本次代码举的例子是，处理文件的抽象工厂，我们假设每个文件的处理都需要读取文件，解析文件，展示文件三个步骤。其中尽管不同的文件有着不同的读取
方式，不同的解析方式，以及不同的展示方式。但他们的处理流程都是读取，解析，展示三步，所以可用使用抽象工厂模式对其进行封装。

我们可以注意到，其实抽象工厂模式底层的实现，大都需要工厂方法模式和简单工厂模式来实现，主要是使用组合的方式进行处理。另一个角度看，工厂方法
有时候也是一种简化版的抽象工厂模式。

***类图***




## 三 实现方式

抽象工厂模式比较复杂，主要是涉及的类型及接口比较多，然后需要各种组合封装。但只要理清楚抽象的思路，底层实现相对而言并不复杂，可以使用工厂方法
模式+简单工厂模式组合起来。

## 四 优缺点

抽象工厂模式可以很好对一系列相关产品或产品家族封装起来，需要生成各个产品时，操作比较简单，后续也可以很好的继续扩展产品家族。但是抽象工厂模式也有
着很大的缺点，那就是一旦这些产品的共同生成方式发生变化，那就需要改动所有的子类，这个改动量将会很大。所以也导致了抽象工厂模式限制比较死，不能灵活
增加或者减少部分生成方式，解决这一缺点的一个灵活但是不太安全的方式是给创建对象的方法加个参数，通过参数来进行控制不同产品的创建。

## 五 注意事项

注意事项，一个是需要理清楚抽象的思路，不然容易绕进去，第二个也是刚说的缺点，抽象工厂模式限制的比较严格，难以改动，所以使用时需要充分评估业务场景
是否符合，不然后续生成方式若有变化，改动将会很大。

## 六 应用场景
抽象工厂模式在 Java 代码中很常见。 许多框架和程序库会将它作为扩展和自定义其标准组件的一种方式。

以下是来自核心 Java 程序库的一些示例：

javax.xml.parsers.DocumentBuilderFactory#newInstance()
javax.xml.transform.TransformerFactory#newInstance()
javax.xml.xpath.XPathFactory#newInstance()


### 七 与其他模式关系

***1 工厂方法模式***
在许多设计工作的初期都会使用工厂方法模式， 随后会慢慢演化为使用抽象工厂模式、 原型模式或生成器模式 （更灵活但更加复杂）。

**2 生成器模式**
生成器模式重点关注如何分步生成复杂对象。 抽象工厂专门用于生产一系列相关对象。 抽象工厂会马上返回产品， 生成器则允许你在获取产品前执行一些额外构
造步骤。

**3 原型模式**
抽象工厂模式通常基于一组工厂方法， 但你也可以使用原型模式来生成这些类的方法。

**4 外观模式**
当只需对客户端代码隐藏子系统创建对象的方式时， 你可以使用抽象工厂来代替外观模式。

**5 桥接模式**
你可以将抽象工厂和桥接模式搭配使用。 如果由桥接定义的抽象只能与特定实现合作， 这一模式搭配就非常有用。 在这种情况下， 抽象工厂可以对这些关系进
行封装， 并且对客户端代码隐藏其复杂性。

**6 单例模式**
抽象工厂、 生成器和原型都可以用单例模式来实现。