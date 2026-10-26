package com.example.crud;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repository;
    public ProductController(ProductRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Product> all() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Product one(@PathVariable Long id) { return find(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product input) {
        validate(input);
        return repository.save(new Product(input.getName().trim(), input.getPrice()));
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product input) {
        validate(input);
        Product product = find(id);
        product.setName(input.getName().trim());
        product.setPrice(input.getPrice());
        return repository.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { repository.delete(find(id)); }

    private Product find(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }
    private void validate(Product p) {
        if (p.getName() == null || p.getName().isBlank() || p.getPrice() == null || p.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter a product name and a non-negative price");
        }
    }
}
