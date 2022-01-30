package models;

public class Movimiento {

	/*
	 * ATRIBUTOS
	 */
	private String nombre;
	private TiposPokemon tipo;
	private int maxPP;
	private int actualPP;
	private int damage;
	private int cambiaAttack;
	private int cambiaDef;
	private int cambiaSpAttack;
	private int cambiaSpDef;
	private int cambiaSpeed;
	private Estados aplicaEstado;
	private int prob;
	private Categoria categoria;
	
	
	/**
	 * CONSTRUCTOR
	 * @param nombre
	 * @param tipo
	 * @param maxPP
	 * @param actualPP
	 * @param damage
	 * @param cambiaAttack
	 * @param cambiaDef
	 * @param cambiaSpAttack
	 * @param cambiaSpDef
	 * @param cambiaSpeed
	 * @param aplicaEstado
	 * @param prob
	 */
	public Movimiento(String nombre, TiposPokemon tipo, int maxPP, int actualPP, int damage, int cambiaAttack,
			int cambiaDef, int cambiaSpAttack, int cambiaSpDef, int cambiaSpeed, Estados aplicaEstado, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.maxPP = maxPP;
		this.actualPP = actualPP;
		this.damage = damage;
		this.cambiaAttack = cambiaAttack;
		this.cambiaDef = cambiaDef;
		this.cambiaSpAttack = cambiaSpAttack;
		this.cambiaSpDef = cambiaSpDef;
		this.cambiaSpeed = cambiaSpeed;
		this.aplicaEstado = aplicaEstado;
		this.categoria = categoria;
	}

	/*
	 * G & S
	 */
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public TiposPokemon getTipo() {
		return tipo;
	}


	public void setTipo(TiposPokemon tipo) {
		this.tipo = tipo;
	}


	public int getMaxPP() {
		return maxPP;
	}


	public void setMaxPP(int maxPP) {
		this.maxPP = maxPP;
	}


	public int getActualPP() {
		return actualPP;
	}


	public void setActualPP(int actualPP) {
		this.actualPP = actualPP;
	}


	public int getDamage() {
		return damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}


	public int getCambiaAttack() {
		return cambiaAttack;
	}


	public void setCambiaAttack(int cambiaAttack) {
		this.cambiaAttack = cambiaAttack;
	}


	public int getCambiaDef() {
		return cambiaDef;
	}


	public void setCambiaDef(int cambiaDef) {
		this.cambiaDef = cambiaDef;
	}


	public int getCambiaSpAttack() {
		return cambiaSpAttack;
	}


	public void setCambiaSpAttack(int cambiaSpAttack) {
		this.cambiaSpAttack = cambiaSpAttack;
	}


	public int getCambiaSpDef() {
		return cambiaSpDef;
	}


	public void setCambiaSpDef(int cambiaSpDef) {
		this.cambiaSpDef = cambiaSpDef;
	}


	public int getCambiaSpeed() {
		return cambiaSpeed;
	}


	public void setCambiaSpeed(int cambiaSpeed) {
		this.cambiaSpeed = cambiaSpeed;
	}


	public Estados getAplicaEstado() {
		return aplicaEstado;
	}


	public void setAplicaEstado(Estados aplicaEstado) {
		this.aplicaEstado = aplicaEstado;
	}


	public int getProb() {
		return prob;
	}


	public void setProb(int prob) {
		this.prob = prob;
	}
	
	public int getCategoria() {
		return prob;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

	
}
