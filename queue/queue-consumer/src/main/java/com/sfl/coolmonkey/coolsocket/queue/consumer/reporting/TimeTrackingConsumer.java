package com.sfl.coolmonkey.coolsocket.queue.consumer.reporting;

import com.sfl.coolmonkey.commons.queue.model.reporting.TimeTrackingUpdatedEvent;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 5/30/16
 * Time: 3:03 PM
 */
public interface TimeTrackingConsumer {
    void consumeUpdatedEvent(@Nonnull final TimeTrackingUpdatedEvent event);
}
