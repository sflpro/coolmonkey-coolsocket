package com.sfl.coolmonkey.coolsocket.service.common.component.impl;

import com.sfl.coolmonkey.coolsocket.service.common.component.HeaderAccessorWrapperComponent;
import com.sfl.coolmonkey.coolsocket.service.common.exception.ServiceRuntimeException;
import com.sfl.coolmonkey.coolsocket.service.model.common.SessionAttributes;
import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUser;
import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 18:37
 */
public class HeaderAccessorWrapperComponentImplTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private final HeaderAccessorWrapperComponent headerAccessorWrapperComponent = new HeaderAccessorWrapperComponentImpl();

    @Mock
    private SimpMessageHeaderAccessor simpMessageHeaderAccessor;
    //endregion

    //region Constructors
    public HeaderAccessorWrapperComponentImplTest() {
    }
    //endregion

    //region Test methods

    //region getSessionUserFromHeaderAccessor
    @Test
    public void testGetSessionUserFromHeaderAccessorWithInvalidArguments() {
        // test data
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            headerAccessorWrapperComponent.getSessionUserFromHeaderAccessor(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testGetSessionUserFromHeaderAccessorWhenSessionUserNotExists() {
        // test data
        // reset
        resetAll();
        // expectations
        expect(simpMessageHeaderAccessor.getSessionAttributes()).andReturn(Collections.emptyMap());
        // reply
        replayAll();
        // run test scenario
        try {
            headerAccessorWrapperComponent.getSessionUserFromHeaderAccessor(simpMessageHeaderAccessor);
            fail("Exception should be thrown");
        } catch (final ServiceRuntimeException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testGetSessionUserFromHeaderAccessor() {
        // test data
        final SessionUser sessionUser = getHelper().createSessionUser();
        final Map<String, Object> sessionAttributes = new HashMap<>();
        sessionAttributes.put(SessionAttributes.SESSION_USER, sessionUser);
        // reset
        resetAll();
        // expectations
        expect(simpMessageHeaderAccessor.getSessionAttributes()).andReturn(sessionAttributes);
        // reply
        replayAll();
        // run test scenario
        final SessionUser result = headerAccessorWrapperComponent.getSessionUserFromHeaderAccessor(simpMessageHeaderAccessor);
        assertNotNull(result);
        assertEquals(sessionUser, result);
        // verify
        verifyAll();
    }
    //endregion

    //endregion

}