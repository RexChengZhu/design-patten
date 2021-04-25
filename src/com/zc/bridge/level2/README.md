# 利用桥接模式继续优化代码
在level1 中 利用handler 和 ApiInfo 简化了Alert的代码
现在来看看 Notification类
```java
public class Notification {

    public void notify(NotificationEmergencyLevel level, String msg){
        if (NotificationEmergencyLevel.EMERGENCY.equals(level)){
            
        }
        if (NotificationEmergencyLevel.NORMAL.equals(level)){

        }
        if (NotificationEmergencyLevel.EMERGENCY.equals(level)){

        }
        if (NotificationEmergencyLevel.EMERGENCY.equals(level)){

        }
    }
}
```

业务中不同程度的紧急任务对应不同的告警方式，不需要通过硬编码的方式组合在一起
将通知类和推送类都提升为抽象类
```java
public abstract class Notification{
    private MsgSender sender;
    
    abstract void notify(String msg);
}

public abstract class MsgSender{
    abstract void send(String msg);
}
```
这样假设严重告警信息需要电话通知，则类表示
```java

public class SevereNotification extends Notification{
    public SevereNotification(MsgSender sender){
        super(sender);
    }
    
    @Override
    void notify(String msg){
        sender.send(msg);
    }
}
public class TelephoneMsgSender extends MsgSender{
    
    
    @Override
    void send(String msg){
        // 打电话的逻辑
    }
}
class Test{
    public static void main(String[] args){
      MsgSender sender = new MsgSender();
      Notification notification = new SevereNotification(sender);
      notification.nofity("告警");
    }
}
```
如果不使用桥接模式，采用继承的方式那么不同的告警对应不同的发送方式，会有类爆炸的风险
```java
class SevereTelephoneNotification{
    
}
class SevereEmailNotification{
    
}
class SevereLogNotification{
    
}
class NormalTelephoneNotification{
    
}
```
## 桥接模式就是把不同的业务通过分开抽象的方式，再组合到一起，防止类爆炸