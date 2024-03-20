import java.util.Random;

public class Ogre extends Monster {
  // create random for:
  // health 60-80
  // attack 5-15
  public Ogre(Random rand) {
    super("Ogre", rand.nextInt(20) + 60, rand.nextInt(10) + 5);
  }
}