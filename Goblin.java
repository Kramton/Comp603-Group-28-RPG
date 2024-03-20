import java.util.Random;

public class Goblin extends Monster {
  // create random for:
  // health 40-60
  // attack 15-25
  public Goblin(Random rand) {
    super("Goblin", rand.nextInt(20) + 60, rand.nextInt(10) + 5);
  }
}