package fr.istic.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.istic.aoc.algo.AlgoDiffusion;
import fr.istic.aoc.algo.DiffusionAtomique;

public class CapteurImpl implements Capteur {

    int value; 
    private List<ObserverDeCapteurAsync> listObserver;
    private AlgoDiffusion algoDiffusion;

    public CapteurImpl() {
        this.value = 0;
        this.listObserver = new ArrayList<ObserverDeCapteurAsync>();
        this.algoDiffusion = new DiffusionAtomique(this);
    }

    public List<ObserverDeCapteurAsync> getListObs() {
        return listObserver;
    }

    public void attach(ObserverDeCapteurAsync observer) {
        listObserver.add(observer);
    }

    public void detach(ObserverDeCapteurAsync observer) {
        listObserver.remove(observer);
    }

    public int getValue(Canal canal) {
        return algoDiffusion.value(canal);
    }

    public void tick() {
        value++;
        algoDiffusion.execute();
    }


    public int getObservers() {
        return this.listObserver.size();
    }


}
