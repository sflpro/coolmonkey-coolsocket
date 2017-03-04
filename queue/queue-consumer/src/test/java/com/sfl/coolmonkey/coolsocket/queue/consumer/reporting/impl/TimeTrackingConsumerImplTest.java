package com.sfl.coolmonkey.coolsocket.queue.consumer.reporting.impl;

import com.sfl.coolmonkey.commons.queue.model.reporting.TimeTrackingUpdatedEvent;
import com.sfl.coolmonkey.coolsocket.queue.consumer.reporting.TimeTrackingConsumer;
import com.sfl.coolmonkey.coolsocket.queue.consumer.test.AbstractConsumerImplTest;
import com.sfl.coolmonkey.coolsocket.service.common.component.SocketMessagingComponent;
import com.sfl.coolmonkey.coolsocket.service.model.channel.TopicChannelDestination;
import com.sfl.coolmonkey.coolsocket.service.model.reporting.ReportingMessageType;
import com.sfl.coolmonkey.coolsocket.service.model.reporting.response.ReportingNotificationResponse;
import org.apache.commons.lang3.SerializationUtils;
import org.easymock.Capture;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;

import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.eq;
import static org.junit.Assert.*;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 5/30/16
 * Time: 3:01 PM
 */
public class TimeTrackingConsumerImplTest extends AbstractConsumerImplTest {

    //region Test subject and mocks
    @TestSubject
    private TimeTrackingConsumer timeTrackingConsumer = new TimeTrackingConsumerImpl();

    @Mock
    private SocketMessagingComponent socketMessagingComponent;
    //endregion

    //region Constructors
    public TimeTrackingConsumerImplTest() {
    }
    //endregion

    //region Test methods

    //region initial
    @Test
    public void testHaveTimeTrackingConsumer() {
        resetAll();
        replayAll();
        assertNotNull(timeTrackingConsumer);
        verifyAll();
    }

    @Test
    public void testHaveSocketMessagingComponent() {
        resetAll();
        replayAll();
        assertNotNull(socketMessagingComponent);
        verifyAll();
    }
    //endregion

    //region consumeUpdatedEvent
    @Test
    public void testConsumeUpdatedEventWithInvalidArguments() {
        resetAll();
        final TimeTrackingUpdatedEvent validEvent = getHelper().createTimeTrackingUpdatedEvent();
        TimeTrackingUpdatedEvent invalidEvent;
        replayAll();
        invalidEvent = null;
        try {
            timeTrackingConsumer.consumeUpdatedEvent(invalidEvent);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        invalidEvent = SerializationUtils.clone(validEvent);
        invalidEvent.setAuthToken(null);
        try {
            timeTrackingConsumer.consumeUpdatedEvent(invalidEvent);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        verifyAll();
    }

    @Test
    public void testConsumeUpdatedEvent() {
        resetAll();
        final Capture<ReportingNotificationResponse> responseCapture = new Capture<>();
        final TimeTrackingUpdatedEvent event = getHelper().createTimeTrackingUpdatedEvent();
        final String authToken = event.getAuthToken();
        socketMessagingComponent.sendToAuthenticatedTopic(eq(authToken), eq(TopicChannelDestination.TIME_TRACKING_UPDATED), capture(responseCapture));
        replayAll();
        timeTrackingConsumer.consumeUpdatedEvent(event);
        verifyAll();
        final ReportingNotificationResponse response = responseCapture.getValue();
        assertEquals(ReportingMessageType.TIME_TRACKING_UPDATED, response.getType());
    }
    //endregion

    //endregion

}
