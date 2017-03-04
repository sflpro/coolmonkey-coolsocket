package com.sfl.coolmonkey.coolsocket.service.setting.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 20/05/16
 * Time: 16:51
 */
@Component
public class ClientSessionConnectedEventListener implements ApplicationListener<SessionConnectedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientSessionConnectedEventListener.class);

    //region Dependencies
    //endregion

    //region Constructors
    public ClientSessionConnectedEventListener() {
        LOGGER.debug("Initializing client session connected event listener");
    }
    //endregion

    //region Public methods
    @Override
    public void onApplicationEvent(final SessionConnectedEvent sessionConnectedEvent) {
    }
    //endregion
}
