package org.project.dao;


import jakarta.persistence.EntityManager;
import org.project.entity.UserEntity;

import static org.project.entity.QUserEntity.userEntity;


public class UserRepository extends RepositoryBase<Long, UserEntity> {

    public UserRepository(EntityManager entityManager) {
        super(UserEntity.class, userEntity, entityManager);
    }
}
