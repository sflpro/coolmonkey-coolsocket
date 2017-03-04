package com.sfl.coolmonkey.coolsocket.service.model.reporting.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import com.sfl.coolmonkey.coolsocket.service.model.reporting.ReportingMessageType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 5/30/16
 * Time: 3:15 PM
 */
public class ReportingNotificationResponse extends AbstractResponseModel {
    private static final long serialVersionUID = 8147005304981982901L;

    //region Properties
    @JsonProperty("type")
    private ReportingMessageType type;
    //endregion

    //region Constructors
    public ReportingNotificationResponse() {
    }

    public ReportingNotificationResponse(final ReportingMessageType type) {
        this.type = type;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReportingNotificationResponse)) {
            return false;
        }
        final ReportingNotificationResponse that = (ReportingNotificationResponse) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(type, that.type)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(type)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public ReportingMessageType getType() {
        return type;
    }

    public void setType(final ReportingMessageType type) {
        this.type = type;
    }
    //endregion

}
