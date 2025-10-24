package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import java.util.List;

@Configuration
public class LoggingWebServiceConfig extends WsConfigurerAdapter {

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        PayloadLoggingInterceptor loggingInterceptor = new PayloadLoggingInterceptor();
        interceptors.add(loggingInterceptor);
    }
}
