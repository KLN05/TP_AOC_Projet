package fr.istic.aoc.algo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import fr.istic.aoc.Canal;
import fr.istic.aoc.Capteur;


public abstract class DiffusionSequentielle implements AlgoDiffusion {

//	private List<Future> futures = new ArrayList<>();
//    private List<Canal> canaux = new ArrayList<>();
//    private Capteur capteur;
//
//    public void configure(Capteur capteur, List<Canal> newCanaux) {
//        this.capteur = capteur;
//        canaux.addAll(newCanaux);
//    }
//    
//
//    @Override
//    public void execute() {
//        if(previousNumber()){
//        	  futures = new ArrayList<>();
//              for(Canal canal : canaux){
//                  futures.add(canal.updateAsync());
//              }
//        }
//    }
//    
//    private boolean previousNumber(){
//        boolean result = true;
//        for(Future<Void> future : this.futures){
//            result &= future.isDone();
//        }
//        return result;
//    }


}
