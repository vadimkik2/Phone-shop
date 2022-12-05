package com.example.shop.service;

import com.example.shop.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhoneService {
    void save(Phone phone);

    Page<Phone> getAll(Pageable pageable);
}
