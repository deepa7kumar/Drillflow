package com.hashmapinc.tempus.witsml.server;

import javax.xml.ws.Endpoint;

import org.apache.catalina.Store;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hashmapinc.tempus.witsml.server.api.StoreImpl;

@Configuration
public class WitsmlApiConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new StoreImpl());
        endpoint.publish("/WMLS");
        return endpoint;
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
}