package com.sfl.coolmonkey.coolsocket.queue.consumer.test;

import com.sfl.coolmonkey.coolsocket.queue.consumer.helper.ConsumerImplTestHelper;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 24/05/16
 * Time: 15:52
 */
@Ignore
@RunWith(EasyMockRunner.class)
public abstract class AbstractConsumerImplTest extends EasyMockSupport {

    //region Properties
    private final ConsumerImplTestHelper helper;
    //endregion

    //region Constructors
    public AbstractConsumerImplTest() {
        helper = new ConsumerImplTestHelper();
    }
    //endregion

    //region Public methods
    //endregion

    //region Properties getters and setters
    public ConsumerImplTestHelper getHelper() {
        return helper;
    }
    //endregion

}
