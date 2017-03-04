package com.sfl.coolmonkey.coolsocket.service.authentication;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 22/05/16
 * Time: 18:15
 */
public interface AuthenticationService {
    /**
     * Authenticate user.
     *
     * @param userUuid  the user uuid
     * @param authToken the auth token
     */
    void authenticate(@Nonnull final String userUuid, @Nonnull final String authToken);
}
