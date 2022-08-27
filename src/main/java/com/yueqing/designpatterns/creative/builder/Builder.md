# 生成器模式

## 一 简介

意图
>将一个复杂对象的构建与它的表示分离。使得同样的构建过程可以创建不同的表示。

## 二 适用场景

生成器模式可以更加精细的控制构建过程，对于构造参数过多，且相互有依赖判断的对象来说，使用生成器模式就会非常方便了，一个类中有很多属性，为了避免
构造函数的参数列表过长，影响代码的可读性和易用性可以使用生成器模式。也避免了需要创建多个构造器。
如果类的属性之间有一定的依赖关系或者约束条件，比如某些字段的赋值依赖于另外的字段，这时候使用set赋值就非常不方便了，而使用生成器模式则可以很好的
解决这个问题。
最后如果需要创建一个不可变类，那就不能直接对外暴露set方法，这时候就可以适用生成器模式代替。

使用生成器模式可避免 “重叠构造函数” 的出现。

假设你的构造函数中有十个可选参数， 那么调用该函数会非常不方便； 因此， 你需要重载这个构造函数， 新建几个只有较少参数的简化版。 但这些构造函数仍需调用主构造函数， 传递一些默认数值来替代省略掉的参数。
生成器模式让你可以分步骤生成对象， 而且允许你仅使用必须的步骤。 应用该模式后， 你再也不需要将几十个参数塞进构造函数里了。

当你希望使用代码创建不同形式的产品 （例如石头或木头房屋） 时， 可使用生成器模式。

如果你需要创建的各种形式的产品， 它们的制造过程相似且仅有细节上的差异， 此时可使用生成器模式。
基本生成器接口中定义了所有可能的制造步骤， 具体生成器将实现这些步骤来制造特定形式的产品。 同时， 主管类将负责管理制造步骤的顺序。

使用生成器构造组合树或其他复杂对象。
生成器模式让你能分步骤构造产品。 你可以延迟执行某些步骤而不会影响最终产品。 你甚至可以递归调用这些步骤， 这在创建对象树时非常方便。
生成器在执行制造步骤时， 不能对外发布未完成的产品。 这可以避免客户端代码获取到不完整结果对象的情况。


***类图***


## 三 实现方式

生成器模式生成比较简单，使用Builder Generator插件就可以自动生成。

## 四 优缺点
生成器模式可以使复杂的构建过程变得简单优雅，易扩展，可以将复杂构造代码从产品的业务逻辑中分离出来。但相对的，也会试类增加很多代码增加了复杂性，
后续字段变动时，改动比较麻烦。

## 五 注意事项

生成器模式会使原来的类变的很复杂，后续字段变动，需要改动的地方都比较多，所以一般确认确实需要生成器模式时才用，不可滥用。

## 六 应用场景
生成器模式是 Java 世界中的一个著名模式。 当你需要创建一个可能有许多配置选项的对象时， 该模式会特别有用。

生成器在 Java 核心程序库中得到了广泛的应用：
java.lang.StringBuilder#append() （ 非同步 ）
java.lang.StringBuffer#append() （ 同步 ）
java.nio.ByteBuffer#put() （还有 CharBuffer、 ShortBuffer、 IntBuffer、 LongBuffer、 FloatBuffer 和 DoubleBuffer）
javax.swing.GroupLayout.Group#addComponent()
java.lang.Appendable的所有实现

识别方法： 生成器模式可以通过类来识别， 它拥有一个构建方法和多个配置结果对象的方法。 生成器方法通常支持方法链 （例如 someBuilder.setValueA(1).setValueB(2).create() ）。

### 七 与其他模式关系

***1 工厂方法模式***
在许多设计工作的初期都会使用工厂方法模式， 随后会慢慢演化为使用抽象工厂模式、 原型模式或生成器模式 （更灵活但更加复杂）。

**2 抽象工厂方法模式**
生成器模式重点关注如何分步生成复杂对象。 抽象工厂专门用于生产一系列相关对象。 抽象工厂会马上返回产品， 生成器则允许你在获取产品前执行一些额外构
造步骤。

**3 组合模式**
你可以在创建复杂组合模式树时使用生成器， 因为这可使其构造步骤以递归的方式运行。

**4 桥接模式**
你可以结合使用生成器和桥接模式： 主管类负责抽象工作， 各种不同的生成器负责实现工作。

**5 单例模式**
抽象工厂、 生成器和原型都可以用单例模式来实现。