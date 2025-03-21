package org.project.dao;

import jakarta.persistence.EntityManager;
import org.project.entity.PromoCodeEntity;
import org.project.entity.QPromoCodeEntity;

public class PromoCodeRepository extends RepositoryBase<Long, PromoCodeEntity> {
    public PromoCodeRepository(EntityManager entityManager) {
        super(PromoCodeEntity.class, QPromoCodeEntity.promoCodeEntity,entityManager);
    }
}
