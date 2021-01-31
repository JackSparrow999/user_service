package com.ykn.user_service.hibernatecustommapper.preferencedatamapper;

import org.hibernate.dialect.PostgreSQL9Dialect;

import java.sql.Types;

public class PreferenceDataJsonPostgreSQLDialect extends PostgreSQL9Dialect {

    public PreferenceDataJsonPostgreSQLDialect(){
        this.registerColumnType(Types.JAVA_OBJECT, "json");
    }

}
