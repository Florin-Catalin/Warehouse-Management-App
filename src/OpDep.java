

import java.util.TreeSet;


public class OpDep {
	
	private TreeSet<Order> comenzi;
	private Warehouse depozit;
	
	public OpDep(Warehouse depozit)
	{
		comenzi = new TreeSet<Order>();
		this.depozit = depozit;
	}
	
	public void adaugaComanda(Order co)
	{
		comenzi.add(co);
	}
	
	public int disponibilitateProdus(Product produs, int cantitate)
	{
		if(depozit.produsDisponibil(produs, cantitate)!=0)
		{
			return 1;
		}
		return 0;
	}
	
public Warehouse getDepozit(){
		
		return depozit;
	}
	
	

}
