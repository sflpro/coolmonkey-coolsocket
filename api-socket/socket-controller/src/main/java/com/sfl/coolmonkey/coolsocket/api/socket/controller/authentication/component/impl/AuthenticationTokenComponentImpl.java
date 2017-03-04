package com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication.component.impl;

import com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication.component.AuthenticationTokenComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 17:21
 */
@Component
public class AuthenticationTokenComponentImpl implements AuthenticationTokenComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationTokenComponentImpl.class);

    //region Dependencies
    //endregion

    //region Constructors
    public AuthenticationTokenComponentImpl() {
        LOGGER.debug("Initializing authentication token component");
    }
    //endregion

    //region Public methods
    @Override
    public String generateToken() {
        return UUID.randomUUID().toString();
    }
    //endregion
}
