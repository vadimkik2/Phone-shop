package com.example.shop.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Phone> phones;
    private BigDecimal price;
    @Column(name = "time_of_create")
    private LocalDateTime timeOfCreate;
    private Boolean paid;
    private Boolean isDelete;

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public BigDecimal getPrice() {
        return this.phones.stream()
                .map(Phone::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long getId() {
        return id;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public LocalDateTime getTimeOfCreate() {
        return timeOfCreate;
    }

    public void setTimeOfCreate(LocalDateTime timeOfCreate) {
        this.timeOfCreate = timeOfCreate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = false;
    }
}
