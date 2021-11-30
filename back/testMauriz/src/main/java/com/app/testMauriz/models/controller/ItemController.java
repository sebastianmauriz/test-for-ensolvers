package com.app.testMauriz.models.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.testMauriz.models.entity.Item;
import com.app.testMauriz.models.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "app/item")
public class ItemController {

	@Autowired
	private ItemService service; 
	
	@GetMapping
	public ResponseEntity<?> list(){
		return ResponseEntity.ok().body(service.findAll());
			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>view(@PathVariable Long id){
		Optional<Item> o = service.findById(id);
		if(o.isEmpty()) {
		return	ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> save (@RequestBody Item item){
		Item itemDb = service.save(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit (@RequestBody Item item, @PathVariable Long id){
		Optional<Item> o = service.findById(id);
		if(o.isEmpty()) {
		return ResponseEntity.notFound().build();
		}
		
		Item itemDb = o.get();
		itemDb.setName(item.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(itemDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
