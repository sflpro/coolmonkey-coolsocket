package com.sfl.coolmonkey.coolsocket.service.setting.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.stereotype.Component;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 20/05/16
 * Time: 16:47
 */
@Component
public class SocketBrokerAvailabilityEventListener implements ApplicationListener<BrokerAvailabilityEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketBrokerAvailabilityEventListener.class);

    //region Dependencies
    //endregion

    //region Constructors
    public SocketBrokerAvailabilityEventListener() {
        LOGGER.debug("Initializing socket broker availability event listener");
    }
    //endregion

    //region Public methods
    @Override
    public void onApplicationEvent(final BrokerAvailabilityEvent brokerAvailabilityEvent) {
    }
    //endregion
}
