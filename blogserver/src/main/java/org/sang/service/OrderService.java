package org.sang.service;

import org.sang.mapper.OrderMapper;
import org.sang.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
@Service
@Transactional
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public List<Order> getAllOrders(){
        return  orderMapper.getAllOrders();
    }

    public int addNewOrder(Order order){
        if(Integer.parseInt(order.getOrderState() ) != 1) return -1;
        if(order.getBeginTime() == null){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            order.setBeginTime(timestamp);
        }
        int res = orderMapper.addNewOrder(order);
        return res;
    }
    public Order getOrderById(Long orid){
        Order order = orderMapper.getOrderById(orid);

        return  order;
    }
    int checkOrder( long OrderId ) {
        int res=0;
        Order order = orderMapper.getOrderById(OrderId);
        if (Integer.parseInt(order.getOrderState()) == 1) {
           res = orderMapper.updateOrderStateById(OrderId, 3);
        }
        return  res;
    }

}
