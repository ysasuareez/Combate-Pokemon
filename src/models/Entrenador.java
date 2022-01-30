package models;

import java.util.ArrayList;

public class Entrenador {

	/*
	 * ATRIBUTOS
	 */
	private String nombre;
	private Equipo equipo;

	
	/*
	 * CONSTRUCTOR
	 * @param nombre
	 * @param equipo
	 */
	public Entrenador(String name, Equipo team) {
		super();
		this.nombre = name;
		this.equipo = team;
	}


	
	/*
	 * G & S
	 */
	public String getName() {
		return nombre;
	}


	public void setName(String name) {
		this.nombre = name;
	}


	public Equipo getTeam() {
		return equipo;
	}


	public void setTeam(Equipo team) {
		this.equipo = team;
	}
	
	
	/*
	 * MÉTODOS
	 */
	
	
	

	
}
