package com.ykn.user_service.hibernatecustommapper.trackerdatamapper;

import com.ykn.user_service.entities.tracker.TrackerData;
import com.ykn.user_service.entities.user.UserData;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.postgresql.util.PGobject;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class TrackerDataJsonUserType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[]{Types.JAVA_OBJECT};
    }

    @Override
    public Class returnedClass() {
        return TrackerData.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return TrackerDataJsonUtil.isEquals((TrackerData) x, (TrackerData) y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        String json = rs.getString(names[0]);

        if (StringUtils.isNotBlank(json)) {
            return TrackerDataJsonUtil.fromJson(json);
        }

        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (value != null) {
            if (value instanceof TrackerData) {
                String json = TrackerDataJsonUtil.toJson((TrackerData) value);
                PGobject pGobject = new PGobject();
                pGobject.setType("json");
                pGobject.setValue(json);
                st.setObject(index, pGobject, Types.OTHER);
                return;
            }
        }

        st.setObject(index, null);
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value == null ? null : new TrackerData((TrackerData) value);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) deepCopy(value);
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return deepCopy(original);
    }
}
