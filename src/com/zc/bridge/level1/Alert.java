package com.zc.bridge.level1;

import com.zc.bridge.level1.handler.Handler;

import java.util.List;

/**
 * Created by 祝程 on 2021-04-25.
 * 告警类
 */
public class Alert {

    private List<Handler> handlers;

    public void addHandler(Handler handler){
        handlers.add(handler);
    }
    public void check(ApiInfo info) {
        for (Handler handler : handlers) {
            handler.handle(info);
        }

    }
}
