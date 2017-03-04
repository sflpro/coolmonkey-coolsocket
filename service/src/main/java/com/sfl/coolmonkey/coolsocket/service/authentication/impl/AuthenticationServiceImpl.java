package com.sfl.coolmonkey.coolsocket.service.authentication.impl;

import com.sfl.coolmonkey.coolsocket.service.authentication.AuthenticationService;
import com.sfl.coolmonkey.coolsocket.service.common.component.SocketMessagingComponent;
import com.sfl.coolmonkey.coolsocket.service.model.authentication.response.AuthenticationResponse;
import com.sfl.coolmonkey.coolsocket.service.model.channel.UserChannelDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 22/05/16
 * Time: 18:16
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    //region Dependencies
    @Autowired
    private SocketMessagingComponent socketMessagingComponent;
    //endregion

    //region Constructors
    public AuthenticationServiceImpl() {
        LOGGER.debug("Initializing authentication service");
    }
    //endregion

    //region Public methods
    @Override
    public void authenticate(@Nonnull final String userUuid, @Nonnull final String authToken) {
        Assert.notNull(userUuid, "The user uuid should not be null");
        Assert.notNull(authToken, "The authentication token should not be null");
        socketMessagingComponent.sendToUser(userUuid, UserChannelDestination.AUTHENTICATION, new AuthenticationResponse(authToken));
    }
    //endregion
}
