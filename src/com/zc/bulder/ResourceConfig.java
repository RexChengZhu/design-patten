package com.zc.bulder;

import javax.annotation.Resource;

/**
 * Created by 祝程 on 2021-04-24.
 */
public class ResourceConfig {


    private String hostName;

    private Integer port;

    private Integer maxConnection;


    private ResourceConfig(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    public static class Builder {
        private final String DEFAULT_HOST = "localhost";
        private final Integer DEFAULT_PORT = 6379;

        private String hostName;

        private Integer port;

        private Integer maxConnection;

        public ResourceConfig build(){
            if (hostName == null){
                hostName = DEFAULT_HOST;
            }
            if (port == null){
                port = DEFAULT_PORT;
            }

            if (maxConnection != null){
                // 做一些逻辑校验
            }

            ResourceConfig config = new ResourceConfig(hostName, port);
            config.maxConnection = maxConnection;
            return config;
        }


        public String getHostName() {
            return hostName;
        }

        public Builder setHostName(String hostName) {
            this.hostName = hostName;
            return this;
        }

        public Integer getPort() {
            return port;
        }

        public Builder setPort(Integer port) {
            this.port = port;
            return this;
        }

        public Integer getMaxConnection() {
            return maxConnection;
        }

        public Builder setMaxConnection(Integer maxConnection) {
            this.maxConnection = maxConnection;
            return this;
        }
    }


}
