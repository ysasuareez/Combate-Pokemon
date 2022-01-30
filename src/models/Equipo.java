package models;

import java.util.ArrayList;

public class Equipo {

	/*
	 * ATRIBUTOS
	 */
	private static ArrayList <Pokemon> misPokemons;

	/*
	 * COSNTRUCTOR
	 */
	public Equipo() {
		super();
		this.misPokemons = new ArrayList <Pokemon> ();
	}

	
	/*
	 * G & S
	 */
	public static ArrayList<Pokemon> getMisPokemons() {
		return misPokemons;
	}

	public void setMisPokemons(ArrayList<Pokemon> misPokemons) {
		this.misPokemons = misPokemons;
	}	


	public void a�adirPoke(Pokemon pokemon) {
		misPokemons.add(pokemon);
	}
	
	
}
