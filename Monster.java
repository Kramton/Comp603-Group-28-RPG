public class Monster {
  private String name;
  private int health;
  private int attack;

  public Monster(String name, int health, int attack)   {
    this.name = name;
    this.health = health;
    this.attack = attack;
  }

  public boolean isDead()
  {
    if (getHealth() <= 0)
    {
      return true;
    }
    return false;
  }

  public String getName() {
    return this.name;
  }

  public int getHealth() {
    return this.health;
  }

  public int getAttack() {
    return this.attack;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setHealth(int value) {
    this.health += value;
  }

  public void setAttack(int value) {
    this.attack += value;
  }
}