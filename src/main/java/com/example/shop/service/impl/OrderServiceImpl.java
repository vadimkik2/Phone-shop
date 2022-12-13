package com.example.shop.service.impl;

import com.example.shop.dto.mapper.OrderMapper;
import com.example.shop.dto.response.OrderResponseDto;
import com.example.shop.model.Order;
import com.example.shop.model.Product;
import com.example.shop.repository.OrderRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.OrderService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final ProductRepository phoneRepository;
    private final OrderMapper orderMapper;

    @Override
    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public OrderResponseDto save(Order order) {
        List<Product> phones = order.getPhones();
        for (Product phone : phones) {
            Product phoneFromDb = phoneRepository.findPhonesByModel(phone.getModel()).orElseThrow(
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

    @Scheduled(cron = "0 */1 * * * *")
    private void deleteUnpaidOrder() {
        List<Order> allUnpaidOrders = repository.findAllUnpaidOrders();
        repository.saveAll(allUnpaidOrders.stream()
                .filter(order -> order.getTimeOfCreate()
                .isBefore(LocalDateTime.now().minusMinutes(10L)))
                .peek(order -> order.setDelete(true))
                .collect(Collectors.toList()));
    }
}
