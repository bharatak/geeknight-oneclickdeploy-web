package com.geeknight.controller;

import com.geeknight.model.Greet;
import com.geeknight.repository.GreetRepository;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class HelloController {

	@Autowired
	private GreetRepository greetRepository;

	@RequestMapping(value = "/greet", method = RequestMethod.POST)
	@ResponseBody
	public List<String> showAllGreets(@RequestParam(value = "name", required = true) String greeting){
		greetRepository.save(new Greet(greeting));

		List<String> greets = new ArrayList<String>();
		Iterator<Greet> allGreets = greetRepository.findAll().iterator();

		while(allGreets.hasNext()){
			greets.add(allGreets.next().getName());
		}
		return greets;
	}

}
