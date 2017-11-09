package com.getjavajob.repository.impl;

import com.getjavajob.repository.IDao;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Named
public abstract class AbstractDao<T> implements IDao<T> {

    private EntityManagerFactory factory;
    private final Class<T> persistenceClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> fetchAll() {
        EntityManager entityManager = factory.createEntityManager();
        Query query = null;
        try {
            entityManager.getTransaction().begin();
            query = entityManager.createQuery("SELECT t FROM " + getTypeName() + " t");
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return query.getResultList();
    }

    @Override
    public T getById(Long id) {
        EntityManager entityManager = this.factory.createEntityManager();
        T byId = null;
        try {
            entityManager.getTransaction().begin();
            System.out.println(getType());
            byId = entityManager.find(getType(), id);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return byId;
    }

    @Override
    public void insert(T entity) {
        EntityManager entityManager = this.factory.createEntityManager();
        try {
            entityManager.getTransaction();
//            entityManager.getTransaction().begin();
            System.out.println(entityManager.getTransaction().isActive());
            entityManager.persist(entity);
//            entityManager.getTransaction().commit();
        } finally {
//            entityManager.getTransaction().rollback();
        }
    }

    private String getTypeName() {
        return this.persistenceClass.getSimpleName();
    }

    private Class<T> getType() {
        return this.persistenceClass;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(T entity) {
        EntityManager entityManager = this.factory.createEntityManager();
        try {
//            entityManager.getTransaction().begin();
            entityManager.merge(entity);
//            entityManager.getTransaction().commit();
        } finally {
//            if (entityManager.getTransaction().isActive()) {
//                entityManager.getTransaction().rollback();
//            }
        }
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    @PersistenceUnit
    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }
}
