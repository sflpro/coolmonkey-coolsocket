package com.sfl.coolmonkey.coolsocket.service.model.channel;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 22/05/16
 * Time: 16:53
 */
public enum UserChannelDestination {
    //region Properties
    AUTHENTICATION("/authentication");

    private final String destination;
    //endregion

    //region Constructors
    UserChannelDestination(final String destination) {
        this.destination = destination;
    }
    //endregion

    //region Properties getters and setters
    public String getDestination() {
        return destination;
    }
    //endregion
}
