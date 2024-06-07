package tp04;

import tpOO.tp04.PendingCase;

public class PendingCaseQueue
{
    public static int CAPACITY = 10;
    private PendingCase[] tableur;

    public PendingCaseQueue()
    {
        this.tableur = new PendingCase[CAPACITY];
    }

    public PendingCase removeOne()
    {
        PendingCase pc = null;
        for(int i = 0; i < this.tableur.length; i++)
        {
            if(this.tableur[i] != null)
            {
                this.tableur[i] = pc;
                break;
            }
        }
        return pc;
    }

    public void clear()
    {
        PendingCase pc = null;
        for(int i = 0; i < this.tableur.length; i++)
        {
            if(this.tableur[i] != null)
            {
                this.tableur[i] = pc;
            }
        }
    }

    public void cheating(PendingCase another, int position)
    {
        if(!isFull() && this.tableur[position] == null)
        {
            for(int i = 0; i < this.tableur.length; i++)
            {
                if(this.tableur[i] == another)
                {
                    this.tableur[i] = null;
                    break;
                }
            }
            this.tableur[position] = another;
        }
    }

    public double getTotalAmount()
    {
        double db = 0.0;
        for(PendingCase c : this.tableur)
        {
            if(c != null)
            {
                db = db + c.getAmount();
            }
        }
        return db;
    }

    public void addOne(PendingCase other)
    {
        if(!isFull())
        {
            for(int i = 0; i < this.tableur.length; i++)
            {
                if(this.tableur[i] == null)
                {
                    this.tableur[i] = other;
                    break;
                }
            }
        }
    }


    public boolean isEmpty()
    {
        int compteur = 0;
        for(PendingCase c : this.tableur)
        {
            if(c == null)
            {
                compteur = compteur + 1;
            }
        }
        return this.tableur.length == compteur;
    }

    public int size()
    {
        return CAPACITY;
    }

    public boolean isFull()
    {
        int compteur = 0;
        for(PendingCase c : this.tableur)
        {
            if(c != null)
            {
                compteur = compteur + 1;
            }
        }
        return CAPACITY == compteur;
    }

    @Override
    public String toString()
    {
        String str = "";
        for(int i = 0; i < CAPACITY; i++)
        {
            if(this.tableur[i] != null)
            {
                str=str+this.tableur[i].getCompany()+" ";
            }
        }
        return str;
    }
}