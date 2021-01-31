package com.ykn.user_service.entities;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
}
