package com.ykn.user_service.hibernatecustommapper.userdatamapper;

import org.hibernate.dialect.PostgreSQL9Dialect;

import java.sql.Types;

public class UserDataJsonPostgreSQLDialect extends PostgreSQL9Dialect {

    public UserDataJsonPostgreSQLDialect(){
        this.registerColumnType(Types.JAVA_OBJECT, "json");
    }

}
