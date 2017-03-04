package com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication.component;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 17:21
 */
public interface AuthenticationTokenComponent {
    /**
     * Generate authentication token.
     *
     * @return the string
     */
    String generateToken();
}
