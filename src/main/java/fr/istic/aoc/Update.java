package fr.istic.aoc;

import java.util.concurrent.Callable;

public class Update implements Callable<Object> {

  private Afficheur afficheur;
  private Canal canal;

  public Update(Afficheur afficheur, Canal canal) {
    this.afficheur = afficheur;
    this.canal = canal;
  }

  @Override
  public Object call() {
    this.afficheur.update(this.canal);
    return null;
  }
}
