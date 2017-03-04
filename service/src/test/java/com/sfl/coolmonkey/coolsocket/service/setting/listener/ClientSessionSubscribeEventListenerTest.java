package com.sfl.coolmonkey.coolsocket.service.setting.listener;

import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 15:49
 */
public class ClientSessionSubscribeEventListenerTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private final ClientSessionSubscribeEventListener clientSessionSubscribeEventListener = new ClientSessionSubscribeEventListener();

    @Mock
    private SessionSubscribeEvent sessionSubscribeEvent;
    //endregion

    //region Constructors
    public ClientSessionSubscribeEventListenerTest() {
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
        clientSessionSubscribeEventListener.onApplicationEvent(sessionSubscribeEvent);
        // verify
        verifyAll();
    }
    //endregion

}