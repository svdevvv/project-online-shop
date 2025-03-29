package org.project.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import org.project.dto.ProductFilter;
import org.project.entity.ProductEntity;
import org.project.utils.QPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.project.entity.QProductEntity.productEntity;

@Repository
public class ProductRepository extends RepositoryBase<Long, ProductEntity> {

    @Autowired
    public ProductRepository(EntityManager entityManager) {
        super(ProductEntity.class, entityManager);
    }

    public List<ProductEntity> findListOfProducts(EntityManager entityManager, ProductFilter filter){
        Predicate predicate = QPredicate.builder()
                .add("%" + filter.getName() + "%", productEntity.name.lower()::like)
                .add("%" + filter.getDescription() + "%", productEntity.description.lower()::like)
                .add(filter.getPrice(), productEntity.price::loe)
                .add(filter.getStatus(), productEntity.status::eq)
                .buildOr();

        return new JPAQuery<ProductEntity>(entityManager)
                .select(productEntity)
                .from(productEntity)
                .where(predicate)
                .fetch();
    }
}
