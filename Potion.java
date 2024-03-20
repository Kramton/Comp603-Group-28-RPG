import java.util.Random;

public class Potion extends Item {
  
  public Potion(Random rand) {
    super("Potion",rand.nextInt(20) + 20);
  }

  public Potion()
  {
    super();
  }
}