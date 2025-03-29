package org.project.repository;

import jakarta.persistence.EntityManager;
import org.project.entity.BlackListEntity;
import org.project.entity.QBlackListEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlackListRepository extends RepositoryBase<Long, BlackListEntity> {

    @Autowired
    public BlackListRepository(EntityManager entityManager) {
        super(BlackListEntity.class, entityManager);
    }
}
