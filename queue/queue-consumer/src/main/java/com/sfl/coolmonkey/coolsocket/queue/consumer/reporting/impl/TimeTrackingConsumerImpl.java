package com.sfl.coolmonkey.coolsocket.queue.consumer.reporting.impl;

import com.sfl.coolmonkey.commons.queue.model.reporting.TimeTrackingUpdatedEvent;
import com.sfl.coolmonkey.coolsocket.queue.consumer.reporting.TimeTrackingConsumer;
import com.sfl.coolmonkey.coolsocket.service.common.component.SocketMessagingComponent;
import com.sfl.coolmonkey.coolsocket.service.model.channel.TopicChannelDestination;
import com.sfl.coolmonkey.coolsocket.service.model.reporting.ReportingMessageType;
import com.sfl.coolmonkey.coolsocket.service.model.reporting.response.ReportingNotificationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 5/30/16
 * Time: 3:03 PM
 */
@Component
public class TimeTrackingConsumerImpl implements TimeTrackingConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeTrackingConsumerImpl.class);

    //region Dependencies
    @Autowired
    private SocketMessagingComponent socketMessagingComponent;
    //endregion

    //region Constructors
    public TimeTrackingConsumerImpl() {
        LOGGER.debug("Initializing time tracking consumer");
    }
    //endregion

    //region Public methods
    @RabbitListener(queues = "#{appProperties['queue.time_tracking_updated']}")
    @Override
    public void consumeUpdatedEvent(@Nonnull final TimeTrackingUpdatedEvent event) {
        Assert.notNull(event, "The time tracking updated even should not be null");
        Assert.notNull(event.getAuthToken(), "The authentication toke should not be null");
        socketMessagingComponent.sendToAuthenticatedTopic(
                event.getAuthToken(),
                TopicChannelDestination.TIME_TRACKING_UPDATED,
                buildReportingNotificationResponse(ReportingMessageType.TIME_TRACKING_UPDATED)
        );
    }
    //endregion

    //region Utility methods
    private ReportingNotificationResponse buildReportingNotificationResponse(final ReportingMessageType type) {
        return new ReportingNotificationResponse(type);
    }
    //endregion
}
