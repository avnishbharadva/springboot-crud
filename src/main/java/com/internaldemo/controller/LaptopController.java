package com.internaldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internaldemo.entities.Laptop;
import com.internaldemo.repository.LaptopRepo;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

	@Autowired
	private LaptopRepo laptopRepo;
	
	@PostMapping("/addlaptop")
	public Laptop addLaptop(@RequestBody Laptop laptop)
	{
		Laptop lp = laptopRepo.save(laptop);
		return lp;
	}
	
	@GetMapping("/alllaptops")
	public List<Laptop> showLaptops()
	{
		List<Laptop> laptops = (List<Laptop>) laptopRepo.findAll();
		return laptops;
	}
	
	@DeleteMapping("/deletelaptop/{lid}")
	public String deleteLaptop(@PathVariable int lid)
	{
		Laptop lp = laptopRepo.findById(lid).get();
		if(lp!=null)
		{
			laptopRepo.delete(lp);
			return lid + " id laptop deleted";
		}
		else
		{
			return lid + " id laptop is not available";
		}
	}
	
	@PutMapping("updatelaptop/{lid}")
	public Laptop updateStudent(@PathVariable int lid,@RequestBody Laptop lt)
	{
		Laptop l = laptopRepo.findById(lid).get();
		l.setBrand(lt.getBrand());
		l.setOs(lt.getOs());
		laptopRepo.save(l);
		return l;
	}
}
