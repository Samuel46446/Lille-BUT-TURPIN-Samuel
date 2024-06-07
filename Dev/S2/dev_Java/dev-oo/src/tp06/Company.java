package tp06;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Company
{
    public static final List<Employee> EMPLOYEES = new ArrayList<>();
    
    public void addEmployee(Employee e)
    {
        EMPLOYEES.add(e);
    }

    public void supprEmployee(int i)
    {
        EMPLOYEES.remove(i);
    }

    public void supprEmployee(Employee e)
    {
        EMPLOYEES.remove(e);
    }

    public int getNbEmployee()
    {
        return EMPLOYEES.size();
    }

    private int getNumbClass(Object c)
    {
        int nb = 0;

        for(int i = 0;i<=EMPLOYEES.size();i++)
        {
            if(EMPLOYEES.get(i).getClass() == c)
            {
                nb=nb+1;
            }
        }
        return nb;
    }

    public int getNbSalesPerson()
    {
        return getNumbClass(Salesperson.class);
    }

    public int getNbWorker()
    {
        return getNumbClass(Worker.class);
    }

    public void firing(LocalDate fatefulDate)
    {
        for(int i = 0;i<=EMPLOYEES.size();i++)
        {
            if(EMPLOYEES.get(i).getHiringDate().toString().equals(fatefulDate.toString()))
            {
                EMPLOYEES.remove(i);
            }
        }
    }

    public void firing()
    {
        for(int i = 0;i<=EMPLOYEES.size();i++)
        {
            if(EMPLOYEES.get(i).objectiveFulfilled())
            {
                EMPLOYEES.remove(i);
            }
        }
    }

    @Override
    public String toString()
    {
        return "Class Company.java";
    }
}