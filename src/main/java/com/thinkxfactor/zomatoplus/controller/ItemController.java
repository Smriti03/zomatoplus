package com.thinkxfactor.zomatoplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.Item;

import com.thinkxfactor.zomatoplus.repository.ItemRepository;



@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	
	@PostMapping("/add")
	public Item additem(@RequestBody Item item) {
		Item persisteditem=itemRepository.save(item);
		return persisteditem;
	}
	
	@GetMapping("/getAll")
	public List<Item> getAll(){
		List<Item> listofitem=itemRepository.findAll();
		return listofitem;
		}
}