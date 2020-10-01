package com.example.stockmanager;

import org.springframework.data.repository.CrudRepository;

import com.example.stockmanager.Stock;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StockRepository extends CrudRepository<Stock, String> {

}
