package com.zc.bridge.level2;

import java.util.Map;

/**
 * Created by 祝程 on 2021-04-25.
 * 告警规则，自由配置
 */
public class AlertRule {
    private Map<String, Rule> ruleMap;


    public Rule getMatchedRule(String api){
        return ruleMap.get(api);
    }

}
