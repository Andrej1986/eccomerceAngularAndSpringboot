package com.soukupandrej.ecommerce.config;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.jmx.ManagementContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {
//    @Value("${activemq.broker.url}")
//    String brokerUrl;

    @Bean
    public BrokerService broker() throws Exception {

        final BrokerService broker = new BrokerService();
        broker.addConnector( "tcp://localhost:61615" );
        broker.setBrokerName("test");
        broker.setUseJmx(false);

//        broker.setPersistent( false );
//        broker.setShutdownHooks( Collections.< Runnable >singletonList( new SpringContextHook() ) );
        final ManagementContext managementContext = new ManagementContext();
        managementContext.setCreateConnector( true );
//        broker.setManagementContext( managementContext );
//        ActiveMQDestination q = ActiveMQDestination.createDestination("testQueue", ActiveMQDestination.QUEUE_TYPE);
//        ActiveMQDestination t = ActiveMQDestination.createDestination("testTopic", ActiveMQDestination.TOPIC_TYPE);
//        broker.setDestinations(new ActiveMQDestination[] { q, t });
        return broker;
    }
}
