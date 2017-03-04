package com.sfl.coolmonkey.coolsocket.service.setting.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 20/05/16
 * Time: 16:53
 */
@Component
public class ClientSessionSubscribeEventListener implements ApplicationListener<SessionSubscribeEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientSessionSubscribeEventListener.class);

    //region Dependencies
    //endregion

    //region Constructors
    public ClientSessionSubscribeEventListener() {
        LOGGER.debug("Initializing client session subscribe event listener");
    }
    //endregion

    //region Public methods
    @Override
    public void onApplicationEvent(final SessionSubscribeEvent sessionSubscribeEvent) {
    }
    //endregion
}
