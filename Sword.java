import java.util.Random;

public class Sword extends Item{
  
  //Random rand = new Random();
  public Sword(Random rand)
  {
    super("Sword",rand.nextInt(10) + 5);
  }

  public Sword()
  {
    super();
  }

  
}