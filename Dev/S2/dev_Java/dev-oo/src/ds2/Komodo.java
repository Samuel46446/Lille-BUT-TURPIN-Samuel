package ds2;

import java.util.ArrayList;
import java.util.List;

public class Komodo
{
    private List<Dragon> population = new ArrayList<>();

    public void add(Dragon d)
    {
        this.population.add(d);
    }

    public void remove(Dragon dr)
    {
        this.population.remove(dr);
    }

    public void remove(String name)
    {
        this.population.remove(search(name));
    }

    public Dragon search(String name)
    {
        for(Dragon drag : this.population)
        {
            if(drag.getNAME().equals(name))
            {
                System.out.println("Dragon found");
                return drag;
            }
        }
        System.out.println("Dragon not found");
        return null;
    }
}