package co.edu.unbosque.model;

import java.util.Arrays;

/**
 * The type Nutricionista.
 */
public class Nutricionista {
	/**
	 * Optimo menu string.
	 *
	 * @param calories the calories
	 * @param calorie  the calorie
	 * @return the string
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
	
	
	private int valueInt(String chars [], int calories [], String letter) {
		for(int i = 0; i < calories.length; i++)
			if(chars[i].equalsIgnoreCase(letter))
				return calories[i];
		return -1;
	}

	private String imprimir(String letter [], int calories [], int value) {
		for(int i = 0; i < calories.length; i++)
			if(calories[i] == value) 
				return letter[i];
		return "";
	}
	
	private String [] values(int length) {
		String chars [] = new String [length];
		for(int i = 0; i < chars.length; i++)
			chars[i] = String.valueOf((char)(65 + i));
		return chars;
	}
}
