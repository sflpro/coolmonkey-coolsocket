package com.sfl.coolmonkey.coolsocket.service.common.component.impl;

import com.sfl.coolmonkey.commons.api.model.CommonErrorType;
import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.coolsocket.service.common.component.ResultResponseAssertionComponent;
import com.sfl.coolmonkey.coolsocket.service.common.exception.ServiceRuntimeException;
import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.easymock.TestSubject;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 26/05/16
 * Time: 17:58
 */
public class ResultResponseAssertionComponentImplTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private final ResultResponseAssertionComponent resultResponseAssertionComponent = new ResultResponseAssertionComponentImpl();
    //endregion

    //region Constructors
    public ResultResponseAssertionComponentImplTest() {
    }
    //endregion

    //region Test methods

    //region assertNoErrors
    @Test
    public void testAssertNoErrorsWithInvalidArguments() {
        // test data
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            resultResponseAssertionComponent.assertNoErrors(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testAssertNoErrorsWhenItHasErrors() {
        // test data
        final ResultResponseModel resultResponseModel = new ResultResponseModel<>();
        resultResponseModel.getErrors().put(CommonErrorType.USER_NOT_VERIFIED, null);
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        try {
            resultResponseAssertionComponent.assertNoErrors(resultResponseModel);
            fail("Exception should be thrown");
        } catch (final ServiceRuntimeException ignore) {
            // Expected
        }
        // verify
        verifyAll();
    }

    @Test
    public void testAssertNoErrors() {
        // test data
        final ResultResponseModel resultResponseModel = new ResultResponseModel<>();
        // reset
        resetAll();
        // expectations
        // reply
        replayAll();
        // run test scenario
        resultResponseAssertionComponent.assertNoErrors(resultResponseModel);
        // verify
        verifyAll();
    }
    //endregion

    //endregion

}