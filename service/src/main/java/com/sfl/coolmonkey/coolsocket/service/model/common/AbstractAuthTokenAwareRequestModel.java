package com.sfl.coolmonkey.coolsocket.service.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.request.AbstractRequestModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 6/7/16
 * Time: 2:25 PM
 */
public class AbstractAuthTokenAwareRequestModel extends AbstractRequestModel {
    private static final long serialVersionUID = 7596488429761339461L;

    //region Properties
    @JsonProperty("authToken")
    private String authToken;
    //endregion

    //region Constructors
    public AbstractAuthTokenAwareRequestModel() {
    }

    public AbstractAuthTokenAwareRequestModel(final String authToken) {
        this.authToken = authToken;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractAuthTokenAwareRequestModel)) {
            return false;
        }
        final AbstractAuthTokenAwareRequestModel that = (AbstractAuthTokenAwareRequestModel) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(authToken, that.authToken)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(authToken)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("authToken", authToken)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(final String authToken) {
        this.authToken = authToken;
    }
    //endregion
}
