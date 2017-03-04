package com.sfl.coolmonkey.coolsocket.api.socket.controller.loggin.impl;

import com.sfl.coolmonkey.coolsocket.api.socket.controller.logging.LoggingActionController;
import com.sfl.coolmonkey.coolsocket.api.socket.controller.logging.impl.LoggingActionControllerImpl;
import com.sfl.coolmonkey.coolsocket.api.socket.controller.test.AbstractSocketControllerImplTest;
import com.sfl.coolmonkey.coolsocket.service.common.component.SessionWrapperComponent;
import com.sfl.coolmonkey.coolsocket.service.logging.LoggingActionService;
import com.sfl.coolmonkey.coolsocket.service.model.logging.request.CreateActivityLogRequest;
import com.sfl.coolmonkey.coolsocket.service.model.logging.request.CreateGetOutboundRequest;
import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUser;
import org.apache.commons.lang3.SerializationUtils;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 6/6/16
 * Time: 4:07 PM
 */
public class LoggingActionControllerImplTest extends AbstractSocketControllerImplTest {

    //region Test subject and mocks
    @TestSubject
    private LoggingActionController loggingActionController = new LoggingActionControllerImpl();

    @Mock
    private LoggingActionService loggingActionService;

    @Mock
    private SessionWrapperComponent sessionWrapperComponent;

    @Mock
    private SimpMessageHeaderAccessor simpMessageHeaderAccessor;
    //endregion

    //region Constructors
    public LoggingActionControllerImplTest() {
    }
    //endregion

    //region Test methods

    //region initial
    @Test
    public void testHaveReportingActionController() {
        resetAll();
        // expectations
        replayAll();
        assertNotNull(loggingActionController);
        verifyAll();
    }

    @Test
    public void testHaveLoggingActionService() {
        resetAll();
        // expectations
        replayAll();
        assertNotNull(loggingActionService);
        verifyAll();
    }

    @Test
    public void testHaveSimpMessageHeaderAccessor() {
        resetAll();
        // expectations
        replayAll();
        assertNotNull(simpMessageHeaderAccessor);
        verifyAll();
    }

    @Test
    public void testHaveSessionWrapperComponent() {
        resetAll();
        // expectations
        replayAll();
        assertNotNull(sessionWrapperComponent);
        verifyAll();
    }
    //endregion

    //region createActivityLog
    @Test
    public void testActivityLogActionWithInvalidArguments() {
        resetAll();
        final CreateActivityLogRequest validRequest = getHelper().createActivityLogActionRequest();
        CreateActivityLogRequest invalidRequest;
        // expectations
        replayAll();
        invalidRequest = null;
        try {
            loggingActionController.createActivityLog(invalidRequest, simpMessageHeaderAccessor);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.setCompanyUuid(null);
        try {
            loggingActionController.createActivityLog(invalidRequest, simpMessageHeaderAccessor);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.setOperatorUuid(null);
        try {
            loggingActionController.createActivityLog(invalidRequest, simpMessageHeaderAccessor);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.setType(null);
        try {
            loggingActionController.createActivityLog(invalidRequest, simpMessageHeaderAccessor);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        try {
            loggingActionController.createActivityLog(validRequest, null);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        verifyAll();
    }

    @Test
    public void testActivityLogAction() {
        resetAll();
        final CreateActivityLogRequest request = getHelper().createActivityLogActionRequest();
        final SessionUser sessionUser = getHelper().createSessionUser();
        // expectations
        expect(sessionWrapperComponent.getSessionUser(simpMessageHeaderAccessor)).andReturn(sessionUser);
        loggingActionService.createActivityLog(request);
        expectLastCall().andAnswer(() -> {
            final CreateActivityLogRequest req = (CreateActivityLogRequest) getCurrentArguments()[0];
            assertEquals(sessionUser.getCompanyUuid(), req.getCompanyUuid());
            assertEquals(sessionUser.getUuid(), req.getOperatorUuid());
            assertEquals(sessionUser.getAuthToken(), req.getAuthToken());
            return req;
        });
        replayAll();
        loggingActionController.createActivityLog(request, simpMessageHeaderAccessor);
        verifyAll();
    }
    //endregion

    //region createGetOutbound
    @Test
    public void testTestGetOutboundActionWithInvalidArguments() {
        resetAll();
        // expectations
        replayAll();
        loggingActionController.createGetOutbound(new CreateGetOutboundRequest(), simpMessageHeaderAccessor);
        verifyAll();
    }
    //endregion

    //endregion

}
