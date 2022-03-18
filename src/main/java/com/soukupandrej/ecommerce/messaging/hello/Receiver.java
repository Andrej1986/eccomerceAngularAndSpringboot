package com.soukupandrej.ecommerce.messaging.hello;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

//    @JmsListener(destination = "mailbox2", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }

}
