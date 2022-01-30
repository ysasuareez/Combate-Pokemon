package main;

import java.util.ArrayList;
import java.util.Arrays;

import models.Categoria;
import models.Combate;
import models.Entrenador;
import models.Equipo;
import models.Estados;
import models.Movimiento;
import models.Pokemon;
import models.TiposPokemon;



public class MainApp {
	
	public static void main(String[] args) {
		
	/*
	 * Creación de pokemon, respectivos movimientos y  entrenadores
	 */
	
	//CHARMANDER
	Movimiento arañazo = new Movimiento ("Arañazo", TiposPokemon.Normal, 20, 20, 40, 0, 0, 0, 0, 0, Estados.None, Categoria.Fisico);
	Movimiento gruñido = new Movimiento ("Gruñido", TiposPokemon.Normal, 20, 20, 0, 1, 0, 0, 0, 0, Estados.None, Categoria.Estado); // cambia ataque
	Movimiento ascuas = new Movimiento ("Ascuas", TiposPokemon.Fuego, 15, 15, 40, 0, 0, 0, 0, 0, Estados.Quemado, Categoria.Estado); 
	Movimiento danzaEspada = new Movimiento ("Danza Espada", TiposPokemon.Normal, 5, 5, 40, 0, 0, 0, 0, 0, Estados.Quemado, Categoria.Fisico);
	
	Pokemon charmander = new Pokemon(59, "Charmander", TiposPokemon.Fuego, TiposPokemon.Ninguno, Estados.None, 52, 43, 60, 50, 65, new ArrayList<Movimiento>(Arrays.asList(arañazo, gruñido, ascuas, danzaEspada)), 39, 100, 50);
	
	Equipo equipo1 = new Equipo();
	
	equipo1.añadirPoke(charmander);
	
	Entrenador ysa = new Entrenador("Ysa", equipo1);
	
	//SQUIRTLE
	Movimiento placaje = new Movimiento ("Placaje", TiposPokemon.Normal, 20, 20, 35, 0, 0, 0, 0, 0, Estados.None, Categoria.Fisico);
	Movimiento latigo = new Movimiento ("Latigo", TiposPokemon.Normal, 20, 20, 0, 0, 1, 0, 0, 0, Estados.None, Categoria.Fisico); //cambia defensa
	Movimiento pistolaAgua = new Movimiento ("Pistola Agua", TiposPokemon.Agua, 15, 15, 40, 0, 0, 0, 0, 0, Estados.None, Categoria.Fisico);
	Movimiento refugio = new Movimiento ("Refugio", TiposPokemon.Normal, 5, 5, 0, 0, 0, 0, 0, 0, Estados.None, Categoria.Fisico);
	
	Pokemon squirtle = new Pokemon(243, "Squirtle", TiposPokemon.Agua, TiposPokemon.Ninguno, Estados.None, 48, 65, 50, 64, 43, new ArrayList <Movimiento> (Arrays.asList(placaje, latigo, pistolaAgua, refugio)), 44, 100, 50);

	Equipo equipo2 = new Equipo();
	equipo2.añadirPoke(squirtle);

	Entrenador alv = new Entrenador("Álvaro", equipo2);
	
	
	//COMENZAMOS EL COMBATE:
	
		Combate combate = new Combate(ysa, alv, charmander, squirtle);
		
		Pokemon primerPoke = combate.primerPoke();
		Pokemon segundoPoke = combate.segundoPoke();
		combate.mostrarDatos();
		
		do {
			
			System.out.println("\nTURNO DE: " + primerPoke.getNombre());
			Movimiento movimiento = (primerPoke.elegirMovimiento());
			combate.aplicarMovimiento(movimiento, primerPoke);
			
			System.out.println("\nTURNO DE: " + segundoPoke.getNombre());
			Movimiento movimiento2 = (segundoPoke.elegirMovimiento());
			combate.aplicarMovimiento(movimiento2, segundoPoke);
			
		}while(!combate.isFinished());
	
	
	
	}
}