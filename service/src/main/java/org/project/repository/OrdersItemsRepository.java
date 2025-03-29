package org.project.repository;

import jakarta.persistence.EntityManager;
import org.project.entity.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersItemsRepository extends RepositoryBase<Long, OrderItems> {

    @Autowired
    public OrdersItemsRepository(EntityManager entityManager) {
        super(OrderItems.class, entityManager);
    }
}
