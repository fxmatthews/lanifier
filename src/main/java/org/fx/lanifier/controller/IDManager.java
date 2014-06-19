package org.fx.lanifier.controller;

import java.util.ArrayList;
import java.util.Iterator;
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

	// TODO : récupérer les infos des jeux
	@RequestMapping(value = "manageID", method = RequestMethod.POST)
	public ModelAndView displayID(
			@ModelAttribute("steamIDList") SteamIDList idList) {
		List<String> ids = idList.getIds();
		List<String> sharedGames = new ArrayList<String>();

		for (String id : ids) {
			List<String> userGames = sUB.build(id).getJeux();
			if (sharedGames.size() == 0)
				sharedGames = userGames;
			else {
				Iterator<String> iterator = sharedGames.iterator();
				while (iterator.hasNext()) {
					String game = iterator.next();
					if (!userGames.contains(game)) {
						iterator.remove();
					}
				}
			}
		}

		ModelAndView mav = new ModelAndView("gamesList");
		mav.addObject("gamesList", sharedGames);
		return mav;
	}

}
