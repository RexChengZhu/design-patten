# 建造者模式
## 什么是建造者模式
建造者模式可以简单的理解为在一个需要创建的对象中定一个一个Builder 类，由它来组织对象的创建工作
```java
class RedisConfig{
    // 必填项
    private String hostName;
    private Integer port;
    
    // 非必填项
    private Integer maxConnection;
    private Integer minConnection;
    
    // 隐藏构造方法
    private RedisConfig(String hostName,Integer port){
        this.hostName = hostName;
        this.port = port;
    }
    /**
    *  建造者
    */
    public class Builder{
        // 必填项
        private String hostName;
        private Integer port;
        
        // 非必填项
        private Integer maxConnection;
        private Integer minConnection;
        
        public RedisConfig build(){
            // 做参数校验等等工作
            return new RedisConfig(hostName,port);    
        }
        
        public Builder setHostName(String hostName){
            return this;
        }
        
        public Builder setPort(Integer port){
            return this;
        }
    }
    
    public static void main(String[] args){
        Builder builder =  new RedisConfig.Builder().setHostName("").setPort(12);
        RedisConfig conf = builder.build();
    }
}
```
## 何时用建造者模式，如何从工厂模式和建造者模式中选取用哪种方式创建对象？
建造者模式的场景是当new对象参数之间有依赖关系，需要做一些校验工作，单纯的new 对象再用set方法注入属性，就做不了参数的验证工作
如:
```java
Config config =  new RedisConfig("hostName",12);
config.setMaxConnec(100);

// 假设config 作用是设置了 maxConn 之后，必须要设置 ConnectionPool ，否则就不让用，但是如果直接new 对象则 可以直接被使用
```
### 如何选用
工厂模式创造出来的对象创造的细节对外部不可见，用户直接调用工厂的getInstance方法就获得了。
而建造者模式，用户需要自己指定一些细节参数，只是校验工作对用户不可知。