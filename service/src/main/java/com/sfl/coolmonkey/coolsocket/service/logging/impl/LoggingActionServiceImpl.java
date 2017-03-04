package com.sfl.coolmonkey.coolsocket.service.logging.impl;

import com.sfl.coolmonkey.commons.queue.model.logging.CreateActivityLogEvent;
import com.sfl.coolmonkey.coolsocket.queue.producer.logging.LoggingEventProducer;
import com.sfl.coolmonkey.coolsocket.service.logging.LoggingActionService;
import com.sfl.coolmonkey.coolsocket.service.model.logging.request.CreateActivityLogRequest;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 6/6/16
 * Time: 5:29 PM
 */
@Service
public class LoggingActionServiceImpl implements LoggingActionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingActionServiceImpl.class);

    //region Dependencies
    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private LoggingEventProducer loggingEventProducer;
    //endregion

    //region Constructors
    public LoggingActionServiceImpl() {
        LOGGER.debug("Initializing logging action service");
    }
    //endregion

    //region Public methods
    @Override
    public void createActivityLog(@Nonnull final CreateActivityLogRequest request) {
        assertActivityLogActionRequest(request);
        final CreateActivityLogEvent event = mapperFacade.map(request, CreateActivityLogEvent.class);
        loggingEventProducer.produceCreateActivityLogEvent(event);
    }
    //endregion

    //region Utility methods
    private void assertActivityLogActionRequest(final CreateActivityLogRequest request) {
        Assert.notNull(request, "The activity log action request should not be null");
        Assert.notNull(request.getCompanyUuid(), "The company uuid should not be null");
        Assert.notNull(request.getOperatorUuid(), "The operator uuid should not be null");
        Assert.notNull(request.getType(), "The parent type should not be null");
    }
    //endregion
}
