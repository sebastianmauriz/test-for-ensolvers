package com.app.testMauriz.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.testMauriz.models.entity.Folder;

public interface FolderRepository extends CrudRepository<Folder, Long> {

}
