package com.sfl.coolmonkey.coolsocket.service.setting.listener;

import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 15:52
 */
public class SocketBrokerAvailabilityEventListenerTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private final SocketBrokerAvailabilityEventListener socketBrokerAvailabilityEventListener = new SocketBrokerAvailabilityEventListener();

    @Mock
    private BrokerAvailabilityEvent brokerAvailabilityEvent;
    //endregion

    //region Constructors
    public SocketBrokerAvailabilityEventListenerTest() {
    }
    //endregion

    //region Test methods
    @Test
    public void testOnApplicationEvent() {
        // test data
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        socketBrokerAvailabilityEventListener.onApplicationEvent(brokerAvailabilityEvent);
        // verify
        verifyAll();
    }
    //endregion

}