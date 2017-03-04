package com.sfl.coolmonkey.coolsocket.service.logging.impl;

import com.sfl.coolmonkey.commons.queue.model.logging.CreateActivityLogEvent;
import com.sfl.coolmonkey.coolsocket.queue.producer.logging.LoggingEventProducer;
import com.sfl.coolmonkey.coolsocket.service.logging.LoggingActionService;
import com.sfl.coolmonkey.coolsocket.service.model.logging.request.CreateActivityLogRequest;
import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.SerializationUtils;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 6/6/16
 * Time: 7:09 PM
 */
public class LoggingActionServiceImplTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private LoggingActionService loggingActionService = new LoggingActionServiceImpl();

    @Mock
    private LoggingEventProducer loggingEventProducer;

    @Mock
    private MapperFacade mapperFacade;
    //endregion

    //region Constructors
    public LoggingActionServiceImplTest() {
    }
    //endregion

    //region Test methods

    //region initial
    @Test
    public void testHaveLoggingActionService() {
        resetAll();
        // expectations
        replayAll();
        assertNotNull(loggingActionService);
        verifyAll();
    }

    @Test
    public void testHaveLoggingActionProducer() {
        resetAll();
        // expectations
        replayAll();
        assertNotNull(loggingEventProducer);
        verifyAll();
    }

    @Test
    public void testHaveMapperFacade() {
        resetAll();
        // expectations
        replayAll();
        assertNotNull(mapperFacade);
        verifyAll();
    }
    //endregion

    //region createActivityLog
    @Test
    public void testCreateActivityLogWithInvalidArguments() {
        resetAll();
        final CreateActivityLogRequest validRequest = getHelper().createActivityLogActionRequest();
        CreateActivityLogRequest invalidRequest;
        // expectations
        replayAll();
        invalidRequest = null;
        try {
            loggingActionService.createActivityLog(invalidRequest);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.setCompanyUuid(null);
        try {
            loggingActionService.createActivityLog(invalidRequest);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.setOperatorUuid(null);
        try {
            loggingActionService.createActivityLog(invalidRequest);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.setType(null);
        try {
            loggingActionService.createActivityLog(invalidRequest);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        verifyAll();
    }

    @Test
    public void testCreateActivityLog() {
        resetAll();
        final CreateActivityLogEvent event = getHelper().createActivityLogEvent();
        final CreateActivityLogRequest request = getHelper().createActivityLogActionRequest();
        // expectations
        expect(mapperFacade.map(request, CreateActivityLogEvent.class)).andReturn(event);
        loggingEventProducer.produceCreateActivityLogEvent(event);
        replayAll();
        loggingActionService.createActivityLog(request);
        verifyAll();
    }
    //endregion

    //endregion

}