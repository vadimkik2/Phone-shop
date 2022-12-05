package com.example.shop.service.impl;

import com.example.shop.model.Phone;
import com.example.shop.repository.PhoneRepository;
import com.example.shop.service.PhoneService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository repository;

    @Override
    public void save(Phone phone) {
            Optional<Phone> phoneFromDb = repository.findPhonesByModel(phone.getModel());
            if(phoneFromDb.isPresent()) {
                Phone phone1 = phoneFromDb.get();
                phone1.setQuantity(phoneFromDb.get().getQuantity() + phone.getQuantity());
                repository.save(phone1);
                return;
            }
            repository.save(phone);
    }
    @Override
    public Page<Phone> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
