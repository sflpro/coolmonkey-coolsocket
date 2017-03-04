package com.sfl.coolmonkey.coolsocket.api.socket.controller.logging.impl;

import com.sfl.coolmonkey.coolsocket.api.socket.controller.logging.LoggingActionController;
import com.sfl.coolmonkey.coolsocket.service.common.component.SessionWrapperComponent;
import com.sfl.coolmonkey.coolsocket.service.logging.LoggingActionService;
import com.sfl.coolmonkey.coolsocket.service.model.logging.request.CreateActivityLogRequest;
import com.sfl.coolmonkey.coolsocket.service.model.logging.request.CreateGetOutboundRequest;
import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 6/6/16
 * Time: 4:10 PM
 */
@Component
@MessageMapping("logging")
public class LoggingActionControllerImpl implements LoggingActionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingActionControllerImpl.class);

    //region Dependencies
    @Autowired
    private LoggingActionService loggingActionService;

    @Autowired
    private SessionWrapperComponent sessionWrapperComponent;
    //endregion

    //region Constructors
    public LoggingActionControllerImpl() {
        LOGGER.debug("Initializing logging action controller");
    }
    //endregion

    //region Public methods
    @MessageMapping("createActivityLog")
    @Override
    public void createActivityLog(@Nonnull final CreateActivityLogRequest request, @Nonnull final SimpMessageHeaderAccessor headerAccessor) {
        assertActivityLogActionRequest(request);
        assertHeaderAccessor(headerAccessor);
        final SessionUser sessionUser = sessionWrapperComponent.getSessionUser(headerAccessor);
        request.setCompanyUuid(sessionUser.getCompanyUuid());
        request.setOperatorUuid(sessionUser.getUuid());
        request.setAuthToken(sessionUser.getAuthToken());
        loggingActionService.createActivityLog(request);
    }

    @MessageMapping("createGetOutbound")
    @Override
    public void createGetOutbound(@Nonnull final CreateGetOutboundRequest request, @Nonnull final SimpMessageHeaderAccessor headerAccessor) {
        assertGetOutboundActionRequest(request);
        assertHeaderAccessor(headerAccessor);
    }
    //endregion

    //region Utility methods
    private void assertActivityLogActionRequest(final CreateActivityLogRequest request) {
        Assert.notNull(request, "The activity log request should not be null");
        Assert.notNull(request.getCompanyUuid(), "The company uuid should not be null");
        Assert.notNull(request.getOperatorUuid(), "The operator uuid should not be null");
        Assert.notNull(request.getType(), "The parent activity type should not be null");
    }

    private void assertGetOutboundActionRequest(final CreateGetOutboundRequest request) {
        Assert.notNull(request, "The create get outbound request should not be null");
    }

    private void assertHeaderAccessor(final SimpMessageHeaderAccessor headerAccessor) {
        Assert.notNull(headerAccessor, "The header accessor should not be null");
    }
    //endregion
}
