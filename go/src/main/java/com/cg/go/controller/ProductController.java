package com.cg.go.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class ProductController {
	@Autowired
	private IProductService productService;

	// This method add products
	@PostMapping("/products")
	public ProductEntity addProduct(@RequestBody ProductEntity pe) throws ProductException {
		return productService.addProduct(pe);
	}
//deleteproductbyid
	@DeleteMapping("/products/{id}")
	public void deleteByProductId(@PathVariable("id") int s) throws ProductException {
		productService.deleteByProductId(s);

	}
//findbypruductcategory
	@GetMapping("/product/{category}")
	public List<ProductEntity> findByProductByCategory(@PathVariable("category") String s) {

		List<ProductEntity> p = productService.findByProductCategory(s);
		return p;
	}
//find by product id
	@GetMapping("products/{id}")
	public ProductEntity findByProductId(@PathVariable("id") int s) {

		ProductEntity p = productService.findByProductId(s);
		return p;
	}
//find all products
	@GetMapping("products")
	public List<ProductEntity> findAllProducts() {
		List<ProductEntity> pe = new ArrayList<ProductEntity>();
		pe = productService.findAllProducts();
		return pe;
	}
//update productby id
	@PutMapping("products/{id}")
	public ProductEntity updateProduct(@PathVariable("id") int ss, @RequestBody ProductEntity productEntity)
			throws ProductException {
		ProductEntity p = productService.updateProduct(productEntity);
		return p;
	}
//update product quantity by id
	@PutMapping("products/{quan},{id}")
	public void updateProductQuantity(@PathVariable("quan") int i, @PathVariable("id") int s2) {
		productService.updateProductQuantity(i, s2);
	}
//search products/by keyword
	@GetMapping("products/{keyword}")
	public List<ProductEntity> search(@PathVariable("keyword") String keyword) {
		return productService.search(keyword);
	}
//filter by max price
	@GetMapping("products/{maxprice}")
	public List<ProductEntity> filter(@PathVariable("maxprice") double maxPrice) {
		return productService.filter(maxPrice);
	}

}
