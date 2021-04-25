package com.zc.bridge.normal;

/**
 * Created by 祝程 on 2021-04-25.
 * 告警类
 */
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
