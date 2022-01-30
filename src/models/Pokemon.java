package models;

import java.util.ArrayList;
import java.util.Scanner;


public class Pokemon {

	
	/*
	 * ATRIBUTOS
	 */
	private int numero;
	private String nombre;
	private TiposPokemon tipo1;
	private TiposPokemon tipo2;
	private Estados estado;
	private double attack;
	private double def;
	private double specialAttack;
	private double specialDef;
	private double speed;
	private ArrayList<Movimiento> misMovimientos;
	private double maxHP;
	private double actualHP;
	private double lvl;
	
	
	/**
	 * CONSTRUCTOR
	 * @param numero
	 * @param nombre
	 * @param tipo1
	 * @param tipo2
	 * @param estado
	 * @param attack
	 * @param def
	 * @param specialAttack
	 * @param specialDef
	 * @param speed
	 * @param mov
	 * @param maxHP
	 * @param actualHP
	 * @param lvl
	 */
	public Pokemon(int numero, String nombre, TiposPokemon tipo1, TiposPokemon tipo2, Estados estado, double attack, double def,
			double specialAttack, double specialDef, double speed, ArrayList<Movimiento> misMovimientos, double maxHP, double actualHP, double lvl) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.estado = estado;
		this.attack = attack;
		this.def = def;
		this.specialAttack = specialAttack;
		this.specialDef = specialDef;
		this.speed = speed;
		this.misMovimientos = misMovimientos;
		this.maxHP = maxHP;
		this.actualHP = actualHP;
		this.lvl = lvl;
	}
	
	
	/*
	 * G & S
	 */
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public TiposPokemon getTipo1() {
		return tipo1;
	}


	public void setTipo1(TiposPokemon tipo1) {
		this.tipo1 = tipo1;
	}


	public TiposPokemon getTipo2() {
		return tipo2;
	}


	public void setTipo2(TiposPokemon tipo2) {
		this.tipo2 = tipo2;
	}


	public Estados getEstado() {
		return estado;
	}


	public void setEstado(Estados estado) {
		this.estado = estado;
	}


	public double getAttack() {
		return attack;
	}


	public void setAttack(double attack) {
		this.attack = attack;
	}


	public double getDef() {
		return def;
	}


	public void setDef(double def) {
		this.def = def;
	}


	public double getSpecialAttack() {
		return specialAttack;
	}


	public void setSpecialAttack(double specialAttack) {
		this.specialAttack = specialAttack;
	}


	public double getSpecialDef() {
		return specialDef;
	}


	public void setSpecialDef(double specialDef) {
		this.specialDef = specialDef;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public ArrayList<Movimiento> getMov() {
		return misMovimientos;
	}


	public void setMov(ArrayList<Movimiento> mov) {
		misMovimientos = mov;
	}


	public double getMaxHP() {
		return maxHP;
	}


	public void setMaxHP(double maxHP) {
		this.maxHP = maxHP;
	}


	public double getActualHP() {
		return actualHP;
	}


	public void setActualHP(double newHP) {
		this.actualHP = newHP;
	}


	public double getLvl() {
		return lvl;
	}


	public void setLvl(double lvl) {
		this.lvl = lvl;
	}
	
	/*
	 * MÉTODOS
	 */
	
	/*
	 *Método por el cual el entrenador puede elegir entre los movimientos de su pokemon 
	 */
	public Movimiento elegirMovimiento() {
		
		int movE = 0;
		Scanner s = new Scanner(System.in);
		boolean elegido = true;
		
		do {
			
			//Llamamos al metodo que muestra los movimientos y le solicitamos al entrenador que elija mediante el scanner
			mostrarMovimientos();
			System.out.print("\nNº del Movimiento a ejecutar:  ");
			movE = Integer.parseInt(s.nextLine());
			
			//cada pokemon tiene 4 movimientos por lo que si se elije un número no valido mostrará este mensaje,
			//hasta que elija un movimiento existente
			if(movE < 1 || movE > 4 || misMovimientos.get(movE-1).getActualPP() < 0){
				
				System.out.println("\nNo es posible elegir este movimiento, vuelva a intentarlo.");
				elegido = false;
				
			}
			
			
		} while (!elegido);
		
		misMovimientos.get(movE-1).setActualPP(misMovimientos.get(movE-1).getActualPP()-1);
		System.out.println("\nHas elegido: " + misMovimientos.get(movE-1).getNombre());
		return misMovimientos.get(movE-1);
		
	}
		
	
	/*
	 * Método que imprime por pantalla los movimientos pertenecientes al pokemon que le toca jugar
	 */
	public void mostrarMovimientos() {
		
		System.out.println("\nMOVIMIENTOS DISPONIBLES:");
		for (int i = 0; i < misMovimientos.size(); i++) {
			System.out.println( (i+1)+ ". " + misMovimientos.get(i).getNombre());	
		}
		
	}


	public void añadirMov(Movimiento movimiento) {
		
		misMovimientos.add(movimiento);
		
	}
	
	
	
}
