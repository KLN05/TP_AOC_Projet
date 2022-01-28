package fr.istic.aoc;

import java.util.List;

public interface Capteur {


	void attach(ObserverDeCapteurAsync observer);

	void detach(ObserverDeCapteurAsync observer);

	int getValue(Canal canal);

    void tick();

    List<ObserverDeCapteurAsync> getListObs();
    
    int getObservers();
}

