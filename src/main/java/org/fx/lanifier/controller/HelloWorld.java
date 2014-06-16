package org.fx.lanifier.controller;

import java.util.List;

import org.fx.lanifier.entites.dao.UtilisateurDAO;
import org.fx.lanifier.entites.utilisateur.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/helloworld/")
public class HelloWorld {

	@Autowired
	UtilisateurDAO utilisateurDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld(ModelMap model) {
		model.addAttribute("message", "hello world");
		return "hello";
	}

	@RequestMapping("{nom}")
	public String helloToi(ModelMap model, @PathVariable("nom") String nom) {
		model.addAttribute("message", "Bonjour " + nom);
		List<Utilisateur> u = this.utilisateurDAO.getTousUtilisateurs();
		model.addAttribute("user", u.get(0));
		return "hello";
	}
}
