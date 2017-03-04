package com.sfl.coolmonkey.coolsocket.service.common.component.impl;

import com.sfl.coolmonkey.coolsocket.service.common.component.HeaderAccessorWrapperComponent;
import com.sfl.coolmonkey.coolsocket.service.common.exception.ServiceRuntimeException;
import com.sfl.coolmonkey.coolsocket.service.model.common.SessionAttributes;
import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 18:35
 */
@Component
public class HeaderAccessorWrapperComponentImpl implements HeaderAccessorWrapperComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderAccessorWrapperComponentImpl.class);

    //region Dependencies
    //endregion

    //region Constructors
    public HeaderAccessorWrapperComponentImpl() {
        LOGGER.debug("Initializing header accessor wrapper component");
    }
    //endregion

    //region Public methods
    @Nonnull
    @Override
    public SessionUser getSessionUserFromHeaderAccessor(@Nonnull final SimpMessageHeaderAccessor headerAccessor) {
        Assert.notNull(headerAccessor, "The header accessor should not be null");
        final Object sessionObject = headerAccessor.getSessionAttributes().get(SessionAttributes.SESSION_USER);
        if (sessionObject instanceof SessionUser) {
            return (SessionUser) sessionObject;
        }
        LOGGER.error("Can not get session user from header accessor - {}", headerAccessor);
        throw new ServiceRuntimeException("Can not get session user from header accessor - " + headerAccessor);
    }
    //endregion
}
