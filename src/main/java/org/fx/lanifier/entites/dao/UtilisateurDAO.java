package org.fx.lanifier.entites.dao;

import java.util.List;

import org.fx.lanifier.entites.Utilisateur;


public interface UtilisateurDAO {

	public void insert(Utilisateur utilisateur);

	public Utilisateur getUtilisateur(String login);

	public List<Utilisateur> getUtilisateurs(List<String> logins);

	public List<Utilisateur> getTousUtilisateurs();
}
