package org.project.entity.interfaces;

public interface BaseEntity<T> {

    void setId(T id);
    T getId();
}
