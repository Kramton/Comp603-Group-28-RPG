import java.util.Random;

public class Shield extends Item {
  
  public Shield(Random rand)
  {
    super("Shield",rand.nextInt(10) + 5);
  }

  public Shield()
  {
    super();
  }
}