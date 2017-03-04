package com.sfl.coolmonkey.coolsocket.api.socket.controller.logging;


import com.sfl.coolmonkey.coolsocket.service.model.logging.request.CreateActivityLogRequest;
import com.sfl.coolmonkey.coolsocket.service.model.logging.request.CreateGetOutboundRequest;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 6/6/16
 * Time: 4:10 PM
 */
public interface LoggingActionController {
    void createActivityLog(@Nonnull final CreateActivityLogRequest request, @Nonnull final SimpMessageHeaderAccessor headerAccessor);

    void createGetOutbound(@Nonnull final CreateGetOutboundRequest request, @Nonnull final SimpMessageHeaderAccessor headerAccessor);
}
