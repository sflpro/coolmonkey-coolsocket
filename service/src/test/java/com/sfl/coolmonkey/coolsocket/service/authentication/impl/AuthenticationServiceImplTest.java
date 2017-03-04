package com.sfl.coolmonkey.coolsocket.service.authentication.impl;

import com.sfl.coolmonkey.coolsocket.service.authentication.AuthenticationService;
import com.sfl.coolmonkey.coolsocket.service.common.component.SocketMessagingComponent;
import com.sfl.coolmonkey.coolsocket.service.model.authentication.response.AuthenticationResponse;
import com.sfl.coolmonkey.coolsocket.service.model.channel.UserChannelDestination;
import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.fail;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 14:25
 */
public class AuthenticationServiceImplTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private AuthenticationService authenticationService = new AuthenticationServiceImpl();

    @Mock
    private SocketMessagingComponent socketMessagingComponent;
    //endregion

    //region Constructors
    public AuthenticationServiceImplTest() {
    }
    //endregion

    //region Test methods

    //region authenticate
    @Test
    public void testAuthenticateWithInvalidArguments() {
        // test data
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            authenticationService.authenticate(null, UUID.randomUUID().toString());
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        try {
            authenticationService.authenticate(UUID.randomUUID().toString(), null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testAuthenticate() {
        // test data
        final String userUuid = UUID.randomUUID().toString();
        final String authToken = UUID.randomUUID().toString();
        // reset
        resetAll();
        // expectations
        socketMessagingComponent.sendToUser(userUuid, UserChannelDestination.AUTHENTICATION, new AuthenticationResponse(authToken));
        // reply
        replayAll();
        // run test scenario
        authenticationService.authenticate(userUuid, authToken);
        // verify
        verifyAll();
    }
    //endregion

    //endregion

}