package org.fx.lanifier.entites.dao.jdbc;

import java.util.List;

import org.fx.lanifier.entites.Utilisateur;
import org.fx.lanifier.entites.dao.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCUtilisateurDAO implements
		UtilisateurDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(Utilisateur utilisateur) {
		String sql = "INSERT INTO utilisants VALUES (?, ?, ?)";

		this.jdbcTemplate.update(
				sql,
				new Object[] { "", utilisateur.getLogin(),
						utilisateur.getSteamId() });
	}

	@Override
	public Utilisateur getUtilisateur(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> getUtilisateurs(List<String> logins) {
		String sql = "SELECT NAME";

		// String name = (String)getJdbcTemplate().queryForObject(
		// sql, new Object[] { custId }, String.class);
		//
		// return name;
		return null;
	}

	@Override
	public List<Utilisateur> getTousUtilisateurs() {
		String sql = "SELECT * FROM utilisants";
		System.out.println(this.jdbcTemplate.toString());
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Utilisateur> customers = this.jdbcTemplate.query(sql,
				new BeanPropertyRowMapper(Utilisateur.class));
		return customers;
	}

}
