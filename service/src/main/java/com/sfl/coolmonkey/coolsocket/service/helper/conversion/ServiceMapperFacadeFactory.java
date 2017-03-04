package com.sfl.coolmonkey.coolsocket.service.helper.conversion;

import com.sfl.coolmonkey.commons.queue.model.logging.CreateActivityLogEvent;
import com.sfl.coolmonkey.commons.queue.model.logging.ParentActivityTypeEventModel;
import com.sfl.coolmonkey.coolsocket.service.model.logging.ParentActivityTypeModel;
import com.sfl.coolmonkey.coolsocket.service.model.logging.request.CreateActivityLogRequest;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/1/15
 * Time: 6:48 PM
 */
@Component
@SuppressWarnings({
        "pmd:NcssMethodCount",
        "squid:S138",
})
@Primary
public class ServiceMapperFacadeFactory extends AbstractFactoryBean<MapperFacade> {

    //region Dependencies
    //endregion

    //region Constructors
    public ServiceMapperFacadeFactory() {
    }
    //endregion

    //region Public methods
    @Override
    public Class<?> getObjectType() {
        return MapperFacade.class;
    }

    @Override
    public MapperFacade createInstance() {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        initLoggingMappings(mapperFactory);
        return mapperFactory.getMapperFacade();
    }
    //endregion

    //region Utility methods
    private void initLoggingMappings(final MapperFactory mapperFactory) {
        mapperFactory.classMap(CreateActivityLogRequest.class, CreateActivityLogEvent.class).byDefault().register();
        mapperFactory.classMap(ParentActivityTypeModel.class, ParentActivityTypeEventModel.class).byDefault().register();
    }
    //endregion
}
