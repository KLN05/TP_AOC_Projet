package fr.istic.aoc;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Void> {

  @Override
  public Void call() throws InterruptedException {
      Thread.sleep(500);
    return null;
  }
}
