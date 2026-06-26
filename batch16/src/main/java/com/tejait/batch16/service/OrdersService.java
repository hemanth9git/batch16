package com.tejait.batch16.service;

import java.util.List;

import com.tejait.batch16.dto.OrdersDto;
import com.tejait.batch16.model.Orders;

public interface OrdersService {

	List<Orders> saveOrders(OrdersDto dto);

}
