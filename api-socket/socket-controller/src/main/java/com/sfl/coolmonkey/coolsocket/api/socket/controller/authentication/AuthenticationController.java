package com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication;

import com.sfl.coolmonkey.coolsocket.service.model.authentication.request.AuthenticationRequest;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 22/05/16
 * Time: 17:24
 */
public interface AuthenticationController {
    /**
     * Authenticate.
     *
     * @param request        the request
     * @param headerAccessor the header accessor
     */
    void authenticate(@Nonnull final AuthenticationRequest request, @Nonnull final SimpMessageHeaderAccessor headerAccessor);
}
