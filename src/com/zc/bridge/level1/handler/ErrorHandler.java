package com.zc.bridge.level1.handler;

import com.zc.bridge.level1.AlertRule;
import com.zc.bridge.level1.ApiInfo;
import com.zc.bridge.level1.Notification;
import com.zc.bridge.level1.NotificationEmergencyLevel;

/**
 * Created by 祝程 on 2021-04-25.
 */
public class ErrorHandler implements Handler {
    private AlertRule rule;

    private Notification notification;
    @Override
    public void handle(ApiInfo apiInfo) {
        if (apiInfo.getErrorCount()>rule.getMatchedRule(apiInfo.getApi()).getErrorCount()){
            notification.notify(NotificationEmergencyLevel.EMERGENCY,"");
        }
    }
}
