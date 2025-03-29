package org.project.repository;

import jakarta.persistence.EntityManager;
import org.project.dto.OrdersForUser;
import org.project.entity.OrdersEntity;
import org.project.utils.QPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.project.entity.QOrdersEntity.ordersEntity;

@Repository
public class OrdersRepository extends RepositoryBase<Long, OrdersEntity> {

    @Autowired
    public OrdersRepository(EntityManager entityManager) {
        super(OrdersEntity.class, entityManager);
    }

    public List<OrdersEntity> listOfActiveOrders(OrdersForUser filter) {
        QPredicate.builder()
                .add(filter.getUserId(), userId -> ordersEntity.userId.id.eq(userId.longValue()))
                .add(filter.getOrderId(), orderId -> ordersEntity.id.eq(orderId.longValue()))
                .add(filter.getPrice(), ordersEntity.price::eq)
                .add(filter.getStatus(), ordersEntity.status::eq);
        return List.of();
    }
}
