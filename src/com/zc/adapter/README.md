# 适配器模式
## 作用
适配两个不兼容的接口，通过转接可以一起工作
```java
public interface FuncA{
    void func1();
    void func2();
    void func3();
}
public interface FuncB{
    void func4();
    void func2();
    void func7();    
}
public class ImplA implements FuncA{
    
}
```
### 类适配模式
```java
public class Adapter extends ImplA implements FuncB{
    void func4(){
        
    }
    void func2(){
        super.func2();
    }
    void func7(){
        
    }
}

```
### 对象适配模式
```java
public class Adapter implements FuncB{
    private FuncA func2;
     void func4(){
            func2.func1();
            // 
     }
     void func2(){
         func2.func2();
     }
     void func7(){
            
     }
}
```

## 使用场景

