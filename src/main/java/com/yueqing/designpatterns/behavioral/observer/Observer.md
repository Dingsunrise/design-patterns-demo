# 观察者模式

## 一 简介

意图
> 定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。

**别名：** 依赖，发布-订阅

## 二 适用场景

1. 当一个对象状态的改变需要改变其他对象， 或实际对象是事先未知的或动态变化的时， 可使用观察者模式。
2. 当应用中的一些对象必须观察其他对象时， 可使用该模式。 但仅能在有限时间内或特定情况下使用。
3. 将消息发送者和接收者解耦。


## 三 实现方式
我们可以直接使用java自带的Observer接口，不过极少使用。

1 同步阻塞方式
  同步阻塞的实现方式。观察者和被观察者代码在同一个线程内执行，被观察者一直阻塞，直到所有的观察者代码都执行完成之后，才执行后续的代码。

2 异步阻塞方式
  每次再创建一个新的线程执行代码。不过，我们还有更加优雅的实现方式，那就是基于Guava EventBus 来实现。

3 跨进程的实现方式
  如RPC调用，消息队列等等。


## 四 优缺点

无需修改发布者代码就能引入新的订阅者类。将发布者与接收者解耦，在运行时建立对象之间的联系。但订阅者的通知顺序是随机的，不能控制顺序。


## 五 注意事项

防止订阅者过多的情况，不然会变得难以管理。如果是跨进程调用，又会涉及到消息丢失与重试的问题。

## 六 应用场景
观察者模式在 Java 代码中很常见， 特别是在 GUI 组件中。 它提供了在不与其他对象所属类耦合的情况下对其事件做出反应的方式。

这里是核心 Java 程序库中该模式的一些示例：
java.util.Observer/java.util.Observable （极少在真实世界中使用）
java.util.EventListener的所有实现 （几乎广泛存在于 Swing 组件中）
javax.servlet.http.HttpSessionBindingListener
javax.servlet.http.HttpSessionAttributeListener
javax.faces.event.PhaseListener
识别方法： 该模式可以通过将对象存储在列表中的订阅方法， 和对于面向该列表中对象的更新方法的调用来识别。

### 七 与其他模式关系

**责任链模式、 命令模式、 中介者模式**
责任链模式、 命令模式、 中介者模式和观察者模式用于处理请求发送者和接收者之间的不同连接方式：
1 责任链按照顺序将请求动态传递给一系列的潜在接收者， 直至其中一名接收者对请求进行处理。
2 命令在发送者和请求者之间建立单向连接。
3 中介者清除了发送者和请求者之间的直接连接， 强制它们通过一个中介对象进行间接沟通。
4 观察者允许接收者动态地订阅或取消接收请求。

**中介者模式**
中介者和观察者之间的区别往往很难记住。 在大部分情况下， 你可以使用其中一种模式， 而有时可以同时使用。 让我们来看看如何做到这一点。
中介者的主要目标是消除一系列系统组件之间的相互依赖。 这些组件将依赖于同一个中介者对象。 观察者的目标是在对象之间建立动态的单向连接， 使得部分
对象可作为其他对象的附属发挥作用。

在观察者模式中，尽管一个参与者既可以是观察者，同时也可以是被观察者，但是，大部分情况下，交互关系往往都是单向的，一个参与者要么是观察者，要么是
被观察者，不会兼具两种身份。也就是说，在观察者模式的应用场景中，参与者之间的交互关系比较有条理。中介模式也是为了解耦对象之间的交互，所有的参与
者都只与中介进行交互。
除此之外，如果一个参与者状态的改变，其他参与者执行的操作有一定先后顺序的要求，这个时候，中介模式就可以利用中介类，通过先后调用不同参与者的方法，
来实现顺序的控制，而观察者模式是无法实现这样的顺序要求的。

有一种流行的中介者模式实现方式依赖于观察者。中介者对象担当发布者的角色，其他组件则作为订阅者，可以订阅中介者的事件或取消订阅。当中介者以
这种方式实现时，它可能看上去与观察者非常相似。
当你感到疑惑时，记住可以采用其他方式来实现中介者。例如，你可永久性地将所有组件链接到同一个中介者对象。这种实现方式和观察者并不相同，但这仍
是一种中介者模式。
假设有一个程序，其所有的组件都变成了发布者，它们之间可以相互建立动态连接。这样程序中就没有中心化的中介者对象， 而只有一些分布式的观察者。