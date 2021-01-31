package com.ykn.user_service.hibernatecustommapper.trackerdatamapper;

import org.hibernate.dialect.PostgreSQL9Dialect;

import java.sql.Types;

public class TrackerDataJsonPostgreSQLDialect extends PostgreSQL9Dialect {

    public TrackerDataJsonPostgreSQLDialect(){
        this.registerColumnType(Types.JAVA_OBJECT, "json");
    }

}
