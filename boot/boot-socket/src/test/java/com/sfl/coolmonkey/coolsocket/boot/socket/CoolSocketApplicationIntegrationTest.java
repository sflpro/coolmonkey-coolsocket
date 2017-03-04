package com.sfl.coolmonkey.coolsocket.boot.socket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 14:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CoolSocketApplicationIntegrationTest.class)
@WebAppConfiguration
public class CoolSocketApplicationIntegrationTest {

    //region Test subject and mocks
    //endregion

    //region Constructors
    public CoolSocketApplicationIntegrationTest() {
    }
    //endregion

    //region Test methods
    @Test
    public void contextLoads() {
    }
    //endregion

}