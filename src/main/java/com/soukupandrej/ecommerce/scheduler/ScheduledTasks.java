package com.soukupandrej.ecommerce.scheduler;

import com.soukupandrej.ecommerce.messaging.hello.Email;
import org.apache.activemq.broker.BrokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Map;

@Component
public class ScheduledTasks implements ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static ApplicationContext applicationContext;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }

    @Scheduled(fixedRate = 15000)
    public static void sendMessageRepetitively () {
        System.out.println("Sending an email message.");
        JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
        Map<String,BrokerService> brokerService = applicationContext.getBeansOfType(BrokerService.class);
        jmsTemplate.convertAndSend("mailbox2", new Email("info@example.com", "Hello"));
        brokerService.forEach((k,v) -> System.out.println(v));
//        System.out.println(brokerService.getBrokerName());
//        System.out.println(brokerService.getVmConnectorURI());

    }
}
