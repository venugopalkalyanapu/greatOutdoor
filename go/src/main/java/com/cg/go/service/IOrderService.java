package com.cg.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.dao.IOrderDaoInterface;
import com.cg.go.entity.OrderEntity;
import com.cg.go.exception.OrderException;
@Service
public class IOrderService implements IOrderServiceInterface
{
	@Autowired
	private IOrderDaoInterface iod;

	@Override
	public OrderEntity addOrder(OrderEntity oe) throws OrderException 
	{
		if(oe.getProducts().isEmpty()) 
		{
			throw new OrderException("No Products Found");
		}
		OrderEntity o=iod.save(oe);
		return o;
	}

	@Override
	public List<OrderEntity> findAllOrders()  {
		return iod.findAll();
	}

	@Override
	public String deleteAllOrders() throws OrderException{
		if(iod.findAll().isEmpty())
		{
			throw new OrderException("There are no orders to delete");
		}
		iod.deleteAll();
		return "all orders deleted successfuly";
	}

	@Override
	public String updateDate(OrderEntity o) throws OrderException 
	{
		String k=o.getOrderId();
		if(iod.existsById(k)) 
		{
			throw new OrderException("There is no such order id to update");
		}
		iod.save(o);
		return "order was updated";
	}

	@Override
	public String deleteOrderById(OrderEntity k) throws OrderException
	{
		String g=k.getOrderId();
		if(iod.existsById(g)) 
		{
			iod.deleteById(g);
			return "delete succesful";
		}
		else 
		{
			throw new OrderException("Order Id is Not found");
		}
	}



	/*@Override
	public List<OrderEntity> findOrderByUId(OrderEntity o) {
		String k=o.getUserId();
		List<OrderEntity> p= iod.findOrderByUId(k);
		return p;
	}*/

}
