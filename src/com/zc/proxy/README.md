# 代理模式
代理模式是在不改变原有代码的情况下，通过代理类给原始类增加功能
## 基于接口代理
```java
public interface IUserController{
    void login();
    void register();
}

public class UserController implements IUserController{
    @Override
    public void login(){
        // 正常登陆逻辑
    }
    
    @Override
    public void register(){
        // 正常注册逻辑
    }
}
public class UserControllerProxy implements IUserController{
    private UserController userController;
    
    public UserControllerProxy(UserController controller){
        // 注入
        this.userController = controller;
    }
    
    @Override
        public void login(){
            // 做自己的事情
            
            // 原始类做事
            userController.login();
            
        }
        
        @Override
        public void register(){
            // 做自己的事情
            
            // 原始类做事
            userController.register();
        }
    
}
```
## 基于继承的代理
```java

public class UserController {
    public void login(){
        // 正常登陆逻辑
    }
    
    public void register(){
        // 正常注册逻辑
    }
}

public class UserControllerProxy extends UserController{
    @Override
    public void login(){
        // 代理类逻辑
        
        // 正常逻辑
        super.login();
    }
    
    @Override
    public void register(){
        // 代理类逻辑
              
        // 正常逻辑
        super.login();
    }
}
```

## 动态代理
上面的两种方法都需要编写实体代码来完成代理模式，java提供了动态代理机制
如果是面向接口的可以使用Proxy
```java
class ProxyDemo{
    public static void main(String[] args){
      Proxy.newProxyInstance()
    }
}
```
如果是基于继承的可以使用Gclib
















