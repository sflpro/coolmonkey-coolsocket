package com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication.impl;

import com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication.AuthenticationController;
import com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication.component.AuthenticationTokenComponent;
import com.sfl.coolmonkey.coolsocket.service.authentication.AuthenticationService;
import com.sfl.coolmonkey.coolsocket.service.common.component.SessionWrapperComponent;
import com.sfl.coolmonkey.coolsocket.service.model.authentication.request.AuthenticationRequest;
import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 14:43
 */
@Controller
@MessageMapping("authentication")
public class AuthenticationControllerImpl implements AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    //region Dependencies
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private SessionWrapperComponent sessionWrapperComponent;

    @Autowired
    private AuthenticationTokenComponent authenticationTokenComponent;
    //endregion

    //region Constructors
    public AuthenticationControllerImpl() {
        LOGGER.debug("Initializing authentication controller");
    }
    //endregion

    //region Public methods
    @MessageMapping("authenticate")
    @Override
    public void authenticate(@Nonnull final AuthenticationRequest request, @Nonnull final SimpMessageHeaderAccessor headerAccessor) {
        assertAuthenticationRequest(request);
        assertHeaderAccessor(headerAccessor);
        final String authToken = authenticationTokenComponent.generateToken();
        final SessionUser sessionUser = new SessionUser(/* Substitute some session info */);
        sessionWrapperComponent.saveSessionUser(sessionUser, headerAccessor);
        authenticationService.authenticate(request.getUserUuid(), authToken);
    }
    //endregion

    //region Utility methods
    private void assertAuthenticationRequest(final AuthenticationRequest request) {
        Assert.notNull(request, "The authentication request should not be null");
        Assert.notNull(request.getUserUuid(), "The user uuid should not be null");
    }

    private void assertHeaderAccessor(final SimpMessageHeaderAccessor headerAccessor) {
        Assert.notNull(headerAccessor, "The header accessor should not be null");
    }
    //endregion
}
