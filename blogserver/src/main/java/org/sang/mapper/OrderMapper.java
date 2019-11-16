package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.sang.bean.Order;

import java.util.List;
@Mapper
public interface OrderMapper {
    List<Order> getAllOrders();
    int addNewOrder(Order order);
    Order getOrderById(Long orid);
    int updateOrderStateById(@Param("OrderId") Long OrderId, @Param("state") Integer state);
    //int updateOrder(Order order);
    //List<Order> getOrderByState(@Param("state") Integer state, @Param("start") Integer start, @Param("count") Integer count, @Param("uid") Long uid, @Param("keywords") String keywords);
}
