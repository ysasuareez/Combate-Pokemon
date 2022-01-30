package models;

public class Combate {

	
	/*
	 * ATRIBUTOS
	 */
	private Entrenador entrenador1;
	private Entrenador entrenador2;
	private Pokemon poke1;
	private Pokemon poke2;
	
	/*
	 * CONSTRUCTOR
	 * @param entrenador1
	 * @param entrenador2
	 * @param pokemon1
	 * @param pokemon2
	 */
	public Combate(Entrenador entrenador1, Entrenador entrenador2, Pokemon poke1, Pokemon poke2) {
		super();
		this.entrenador1 = entrenador1;
		this.entrenador2 = entrenador2;
		this.poke1 = poke1;
		this.poke2 = poke2;
	}
	
	
	/*
	 * G & S
	 */
	public Entrenador getEntrenador1() {
		return entrenador1;
	}
	
	public void setEntrenador1(Entrenador entrenador1) {
		this.entrenador1 = entrenador1;
	}
	
	
	public Entrenador getEntrenador2() {
		return entrenador2;
	}
	
	public void setEntrenador2(Entrenador entrenador2) {
		this.entrenador2 = entrenador2;
	}
	
	
	public Pokemon getPokemon1() {
		return poke1;
	}
	
	public void setPokemon1(Pokemon pokemon1) {
		this.poke1 = pokemon1;
	}
	
	
	public Pokemon getPokemon2() {
		return poke2;
	}
	
	public void setPokemon2(Pokemon pokemon2) {
		this.poke2 = pokemon2;
	}


	/*
	 * MÉTODOS
	 */
	
	/*
	 * Método que se aplica para ver que pokemon empieza el ataque dependiendo de la velocidad
	 * ( quien tenga más speed empieza )
	 */
	
	
	public Pokemon primerPoke() {
		
		if(poke1.getSpeed() >= poke2.getSpeed()) {
			
			System.out.println(poke1.getNombre() + " empezará el combate.");
			return poke1;
		
		} else { 
			
			System.out.println(poke2.getNombre() + " empezará el combate.");
			return poke2;
		}
	}
	
