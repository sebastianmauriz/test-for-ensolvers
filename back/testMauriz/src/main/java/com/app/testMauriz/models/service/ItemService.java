package com.app.testMauriz.models.service;

import java.util.Optional;

import com.app.testMauriz.models.entity.Item;

public interface ItemService {
	public Iterable<Item> findAll();
	public Optional<Item> findById(Long id);
	public Item save (Item item);
	public void deleteById(Long id);

}
