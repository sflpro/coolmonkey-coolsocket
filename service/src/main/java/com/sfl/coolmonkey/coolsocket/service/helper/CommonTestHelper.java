package com.sfl.coolmonkey.coolsocket.service.helper;

import com.sfl.coolmonkey.coolsocket.service.model.logging.ParentActivityTypeModel;
import com.sfl.coolmonkey.coolsocket.service.model.logging.request.CreateActivityLogRequest;
import com.sfl.coolmonkey.coolsocket.service.model.reporting.ReportingMessageType;
import com.sfl.coolmonkey.coolsocket.service.model.reporting.response.ReportingNotificationResponse;
import com.sfl.coolmonkey.coolsocket.service.model.user.SessionOperatorTypeModel;
import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUser;
import com.sfl.coolmonkey.coolsocket.service.model.user.SessionUserTypeModel;

import java.util.UUID;

/**
 * User: Arthur Asatryan.
 * Company: SFL LLC
 * Date: 23/05/16
 * Time: 14:24
 */
@SuppressWarnings({
        "MagicNumber",
        "DuplicateStringLiteralInspection",
        "checkstyle:com.puppycrawl.tools.checkstyle.checks.coding.MagicNumberCheck",
        "pmd:AvoidDuplicateLiterals",
        "squid:S1192"
})
public class CommonTestHelper {

    //region Constructors
    protected CommonTestHelper() {
    }
    //endregion

    //region Public methods

    //region User
    public SessionUser createSessionUser() {
        return new SessionUser(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                SessionUserTypeModel.OPERATOR,
                SessionOperatorTypeModel.MARKETING
        );
    }
    //endregion

    //region Reporting
    public ReportingNotificationResponse createReportingNotificationResponse() {
        return new ReportingNotificationResponse(ReportingMessageType.TIME_TRACKING_UPDATED);
    }

    public ReportingNotificationResponse createReportingNotificationResponse(final ReportingMessageType type) {
        return new ReportingNotificationResponse(type);
    }
    //endregion

    //region logging
    public CreateActivityLogRequest createActivityLogActionRequest() {
        return new CreateActivityLogRequest(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                ParentActivityTypeModel.OUTBOUND
        );
    }
    //endregion

    //endregion

}
