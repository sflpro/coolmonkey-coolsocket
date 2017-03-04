package com.sfl.coolmonkey.coolsocket.api.socket.controller.common.exception;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 15:08
 */
public class SocketControllerRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 3461514766161746562L;

    //region Constructors
    public SocketControllerRuntimeException() {
        super();
    }

    public SocketControllerRuntimeException(final String message) {
        super(message);
    }

    public SocketControllerRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }
    //endregion
}
