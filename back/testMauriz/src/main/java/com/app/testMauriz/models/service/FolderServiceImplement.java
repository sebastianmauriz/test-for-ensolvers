package com.app.testMauriz.models.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.testMauriz.models.entity.Folder;
import com.app.testMauriz.models.repository.FolderRepository;

@Service
public class FolderServiceImplement implements FolderService {

	@Autowired
	private FolderRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Folder> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Folder> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Folder save(Folder folder) {
		// TODO Auto-generated method stub
		return repository.save(folder);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
