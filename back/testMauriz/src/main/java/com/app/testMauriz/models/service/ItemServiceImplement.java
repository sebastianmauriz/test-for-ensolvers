package com.app.testMauriz.models.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import com.app.testMauriz.models.entity.Item;
import com.app.testMauriz.models.repository.ItemRepository;

public class ItemServiceImplement implements ItemService {

	@Autowired
	private ItemRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Item> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Item> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Item save(Item item) {
		// TODO Auto-generated method stub
		return repository.save(item);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
