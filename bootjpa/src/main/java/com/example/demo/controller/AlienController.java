package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;

	/*
	 * @RequestMapping("/home") public String home() { return "home.jsp"; }
	 */

	/*
	 * @RequestMapping("/addAlien") public String addAlien(Alien alien) {
	 * repo.save(alien); return "home.jsp"; }
	 * 
	 * @RequestMapping("/getAlien")
	 * 
	 * public ModelAndView getAlien(@RequestParam int aid) {
	 * 
	 * 
	 * 
	 * ModelAndView mv = new ModelAndView("showAlien.jsp"); Alien alien =
	 * repo.findById(aid).orElse(new Alien());
	 * 
	 * mv.addObject(alien);
	 * 
	 * System.out.println(repo.findByTech("java"));
	 * System.out.println(repo.findByAidGreaterThan(102));
	 * 
	 * System.out.println(repo.findByTechSorted("java")); return mv;
	 * 
	 * }
	 * 
	 * @RequestMapping("/aliens")
	 * 
	 * @ResponseBody public String getAllAliens() {
	 * 
	 * return repo.findAll().toString(); }
	 * 
	 * @RequestMapping("/alien/{aid}")
	 * 
	 * @ResponseBody public String getAllAlienById(@PathVariable("aid") int aid) {
	 * 
	 * return repo.findById(aid).toString(); }
	 */

	/*
	 * @RequestMapping("/addAlien") public String addAlien(Alien alien) {
	 * repo.save(alien); return "home.jsp"; }
	 */

	/*
	 * @RequestMapping("/getAlien")
	 * 
	 * public ModelAndView getAlien(@RequestParam int aid) {
	 * 
	 * ModelAndView mv = new ModelAndView("showAlien.jsp"); Alien alien =
	 * repo.findById(aid).orElse(new Alien());
	 * 
	 * mv.addObject(alien);
	 */
		/*
		 * System.out.println(repo.findByTech("java"));
		 * System.out.println(repo.findByAidGreaterThan(102));
		 */
		/*
		 * System.out.println(repo.findByTechSorted("java")); return mv;
		 */

	/*
		*/
	@RequestMapping(path="/aliens")
	@ResponseBody
	public List<Alien> getAllAliens() {

		return repo.findAll();
	}

	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAllAlienById(@PathVariable("aid") int aid) {

		return repo.findById(aid);
	}
	
	
	@PostMapping("/addAlien")
	@ResponseBody
	public Alien addAlien(@RequestBody Alien alien)
	{
		return repo.save(alien);
		
	}
	
	@DeleteMapping("alien/{aid}")
	public Optional<Alien> deleteAlien(@PathVariable("aid") int aid)
	{
	   Optional<Alien> alien = repo.findById(aid);
	   repo.deleteById(aid);
	   return alien; 	
	}
	
	@PutMapping("alien/{aid}")
	public String updateAlien(@RequestBody Alien alien)
	{
		/* alien = repo.findById(aid).orElse(new Alien()); */
		repo.save(alien);
		return "Updated";
	   	
	}
}
