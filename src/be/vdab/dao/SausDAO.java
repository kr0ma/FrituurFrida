package be.vdab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import be.vdab.entities.Saus;

public class SausDAO extends abstractDAO {
	private static final String BEGIN_SELECT = "select id, naam, ingredienten from sauzen ";
	private static final String SELECT_BY_INGREDIENT = "select id, naam, ingredienten from sauzen where ingredienten like ?";
	private static final String DELETE_BY_ID = "delete from sauzen where id = ?";
	
	private Saus resultSetRijNaarSaus(ResultSet resultset) throws SQLException {
		String[] ingredienten = (resultset.getString("ingredienten")).split(",", 0);
		Saus saus = new Saus(resultset.getLong("id"),
				resultset.getString("naam"), Arrays.asList(ingredienten));
		return saus;
	}

	public List<Saus> findAll() {
		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery(BEGIN_SELECT)) {
			List<Saus> sauzen = new ArrayList<>();
			while (resultset.next()) {
				sauzen.add(resultSetRijNaarSaus(resultset));
			}
			return sauzen;

		} catch (SQLException ex) {
			throw new DAOException(ex);
		}
	}

	public List<Saus> findWithIngredient(String ingredient) {
		List<Saus> sauzenMetIngredient = new ArrayList<>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(SELECT_BY_INGREDIENT)) {
			ingredient = "%" + ingredient + "%";
			statement.setString(1, ingredient);
			try (ResultSet resultset = statement.executeQuery()) {
				while (resultset.next()) {
					sauzenMetIngredient.add(resultSetRijNaarSaus(resultset));
				}
				return sauzenMetIngredient;
			}
		} catch (SQLException ex) {
			throw new DAOException(ex);
		}
	}

	public void removeById(Long id) {
		try(Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)){
			statement.setLong(1, id);
			statement.executeUpdate();		
		} catch (SQLException ex){
			throw new DAOException(ex);
		}		
	}
}
