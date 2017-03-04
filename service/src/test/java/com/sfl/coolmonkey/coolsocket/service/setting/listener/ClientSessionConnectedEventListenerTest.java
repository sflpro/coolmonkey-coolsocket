package com.sfl.coolmonkey.coolsocket.service.setting.listener;

import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 15:45
 */
public class ClientSessionConnectedEventListenerTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private final ClientSessionConnectedEventListener clientSessionConnectedEventListener = new ClientSessionConnectedEventListener();

    @Mock
    private SessionConnectedEvent sessionConnectedEvent;
    //endregion

    //region Constructors
    public ClientSessionConnectedEventListenerTest() {
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
        clientSessionConnectedEventListener.onApplicationEvent(sessionConnectedEvent);
        // verify
        verifyAll();
    }
    //endregion

}