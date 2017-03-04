package com.sfl.coolmonkey.coolsocket.service.test;

import com.sfl.coolmonkey.coolsocket.service.helper.ServiceImplTestHelper;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 14:23
 */
@RunWith(EasyMockRunner.class)
@Ignore
public abstract class AbstractServiceImplTest extends EasyMockSupport {

    //region Properties
    private final ServiceImplTestHelper helper;
    //endregion

    //region Constructors
    protected AbstractServiceImplTest() {
        helper = new ServiceImplTestHelper();
    }
    //endregion

    //region Properties getters and setters
    protected ServiceImplTestHelper getHelper() {
        return helper;
    }
    //endregion
}
