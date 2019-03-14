

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;



public class Warehouse{
	
	public static TreeSet<Product> depozit = new TreeSet<Product>();
	
	public Warehouse()
	{
		this.depozit = new TreeSet<Product>();
	}

	public void adaugaInDepozit(Product p)
	{
		Iterator itr = depozit.iterator();
		Product q;
		int ok=0;
		while(itr.hasNext())
		{
			q = (Product) itr.next();
			if(q.getNumeProdus() == p.getNumeProdus())
			{
				q.setCantitate(p.getCantitate()+q.getCantitate());
				ok=1;
			}
		}
			if(ok==0)
			{
				depozit.add(p);
			}
	}
	
	
	
	public static Product getProdus(String x)
	{
		Iterator itr=depozit.iterator();
		Product q;
		while(itr.hasNext())
		{
			q = (Product) itr.next();
			if(q.getNumeProdus().equals(x)) return q;
		}
		return null;
	}
	
	
	public static int produsDisponibil(Product p, int x)
	{
		Iterator itr=depozit.iterator();
		Product q;
		while(itr.hasNext())
		{
			q = (Product) itr.next();
			if(q.getNumeProdus().equals(p.getNumeProdus()))
				{
				if(q.getCantitate()>=x)
				{
					q.setCantitate(q.getCantitate()-x);
					System.out.println(q.getCantitate());
					return 1;
				}
				else
				{ 
					return 0;
				}
				}	
		}
		return 0;
	}
	
	public void stocDepozit()
	{
		Iterator itr=depozit.iterator();
		Product q;
		while(itr.hasNext())
		{
			q = (Product) itr.next();
			System.out.println(q.getNumeProdus());
		}
	}
	
}
