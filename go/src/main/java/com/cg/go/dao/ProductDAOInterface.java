package com.cg.go.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.go.entity.ProductEntity;

@Repository
public interface ProductDAOInterface extends JpaRepository<ProductEntity, Integer> {
	@Query("Select t from ProductEntity t where t.category=?1")
	public List<ProductEntity> findByProductCategory(String productCategory);

	@Query("SELECT p FROM ProductEntity p WHERE CONCAT(p.productId,' ',p.productName,' ',p.price,' ',p.image,' ',p.color,' ',p.category,' ',p.quantity,' ',p.manufacturer,' ',p.specification)LIKE %?1%")
	public List<ProductEntity> search(String keyword);

	@Query("Select t from ProductEntity t where t.price<=?1")
	public List<ProductEntity> filter(double maxPrice);

}
