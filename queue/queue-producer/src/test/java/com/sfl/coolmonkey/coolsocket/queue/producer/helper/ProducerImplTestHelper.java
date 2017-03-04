package com.sfl.coolmonkey.coolsocket.queue.producer.helper;

import com.sfl.coolmonkey.commons.queue.model.logging.CreateActivityLogEvent;
import com.sfl.coolmonkey.commons.queue.model.logging.OperatorTypeEventModel;
import com.sfl.coolmonkey.commons.queue.model.logging.ParentActivityTypeEventModel;

import java.util.UUID;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 24/05/16
 * Time: 15:50
 */
public final class ProducerImplTestHelper {

    //region Constructors
    public ProducerImplTestHelper() {
    }
    //endregion

    //region Public methods

    //region Logging
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
