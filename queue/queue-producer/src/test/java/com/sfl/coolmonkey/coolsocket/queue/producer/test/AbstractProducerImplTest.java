package com.sfl.coolmonkey.coolsocket.queue.producer.test;

import com.sfl.coolmonkey.coolsocket.queue.producer.helper.ProducerImplTestHelper;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 24/05/16
 * Time: 15:48
 */
@Ignore
@RunWith(EasyMockRunner.class)
public abstract class AbstractProducerImplTest extends EasyMockSupport {

    //region Properties
    private final ProducerImplTestHelper helper;
    //endregion

    //region Constructors
    public AbstractProducerImplTest() {
        helper = new ProducerImplTestHelper();
    }
    //endregion

    //region Public methods
    //endregion

    //region Properties getters and setters
    public ProducerImplTestHelper getHelper() {
        return helper;
    }
    //endregion
}
