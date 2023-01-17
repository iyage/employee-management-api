package com.example.demo;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class IdGenerator implements IdentifierGenerator {


    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String query = String.format("select %s from %s",
                sharedSessionContractImplementor.getEntityPersister(o.getClass().getName(), o)
                        .getIdentifierPropertyName(),
                o.getClass().getSimpleName());
        return  generateId();
    }
    public String generateId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();

    }
}
