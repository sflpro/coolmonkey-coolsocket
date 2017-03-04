package com.sfl.coolmonkey.coolsocket.service.common.component.impl;

import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.coolsocket.service.common.component.ResultResponseAssertionComponent;
import com.sfl.coolmonkey.coolsocket.service.common.exception.ServiceRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 26/05/16
 * Time: 17:56
 */
@Component
public class ResultResponseAssertionComponentImpl implements ResultResponseAssertionComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultResponseAssertionComponentImpl.class);

    //region Dependencies
    //endregion

    //region Constructors
    public ResultResponseAssertionComponentImpl() {
        LOGGER.debug("Initializing result response assertion component");
    }
    //endregion

    //region Public methods
    @Override
    public <T extends AbstractResponseModel> void assertNoErrors(@Nonnull final ResultResponseModel<T> resultResponse) {
        Assert.notNull(resultResponse, "The result response model should not be null");
        if (resultResponse.hasErrors()) {
            LOGGER.error("Result response model - {} has errors - {}", resultResponse, resultResponse.getErrors());
            throw new ServiceRuntimeException("Result response model - " + resultResponse + " has errors");
        }
    }
    //endregion
}
