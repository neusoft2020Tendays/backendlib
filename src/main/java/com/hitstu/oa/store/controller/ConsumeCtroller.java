package com.hitstu.oa.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.store.service.IConsumeService;

@RestController
@RequestMapping("/consume")
@CrossOrigin(origins = {"*","null"})
public class ConsumeCtroller {
	@Autowired
	private IConsumeService consumeService = null;
	
	
}
