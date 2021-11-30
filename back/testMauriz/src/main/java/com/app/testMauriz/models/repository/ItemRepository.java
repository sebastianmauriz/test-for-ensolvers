package com.app.testMauriz.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.testMauriz.models.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
