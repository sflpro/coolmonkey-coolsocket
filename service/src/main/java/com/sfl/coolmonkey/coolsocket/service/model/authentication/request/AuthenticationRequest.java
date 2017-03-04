package com.sfl.coolmonkey.coolsocket.service.model.authentication.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.request.AbstractRequestModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 22/05/16
 * Time: 17:44
 */
public class AuthenticationRequest extends AbstractRequestModel {
    private static final long serialVersionUID = 3308472833473582412L;

    //region Properties
    @JsonProperty("userUuid")
    private String userUuid;

    @JsonProperty("companyUuid")
    private String companyUuid;
    //endregion

    //region Constructors
    public AuthenticationRequest() {
    }

    public AuthenticationRequest(final String userUuid, final String companyUuid) {
        this.userUuid = userUuid;
        this.companyUuid = companyUuid;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AuthenticationRequest)) {
            return false;
        }
        final AuthenticationRequest that = (AuthenticationRequest) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(userUuid, that.userUuid)
                .append(companyUuid, that.companyUuid)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(userUuid)
                .append(companyUuid)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userUuid", userUuid)
                .append("companyUuid", companyUuid)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(final String userUuid) {
        this.userUuid = userUuid;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(final String companyUuid) {
        this.companyUuid = companyUuid;
    }
    //endregion
}
