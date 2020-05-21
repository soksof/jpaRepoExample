package eu.codschool.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import eu.codschool.jpa.entity.Director;
import eu.codschool.jpa.service.DirectorService;

@Controller
public class DirectorController {
	private final DirectorService directorService;

	public DirectorController(DirectorService directorService) {
		this.directorService = directorService;
	}

	@RequestMapping(value = "/director/view", method = RequestMethod.GET)
	public ModelAndView viewPerson(@ModelAttribute("director") Director d) {
		return new ModelAndView("director/view", "director", d);
	}

	@RequestMapping("/director/{id}")
	public String directorProfile(@PathVariable int id, Model model) {
		model.addAttribute("d", directorService.getDirectorById(id));
		return "fragments/directorInfo";
	}

	@RequestMapping(value = "/director/list", method = RequestMethod.GET)
	public String getDirectorList(Model model) {
		List<Director> directors = directorService.findAll();
		model.addAttribute("directors", directors);
		return "fragments/directors";
	}

	@GetMapping("/director/new")
	public String newDirector(Model model) {
		model.addAttribute("directorNew", new Director());
		return "fragments/directorNew";
	}

	@PostMapping("/director/new")
	public String saveNewDirector(@ModelAttribute("directorNew") Director d, BindingResult result, Model model){
		System.out.println("I will add to the repo the new director "+d.getName());
		directorService.save(d);
		return "redirect:/index";
	}

	@RequestMapping(value = "/director", method = RequestMethod.POST)
	public String addDirector(@ModelAttribute("director") Director d, BindingResult result, ModelMap model) {
		if (d.getName().trim().length() == 0) {
			result.rejectValue("name", "empty", "The director name cannot be empty!");
		}

		if (result.hasErrors()) {
			return "error/director";
		}
		directorService.save(d);
		model.addAttribute("message", "Director saved successfuly");
		model.addAttribute("director", d);
		return "director/view";
	}
}
