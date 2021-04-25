package com.zc.bulder;

/**
 * Created by 祝程 on 2021-04-24.
 */
public class BuilderDemo {
    public static void main(String[] args) {
        ResourceConfig config = new ResourceConfig.Builder()
                .setHostName("sdsd")
                .setPort(123)
                .setMaxConnection(1111)
                .build();



    }
}
