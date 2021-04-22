package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.ProductException;

public interface IProductService {

	ProductEntity addProduct(ProductEntity pe) throws ProductException;

	ProductEntity findByProductId(String s);

	List<ProductEntity> findByProductCategory(String productCategory);

	List<ProductEntity> findAllProducts();

	ProductEntity updateProduct(ProductEntity productEntity) throws ProductException;

	void updateProductQuantity(int quantity, String productId);

	void deleteByProductId(String s) throws ProductException;

	List<ProductEntity> search(String keyword);

	List<ProductEntity> filter(double maxPrice);
}
