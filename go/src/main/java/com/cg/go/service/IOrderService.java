package com.cg.go.service;

import java.util.List;
import java.util.Optional;

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


	//Add Order
	@Override
	public OrderEntity addOrder(OrderEntity oe) throws OrderException 
	{
		if(oe==null) {
			throw new OrderException("No Products Found");
		}
		OrderEntity o=iod.save(oe);
		return o;
	}


	//Find all Orders
	@Override
	public List<OrderEntity> findAllOrders()  {
		return iod.findAll();
	}


	//Delete Orders
	@Override
	public String deleteAllOrders() throws OrderException{
		if(iod.findAll().isEmpty()){
			throw new OrderException("There are no orders to delete");
		}
		iod.deleteAll();
		return "all orders deleted successfuly";
	}


	//Update Date of Orders
	@Override
	public String updateDate(OrderEntity o) throws OrderException 
	{
		String k=o.getOrderId();
		if(iod.existsById(k)) {
			throw new OrderException("There is no such order id to update");
		}
		iod.save(o);
		return "order was updated";
	}


	//Delete Orders By Id
	@Override
	public String deleteOrderById(OrderEntity k) throws OrderException
	{
		String g=k.getOrderId();
		if(iod.existsById(g)) {
			iod.deleteById(g);
			return "delete succesful";
		}
		else 
		{
			throw new OrderException("Order Id is Not found");
		}
	}



	@Override
	public OrderEntity findOrderByUId(OrderEntity o) {
		String k=o.getOrderId();
		Optional<OrderEntity> p= iod.findById(k);
	    OrderEntity g=p.get();
		return g;
	}

}
