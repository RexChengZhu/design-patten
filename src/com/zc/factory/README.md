# 工厂模式
工厂模式常用的分为简单工厂和工厂模式，抽象工厂模式不常用
## 简单工厂模式
当new 一个对象步骤很复杂的时候，可以使用简单工厂模式，把复杂的创建方法放到工厂中，对外暴露的只有简单工厂对象的方法
```java
// 普通创建模式
Person person = new Person();
// 可能还需要加载配置文件
Config config = new Config();
person.setConfig(config);
// http请求外部资源等等

return Person;


// 简单工厂模式
class SimpleFactory{
    public Person getPerson(){
        Person person = new Person();
        // 可能还需要加载配置文件
        Config config = new Config();
        person.setConfig(config);
        // http请求外部资源等等
        
        return Person;
    }
}

// 对于外部来说
SimpleFactory factory = new SimpleFactory();
Person person =  factory.getPerson();
```
## 工厂模式
假设创建对象的方式有很多种，如果都放在简单工厂内，违反 ``单一职责原则`` 所以需要创建不同的工厂来完成不同状态对象的创建
但是这样一来，不同状态的判断又会回到代码中判断，于是创建一个 工厂来判断这些状态，然后在工厂中再返回一个专门生产的工厂。
这就是工厂模式

# 总结
简单工厂和工厂模式的使用场景是当 new 对象很复杂的时候，可以使用工厂封装细节。
## 简单工厂和工厂的使用场景
如果创建的对象没有那么多种类，可以使用简单工厂。
如果有很多不同类别，则使用工厂模式。
### 切勿过度设计，如果短期不存在多种种类的对象，就不要使用工厂模式，简单工厂即可