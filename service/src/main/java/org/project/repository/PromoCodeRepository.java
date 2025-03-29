package org.project.repository;

import jakarta.persistence.EntityManager;
import org.project.entity.PromoCodeEntity;
import org.project.entity.QPromoCodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PromoCodeRepository extends RepositoryBase<Long, PromoCodeEntity> {

    @Autowired
    public PromoCodeRepository(EntityManager entityManager) {
        super(PromoCodeEntity.class, entityManager);
    }
}
