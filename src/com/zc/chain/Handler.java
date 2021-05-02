package com.zc.chain;

/**
 * Created by 祝程 on 2021-05-02.
 */
public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void doHandle(){
        boolean handle = handle();
        if (!handle && successor != null){
            successor.handle();
        }
    }
    public abstract boolean handle();
}
