# 观察者模式
分为观察者和被观察者，还有一个调度器。
被观察者向调度器注册观察者。当被观察者某些方法被执行了，想要通知观察者的时候，被观察者调用调度器的通知方法，之前注册的观察者就都可以收到通知

```java
// 调度器
class Dispatcher{
    List<Listener> listerers;
    
    public void register(Listener listener){
        listerers.add(listener);
    }
    
    public void notify(Message msg){
        for(Listener li : Listeners){
            Listener.notify(msg);
        }
    }
}

class Listener{
    public void notify(Message msg){
        // 处理消息类型
    }
}

class Observer{
    private Dispatcher dispatcher;
    
    public void addListener(){
        // 注册一些监听者
        dispatcher.register();
    }
    public void func1(){
        // 与监听无关的业务
    }
    
    // 该方法被调用了需要有人监听
    public void func2(){
        // 通知需要监听该事件的监听者
        dispatcher.notify();
        
    }
}

class  Message{
    
}
```