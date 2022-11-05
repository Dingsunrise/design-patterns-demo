package com.yueqing.designpatterns.behavioral.mediator;

/**
 * @author dingliming
 * @date 2022/8/7
 */
public class ConcreteMediator implements Mediator{
    private LoginComponent loginComponent;
    private RegisterComponent registerComponent;

    @Override
    public void handleEvent(String componentName) {
        if("login".equals(componentName)){
            loginComponent.login();
            registerComponent.register();
            return;
        }
        if("register".equals(componentName)){
            registerComponent.register();
            loginComponent.login();
        }
    }

    public void setLoginComponent(LoginComponent loginComponent) {
        this.loginComponent = loginComponent;
    }

    public void setRegisterComponent(RegisterComponent registerComponent) {
        this.registerComponent = registerComponent;
    }
}
