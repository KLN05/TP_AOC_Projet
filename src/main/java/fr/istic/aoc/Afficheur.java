package fr.istic.aoc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Role de Concrete Componant
 */
public class Afficheur implements ObserverDeCapteur {

	private Canal canal;
	private int id;

	public Afficheur(int id) {
		this.id = id;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal c){
		this.canal = c;
	}

	@Override
	public Void update(Canal s) {
		this.canal = s;
		try {
			Logger.getGlobal().log(Level.INFO, "Afficheur " + this.id + " Valeur : " + this.canal.getValueAsync().get());
		} catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
