package com.sfl.coolmonkey.coolsocket.api.socket.controller.test;

import com.sfl.coolmonkey.coolsocket.api.socket.controller.helper.SocketControllerImplTestHelper;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 14:33
 */
@RunWith(EasyMockRunner.class)
@Ignore
public abstract class AbstractSocketControllerImplTest extends EasyMockSupport {

    //region Properties
    private final SocketControllerImplTestHelper helper;
    //endregion

    //region Constructors
    protected AbstractSocketControllerImplTest() {
        helper = new SocketControllerImplTestHelper();
    }
    //endregion

    //region Properties getters and setters
    protected SocketControllerImplTestHelper getHelper() {
        return helper;
    }
    //endregion

}
