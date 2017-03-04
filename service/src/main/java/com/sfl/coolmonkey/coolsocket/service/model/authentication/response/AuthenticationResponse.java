package com.sfl.coolmonkey.coolsocket.service.model.authentication.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 22/05/16
 * Time: 18:22
 */
public class AuthenticationResponse extends AbstractResponseModel {
    private static final long serialVersionUID = -1740636228785213533L;

    //region Properties
    @JsonProperty("authToken")
    private String authToken;
    //endregion

    //region Constructors
    public AuthenticationResponse() {
    }

    public AuthenticationResponse(final String authToken) {
        this.authToken = authToken;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AuthenticationResponse)) {
            return false;
        }
        final AuthenticationResponse that = (AuthenticationResponse) o;
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
