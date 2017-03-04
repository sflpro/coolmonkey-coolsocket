package com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication.component.impl;

import com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication.component.AuthenticationTokenComponent;
import com.sfl.coolmonkey.coolsocket.api.socket.controller.test.AbstractSocketControllerImplTest;
import org.easymock.TestSubject;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 17:30
 */
public class AuthenticationTokenComponentImplTest extends AbstractSocketControllerImplTest {

    //region Test subject and mocks
    @TestSubject
    private final AuthenticationTokenComponent authenticationTokenComponent = new AuthenticationTokenComponentImpl();
    //endregion

    //region Constructors
    public AuthenticationTokenComponentImplTest() {
    }
    //endregion

    //region Test methods

    //region generateToken
    @Test
    public void testGenerateToken() {
        // test data
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        final String authToken = authenticationTokenComponent.generateToken();
        assertNotNull(authToken);
        // verify
        verifyAll();
    }
    //endregion

    //endregion

}