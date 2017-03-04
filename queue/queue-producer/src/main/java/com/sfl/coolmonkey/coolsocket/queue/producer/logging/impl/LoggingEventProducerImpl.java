package com.sfl.coolmonkey.coolsocket.queue.producer.logging.impl;

import com.sfl.coolmonkey.commons.queue.model.logging.CreateActivityLogEvent;
import com.sfl.coolmonkey.coolsocket.queue.producer.logging.LoggingEventProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 6/7/16
 * Time: 11:41 AM
 */
@Component
public class LoggingEventProducerImpl implements LoggingEventProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingEventProducerImpl.class);

    //region Dependencies
    @Value("#{appProperties['queue.create_activity_log']}")
    private String createActivityLogQueueRoute;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    //endregion

    //region Constructors
    public LoggingEventProducerImpl() {
        LOGGER.debug("Initializing logging action producer.");
    }
    //endregion

    //region Public methods
    @Override
    public void produceCreateActivityLogEvent(@Nonnull final CreateActivityLogEvent event) {
        assertCreateActivityLogEvent(event);
        rabbitTemplate.convertAndSend(createActivityLogQueueRoute, event);
    }
    //endregion

    //region Utility methods
    private void assertCreateActivityLogEvent(final @Nonnull CreateActivityLogEvent event) {
        Assert.notNull(event, "Create activity log event can not be null");
    }
    //endregion
}
