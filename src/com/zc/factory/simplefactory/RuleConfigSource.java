package com.zc.factory.simplefactory;

import java.text.SimpleDateFormat;

/**
 * Created by 祝程 on 2021-04-23.
 */
public class RuleConfigSource {


    /**
     * 根据文件的后缀采取不同的解析器，将文件中的数据解析成 RuleConfig 对象
     * @param configPath
     * @return
     */
    public RuleConfig load(String configPath){

        String extension = getFileExtension(configPath);
        // 调用简单工厂
        SimpleParserFactory factory = new SimpleParserFactory();
        IRuleConfigParser paser = factory.getRuleConfigParser(extension);

        RuleConfig config = paser.parse(configPath);
        return config;
    }



    private String getFileExtension(String path){
        return "json";
    }


    /**
     * 简单工厂
     */
    class SimpleParserFactory{
        /**
         * 提取复杂方法
         * @param extension
         * @return
         */
        public IRuleConfigParser getRuleConfigParser(String extension) {
            IRuleConfigParser paser = null;
            if ("json".equals(extension)){
                paser = new JsonRuleConfigPaser();
            }
            if ("xml".equals(extension)){
                paser = new XmlRuleConfigPaser();
            }
            return paser;
        }
    }
}
