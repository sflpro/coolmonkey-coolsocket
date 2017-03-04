package com.sfl.coolmonkey.coolsocket.service.setting.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 20/05/16
 * Time: 16:25
 */
@Component
public class ClientSessionDisconnectEventListener implements ApplicationListener<SessionDisconnectEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientSessionDisconnectEventListener.class);

    //region Dependencies
    //endregion

    //region Constructors
    public ClientSessionDisconnectEventListener() {
        LOGGER.debug("Initializing client disconnected event listener");
    }
    //endregion

    //region Public methods
    @Override
    public void onApplicationEvent(final SessionDisconnectEvent sessionDisconnectEvent) {
        LOGGER.info("Disconnected from - {}", sessionDisconnectEvent);
    }
    //endregion
}
