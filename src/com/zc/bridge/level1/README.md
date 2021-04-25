在一开始的设计中如果需要增加新的需求需要修改
```java
public class Alert {
    private AlertRule alertRule;

    private Notification notification;

    public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
        long tps = 0;

        if (tps > alertRule.getMatchedRule("").getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.EMERGENCY,"");
        }

        if (errorCount > alertRule.getMatchedRule("").getErrorCount()){
            notification.notify(NotificationEmergencyLevel.NORMAL,"");
        }
   }
}
```
Check 的入参，那么所有调用原来check方法的地方都要进行修改
第二，check中的if 判断太多，增加业务需求之后也会修改到原有的方法

## 改进
新增 ApiInfo 类来代替入参，把每个if判断封装到不同的Handler中
