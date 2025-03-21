package org.project.entity;

public interface BaseEntity<T> {

    void setId(T id);
    T getId();
}
