package com.sfl.coolmonkey.coolsocket.service.setting.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 20/05/16
 * Time: 16:45
 */
@Component
public class ClientSessionConnectEventListener implements ApplicationListener<SessionConnectEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientSessionConnectEventListener.class);

    //region Dependencies
    //endregion

    //region Constructors
    public ClientSessionConnectEventListener() {
        LOGGER.debug("Initializing client session connect event listener");
    }
    //endregion

    //region Public methods
    @Override
    public void onApplicationEvent(final SessionConnectEvent sessionConnectEvent) {
    }
    //endregion
}
