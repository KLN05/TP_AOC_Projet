package fr.istic.aoc;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



public class Canal implements CapteurAsync, ObserverDeCapteurAsync{

    private Capteur capteur;
    private Afficheur afficheur;
    private ScheduledExecutorService scheduler;

    public Canal(ScheduledExecutorService scheduler, Afficheur afficheur, Capteur capteur){
    	this.scheduler = scheduler;
    	this.afficheur = afficheur;
    	this.capteur = capteur;
    	this.afficheur.setCanal(this);
    }

	public Future<Void> updateAsync() {
		Callable<Void> callableVoid2 = () -> this.afficheur.update(this);
		Random r = new Random();
		//Update callableVoid = new Update(this.afficheur,this);
		return scheduler.schedule(callableVoid2, r.nextInt(1000), TimeUnit.MILLISECONDS);
	}

	public Future<Integer> getValueAsync() {
		Callable<Integer> callableInt2 = () -> capteur.getValue(this);
		Random r = new Random();
		//GetValue callableInt = new GetValue();
		return scheduler.schedule(callableInt2, r.nextInt(1000), TimeUnit.MILLISECONDS);
	}

}
