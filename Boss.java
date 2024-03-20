import java.util.Random;

public class Boss extends Monster {
  // create random for:
  // health 60-80
  // attack 15-25
  public Boss(Random rand) {
    super("Boss", rand.nextInt(20) + 60, rand.nextInt(10) + 15);
  }
}