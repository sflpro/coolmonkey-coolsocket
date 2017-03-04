package com.sfl.coolmonkey.coolsocket.service.setting.listener;

import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 15:48
 */
public class ClientSessionDisconnectEventListenerTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private final ClientSessionDisconnectEventListener clientSessionDisconnectEventListener = new ClientSessionDisconnectEventListener();

    @Mock
    private SessionDisconnectEvent sessionDisconnectEvent;
    //endregion

    //region Constructors
    public ClientSessionDisconnectEventListenerTest() {
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
        clientSessionDisconnectEventListener.onApplicationEvent(sessionDisconnectEvent);
        // verify
        verifyAll();
    }
    //endregion

}