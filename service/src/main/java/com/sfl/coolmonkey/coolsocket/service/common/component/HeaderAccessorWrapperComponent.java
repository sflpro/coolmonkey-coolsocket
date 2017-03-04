package com.sfl.coolmonkey.coolsocket.service.common.component;

import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUser;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 18:34
 */
public interface HeaderAccessorWrapperComponent {
    /**
     * Gets session user from header accessor.
     *
     * @param headerAccessor the header accessor
     * @return the session user from header accessor
     */
    @Nonnull
    SessionUser getSessionUserFromHeaderAccessor(@Nonnull final SimpMessageHeaderAccessor headerAccessor);
}
