package com.cg.go.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.go.dao.ProductDAOInterface;
import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.ProductException;
import com.cg.go.service.ProductService;

@SpringBootTest
public class ProductServiceTest {
	private ProductEntity productMock1;
	private ProductEntity productMock2;
	@Autowired
	private ProductService productService;
	// @MockBean annotation is used to create the mock object to be injected
	@MockBean
	private ProductDAOInterface productDao;

	@Test
	@DisplayName("Test for adding products")
	public void testAddProduct() throws ProductException {
		/*
		 * String productId, String productName, double price, String image, String
		 * color,String category, int quantity, String manufacturer, String
		 * specification
		 */
		// Create a productMock1 object which is to be tested
		productMock1 = new ProductEntity("100", "soap", 20.5, "santoor", "orange", "soaps", 1, "john", "good");
		// mock the behavior of product dao to return the product entity
		when(productDao.save(productMock1)).thenReturn(productMock1);

		ProductEntity result = productService.addProduct(productMock1);
		// test the add product functionality
		assertEquals(result.getProductId(), productMock1.getProductId());
	}

	@Test
	@DisplayName("Test for displaying all products")
	public void testVeiwAllProducts() {
		productMock1 = new ProductEntity("100", "soap", 20.5, "santoor", "orange", "soaps", 1, "john", "good");
		productMock2 = new ProductEntity("500", "soap", 20.5, "santoor", "orange", "soaps", 1, "john", "good");
		when(productDao.findAll()).thenReturn(Stream.of(productMock1, productMock2).collect(Collectors.toList()));
		assertEquals(2, productService.findAllProducts().size());
	}

	@Test
	@DisplayName("Test to display product by given id")
	public void testFindByProductId() {
		productMock1 = new ProductEntity("100", "soap", 20.5, "santoor", "orange", "soaps", 1, "john", "good");
		Optional<ProductEntity> oProduct = Optional.ofNullable(productMock1);
		when(productDao.findById("100")).thenReturn(oProduct);
		assertEquals(productMock1, productService.findByProductId("100"));
	}

	@Test
	@DisplayName("Test to display product by given category")
	public void testFindByProductCategory() {
		productMock1 = new ProductEntity("100", "soap", 20.5, "santoor", "orange", "soaps", 1, "john", "good");
		List<ProductEntity> p = new ArrayList<>();
		p.add(productMock1);

		when(productDao.findByProductCategory("soaps")).thenReturn(p);
		assertEquals(p, productService.findByProductCategory("soaps"));
	}

	@Test
	@DisplayName("Test to update product")
	public void testUpdateProducts() throws ProductException {

		productMock1 = new ProductEntity("100", "soap", 20.5, "santoor", "orange", "soaps", 1, "john", "good");
		when(productDao.findById("100")).thenReturn(Optional.of(productMock1));
		assertEquals(productMock1, productService.findByProductId("100"));
	}

	@Test
	@DisplayName("Test to display product by given keyword")
	public void testSearchProducts() {

		productMock1 = new ProductEntity("100", "soap", 20.5, "santoor", "orange", "soaps", 1, "john", "good");
		List<ProductEntity> p = new ArrayList<>();
		p.add(productMock1);
		when(productDao.search("john")).thenReturn(p);
		assertEquals(p, productService.search("john"));
	}

	@Test
	@DisplayName("Test to filter products by given max price")
	public void testFilterProducts() {

		productMock1 = new ProductEntity("100", "soap", 20.5, "santoor", "orange", "soaps", 1, "john", "good");
		List<ProductEntity> p = new ArrayList<>();
		p.add(productMock1);
		when(productDao.filter(25)).thenReturn(p);
		assertEquals(p, productService.filter(25));
	}

	@Test
	public void testAddUserProductForDuplicateProductException() {
		productMock1 = new ProductEntity("500", "soap", 20.5, "santoor", "orange", "soaps", 1, "john", "good");
		when(productDao.save(productMock1)).thenThrow(new ProductException("No Such Product Found"));
		assertThrows(ProductException.class, () -> productService.addProduct(productMock1));
	}

	@Test
	public void testVeiwAllProductsForNoSuchProductException() {
		when(productDao.findAll()).thenThrow(new ProductException("No Product Found"));
		assertThrows(ProductException.class, () -> productService.findAllProducts());
	}

	@Test
	public void testNotFoundByProductId() {
		productMock1 = new ProductEntity("500", "soap", 20.5, "santoor", "orange", "soaps", 1, "john", "good");
		when(productDao.findById("500")).thenThrow(new ProductException("No Such Product Found"));
		assertThrows(ProductException.class, () -> productService.findByProductId("500"));
	}

	@Test
	public void testNotFoundByProductCategory() {
		productMock1 = new ProductEntity("500", "soap", 20.5, "santoor", "orange", "soaps", 1, "john", "good");
		when(productDao.findByProductCategory("laptop")).thenThrow(new ProductException("No Such Product Found"));
		assertThrows(ProductException.class, () -> productService.findByProductCategory("laptop"));
	}

}
