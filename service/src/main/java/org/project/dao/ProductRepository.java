package org.project.dao;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import org.project.dto.FindProductFilter;
import org.project.entity.ProductEntity;
import org.project.utils.QPredicate;

import java.util.List;

import static org.project.entity.QProductEntity.*;

public class ProductRepository extends RepositoryBase<Long, ProductEntity> {

    public ProductRepository(EntityManager entityManager) {
        super(ProductEntity.class, productEntity, entityManager);
    }

    public List<ProductEntity> finsListOfProducts(EntityManager entityManager, FindProductFilter filter){
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
