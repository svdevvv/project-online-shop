package org.project.dao;

import jakarta.persistence.EntityManager;
import org.project.dto.FIndOrdersForUser;
import org.project.entity.OrdersEntity;
import org.project.utils.QPredicate;

import java.util.List;

import static org.project.entity.QOrdersEntity.ordersEntity;


public class OrdersRepository extends RepositoryBase<Long, OrdersEntity> {

    public OrdersRepository(EntityManager entityManager) {
        super(OrdersEntity.class, ordersEntity, entityManager);
    }

    public List<OrdersEntity> listOfActiveOrders(EntityManager entityManager, FIndOrdersForUser filter) {
        QPredicate.builder()
                .add(filter.getUserId(), userId -> ordersEntity.userId.id.eq(userId.longValue()))
                .add(filter.getOrderId(), orderId -> ordersEntity.id.eq(orderId.longValue()))
                .add(filter.getPrice(), ordersEntity.price::eq)
                .add(filter.getStatus(), ordersEntity.status::eq);
        return List.of();
    }
}
