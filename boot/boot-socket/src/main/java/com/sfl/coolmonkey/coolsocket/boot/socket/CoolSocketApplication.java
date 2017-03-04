package com.sfl.coolmonkey.coolsocket.boot.socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 22/05/16
 * Time: 20:26
 */
@SpringBootApplication
@ImportResource({"classpath:applicationContext-boot-socket.xml"})
@SuppressWarnings({"checkstyle:com.puppycrawl.tools.checkstyle.checks.design.HideUtilityClassConstructorCheck"})
public class CoolSocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoolSocketApplication.class, args);
    }
}
