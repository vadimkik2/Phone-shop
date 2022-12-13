package com.example.shop.service.impl;

import com.example.shop.model.Product;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.ProductService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public void save(Product phone) {
        Optional<Product> phoneFromDb = repository.findPhonesByModel(phone.getModel());
        if (phoneFromDb.isPresent()) {
            Product phone1 = phoneFromDb.get();
            phone1.setQuantity(phoneFromDb.get().getQuantity() + phone.getQuantity());
            repository.save(phone1);
            return;
        }
        repository.save(phone);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
