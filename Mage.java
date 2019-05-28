import java.util.Random;

public class Mage
{
    private static int randomTwitch()
    {
        Random rng = new Random();
        return rng.nextInt(10) - 5;
    }

    private int hitPoints = 100;
    private int manaPoints = 50;
    private int blackMagicPower;
    private int whiteMagicPower;

    Mage(String allegiance)
    {
        switch(allegiance)
        {
            case "good":
                this.blackMagicPower = 10 + randomTwitch();
                this.whiteMagicPower = 20 + randomTwitch();
                break;
            case "evil":
                this.blackMagicPower = 12 + randomTwitch();
                this.whiteMagicPower = 10 + randomTwitch();
                break;
        }
    }

    public int getHitPoints() {
        return hitPoints;
    }

    void attack(Mage attacked)
    {
        int attackPoints = this.blackMagicPower + randomTwitch();
        attacked.hitPoints -= attackPoints;
        this.manaPoints -= 5;
        if(this.manaPoints < 0) this.manaPoints = 0;
    }

    void heal(Mage healed)
    {
        int healPoints = this.whiteMagicPower + randomTwitch();
        healed.hitPoints += healPoints;
        this.manaPoints -= 3;
        if(this.manaPoints < 0) this.manaPoints = 0;
    }
}