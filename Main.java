import java.util.LinkedList;

public class Main
{
    public static void main(String[] args)
    {
        LinkedList<Mage> goodMages = new LinkedList<>();
        LinkedList<Mage> evilMages = new LinkedList<>();
        for(int i = 0; i < 5; i++)
        {
            goodMages.add(new Mage("good"));
            evilMages.add(new Mage("evil"));
        }

        while(!goodMages.isEmpty() && !evilMages.isEmpty())
        {
            for (Mage goodMage: goodMages)
            {
                if( mageInNeed(goodMages) != -1 ) goodMage.heal(goodMages.get(mageInNeed(goodMages)));
                else goodMage.attack(evilMages.getFirst());
            }
            for (Mage evilMage: evilMages)
            {
                if( mageInNeed(evilMages) != -1 ) evilMage.heal(evilMages.get(mageInNeed(evilMages)));
                else evilMage.attack(goodMages.getFirst());
            }
            for (int i = 0; i < goodMages.size(); i++)
                if(goodMages.get(i).getHitPoints() <= 0)
                {
                    goodMages.remove(i);
                    System.out.println("Good Mages just lost one of their kind!");
                }
            for (int i = 0; i < evilMages.size(); i++)
                if(evilMages.get(i).getHitPoints() <= 0)
                {
                    evilMages.remove(i);
                    System.out.println("Evil Mages just lost one of their kind!");
                }
        }
        if(goodMages.isEmpty()) System.out.println("Evil mages won!");
        else System.out.println("Good mages won!");
    }

    public static int mageInNeed(LinkedList<Mage> mages)
    {
        for (int i = 0; i < mages.size(); i++)
            if(mages.get(i).getHitPoints() < 20) return i;
        return -1;
    }
}