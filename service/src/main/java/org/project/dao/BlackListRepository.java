package org.project.dao;

import jakarta.persistence.EntityManager;
import org.project.entity.BlackListEntity;
import org.project.entity.QBlackListEntity;

public class BlackListRepository extends RepositoryBase<Long, BlackListEntity> {
    public BlackListRepository(EntityManager entityManager) {
        super(BlackListEntity.class, QBlackListEntity.blackListEntity, entityManager);
    }
}
