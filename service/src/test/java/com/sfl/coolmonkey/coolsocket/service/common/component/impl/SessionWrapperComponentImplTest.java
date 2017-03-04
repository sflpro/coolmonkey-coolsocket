package com.sfl.coolmonkey.coolsocket.service.common.component.impl;

import com.sfl.coolmonkey.coolsocket.service.common.component.HeaderAccessorWrapperComponent;
import com.sfl.coolmonkey.coolsocket.service.common.component.SessionWrapperComponent;
import com.sfl.coolmonkey.coolsocket.service.model.common.SessionAttributes;
import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUser;
import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.apache.commons.lang3.SerializationUtils;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

import java.util.HashMap;
import java.util.Map;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.junit.Assert.*;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 15:04
 */
public class SessionWrapperComponentImplTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private SessionWrapperComponent sessionWrapperComponent = new SessionWrapperComponentImpl();

    @Mock
    private SessionSubscribeEvent sessionSubscribeEvent;

    @Mock
    private SessionDisconnectEvent sessionDisconnectEvent;

    @Mock
    private SessionUnsubscribeEvent sessionUnsubscribeEvent;

    @Mock
    private SimpMessageHeaderAccessor simpMessageHeaderAccessor;

    @Mock
    private HeaderAccessorWrapperComponent headerAccessorWrapperComponent;
    //endregion

    //region Constructors
    public SessionWrapperComponentImplTest() {
    }
    //endregion

    //region Test methods

    //region getSessionUser
    @Test
    public void testGetSessionUserWithInvalidArguments() {
        // test data
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            sessionWrapperComponent.getSessionUser(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testGetSessionUser() {
        /// test data
        final SessionUser sessionUser = getHelper().createSessionUser();
        // reset
        resetAll();
        // expectations
        expect(headerAccessorWrapperComponent.getSessionUserFromHeaderAccessor(simpMessageHeaderAccessor)).andReturn(sessionUser);
        // reply
        replayAll();
        // run test scenario
        final SessionUser result = sessionWrapperComponent.getSessionUser(simpMessageHeaderAccessor);
        assertNotNull(sessionUser);
        assertEquals(sessionUser, result);
        // verify
        verifyAll();
    }
    //endregion

    //region getSessionUserFromSessionDisconnectEvent
    @Test
    public void testGetSessionUserFromSessionDisconnectEventWithInvalidArguments() {
        // test data
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            sessionWrapperComponent.getSessionUserFromSessionDisconnectEvent(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testGetSessionUserFromSessionDisconnectEvent() {
        // test data
        final SessionUser sessionUser = getHelper().createSessionUser();
        // reset
        resetAll();
        // expectations
        final Message<byte[]> message = createByteMessage();
        expect(sessionDisconnectEvent.getMessage()).andReturn(message);
        expect(headerAccessorWrapperComponent.getSessionUserFromHeaderAccessor(isA(SimpMessageHeaderAccessor.class))).andReturn(sessionUser);
        // reply
        replayAll();
        // run test scenario
        final SessionUser result = sessionWrapperComponent.getSessionUserFromSessionDisconnectEvent(sessionDisconnectEvent);
        assertNotNull(result);
        assertEquals(sessionUser, result);
        // verify
        verifyAll();
    }
    //endregion

    //region getSessionUserFromSessionSubscribeEvent
    @Test
    public void testGetSessionUserFromSessionSubscribeEventWithInvalidArguments() {
        // test data
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            sessionWrapperComponent.getSessionUserFromSessionSubscribeEvent(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testGetSessionUserFromSessionSubscribeEvent() {
        // test data
        final SessionUser sessionUser = getHelper().createSessionUser();
        // reset
        resetAll();
        // expectations
        final Message<byte[]> message = createByteMessage();
        expect(sessionSubscribeEvent.getMessage()).andReturn(message);
        expect(headerAccessorWrapperComponent.getSessionUserFromHeaderAccessor(isA(SimpMessageHeaderAccessor.class))).andReturn(sessionUser);
        // reply
        replayAll();
        // run test scenario
        final SessionUser result = sessionWrapperComponent.getSessionUserFromSessionSubscribeEvent(sessionSubscribeEvent);
        assertNotNull(result);
        assertEquals(sessionUser, result);
        // verify
        verifyAll();
    }
    //endregion

    //region getSessionUserFromSessionUnsubscribeEvent
    @Test
    public void testGetSessionUserFromSessionUnsubscribeEventWithInvalidArguments() {
        // test data
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            sessionWrapperComponent.getSessionUserFromSessionUnsubscribeEvent(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testGetSessionUserFromSessionUnsubscribeEvent() {
        // test data
        final SessionUser sessionUser = getHelper().createSessionUser();
        // reset
        resetAll();
        // expectations
        final Message<byte[]> message = createByteMessage();
        expect(sessionUnsubscribeEvent.getMessage()).andReturn(message);
        expect(headerAccessorWrapperComponent.getSessionUserFromHeaderAccessor(isA(SimpMessageHeaderAccessor.class))).andReturn(sessionUser);
        // reply
        replayAll();
        // run test scenario
        final SessionUser result = sessionWrapperComponent.getSessionUserFromSessionUnsubscribeEvent(sessionUnsubscribeEvent);
        assertNotNull(result);
        assertEquals(sessionUser, result);
        // verify
        verifyAll();
    }
    //endregion

    //region saveSessionUser
    @Test
    public void testSaveSessionUserWithInvalidArguments() {
        // test data
        final SessionUser validSessionUser = getHelper().createSessionUser();
        SessionUser invalidSessionUser;
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        invalidSessionUser = null;
        try {
            sessionWrapperComponent.saveSessionUser(invalidSessionUser, simpMessageHeaderAccessor);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        invalidSessionUser = SerializationUtils.clone(validSessionUser);
        invalidSessionUser.setUuid(null);
        try {
            sessionWrapperComponent.saveSessionUser(invalidSessionUser, simpMessageHeaderAccessor);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        try {
            sessionWrapperComponent.saveSessionUser(validSessionUser, null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testSaveSessionUser() {
        // test data
        final SessionUser sessionUser = getHelper().createSessionUser();
        final Map<String, Object> sessionAttributes = createSessionAttributesForUser();
        sessionAttributes.put(SessionAttributes.SESSION_USER, sessionUser);
        // reset
        resetAll();
        // expectations
        expect(simpMessageHeaderAccessor.getSessionAttributes()).andReturn(sessionAttributes);
        // reply
        replayAll();
        // run test scenario
        sessionWrapperComponent.saveSessionUser(sessionUser, simpMessageHeaderAccessor);
        // verify
        verifyAll();
    }
    //endregion

    //region checkIfSessionUserExists
    @Test
    public void testCheckIfSessionUserExistsWithInvalidArguments() {
        // test data
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            sessionWrapperComponent.checkIfSessionUserExists(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testCheckIfSessionUserExistsWhenNotExists() {
        // test data
        final Map<String, Object> sessionAttributes = new HashMap<>();
        // reset
        resetAll();
        // expectations
        expect(simpMessageHeaderAccessor.getSessionAttributes()).andReturn(sessionAttributes);
        // reply
        replayAll();
        // run test scenario
        assertFalse(sessionWrapperComponent.checkIfSessionUserExists(simpMessageHeaderAccessor));
        // verify
        verifyAll();
    }

    @Test
    public void testCheckIfSessionUserExists() {
        // test data
        final Map<String, Object> sessionAttributes = createSessionAttributesForUser();
        // reset
        resetAll();
        // expectations
        expect(simpMessageHeaderAccessor.getSessionAttributes()).andReturn(sessionAttributes);
        // reply
        replayAll();
        // run test scenario
        assertTrue(sessionWrapperComponent.checkIfSessionUserExists(simpMessageHeaderAccessor));
        // verify
        verifyAll();
    }
    //endregion

    //endregion

    //region Utility methods
    private Map<String, Object> createSessionAttributesForUser() {
        final Map<String, Object> sessionAttributes = new HashMap<>();
        final SessionUser sessionUser = getHelper().createSessionUser();
        sessionAttributes.put(SessionAttributes.SESSION_USER, sessionUser);
        return sessionAttributes;
    }

    private Message<byte[]> createByteMessage() {
        return new Message<byte[]>() {
            @Override
            public byte[] getPayload() {
                return new byte[0];
            }

            @Override
            public MessageHeaders getHeaders() {
                return null;
            }
        };
    }
    //endregion

}