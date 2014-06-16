package org.fx.lanifier.controller;

import java.util.List;

import org.fx.lanifier.entites.utilisateur.SteamIDList;
import org.fx.lanifier.entites.utilisateur.SteamUser;
import org.fx.lanifier.entites.utilisateur.SteamUserBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IDManager {
	
	@RequestMapping(value = "manageID", method = RequestMethod.GET)
	public ModelAndView manageID(
			@ModelAttribute("steamIDList") SteamIDList idList) {
		return new ModelAndView("formulairesID");
	}

	@RequestMapping(value = "manageID", method = RequestMethod.POST)
	public void displayID(@ModelAttribute("steamIDList") SteamIDList idList) {
		List<String> ids = idList.getIds();
		for (String id : ids) {
			SteamUser user = new SteamUserBuilder().build(id);
		}
	}

}
