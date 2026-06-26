package com.tejait.batch16.dto;

import java.util.List;

import com.tejait.batch16.model.Orders;

import lombok.Data;
@Data
public class OrdersDto {
private int personId;
private List<Orders> ordList;
}
