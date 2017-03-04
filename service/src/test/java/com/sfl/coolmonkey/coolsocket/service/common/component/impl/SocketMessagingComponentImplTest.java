package com.sfl.coolmonkey.coolsocket.service.common.component.impl;

import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import com.sfl.coolmonkey.coolsocket.service.common.component.SocketMessagingComponent;
import com.sfl.coolmonkey.coolsocket.service.model.authentication.response.AuthenticationResponse;
import com.sfl.coolmonkey.coolsocket.service.model.channel.QueueChannelDestination;
import com.sfl.coolmonkey.coolsocket.service.model.channel.TopicChannelDestination;
import com.sfl.coolmonkey.coolsocket.service.model.channel.UserChannelDestination;
import com.sfl.coolmonkey.coolsocket.service.model.reporting.response.ReportingNotificationResponse;
import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.UUID;

import static org.junit.Assert.fail;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 16:53
 */
public class SocketMessagingComponentImplTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private final SocketMessagingComponent socketMessagingComponent = new SocketMessagingComponentImpl();

    @Mock
    private SimpMessagingTemplate simpMessagingTemplate;
    //endregion

    //region Constructors
    public SocketMessagingComponentImplTest() {
    }
    //endregion

    //region Test methods

    //region sendToUser
    @Test
    public void testSendToUserWithInvalidArguments() {
        // test data
        final AuthenticationResponse validResponse = createValidResponse();
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            socketMessagingComponent.sendToUser(null, UserChannelDestination.AUTHENTICATION, validResponse);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        try {
            socketMessagingComponent.sendToUser(UUID.randomUUID().toString(), null, validResponse);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        try {
            socketMessagingComponent.sendToUser(UUID.randomUUID().toString(), UserChannelDestination.AUTHENTICATION, null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testSendToUser() {
        // test data
        final UserChannelDestination destination = UserChannelDestination.AUTHENTICATION;
        final AbstractResponseModel message = createValidResponse();
        final String user = UUID.randomUUID().toString();
        // reset
        resetAll();
        // expectations
        simpMessagingTemplate.convertAndSendToUser(user, destination.getDestination(), message);
        // reply
        replayAll();
        // run test scenario
        socketMessagingComponent.sendToUser(user, destination, message);
        // verify
        verifyAll();
    }
    //endregion

    //region sendToTopic
    @Test
    public void testSendToTopicWithInvalidArguments() {
        // test data
        final AuthenticationResponse validResponse = createValidResponse();
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            socketMessagingComponent.sendToTopic(null, validResponse);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        try {
            socketMessagingComponent.sendToTopic(TopicChannelDestination.TIME_TRACKING_UPDATED, null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testSendToTopic() {
        // test data
        final TopicChannelDestination destination = TopicChannelDestination.TIME_TRACKING_UPDATED;
        final AbstractResponseModel message = createValidResponse();
        // reset
        resetAll();
        // expectations
        simpMessagingTemplate.convertAndSend(destination.getDestination(), message);
        // reply
        replayAll();
        // run test scenario
        socketMessagingComponent.sendToTopic(destination, message);
        // verify
        verifyAll();
    }
    //endregion

    //region sendToQueue
    @Test
    public void testSendToQueueWithInvalidArguments() {
        // test data
        final AuthenticationResponse validResponse = createValidResponse();
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            socketMessagingComponent.sendToQueue(null, validResponse);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        try {
            socketMessagingComponent.sendToQueue(QueueChannelDestination.DUMMY, null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testSendToQueue() {
        // test data
        final QueueChannelDestination destination = QueueChannelDestination.DUMMY;
        final AbstractResponseModel message = createValidResponse();
        // reset
        resetAll();
        // expectations
        simpMessagingTemplate.convertAndSend(destination.getDestination(), message);
        // reply
        replayAll();
        // run test scenario
        socketMessagingComponent.sendToQueue(destination, message);
        // verify
        verifyAll();
    }
    //endregion

    //region sendToAuthenticatedTopic
    @Test
    public void testSendToAuthenticatedTopicWithInvalidArguments() {
        resetAll();
        final ReportingNotificationResponse validResponse = getHelper().createReportingNotificationResponse();
        replayAll();
        try {
            socketMessagingComponent.sendToAuthenticatedTopic(null, TopicChannelDestination.TIME_TRACKING_UPDATED, validResponse);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        try {
            socketMessagingComponent.sendToAuthenticatedTopic(UUID.randomUUID().toString(), null, validResponse);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        try {
            socketMessagingComponent.sendToAuthenticatedTopic(UUID.randomUUID().toString(), TopicChannelDestination.TIME_TRACKING_UPDATED, null);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        verifyAll();
    }

    @Test
    public void testSendToAuthenticatedTopic() {
        resetAll();
        final String authToken = UUID.randomUUID().toString();
        final TopicChannelDestination timeTrackingUpdatedTopicDestination = TopicChannelDestination.TIME_TRACKING_UPDATED;
        final ReportingNotificationResponse response = getHelper().createReportingNotificationResponse();
        // expectations
        simpMessagingTemplate.convertAndSend(timeTrackingUpdatedTopicDestination.getDestination() + authToken, response);
        replayAll();
        socketMessagingComponent.sendToAuthenticatedTopic(authToken, timeTrackingUpdatedTopicDestination, response);
        verifyAll();
    }
    //endregion

    //endregion

    //region Utility methods
    private AuthenticationResponse createValidResponse() {
        return new AuthenticationResponse();
    }
    //endregion

}