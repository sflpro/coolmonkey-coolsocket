package com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication.impl;

import com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication.AuthenticationController;
import com.sfl.coolmonkey.coolsocket.api.socket.controller.authentication.component.AuthenticationTokenComponent;
import com.sfl.coolmonkey.coolsocket.api.socket.controller.test.AbstractSocketControllerImplTest;
import com.sfl.coolmonkey.coolsocket.service.authentication.AuthenticationService;
import com.sfl.coolmonkey.coolsocket.service.common.component.SessionWrapperComponent;
import com.sfl.coolmonkey.coolsocket.service.model.authentication.request.AuthenticationRequest;
import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUser;
import org.apache.commons.lang3.SerializationUtils;
import org.easymock.Capture;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import java.util.UUID;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 14:45
 */
public class AuthenticationControllerImplTest extends AbstractSocketControllerImplTest {

    //region Test subject and mocks
    @TestSubject
    private AuthenticationController authenticationController = new AuthenticationControllerImpl();

    @Mock
    private AuthenticationService authenticationService;

    @Mock
    private SessionWrapperComponent sessionWrapperComponent;

    @Mock
    private SimpMessageHeaderAccessor simpMessageHeaderAccessor;

    @Mock
    private AuthenticationTokenComponent authenticationTokenComponent;
    //endregion

    //region Constructors
    public AuthenticationControllerImplTest() {
    }
    //endregion

    //region Test methods

    //region authenticate
    @Test
    public void testAuthenticateWithInvalidArguments() {
        // test data
        final AuthenticationRequest validRequest = new AuthenticationRequest(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        AuthenticationRequest invalidRequest;
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        invalidRequest = null;
        try {
            authenticationController.authenticate(invalidRequest, simpMessageHeaderAccessor);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.setUserUuid(null);
        try {
            authenticationController.authenticate(invalidRequest, simpMessageHeaderAccessor);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        try {
            authenticationController.authenticate(validRequest, null);
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
        final AuthenticationRequest request = new AuthenticationRequest(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        final String authToken = UUID.randomUUID().toString();
        final Capture<SessionUser> sessionUserCapture = new Capture<>();
        // reset
        resetAll();
        // expectations
        expect(authenticationTokenComponent.generateToken()).andReturn(authToken);
        sessionWrapperComponent.saveSessionUser(capture(sessionUserCapture), eq(simpMessageHeaderAccessor));
        authenticationService.authenticate(request.getUserUuid(), authToken);
        // reply
        replayAll();
        // run test scenario
        authenticationController.authenticate(request, simpMessageHeaderAccessor);
        assertTrue(sessionUserCapture.getValue() != null);
        // verify
        verifyAll();
    }
    //endregion

    //endregion

}