package org.project.repository;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.project.entity.BaseEntity;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public abstract class RepositoryBase<K extends Serializable, E extends BaseEntity<Long>> implements CrudInterface<K, E> {

    private final Class<E> clazz;

    @Getter
    private final EntityManager entityManager;

    @Override
    public E save(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(K id) {
        entityManager.remove(id);
        entityManager.flush();
    }

    @Override
    public void update(E entity) {
        entityManager.merge(entity);
    }

    @Override
    public Optional<E> findById(K id) {
        return Optional.ofNullable(entityManager.find(clazz, id));
    }

    @Override
    public List<E> findAll() {
        CriteriaQuery<E> criteria = entityManager.getCriteriaBuilder().createQuery(clazz);
        criteria.select(criteria.from(clazz));
        return entityManager.createQuery(criteria)
                .getResultList();
    }

}
