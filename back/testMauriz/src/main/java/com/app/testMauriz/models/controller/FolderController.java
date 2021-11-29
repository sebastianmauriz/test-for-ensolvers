package com.app.testMauriz.models.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.testMauriz.models.entity.Folder;
import com.app.testMauriz.models.service.FolderService;

@RestController
public class FolderController {

	@Autowired
	private FolderService service; 
	
	@GetMapping
	public ResponseEntity<?> list(){
		return ResponseEntity.ok().body(service.findAll());
			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>view(@PathVariable Long id){
		Optional<Folder> o = service.findById(id);
		if(o.isEmpty()) {
		return	ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> save (@RequestBody Folder folder){
		Folder folderDb = service.save(folder);
		return ResponseEntity.status(HttpStatus.CREATED).body(folderDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit (@RequestBody Folder folder, @PathVariable Long id){
		Optional<Folder> o = service.findById(id);
		if(o.isEmpty()) {
		return ResponseEntity.notFound().build();
		}
		
		Folder folderDb = o.get();
		folderDb.setName(folder.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(folderDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	



}



