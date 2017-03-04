package com.sfl.coolmonkey.coolsocket.service.common.exception;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 16:49
 */
public class ServiceRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 5957748724574429947L;

    //region Constructors
    public ServiceRuntimeException() {
    }

    public ServiceRuntimeException(final String message) {
        super(message);
    }

    public ServiceRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }
    //endregion
}
