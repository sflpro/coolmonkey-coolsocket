package com.sfl.coolmonkey.coolsocket.queue.consumer.helper;

import com.sfl.coolmonkey.commons.queue.model.reporting.TimeTrackingUpdatedEvent;
import com.sfl.coolmonkey.coolsocket.service.helper.CommonTestHelper;

import java.util.UUID;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 24/05/16
 * Time: 15:50
 */
public final class ConsumerImplTestHelper extends CommonTestHelper {

    //region Constructors
    public ConsumerImplTestHelper() {
    }
    //endregion

    //region Public methods

    //region Time tracking
    public TimeTrackingUpdatedEvent createTimeTrackingUpdatedEvent() {
        return new TimeTrackingUpdatedEvent(UUID.randomUUID().toString());
    }
    //endregion

    //endregion

}
