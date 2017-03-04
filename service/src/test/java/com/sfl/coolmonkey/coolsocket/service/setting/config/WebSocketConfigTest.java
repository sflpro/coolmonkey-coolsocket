package com.sfl.coolmonkey.coolsocket.service.setting.config;

import com.sfl.coolmonkey.coolsocket.service.test.AbstractServiceImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.config.SimpleBrokerRegistration;
import org.springframework.web.socket.config.annotation.SockJsServiceRegistration;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;

import static org.easymock.EasyMock.expect;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 15:57
 */
public class WebSocketConfigTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private final WebSocketConfig webSocketConfig = new WebSocketConfig();

    @Mock
    private StompEndpointRegistry stompEndpointRegistry;

    @Mock
    private StompWebSocketEndpointRegistration stompWebSocketEndpointRegistration;

    @Mock
    private SockJsServiceRegistration sockJsServiceRegistration;

    @Mock
    private MessageBrokerRegistry messageBrokerRegistry;

    @Mock
    private SimpleBrokerRegistration simpleBrokerRegistration;
    //endregion

    //region Constructors
    public WebSocketConfigTest() {
    }
    //endregion

    //region Test methods

    //region registerStompEndpoints
    @Test
    public void testRegisterStompEndpoints() {
        // test data
        // reset
        resetAll();
        // expectations
        expect(stompEndpointRegistry.addEndpoint("/coolsocket")).andReturn(stompWebSocketEndpointRegistration);
        expect(stompWebSocketEndpointRegistration.setAllowedOrigins("*")).andReturn(stompWebSocketEndpointRegistration);
        expect(stompWebSocketEndpointRegistration.withSockJS()).andReturn(sockJsServiceRegistration);
        // reply
        replayAll();
        // run test scenario
        webSocketConfig.registerStompEndpoints(stompEndpointRegistry);
        // verify
        verifyAll();
    }
    //endregion

    //region configureMessageBroker

    @Test
    public void testConfigureMessageBroker() {
        // test data
        // reset
        resetAll();
        // expectations
        expect(messageBrokerRegistry.enableSimpleBroker("/queue/", "/topic/", "/user")).andReturn(simpleBrokerRegistration);
        expect(messageBrokerRegistry.setApplicationDestinationPrefixes("/app")).andReturn(messageBrokerRegistry);
        // reply
        replayAll();
        // run test scenario
        webSocketConfig.configureMessageBroker(messageBrokerRegistry);
        // verify
        verifyAll();
    }

    //endregion

    //endregion

}