package org.project.dao;

import org.project.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudInterface<K extends Serializable, E extends BaseEntity> {

    E save(E entity);

    void delete(K id);

    void update(E entity);

    Optional<E> findById(K id);

    List<E> findAll();
}
