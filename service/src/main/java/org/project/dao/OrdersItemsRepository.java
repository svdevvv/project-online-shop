package org.project.dao;

import jakarta.persistence.EntityManager;
import org.project.entity.OrderItems;
import org.project.entity.QOrderItems;

public class OrdersItemsRepository extends RepositoryBase<Long, OrderItems> {
    public OrdersItemsRepository(EntityManager entityManager) {
        super(OrderItems.class, QOrderItems.orderItems, entityManager);
    }
}
