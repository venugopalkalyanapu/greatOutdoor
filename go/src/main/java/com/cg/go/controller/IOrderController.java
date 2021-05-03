package com.cg.go.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.entity.OrderEntity;
import com.cg.go.exception.OrderException;
import com.cg.go.service.IOrderServiceInterface;


@RestController
public class IOrderController {
	@Autowired
	private IOrderServiceInterface ios;


    //Add Order
	@PostMapping("addOrder")
	public OrderEntity addOrder(@RequestBody OrderEntity oe) throws OrderException{
		OrderEntity o=ios.addOrder(oe);
		return o;
	}

	//Find All Orders
	@GetMapping("findAllOrders")
	public List<OrderEntity> findAllOrders(){
		return ios.findAllOrders();

	}


    //Delete All Orders
	@DeleteMapping("deleteAllOrders")
	public String deleteAllOrders() throws OrderException {
		return ios.deleteAllOrders();
	}


	
	//Delete Order By Using Order Id
	@DeleteMapping("deleteOrderById/{oid}")
	public String deleteOrderById(@PathVariable("oid") String o)throws OrderException{
		OrderEntity k=new OrderEntity();
		k.setOrderId(o);
		return ios.deleteOrderById(k);
	}
	
	

	
	//Update Date using Order Id
	@PutMapping("updateDate/{oid}/{diD}/{deD}")
	public String updateDate(@PathVariable(name="oid") String s,@PathVariable(name="diD") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate k,
			@PathVariable(name="deD") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate g ) throws OrderException {
		OrderEntity o=new  OrderEntity();
		o.setDispatchDate(k);
		o.setDeliveryDate(g);
		o.setOrderId(s);
		return ios.updateDate(o);

	}
	
	
	@GetMapping("findOrderByUId/{oid}")
    public OrderEntity findOrderByUId(@PathVariable ("oid") String s){
	OrderEntity o=new OrderEntity();
	o.setOrderId(s);
	return ios.findOrderByUId(o);
    }

}
