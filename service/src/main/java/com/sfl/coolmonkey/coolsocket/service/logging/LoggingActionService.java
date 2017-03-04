package com.sfl.coolmonkey.coolsocket.service.logging;


import com.sfl.coolmonkey.coolsocket.service.model.logging.request.CreateActivityLogRequest;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 6/6/16
 * Time: 4:42 PM
 */
public interface LoggingActionService {
    void createActivityLog(@Nonnull final CreateActivityLogRequest request);
}
