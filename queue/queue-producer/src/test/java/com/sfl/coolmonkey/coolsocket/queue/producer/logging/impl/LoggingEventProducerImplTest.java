package com.sfl.coolmonkey.coolsocket.queue.producer.logging.impl;

import com.sfl.coolmonkey.commons.queue.model.logging.CreateActivityLogEvent;
import com.sfl.coolmonkey.coolsocket.queue.producer.logging.LoggingEventProducer;
import com.sfl.coolmonkey.coolsocket.queue.producer.test.AbstractProducerImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 6/7/16
 * Time: 11:43 AM
 */
public class LoggingEventProducerImplTest extends AbstractProducerImplTest {

    //region Constants
    private static final String CREATE_ACTIVITY_LOG_QUEUE_ROUTE_PROPERTY_NAME = "createActivityLogQueueRoute";

    private static final String CREATE_ACTIVITY_LOG_QUEUE_ROUTE_PROPERTY_VALUE = "createActivityLog";
    //endregion

    //region Test subject and mocks
    @TestSubject
    private LoggingEventProducer loggingEventProducer = new LoggingEventProducerImpl();

    @Mock
    private RabbitTemplate rabbitTemplate;
    //endregion

    //region Constructors
    public LoggingEventProducerImplTest() {
    }
    //endregion

    //region Test methods

    //region initial
    @Test
    public void testHaveLoggingActionProducer() {
        resetAll();
        // expectations
        replayAll();
        assertNotNull(loggingEventProducer);
        verifyAll();
    }

    @Test
    public void testHaveRabbitTemplate() {
        resetAll();
        // expectations
        replayAll();
        assertNotNull(rabbitTemplate);
        verifyAll();
    }
    //endregion

    //region produceCreateActivityLogEvent
    @Test
    public void testProduceCreateActivityLogEventWithInvalidArgument() {
        resetAll();
        // expectations
        replayAll();
        try {
            loggingEventProducer.produceCreateActivityLogEvent(null);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        verifyAll();
    }

    @Test
    public void testProduceCreateActivityLogEvent() {
        resetAll();
        ReflectionTestUtils.setField(loggingEventProducer, CREATE_ACTIVITY_LOG_QUEUE_ROUTE_PROPERTY_NAME, CREATE_ACTIVITY_LOG_QUEUE_ROUTE_PROPERTY_VALUE);
        final CreateActivityLogEvent event = getHelper().createActivityLogEvent();
        // expectations
        rabbitTemplate.convertAndSend(CREATE_ACTIVITY_LOG_QUEUE_ROUTE_PROPERTY_VALUE, event);
        replayAll();
        loggingEventProducer.produceCreateActivityLogEvent(event);
        verifyAll();
    }
    //endregion

    //endregion

}