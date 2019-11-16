package org.sang.controller.bussiness;


import org.sang.bean.RespBean;
import org.sang.bean.Order;
import org.sang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/{orid}", method = RequestMethod.GET)
    public Order getOrderById(@PathVariable Long orid) {
        return orderService.getOrderById(orid);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Map<String, Object> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        Map<String, Object> map = new HashMap<>();
        map.put("orders", orders);
        return map;
    }

    @RequestMapping(value = "/add_one", method = RequestMethod.POST)
    public RespBean addNeworder(Order order) {
        int result = orderService.addNewOrder(order);
        if (result == 1) {
            return new RespBean("success", order.getId() + order.toString());
        } else {
            return new RespBean("error",  "订单增加失败!");
        }
    }
}
