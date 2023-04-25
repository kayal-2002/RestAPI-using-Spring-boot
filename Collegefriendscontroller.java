package com.making.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.making.demo.entity.CollegeFriends;
import com.making.demo.service.CollegeService;

import ch.qos.logback.core.model.Model;

@Controller
public class Collegefriendscontroller {
	private CollegeService clgservice;

	public Collegefriendscontroller(CollegeService clgservice) {
		super();
		this.clgservice = clgservice;
	} 
	@RequestMapping("/login")
	public ModelAndView login() { 
		ModelAndView mv=new ModelAndView("login.html"); 
		return mv;
	}
	@RequestMapping("/home")
	public ModelAndView home() { 
		ModelAndView mv=new ModelAndView("home.html");
		return mv;
	}
	//handler method to handle list students and return model and view
	@RequestMapping("/list") 
	public ModelAndView listall() {
		  ModelAndView mv=new ModelAndView("list.html");
		  mv.addObject("friends",clgservice.getall());
		
		return mv ;
		
	}
	@RequestMapping("/startlogin")
	public String loginstart(@RequestParam("email") String email) { 
		//if(clgservice.findByEmail(email)==null) 
			//throw new RuntimeException("No user exists");
		//else {
			return "redirect:/list";
		
		
	}
	@GetMapping("/friends/new")
	public ModelAndView createfriends() { 
		//create student object to hold student form data
		CollegeFriends clg=new CollegeFriends();
		ModelAndView mv=new ModelAndView("createfriends.html");
		mv.addObject("friends",clg);
		return mv;
	}
	@PostMapping("/friends")
	public String savefriends(@ModelAttribute("friends") CollegeFriends friend) {
		clgservice.save(friend);
		return "redirect:/list";
		
}
	@RequestMapping("/friend/edit/{id}")
	public ModelAndView editfriend(@PathVariable Long id) { 
		ModelAndView mv=new ModelAndView("update.html");
		CollegeFriends clg=new CollegeFriends();
	
		mv.addObject("friends",clg);
		mv.addObject("friend",clgservice.getFriendById(id)); 
		return mv;
		
	}
	//get friend from database by id
	@PostMapping("/friends/{id}")
	public String updatefriend(@PathVariable Long id,@ModelAttribute("friends") CollegeFriends clg) {
		CollegeFriends clg1=clgservice.getFriendById(id); 
		clg1.setId(id); 
		clg1.setFirstname(clg.getFirstname());
		clg1.setLastname(clg.getLastname()); 
		clg1.setEmail(clg.getEmail());
		clgservice.update(clg1);
		 
		return "redirect:/list";
		
	}
	//handler to delete friend
	@GetMapping("/friend/delete/{id}")
	public String delete(@PathVariable Long id) {
		clgservice.delete(id);
		return "redirect:/list";
	}

}
