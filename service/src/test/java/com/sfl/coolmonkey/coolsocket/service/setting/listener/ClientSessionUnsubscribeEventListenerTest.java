package com.sfl.coolmonkey.coolsocket.service.setting.listener;

import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 15:51
 */
public class ClientSessionUnsubscribeEventListenerTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private final ClientSessionUnsubscribeEventListener clientSessionUnsubscribeEventListener = new ClientSessionUnsubscribeEventListener();

    @Mock
    private SessionUnsubscribeEvent sessionUnsubscribeEvent;
    //endregion

    //region Constructors
    public ClientSessionUnsubscribeEventListenerTest() {
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
        clientSessionUnsubscribeEventListener.onApplicationEvent(sessionUnsubscribeEvent);
        // verify
        verifyAll();
    }
    //endregion

}