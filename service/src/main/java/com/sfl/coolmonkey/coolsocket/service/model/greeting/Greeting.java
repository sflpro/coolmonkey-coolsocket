package com.sfl.coolmonkey.coolsocket.service.model.greeting;

import java.io.Serializable;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 20/05/16
 * Time: 14:09
 */
public class Greeting implements Serializable {
    private static final long serialVersionUID = -3845124653263681941L;

    private String content;

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
