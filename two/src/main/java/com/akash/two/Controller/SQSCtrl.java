package com.akash.two.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@RestController
@RequestMapping(value = "/sqs")
public class SQSCtrl {

    private static final Logger logger = LoggerFactory.getLogger(SQSCtrl.class);

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${sqs.queue.name}")
    private String queueName;

    @GetMapping("/sendmsg/{msg}")
    public String sendMsg(@PathVariable("msg") String msg){
        MessageBuilder messageBuilder = MessageBuilder.withPayload(msg);
        queueMessagingTemplate.send(queueName, messageBuilder.build());
        return "Sent msg to SQS!";
    }

   /* @SqsListener(value = "StandardQueue")
    public void sqsListener(String msg){
        logger.info("Message Received using SQS Listner " + msg);
    }*/

}
