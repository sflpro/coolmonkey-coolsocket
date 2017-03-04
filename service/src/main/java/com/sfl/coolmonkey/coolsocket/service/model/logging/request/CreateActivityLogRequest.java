package com.sfl.coolmonkey.coolsocket.service.model.logging.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.coolsocket.service.model.common.AbstractAuthTokenAwareRequestModel;
import com.sfl.coolmonkey.coolsocket.service.model.logging.ParentActivityTypeModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 6/6/16
 * Time: 4:25 PM
 */
public class CreateActivityLogRequest extends AbstractAuthTokenAwareRequestModel {
    private static final long serialVersionUID = 2328136997413603134L;

    //region Properties
    @JsonProperty("companyUuid")
    private String companyUuid;

    @JsonProperty("operatorUuid")
    private String operatorUuid;

    @JsonProperty("type")
    private ParentActivityTypeModel type;
    //endregion

    //region Constructors
    public CreateActivityLogRequest() {
    }

    public CreateActivityLogRequest(final String companyUuid,
                                    final String operatorUuid,
                                    final ParentActivityTypeModel type) {
        this.companyUuid = companyUuid;
        this.operatorUuid = operatorUuid;
        this.type = type;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CreateActivityLogRequest)) {
            return false;
        }
        final CreateActivityLogRequest that = (CreateActivityLogRequest) o;
        return new EqualsBuilder()
                .append(companyUuid, that.companyUuid)
                .append(operatorUuid, that.operatorUuid)
                .append(type, that.type)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(companyUuid)
                .append(operatorUuid)
                .append(type)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("companyUuid", companyUuid)
                .append("operatorUuid", operatorUuid)
                .append("type", type)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(final String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getOperatorUuid() {
        return operatorUuid;
    }

    public void setOperatorUuid(final String operatorUuid) {
        this.operatorUuid = operatorUuid;
    }

    public ParentActivityTypeModel getType() {
        return type;
    }

    public void setType(final ParentActivityTypeModel type) {
        this.type = type;
    }
    //endregion
}
