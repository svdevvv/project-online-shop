package org.project.repository;

import org.project.entity.OrdersEntity;
import org.springframework.data.repository.Repository;

public interface OrdersRepository extends Repository<OrdersEntity, Long> {

//    public List<OrdersEntity> listOfActiveOrders(OrdersForUser filter) {
//        QPredicate.builder()
//                .add(filter.getUserId(), userId -> ordersEntity.userId.id.eq(userId.longValue()))
//                .add(filter.getOrderId(), orderId -> ordersEntity.id.eq(orderId.longValue()))
//                .add(filter.getPrice(), ordersEntity.price::eq)
//                .add(filter.getStatus(), ordersEntity.status::eq);
//        return List.of();
//    }
}
