package com.app.testMauriz.models.service;

import java.util.Optional;

import com.app.testMauriz.models.entity.Folder;

public interface FolderService {
	
	public Iterable<Folder> findAll();
	public Optional<Folder> findById(Long id);
	public Folder save (Folder folder);
	public void deleteById(Long id);

}
