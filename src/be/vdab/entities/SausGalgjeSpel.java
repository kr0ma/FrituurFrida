package be.vdab.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import be.vdab.dao.SausDAO;

public class SausGalgjeSpel implements Serializable {
	private static final long serialVersionUID = 1L;
	private final SausDAO sausDAO = new SausDAO();
	private final String teRadenSaus = sausDAO.findAll().get(new Random().nextInt(sausDAO.findAll().size())).getNaam();
	private Map<Character, Boolean> teRadenLetters = convertToMap(teRadenSaus);
	private int aantalVerkeerdePogingen;		
	
	public Map<Character, Boolean> getTeRadenLetters() {
		return teRadenLetters;
	}	
	
	public String getTeRadenSaus() {
		return teRadenSaus;
	}
	
	public int getAantalVerkeerdePogingen() {
		return aantalVerkeerdePogingen;
	}
	
	public void valideerLetter(char letter){
		if (teRadenLetters.containsKey(letter)){			
			teRadenLetters.put(letter, true);				
		} else {
			if (aantalVerkeerdePogingen < 10){
				aantalVerkeerdePogingen++;
			}			
		}
	}
	
	public static Map<Character, Boolean> convertToMap(String string) {
	      // Result hashset
	      Map<Character, Boolean> resultSet = new HashMap<>();

	      for (int i = 0; i < string.length(); i++) {	          
	          resultSet.put(string.charAt(i), false);
	      }
	      // Return result	      
	      return resultSet;
	  }	
	
	public boolean getGameIsFinished(){
		return (!teRadenLetters.containsValue(false) || aantalVerkeerdePogingen == 10);
	}

}
