package com.sapient.pc.restapi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.pc.dao.ProductRepository;
import com.sapient.pc.exception.ResourceNotFoundException;
import com.sapient.pc.model.Product;

@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerRest {

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId)
			throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for productId:" + productId));
		// return ResponseEntity.ok().body(product);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Product>(product, headers, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
		Product pr = productRepository.save(product);
		return new ResponseEntity<Product>(pr, HttpStatus.CREATED);
	}

	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product,
			@PathVariable("productId") Long productId) throws ResourceNotFoundException {
		Product pr = productRepository.findById(productId).orElseThrow(
				() -> new ResourceNotFoundException("Product not found while updating for productId:" + productId));
		
		pr.setProductName(product.getProductName());
		pr.setCategory(product.getCategory());
		pr.setColor(product.getColor());
		pr.setPrice(product.getPrice());
		pr.setSize(product.getSize());
		pr.setOffPercent(product.getOffPercent());
		productRepository.save(pr);
		return new ResponseEntity<Product>(pr, HttpStatus.OK);
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity deleteProductById(@PathVariable("productId") Long productId) throws ResourceNotFoundException {
		Product pr = productRepository.findById(productId).orElseThrow(
				() -> new ResourceNotFoundException("Product not found while deleting for productId:" + productId));
		productRepository.deleteById(productId);
		return ResponseEntity.ok().build();
	}

}
