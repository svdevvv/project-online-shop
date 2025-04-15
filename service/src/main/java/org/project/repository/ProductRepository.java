package org.project.repository;

import org.project.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

//    public List<ProductEntity> findListOfProducts(EntityManager entityManager, ProductFilter filter){
//        Predicate predicate = QPredicate.builder()
//                .add("%" + filter.getName() + "%", productEntity.name.lower()::like)
//                .add("%" + filter.getDescription() + "%", productEntity.description.lower()::like)
//                .add(filter.getPrice(), productEntity.price::loe)
//                .add(filter.getStatus(), productEntity.status::eq)
//                .buildOr();
//
//        return new JPAQuery<ProductEntity>(entityManager)
//                .select(productEntity)
//                .from(productEntity)
//                .where(predicate)
//                .fetch();
//    }
}
