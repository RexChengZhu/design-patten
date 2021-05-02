# 策略模式
策略模式的作用就是为了避免过多的if else 判断，事先定义好诸多类型和应对策略，等外界传来对应类型时，直接返回策略
```java
/**
* 加油站加油
*/
class GasStation{
    public Gas fill(Integer type){
        if (type = 92){
            return Gas92();
        }
        if (type = 95){
            return  Gas95();
        }
    }
}
/**
*   策略模式下的加油站
* 
*/
class StrategyGasStation{
    private static GasMap<Integer,Gas> gasMap;
    /**
    * 装载策略 
    */
    static {
        gasMap.put(92,Gas92());
        gasMap.put(95,Gas95());
    }
    
    public Gas fill(Integer type){
        return gasMap.get(type);
    }
}
```