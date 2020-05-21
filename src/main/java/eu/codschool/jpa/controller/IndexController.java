package eu.codschool.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @GetMapping(value={"/", "/index"})
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Hello and welcome to our application");
        return "index";
    }

    @RequestMapping(value = "/jsontohtml", method = RequestMethod.GET)
    public String getMoviesFromJson(ModelMap model){
        return "JpaRepoExampleClientPage";
    }
}
