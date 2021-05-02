package com.zc.chain;

import java.util.List;

/**
 * Created by 祝程 on 2021-05-02.
 */
public class HandlerChain {

    private List<Handler> chain;

    public void addHandler(Handler handler){
        chain.add(handler);
    }

    public void handle(){
        for (Handler handler : chain) {
            if (handler.handle()){
                break;
            }
        }
    }

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}
