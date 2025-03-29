package org.project.repository;

import jakarta.persistence.EntityManager;
import org.project.entity.PromoCodeUsageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PromoCodeUsageRepository extends RepositoryBase<Long, PromoCodeUsageEntity> {

    @Autowired
    public PromoCodeUsageRepository(EntityManager entityManager) {
        super(PromoCodeUsageEntity.class, entityManager);
    }
}
