package com.cg.go.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.ProductException;
import com.cg.go.service.IProductService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
	@Autowired
	private IProductService productService;

	// This method add products
	@PostMapping("addproduct")
	public ProductEntity addProduct(@RequestBody ProductEntity pe) throws ProductException {
		return productService.addProduct(pe);
	}
//deleteproductbyid
	@DeleteMapping("deletebyproductid/{id}")
	public void deleteByProductId(@PathVariable("id") int s) throws ProductException {
		productService.deleteByProductId(s);

	}
//findbypruductcategory
	@GetMapping("findbyproductcategory/{category}")
	public List<ProductEntity> findByProductByCategory(@PathVariable("category") String s) {

		List<ProductEntity> p = productService.findByProductCategory(s);
		return p;
	}
//find by product id
	@GetMapping("findbyproductid/{id}")
	public ProductEntity findByProductId(@PathVariable("id") int s) {

		ProductEntity p = productService.findByProductId(s);
		return p;
	}
//find all products
	@GetMapping("findallproducts")
	public List<ProductEntity> findAllProducts() {
		List<ProductEntity> pe = new ArrayList<ProductEntity>();
		pe = productService.findAllProducts();
		return pe;
	}
//update productby id
	@PutMapping("updateproduct/{id}")
	public ProductEntity updateProduct(@PathVariable("id") int ss, @RequestBody ProductEntity productEntity)
			throws ProductException {
		ProductEntity p = productService.updateProduct(productEntity);
		return p;
	}
//update product quantity by id
	@PutMapping("updateproductbyquantity/{quan},{id}")
	public void updateProductQuantity(@PathVariable("quan") int i, @PathVariable("id") int s2) {
		productService.updateProductQuantity(i, s2);
	}
//search products/by keyword
	@GetMapping("search/{keyword}")
	public List<ProductEntity> search(@PathVariable("keyword") String keyword) {
		return productService.search(keyword);
	}
//filter by max price
	@GetMapping("filter/{maxprice}")
	public List<ProductEntity> filter(@PathVariable("maxprice") double maxPrice) {
		return productService.filter(maxPrice);
	}

}
