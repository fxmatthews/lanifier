package org.fx.lanifier.controller;

import java.util.ArrayList;
import java.util.List;

import org.fx.lanifier.entites.SteamIDList;
import org.fx.lanifier.steamapi.SteamUser;
import org.fx.lanifier.steamapi.SteamUserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IDManager {
	
	@Autowired
	private SteamUserBuilder sUB;

	@RequestMapping(value = "manageID", method = RequestMethod.GET)
	public ModelAndView manageID(
			@ModelAttribute("steamIDList") SteamIDList idList) {
		return new ModelAndView("formulairesID");
	}

	// TODO : récupérer la liste des jeux + les infos des jeux
	@RequestMapping(value = "manageID", method = RequestMethod.POST)
	public String displayID(@ModelAttribute("steamIDList") SteamIDList idList) {
		List<String> ids = idList.getIds();
		List<SteamUser> users = new ArrayList<SteamUser>();
		List<String> blabla = new ArrayList<String>();
		for (String id : ids) {
			System.out.println(id);;
			 users.add(sUB.build(id));
			 blabla.add(users.get(users.size()-1).getPseudo());
		}
		return blabla.get(0);
	}

}
