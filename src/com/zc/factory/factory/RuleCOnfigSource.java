package com.zc.factory.factory;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by 祝程 on 2021-04-24.
 * 工厂方法实现
 * 相比于简单工厂方法，如果一个单独一个创建对象的过程已经很复杂，不想把所有 类型判断创建对象都放在一个工厂中
 * 根据每个后缀创建一个单独的工厂，然后再由一个创建工厂的工厂来进行路由
 */
public class RuleCOnfigSource {

    /**
     * 根据文件的后缀采取不同的解析器，将文件中的数据解析成 RuleConfig 对象
     * @param configPath
     * @return
     */
    public RuleConfig load(String configPath){

        String extension = getFileExtension(configPath);

        IRuleConfigParserFactory factory = IRuleConfigParserFactoryMap.getFactory(extension);

        IRuleConfigParser parser = factory.getParser();

        RuleConfig config = parser.parse(configPath);

        return config;
    }



    private String getFileExtension(String path){
        return "json";
    }


    /**
     * 工厂对象的工厂
     */
    public static class IRuleConfigParserFactoryMap{
        private  static Map<String,IRuleConfigParserFactory> factoryMap = new HashMap<>();

        static {
            factoryMap.put("json", new JsonRuleConfigParserFactory());
            factoryMap.put("xml", new XmlConfigParserFactory());
        }

        public static IRuleConfigParserFactory getFactory(String path){
            return factoryMap.get(path);
        }
    }

}
