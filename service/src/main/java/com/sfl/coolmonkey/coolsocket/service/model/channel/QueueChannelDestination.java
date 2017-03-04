package com.sfl.coolmonkey.coolsocket.service.model.channel;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 16:47
 */
public enum QueueChannelDestination {
    //region Properties
    DUMMY("/queue/dummy");

    private final String destination;
    //endregion

    //region Constructors
    QueueChannelDestination(final String destination) {
        this.destination = destination;
    }
    //endregion

    //region Properties getters and setters
    public String getDestination() {
        return destination;
    }
    //endregion
}
