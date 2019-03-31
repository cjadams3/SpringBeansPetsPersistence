package dmacc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Pet;
import dmacc.repository.PetRepository;

@Controller
public class WebController {
	@Autowired
	PetRepository repo;
	
	@GetMapping("/ViewAll")
	public String viewAllPets(Model model) {
		model.addAttribute("pets", repo.findAll());
		return "list";
	}
	
	@GetMapping("/inputPet")
	public String addNewPet(Model model) {
		Pet p = new Pet();
		model.addAttribute("newPet", p);
		return "input";
	}
	
	@PostMapping("/inputPet")
	public String addNewPet(@ModelAttribute Pet p, Model model) {
		repo.save(p);
		model.addAttribute("pets", repo.findAll());
		return "list";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Pet p = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Pet Id: " + id));
		
		model.addAttribute("pet", p);
		return "update";
		
	}
	
	@PostMapping("/update/{id}")
	public String updatePet(@PathVariable("id") long id, @Valid Pet p, BindingResult result, Model model) {
		if (result.hasErrors()) {
			p.setId(id);
			return "update";
		}
		
		repo.save(p);
		model.addAttribute("pets", repo.findAll());
		return "list";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePet(@PathVariable("id") long id, Model model) {
		Pet p = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Pet Id: " + id));
		
		repo.delete(p);
		model.addAttribute("pets", repo.findAll());
		return "list";
	}
}
