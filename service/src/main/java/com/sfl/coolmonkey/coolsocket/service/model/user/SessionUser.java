package com.sfl.coolmonkey.coolsocket.service.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 22/05/16
 * Time: 16:50
 */
public class SessionUser implements ApiModel {
    private static final long serialVersionUID = 3752275821044033339L;

    //region Properties
    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("authToken")
    private String authToken;

    @JsonProperty("companyUuid")
    private String companyUuid;

    @JsonProperty("type")
    private SessionUserTypeModel type;

    @JsonProperty("operatorType")
    private SessionOperatorTypeModel operatorType;
    //endregion

    //region Constructors
    public SessionUser() {
    }

    public SessionUser(final String uuid,
                       final String authToken,
                       final String companyUuid,
                       final SessionUserTypeModel type,
                       final SessionOperatorTypeModel operatorType) {
        this.uuid = uuid;
        this.authToken = authToken;
        this.companyUuid = companyUuid;
        this.type = type;
        this.operatorType = operatorType;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SessionUser)) {
            return false;
        }
        final SessionUser that = (SessionUser) o;
        return new EqualsBuilder()
                .append(uuid, that.uuid)
                .append(authToken, that.authToken)
                .append(companyUuid, that.companyUuid)
                .append(type, that.type)
                .append(operatorType, that.operatorType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(uuid)
                .append(authToken)
                .append(companyUuid)
                .append(type)
                .append(operatorType)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uuid", uuid)
                .append("authToken", authToken)
                .append("companyUuid", companyUuid)
                .append("type", type)
                .append("operatorType", operatorType)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(final String authToken) {
        this.authToken = authToken;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(final String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public SessionUserTypeModel getType() {
        return type;
    }

    public void setType(final SessionUserTypeModel type) {
        this.type = type;
    }

    public SessionOperatorTypeModel getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(final SessionOperatorTypeModel operatorType) {
        this.operatorType = operatorType;
    }
    //endregion
}
