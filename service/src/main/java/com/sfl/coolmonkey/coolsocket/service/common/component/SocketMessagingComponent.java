package com.sfl.coolmonkey.coolsocket.service.common.component;

import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import com.sfl.coolmonkey.coolsocket.service.model.channel.QueueChannelDestination;
import com.sfl.coolmonkey.coolsocket.service.model.channel.TopicChannelDestination;
import com.sfl.coolmonkey.coolsocket.service.model.channel.UserChannelDestination;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 16:46
 */
public interface SocketMessagingComponent {
    /**
     * Push / Send message to user channel.
     *
     * @param user        the user
     * @param destination the destination
     * @param message     the message
     */
    void sendToUser(
            @Nonnull final String user,
            @Nonnull final UserChannelDestination destination,
            @Nonnull final AbstractResponseModel message
    );

    /**
     * Send / Push message to topic channel.
     *
     * @param destination the destination
     * @param message     the message
     */
    void sendToTopic(@Nonnull final TopicChannelDestination destination, @Nonnull final AbstractResponseModel message);

    /**
     * Send / Push message to queue channel.
     *
     * @param destination the destination
     * @param message     the message
     */
    void sendToQueue(@Nonnull final QueueChannelDestination destination, @Nonnull final AbstractResponseModel message);

    /**
     * Send / Push message to authenticated topic channel.
     *
     * @param authToken   the auth token
     * @param destination the time tracking updated
     * @param message     the message
     */
    void sendToAuthenticatedTopic(
            @Nonnull final String authToken,
            @Nonnull final TopicChannelDestination destination,
            @Nonnull final AbstractResponseModel message
    );
}
