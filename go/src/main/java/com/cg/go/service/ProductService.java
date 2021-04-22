package com.cg.go.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.dao.ProductDAOInterface;
import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.ProductException;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductDAOInterface productDao;

	@Override
	public ProductEntity addProduct(ProductEntity productEntity) throws ProductException {
		String id = productEntity.getProductId();
		if (productDao.existsById(id))
			throw new ProductException("Product not found");
		// handler method to save a product
		return productDao.save(productEntity);
	}

	@Override
	public ProductEntity findByProductId(String s) {
		Optional<ProductEntity> o = productDao.findById(s);
		// handler method to get a product
		ProductEntity e = o.get();
		return e;

	}

	@Override
	public void deleteByProductId(String s) throws ProductException {
		Optional<ProductEntity> optional = productDao.findById(s);
		if (!optional.isPresent())
			throw new ProductException("Product details not found for id " + s);
		else {
			ProductEntity product = optional.get();
			// handler method to delete a product
			productDao.delete(product);
			
		}
	}

	@Override
	public List<ProductEntity> findByProductCategory(String productCategory) {
		// handler method to find a product by given category
		return productDao.findByProductCategory(productCategory);
	}

	@Override
	public List<ProductEntity> findAllProducts() {
		List<ProductEntity> ll = new ArrayList<ProductEntity>();
		// handler method to find all products
		productDao.findAll().forEach(l1 -> ll.add(l1));
		return ll;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity productEntity) throws ProductException {
		String id = productEntity.getProductId();
		if (productDao.existsById(id))
			// handler method to update a product
			return productDao.save(productEntity);
		else
			throw new ProductException("Product not found");
	}

	@Override
	public void updateProductQuantity(int quantity, String productId) {
		Optional<ProductEntity> o = productDao.findById(productId);
		ProductEntity e = o.get();
		e.setQuantity(quantity);
		productDao.save(e);
	}

	public List<ProductEntity> search(String keyword) {
		if (keyword != null) {
			// handler method to search a product with given keyword
			return productDao.search(keyword);
		}
		return productDao.findAll();
	}

	@Override
	public List<ProductEntity> filter(double maxPrice) {
		// handler method to filter products by maximum price 
		return productDao.filter(maxPrice);
	}

}
