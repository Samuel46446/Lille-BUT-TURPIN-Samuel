package tp08;

import java.time.LocalDate;
import java.util.ArrayList;

public class Shop
{
    private ArrayList<Shelf> shop;

    public Shop() {}

    public Shop(ArrayList<Shelf> s)
    {
        this.shop=s;
    }

    public ArrayList<Shelf> getShelving()
    {
        return this.shop;
    }

    public void tidy(ArrayList<IProduct> aStock)
    {
        for(int i = 0; i < shop.size(); i++)
        {
            for(int j = 0; j < aStock.size(); j++)
            {
                if(shop.get(i).isRefrigerated() && !shop.get(i).isFull() && aStock.get(i).isPerishable())
                {
                    shop.get(i).add(aStock.get(i));
                }
                else
                {
                    shop.get(i).add(aStock.get(i));
                }
            }
        }
    }

    public ArrayList<Food> closeBestBeforeDate(int nbDays)
    {
        ArrayList<Food> funked = new ArrayList<>();

        for(int i = 0; i < shop.size(); i++)
        {
            if(shop.get(i).getFood(i).isNotRotten(LocalDate.now()))
            {

            }
        }
        return funked;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}