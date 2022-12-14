# 桥接模式

## 一 简介

意图：
> 将抽象部分与它的实现部分分离，使它们可以独立地变化。

**别名** Handle/Body

关于桥接模式，很多书籍、资料中，还有另外一种理解方式：
“一个类存在两个（或多个）独立变化的维度，我们通过组合的方式，让这两个（或多个）维度可以独立进行扩展。”通过组合关系来替代继承关系，避免继承层次的指数级
爆炸。这种理解方式非常类似于，我们之前讲过的“组合优于继承”设计原则。

个人理解，如果当前有多个维度的变化，则可把每种变化抽象出来，组合在一起，这种抽象可以是一个抽象方法，也可以是一个接口或 抽象类，或者一组抽象接口等等。
比如说JDBC 和 Driver 各自独立开发，通过对象之间的组合关系，组装在一起。JDBC 的所有逻辑操作，最终都委托给 Driver 来执行。
JDBC 本身就相当于“抽象”。注意，这里所说的“抽象”，指的并非“抽象类”或“接口”，而是跟具体的数据库无关的、被抽象出来的一套“类库”。具体的 Driver
（比如，com.mysql.jdbc.Driver）就相当于“实现”。注意，这里所说的“实现”，也并非指“接口的实现类”,而是跟具体数据库相关的一套“类库”。
JDBC和Driver独立开发，

桥接模式是一组类和另外一组类的组合，桥接就是面向接口编程的集大成者。面向接口编程只是说在系统的某一个功能上将接口和实现解藕，而桥接是详细的分析系统功能，
将各个独立的纬度都抽象出来，使用时按需组合。


## 二 适用场景

1. 如果你想要拆分或重组一个具有多重功能的庞杂类 （例如能与多个数据库服务器进行交互的类）， 可以使用桥接模式。
   类的代码行数越多， 弄清其运作方式就越困难， 对其进行修改所花费的时间就越长。 一个功能上的变化可能需要在整个类范围内进行修改， 而且常常会产生错误，
   甚至还会有一些严重的副作用。桥接模式可以将庞杂类拆分为几个类层次结构。 此后， 你可以修改任意一个类层次结构而不会影响到其他类层次结构。 这种方法可以
   简化代码的维护工作， 并将修改已有代码的风险降到最低。

2. 在几个独立维度上扩展一个类，可使用该模式。桥接建议将每个维度抽取为独立的类层次。初始类将相关工作委派给属于对应类层次的对象，无需自己完成所有工作。

3. 需要在运行时切换不同实现方法， 可使用桥接模式。当然并不是说一定要实现这一点， 桥接模式可替换抽象部分中的实现对象， 具体操作就和给成员变量赋新值一样
   简单。顺便提一句， 最后一点是很多人混淆桥接模式和策略模式的主要原因。 记住， 设计模式并不仅是一种对类进行组织的方式， 它还能用于沟通意图和解决问题。

## 三 实现方式

1. 明确类中独立的维度。 独立的概念可能是： 抽象/平台， 域/基础设施， 前端/后端或接口/实现。
2. 了解客户端的业务需求， 并在抽象基类中定义它们。
3. 确定在所有平台上都可执行的业务。 并在通用实现接口中声明抽象部分所需的业务。
4. 为你域内的所有平台创建实现类， 但需确保它们遵循实现部分的接口。
5. 在抽象类中添加指向实现类型的引用成员变量。 抽象部分会将大部分工作委派给该成员变量所指向的实现对象。
6. 如果你的高层逻辑有多个变体， 则可通过扩展抽象基类为每个变体创建一个精确抽象。
7. 客户端代码必须将实现对象传递给抽象部分的构造函数才能使其能够相互关联。此后，客户端只需与抽象对象进行交互，无需和实现对象打交道。

简单来说将业务中可能会变化的维度进行拆分，每个维度抽象出共同的接口，每个维度根据业务各自独立去实现各自接口完成扩展。最后通过组合的方式对各维度的实现进行调用。


## 四 优缺点

适配器模式可以将接口或数据转换代码从程序主要业务逻辑中分离。能在不修改现有客户端代码的情况下在程序中添加新类型的适配器。但这会使代码整体复杂度增加，
你需要新增一系列接口和类。 所以如果改动比较简单，可以直接更改服务类使其与其他代码兼容。


## 五 注意事项

桥接模式可以创建与平台无关的类和程序。仅与高层抽象部分进行互动，不会接触到具体实现。可以针对不同维度新增抽象部分和实现部分，且它们之间不会相互影响。每个
维度都符合单一职责原则，但桥接模式如果分类过多，实现比较复杂，组合起来就很麻烦，难以维护。


## 六 应用场景

桥接模式在处理跨平台应用、 支持多种类型的数据库服务器或与多个特定种类 （例如云平台和社交网络等） 的 API 供应商协作时会特别有用。

**识别方法：** 桥接可以通过一些控制实体及其所依赖的多个不同平台之间的明确区别来进行识别。

### 七 与其他模式关系

**适配器模式**
桥接模式通常会于开发前期进行设计， 使你能够将程序的各个部分独立开来以便开发。另一方面，适配器模式通常在已有程序中使用， 让相互不兼容的类能很好地合作。

**状态模式和策略模式**
桥接、 状态模式和策略模式 （在某种程度上包括适配器） 模式的接口非常相似。 实际上， 它们都基于组合模式——即将工作委派给其他对象， 不过也各自解决了不同的
问题。 模式并不只是以特定方式组织代码的配方， 你还可以使用它们来和其他开发者讨论模式所解决的问题。

**抽象工厂模式**
你可以将抽象工厂模式和桥接搭配使用。 如果由桥接定义的抽象只能与特定实现合作， 这一模式搭配就非常有用。 在这种情况下， 抽象工厂可以对这些关系进行封装，
并且对客户端代码隐藏其复杂性。

**生成器模式**
你可以结合使用生成器模式和桥接模式： 主管类负责抽象工作， 各种不同的生成器负责实现工作。