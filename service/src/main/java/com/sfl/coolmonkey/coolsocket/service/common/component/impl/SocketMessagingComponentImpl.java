package com.sfl.coolmonkey.coolsocket.service.common.component.impl;

import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import com.sfl.coolmonkey.coolsocket.service.common.component.SocketMessagingComponent;
import com.sfl.coolmonkey.coolsocket.service.model.channel.QueueChannelDestination;
import com.sfl.coolmonkey.coolsocket.service.model.channel.TopicChannelDestination;
import com.sfl.coolmonkey.coolsocket.service.model.channel.UserChannelDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 16:50
 */
@Component
public class SocketMessagingComponentImpl implements SocketMessagingComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketMessagingComponentImpl.class);

    //region Dependencies
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    //endregion

    //region Constructors
    public SocketMessagingComponentImpl() {
        LOGGER.debug("Initializing socket messaging component");
    }
    //endregion

    //region Public methods
    @Override
    public void sendToUser(@Nonnull final String user,
                           @Nonnull final UserChannelDestination destination,
                           @Nonnull final AbstractResponseModel message) {
        Assert.notNull(user, "The user should not be null");
        Assert.notNull(destination, "The user destination should not be null");
        assertMessage(message);
        simpMessagingTemplate.convertAndSendToUser(user, destination.getDestination(), message);
    }

    @Override
    public void sendToTopic(@Nonnull final TopicChannelDestination destination, @Nonnull final AbstractResponseModel message) {
        assertTopicDestinationNotNull(destination);
        assertMessage(message);
        simpMessagingTemplate.convertAndSend(destination.getDestination(), message);
    }

    @Override
    public void sendToQueue(@Nonnull final QueueChannelDestination destination, @Nonnull final AbstractResponseModel message) {
        Assert.notNull(destination, "The queue destination should not be null");
        assertMessage(message);
        simpMessagingTemplate.convertAndSend(destination.getDestination(), message);
    }

    @Override
    public void sendToAuthenticatedTopic(@Nonnull final String authToken,
                                         @Nonnull final TopicChannelDestination destination,
                                         @Nonnull final AbstractResponseModel message) {
        Assert.notNull(authToken, "The authentication toke should not be null");
        assertTopicDestinationNotNull(destination);
        assertMessage(message);
        simpMessagingTemplate.convertAndSend(destination.getDestination() + authToken, message);
    }
    //endregion

    //region Utility methods
    private void assertMessage(final AbstractResponseModel message) {
        Assert.notNull(message, "The message should not be null");
    }

    private void assertTopicDestinationNotNull(final @Nonnull TopicChannelDestination destination) {
        Assert.notNull(destination, "The topic destination should not be null");
    }
    //endregion
}
