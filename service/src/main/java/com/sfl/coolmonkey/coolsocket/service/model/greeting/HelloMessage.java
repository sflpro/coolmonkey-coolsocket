package com.sfl.coolmonkey.coolsocket.service.model.greeting;

import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 20/05/16
 * Time: 14:10
 */
public class HelloMessage extends AbstractResponseModel {
    private static final long serialVersionUID = 5972696470464521287L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HelloMessage)) {
            return false;
        }
        final HelloMessage that = (HelloMessage) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(name)
                .toHashCode();
    }
}
