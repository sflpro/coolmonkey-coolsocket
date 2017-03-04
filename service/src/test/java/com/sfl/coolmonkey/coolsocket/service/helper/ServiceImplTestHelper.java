package com.sfl.coolmonkey.coolsocket.service.helper;

import com.sfl.coolmonkey.commons.queue.model.logging.CreateActivityLogEvent;
import com.sfl.coolmonkey.commons.queue.model.logging.OperatorTypeEventModel;
import com.sfl.coolmonkey.commons.queue.model.logging.ParentActivityTypeEventModel;

import java.util.UUID;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 14:23
 */
public final class ServiceImplTestHelper extends CommonTestHelper {

    //region Constructors
    public ServiceImplTestHelper() {
    }
    //endregion

    //region Public methods

    //region logging
    public CreateActivityLogEvent createActivityLogEvent() {
        return new CreateActivityLogEvent(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                ParentActivityTypeEventModel.OUTBOUND,
                OperatorTypeEventModel.MARKETING
        );
    }
    //endregion

    //endregion
}