	public Pokemon segundoPoke() {
		
		if(poke1.getSpeed() >= poke2.getSpeed()) {
			
			System.out.println(poke2.getNombre() + " será el segundo.");
			return poke2;
		
		} else { 
			
			System.out.println(poke1.getNombre() + " será el segundo.");
			return poke1;
		}
	}
	
	
	/*
	 * Método que reacciona segun el movimiento elegido, creando el daño o variando los stats
	 */
	public void aplicarMovimiento(Movimiento movE, Pokemon poke){
		
		double daño = 0;
		int probabilidad = 0;
		
		//Si el turno es del primer pokemon
		if(poke.equals(poke1)) {
			
			//Comprobamos si tiene algun estado (Se deberia comprobar que tipo de estado tiene, en este caso como solo tenemos quemado hacemos lo siguiente)
			
			for (int i = 0; i < Estados.values().length; i++) {
			

				if(poke1.getEstado().equals(Estados.values()[i]) && (!poke1.getEstado().equals(Estados.None))) {
					poke1.setActualHP(poke1.getActualHP() - 2);
					System.out.println(poke1.getNombre() + " está '" + poke1.getEstado() + "', su HP se ve afectada.\n");
				}
	
			}
	
			//Si el movimiento es de tipo fisico, es decir, crea un daño fisico
			if(movE.getDamage() > 0) {
				
				daño = ((  (((  (2 * poke1.getLvl())/5) + 2 ))  *  (movE.getDamage())  *  ((poke1.getAttack() / poke2.getDef())) / 50 ) + 2);
				
				poke2.setActualHP(poke2.getActualHP() - daño);

				if(movE.getAplicaEstado().equals(Estados.Quemado)) {
					
					//Procedimiento de probabilidad
					probabilidad = (int)(Math.random() * 100 + 1);
					
					if (probabilidad <= 10) {
						
						poke2.setEstado(movE.getAplicaEstado());
					}
				}
				
				
				
			} else if (movE.getDamage() == 0) {
				
				if(movE.getAplicaEstado().equals(Estados.Quemado)) {
					
					//Procedimiento de probabilidad
					probabilidad = (int)(Math.random() * 100 + 1);
					
					if (probabilidad <= 10) {
						
						poke2.setEstado(movE.getAplicaEstado());
					}
				}
				

			}

		poke2.setAttack((poke2.getAttack()) - (movE.getCambiaAttack()));
		poke2.setDef((poke2.getDef()) - (movE.getCambiaDef()));
		mostrarDatos();
		
		//Si el turno es del segundo pokemon
		//Hacemos lo mismo con el segundo pokemon
		}else if (poke.equals(poke2)) {
			
			for (int i = 0; i < Estados.values().length; i++) {
				
				if(poke2.getEstado().equals(Estados.values()[i]) && (!poke2.getEstado().equals(Estados.None))) {
					poke2.setActualHP(poke2.getActualHP() - 2);
					System.out.println(poke2.getNombre() + " está '" + poke2.getEstado() + "', su HP se ve afectada.\n");
				}

			}
			
			
			if(movE.getDamage() > 0) {
		
				daño = ((  (((  (2 * poke2.getLvl())/5) + 2 ))  *  (movE.getDamage())  *  ((poke2.getAttack() / poke1.getDef())) / 50 ) + 2);
				
				poke1.setActualHP(poke1.getActualHP() - daño);
				
				if(movE.getAplicaEstado().equals(Estados.Quemado)) {
					
					probabilidad = (int)(Math.random() * 100 + 1);
					
					if (probabilidad <= 10) {
						
						poke1.setEstado(movE.getAplicaEstado());
					}
				}
				
			} else if (movE.getDamage() == 0) {
				
				if(movE.getAplicaEstado().equals(Estados.Quemado)) {
					
					probabilidad = (int)(Math.random() * 100 + 1);
					
					if (probabilidad <= 10) {
						
						poke1.setEstado(movE.getAplicaEstado());
					}
				}
			}
			
			poke1.setAttack((poke1.getAttack()) - (movE.getCambiaAttack()));
			poke1.setDef((poke1.getDef()) - (movE.getCambiaDef()));
			mostrarDatos();
		}
	}
		
	
	/*
	 * Método que imprime por pantalla como se encuentran los niveles de los pokemons.
	 */
	public void mostrarDatos() {
	
		System.out.println("\nDATOS:");
		System.out.println(poke1.getNombre());
		System.out.println("   HP: " + poke1.getActualHP() );
		System.out.println("   Estado: " + poke1.getEstado());
		System.out.println("   Ataque: " + poke1.getAttack() );
		System.out.println("   Defensa: " + poke1.getDef() );
		
		System.out.println("");
		
		System.out.println(poke2.getNombre());
		System.out.println("   HP: " + poke2.getActualHP() );
		System.out.println("   Estado: " + poke2.getEstado());
		System.out.println("   Ataque: " + poke2.getAttack() );
		System.out.println("   Defensa: " + poke2.getDef() );
		
		
	}
	
	/*
	 * Método que finaliza el combate si alguno de los dos pokemons se ha quedado sin HP (vida)
	 */
	public boolean isFinished() {
		
		if(poke1.getActualHP() <= 0 ){
			
			System.out.println("¡¡SE ACABÓ EL COMBATE!!");
			System.out.println("   Y EL GANADOR ES...");
			System.out.println("          ...");
			System.out.println("          ...");
			System.out.println("          ...");
			System.out.println("          ...");
			System.out.println("          ...");
			System.out.println(poke1.getNombre());
			System.out.println("     ¡ENHORABUENA!");
			return true;
			
		}else if (poke2.getActualHP() <= 0){
			System.out.println("¡¡SE ACABÓ EL COMBATE!!");
			System.out.println("   Y EL GANADOR ES...");
			System.out.println("          ...");
			System.out.println("          ...");
			System.out.println("          ...");
			System.out.println("          ...");
			System.out.println("          ...");
			System.out.println(poke2.getNombre());
			System.out.println("     ¡ENHORABUENA!");
			return true;
			
		}else {
			
			return false;
			
		}
		
	}
	
	
	
}
