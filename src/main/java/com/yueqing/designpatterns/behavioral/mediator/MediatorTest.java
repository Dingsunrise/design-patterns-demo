package com.yueqing.designpatterns.behavioral.mediator;

/**
 * @author dingliming
 * @date 2022/8/7
 */
public class MediatorTest {

    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        mediator.setLoginComponent(new LoginComponent());
        mediator.setRegisterComponent(new RegisterComponent());
        mediator.handleEvent("login");
    }

}
