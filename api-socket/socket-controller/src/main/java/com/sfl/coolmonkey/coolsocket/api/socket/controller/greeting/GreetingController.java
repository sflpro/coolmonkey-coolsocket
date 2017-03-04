package com.sfl.coolmonkey.coolsocket.api.socket.controller.greeting;

import com.sfl.coolmonkey.coolsocket.service.model.greeting.Greeting;
import com.sfl.coolmonkey.coolsocket.service.model.greeting.HelloMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 20/05/16
 * Time: 14:05
 */
@Controller
public class GreetingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    //region Dependencies
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    //endregion

    //region Constructors
    public GreetingController() {
        LOGGER.debug("Initializing");
    }
    //endregion

    //region Public methods
    @MessageMapping("/greeting")
    public void greeting(SimpMessageHeaderAccessor headerAccessor, HelloMessage message) throws Exception {
        LOGGER.info("Greeting from - {}", message);
        simpMessagingTemplate.convertAndSend("/topic/greetings/arthur", new Greeting("/topic/greetings/arthur - " + message.getName()));
        simpMessagingTemplate.convertAndSend("/topic/greetings/foo", new Greeting("/topic/greetings/foo - " + message.getName()));
        simpMessagingTemplate.convertAndSendToUser("arthur", "/reply", new Greeting("/user/arthur/reply - " + message.getName()));
    }

    @SubscribeMapping("/topic/greetings/arthur")
    public Object topicSubsMapping(final Object object) {
        return object;
    }
    //endregion

}