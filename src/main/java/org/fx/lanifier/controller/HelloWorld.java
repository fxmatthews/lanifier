package org.fx.lanifier.controller;

import java.util.List;
import java.util.Properties;

import org.fx.lanifier.entites.dao.UtilisateurDAO;
import org.fx.lanifier.entites.settings.ManagementProperty;
import org.fx.lanifier.entites.utilisateur.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
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
	@Autowired
	Environment env;
	
	@Autowired
	ManagementProperty mp;

	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld(ModelMap model) {
		model.addAttribute("message", "hello world");
		System.out.println(mp.getSteamKey());
		model.addAttribute(mp.getSteamKey());
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
