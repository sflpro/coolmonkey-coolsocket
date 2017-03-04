package com.sfl.coolmonkey.coolsocket.service.common.component;

import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUser;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
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
public interface SessionWrapperComponent {
    /**
     * Gets session user.
     *
     * @param headerAccessor the header accessor
     * @return the session user
     */
    @Nonnull
    SessionUser getSessionUser(@Nonnull final SimpMessageHeaderAccessor headerAccessor);

    /**
     * Gets session user from session disconnect event.
     *
     * @param sessionDisconnectEvent the session disconnect event
     * @return the session user
     */
    @Nonnull
    SessionUser getSessionUserFromSessionDisconnectEvent(@Nonnull final SessionDisconnectEvent sessionDisconnectEvent);

    /**
     * Gets session user from session subscribe event.
     *
     * @param sessionSubscribeEvent the session subscribe event
     * @return the session user
     */
    @Nonnull
    SessionUser getSessionUserFromSessionSubscribeEvent(@Nonnull final SessionSubscribeEvent sessionSubscribeEvent);

    /**
     * Gets session user from session unsubscribe event.
     *
     * @param sessionUnsubscribeEvent the session unsubscribe event
     * @return the session user
     */
    @Nonnull
    SessionUser getSessionUserFromSessionUnsubscribeEvent(@Nonnull final SessionUnsubscribeEvent sessionUnsubscribeEvent);

    /**
     * Update session user session user.
     *
     * @param sessionUser    the session user
     * @param headerAccessor the header accessor
     */
    void saveSessionUser(@Nonnull final SessionUser sessionUser, @Nonnull final SimpMessageHeaderAccessor headerAccessor);

    /**
     * Check if session user exists.
     *
     * @param headerAccessor the header accessor
     * @return the boolean
     */
    boolean checkIfSessionUserExists(@Nonnull final SimpMessageHeaderAccessor headerAccessor);
}
