package co.edu.unbosque.model;
import java.util.Arrays;

/**
 * Manage the process to obtain the optimal menu that a 
 * given user requires. required by a given user.
 * 
 * @author Hernan Alvarado
 * @author Kevin Pinzon
 * @author Eduardo Bocanegra
 * @since 2022
 * @version 1.0
 */
public class Nutricionista {
	
	/**
	 * Determine the optimal menu according to the calories and the minimum amount 
	 * of calories that the menu should meet and the calories of each dish that is 
	 * present.
	 *
	 * @param calories array containing the calories of the dishes
	 * @param calorie  minimum calories to be met
	 * @return the string the minimum calories determined and the dishes that meet those calories
	 */
	public String optimoMenu(int calories [], int calorie){
		Arrays.sort(calories);
		int nums [][] = new int [calories.length +1][calorie +1];
		StringBuilder chars [][] = new StringBuilder [nums.length][nums[0].length];
		String values [] = values(calories.length);
		for(int i = 1; i < nums[0].length; i++)
			nums[0][i] = Integer.MAX_VALUE;
		for(int i = 1, compare; i < nums.length; i++) {
			for(int j = 1; j < nums[i].length; j++) {
				StringBuilder builder = new StringBuilder();
				if(calories[i - 1] <= j) {
					compare = nums[i - 1][j - calories[i - 1]];
					builder.append(compare != 0? chars[i - 1][j - calories[i - 1]] : "");
					if(compare < Integer.MAX_VALUE) {
						builder.append(imprimir(values, calories, calories[i - 1]));
						compare += calories[i - 1];
					}
				}else {
					compare = calories[i - 1];
					builder.append(imprimir(values, calories, compare));
				}
				if(compare >= j) {
					if(nums[i -1][j] < compare) {
						builder.setLength(0);
						String value = imprimir(values, calories, nums[i - 1][j]);
						builder.append(value == ""? chars[i - 1][j] : value);
					}
				}
				nums[i][j] = compare >= j? Math.min(nums[i - 1][j], compare) : Integer.MAX_VALUE;
				chars[i][j] = builder.compareTo(new StringBuilder(String.valueOf("2147483647"))) == 0? null : builder;
			}
		}
		String fin = chars[calories.length][calorie].toString();
		String caloriasOptimas = "Las calorias optimas son: " + nums[calories.length][calorie] + "\n";
		for(int i = 0; i < fin.length(); i++) {
			int optimas = valueInt(values, calories, String.valueOf(fin.charAt(i)));
			caloriasOptimas += "Plato " + imprimir(values,calories,optimas) + " calorias: " + optimas + "\n";
		}
		return caloriasOptimas;
	}
	
	/**
	 * 
	 * @param chars array containing the names of the dishes
	 * @param calories array containing the amount of calories in the menu
	 * @param letter represents the plate being used
	 * @return calories in relation to the dish
	 */
	private int valueInt(String chars [], int calories [], String letter) {
		for(int i = 0; i < calories.length; i++)
			if(chars[i].equalsIgnoreCase(letter))
				return calories[i];
		return -1;
	}

	/**
	 * Create a relationship between the names of the dishes and their respective calories.
	 * 
	 * @param letter array containing the names of the dishes
	 * @param calories array containing the amount of calories in the menu
	 * @param value integer value with respect to the plate used
	 * @return string representing the integer value
	 */
	private String imprimir(String letter [], int calories [], int value) {
		for(int i = 0; i < calories.length; i++)
			if(calories[i] == value) 
				return letter[i];
		return "";
	}
	
	/**
	 * create name whose length is equal to the array of calories entered
	 * 
	 * @param length of the array containing the names of the dishes
	 * @return name array
	 */
	private String [] values(int length) {
		String chars [] = new String [length];
		for(int i = 0; i < chars.length; i++)
			chars[i] = String.valueOf((char)(65 + i));
		return chars;
	}
}