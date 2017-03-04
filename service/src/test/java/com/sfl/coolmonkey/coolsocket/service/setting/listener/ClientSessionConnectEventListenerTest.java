package com.sfl.coolmonkey.coolsocket.service.setting.listener;

import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.web.socket.messaging.SessionConnectEvent;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 15:46
 */
public class ClientSessionConnectEventListenerTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private final ClientSessionConnectEventListener clientSessionConnectEventListener = new ClientSessionConnectEventListener();

    @Mock
    private SessionConnectEvent sessionConnectEvent;
    //endregion

    //region Constructors
    public ClientSessionConnectEventListenerTest() {
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
        clientSessionConnectEventListener.onApplicationEvent(sessionConnectEvent);
        // verify
        verifyAll();
    }
    //endregion

}