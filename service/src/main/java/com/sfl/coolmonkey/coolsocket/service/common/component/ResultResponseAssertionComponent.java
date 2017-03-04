package com.sfl.coolmonkey.coolsocket.service.common.component;

import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 26/05/16
 * Time: 17:55
 */
public interface ResultResponseAssertionComponent {
    /**
     * Ensures that the result response model does not have errors.
     *
     * @param <T>            instance of AbstractResponseModel
     * @param resultResponse the result response
     */
    <T extends AbstractResponseModel>
    void assertNoErrors(@Nonnull final ResultResponseModel<T> resultResponse);
}
