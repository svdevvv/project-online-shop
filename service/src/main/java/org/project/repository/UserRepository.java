package org.project.repository;


import jakarta.persistence.EntityManager;
import org.project.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends RepositoryBase<Long, UserEntity> {

    @Autowired
    public UserRepository(EntityManager entityManager) {
        super(UserEntity.class,entityManager);
    }
}
