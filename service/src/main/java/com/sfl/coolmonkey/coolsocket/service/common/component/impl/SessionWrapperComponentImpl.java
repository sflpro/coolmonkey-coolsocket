package com.sfl.coolmonkey.coolsocket.service.common.component.impl;

import com.sfl.coolmonkey.coolsocket.service.common.component.HeaderAccessorWrapperComponent;
import com.sfl.coolmonkey.coolsocket.service.common.component.SessionWrapperComponent;
import com.sfl.coolmonkey.coolsocket.service.model.common.SessionAttributes;
import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 15:03
 */
@Component
public class SessionWrapperComponentImpl implements SessionWrapperComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionWrapperComponentImpl.class);

    //region Dependencies
    @Autowired
    private HeaderAccessorWrapperComponent headerAccessorWrapperComponent;
    //endregion

    //region Constructors
    public SessionWrapperComponentImpl() {
        LOGGER.debug("Initializing session wrapper component");
    }
    //endregion

    //region Test methods
    @Nonnull
    @Override
    public SessionUser getSessionUser(@Nonnull final SimpMessageHeaderAccessor headerAccessor) {
        assertHeaderAccessor(headerAccessor);
        return headerAccessorWrapperComponent.getSessionUserFromHeaderAccessor(headerAccessor);
    }

    @Nonnull
    @Override
    public SessionUser getSessionUserFromSessionDisconnectEvent(@Nonnull final SessionDisconnectEvent sessionDisconnectEvent) {
        Assert.notNull(sessionDisconnectEvent, "The session disconnect event should not be null");
        final SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());
        return headerAccessorWrapperComponent.getSessionUserFromHeaderAccessor(headerAccessor);
    }

    @Nonnull
    @Override
    public SessionUser getSessionUserFromSessionSubscribeEvent(@Nonnull final SessionSubscribeEvent sessionSubscribeEvent) {
        Assert.notNull(sessionSubscribeEvent, "The session subscribe event should not be null");
        final SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.wrap(sessionSubscribeEvent.getMessage());
        return headerAccessorWrapperComponent.getSessionUserFromHeaderAccessor(headerAccessor);
    }

    @Nonnull
    @Override
    public SessionUser getSessionUserFromSessionUnsubscribeEvent(@Nonnull final SessionUnsubscribeEvent sessionUnsubscribeEvent) {
        Assert.notNull(sessionUnsubscribeEvent, "The session unsubscribe event should not be null");
        final SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.wrap(sessionUnsubscribeEvent.getMessage());
        return headerAccessorWrapperComponent.getSessionUserFromHeaderAccessor(headerAccessor);
    }

    @Override
    public void saveSessionUser(@Nonnull final SessionUser sessionUser, @Nonnull final SimpMessageHeaderAccessor headerAccessor) {
        assertSessionUser(sessionUser);
        assertHeaderAccessor(headerAccessor);
        headerAccessor.getSessionAttributes().put(SessionAttributes.SESSION_USER, sessionUser);
    }

    @Override
    public boolean checkIfSessionUserExists(@Nonnull final SimpMessageHeaderAccessor headerAccessor) {
        assertHeaderAccessor(headerAccessor);
        return headerAccessor.getSessionAttributes().get(SessionAttributes.SESSION_USER) instanceof SessionUser;
    }
    //endregion

    //region Utility methods
    private void assertSessionUser(final SessionUser sessionUser) {
        Assert.notNull(sessionUser, "The session user should not be null");
        Assert.notNull(sessionUser.getUuid(), "The session user uuid should not be null");
    }

    private void assertHeaderAccessor(final SimpMessageHeaderAccessor headerAccessor) {
        Assert.notNull(headerAccessor, "The header accessor should not be null");
    }
    //endregion
}
