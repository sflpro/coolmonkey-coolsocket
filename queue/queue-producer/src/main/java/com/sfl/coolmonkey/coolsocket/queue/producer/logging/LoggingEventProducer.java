package com.sfl.coolmonkey.coolsocket.queue.producer.logging;

import com.sfl.coolmonkey.commons.queue.model.logging.CreateActivityLogEvent;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 6/7/16
 * Time: 11:13 AM
 */
public interface LoggingEventProducer {
    void produceCreateActivityLogEvent(@Nonnull final CreateActivityLogEvent event);
}
