package fr.istic.aoc;

import java.util.concurrent.Future;

public interface ObserverDeCapteurAsync {
	public Future<Void> updateAsync(); 

}
