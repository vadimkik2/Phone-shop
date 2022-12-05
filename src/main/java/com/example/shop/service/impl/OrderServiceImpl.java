package com.example.shop.service.impl;

import com.example.shop.dto.external.OrderResponseDto;
import com.example.shop.dto.mapper.OrderMapper;
import com.example.shop.model.Order;
import com.example.shop.model.Phone;
import com.example.shop.repository.OrderRepository;
import com.example.shop.repository.PhoneRepository;
import com.example.shop.service.OrderService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final PhoneRepository phoneRepository;
    private final OrderMapper orderMapper;


    @Override
    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public OrderResponseDto save(Order order) {
        List<Phone> phones = order.getPhones();
        for (Phone phone : phones) {
            Phone phoneFromDb = phoneRepository.findPhonesByModel(phone.getModel()).orElseThrow(
                    () -> new RuntimeException("Can't find phone by id " + phone.getId()));
            if (phoneFromDb.getQuantity() < phone.getQuantity()) {
                throw new RuntimeException("We don't have enough phone in stock!");
            } else if (phoneFromDb.getQuantity() >= phone.getQuantity()) {
                phoneFromDb.setQuantity(phoneFromDb.getQuantity() - phone.getQuantity());
                phoneRepository.save(phoneFromDb);
            }
        }
        order.setTimeOfCreate(LocalDateTime.now());
        OrderResponseDto orderResponseDto = orderMapper.mapToDto(order);
        repository.save(order);
        return orderResponseDto;
    }

    @Scheduled(cron = "0 0/5 * * * *")
    private void deleteUnpaidOrder(){
        List<Order> allUnpaidOrders = repository.findAllUnpaidOrders();
        repository.saveAll(allUnpaidOrders.stream()
                .filter(order -> order.getTimeOfCreate().isBefore(LocalDateTime.now().minusMinutes(10L)))
                .peek(order -> order.setDelete(true))
                .collect(Collectors.toList()));
    }
}
