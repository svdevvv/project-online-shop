package org.project.dao;

import jakarta.persistence.EntityManager;
import org.project.entity.PromoCodeUsageEntity;
import org.project.entity.QPromoCodeUsageEntity;

public class PromoCodeUsageRepository extends RepositoryBase<Long, PromoCodeUsageEntity>{
    public PromoCodeUsageRepository(EntityManager entityManager) {
        super(PromoCodeUsageEntity.class, QPromoCodeUsageEntity.promoCodeUsageEntity,entityManager);
    }
}
