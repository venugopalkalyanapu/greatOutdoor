package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.OrderEntity;
import com.cg.go.exception.OrderException;


public interface IOrderServiceInterface {

	public OrderEntity addOrder(OrderEntity oe) throws OrderException;

	public List<OrderEntity> findAllOrders();

	public String deleteAllOrders() throws OrderException;

	public String updateDate(OrderEntity o) throws OrderException;

	public String deleteOrderById(OrderEntity k) throws OrderException;


	public OrderEntity findOrderByUId(OrderEntity o);

}
