package com.example.SK_Prj2_Rakic_Vasic.UserService;

import org.apache.activemq.broker.BrokerService;

public class MessageBroker {
    public static void main(String[] args) throws Exception {
        BrokerService brokerService = new BrokerService();

        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }

}
