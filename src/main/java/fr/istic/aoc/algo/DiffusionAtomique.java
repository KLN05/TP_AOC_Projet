package fr.istic.aoc.algo;

import fr.istic.aoc.Canal;
import fr.istic.aoc.Capteur;
import fr.istic.aoc.ObserverDeCapteurAsync;

public class DiffusionAtomique implements AlgoDiffusion {

    private Capteur capteur;
    private int cptRead;
    private Integer val;

	
    public DiffusionAtomique(Capteur capteur) {
        this.capteur = capteur;
        this.cptRead = 0;
        this.val = 0;
    }
    
	@Override
	public void execute() {
        this.val++;
        for (ObserverDeCapteurAsync o : this.capteur.getListObs()) { 
            o.updateAsync();
        }
   }

	

	@Override
	public Integer value(Canal c) {
		 this.cptRead++;
	        if(this.cptRead == this.capteur.getObservers()) {
	            this.cptRead = 0;
	        }
	        return this.val;
	    }


}
