package fr.istic.aoc;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.istic.aoc.algo.AlgoDiffusion;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	
	int cptAff;
	
    AlgoDiffusion algoDiffusion;

    Capteur capteur;

    Afficheur afficheur1;

    Afficheur afficheur2;

    Canal canal1;

    Canal canal2;
    
    ScheduledExecutorService exec;
    
    @BeforeEach
    void setUp() {
    	exec = Executors.newScheduledThreadPool(8);
    	
    	cptAff = 0;
        capteur = new CapteurImpl( );

        afficheur1 = new Afficheur(cptAff++);
		afficheur2 = new Afficheur(cptAff++);


        canal1 = new Canal(exec, afficheur1, capteur);
        canal2 = new Canal(exec, afficheur2, capteur);

        capteur.attach(canal1);
        capteur.attach(canal2);

    }
	
	
    @Test
    public void TestAtom() throws InterruptedException, ExecutionException {


		Logger.getGlobal().log(Level.INFO, "Start");
		for(Integer cpt = 1; cpt < 10; cpt++) {
			capteur.tick();
			Thread.sleep(1000 - System.currentTimeMillis() % 1000);
			Integer val1 = afficheur1.getCanal().getValueAsync().get(); 
			Integer val2 = afficheur2.getCanal().getValueAsync().get();
			assertTrue(val1==cpt);
			assertTrue(val2 == cpt);
		}
		
		exec.awaitTermination(30, TimeUnit.SECONDS);
		capteur.detach(canal1);
		capteur.detach(canal2);

    }
}
