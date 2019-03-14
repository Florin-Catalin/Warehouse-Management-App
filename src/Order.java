

import java.util.ArrayList;

public class Order {
	
	private float pretTotal;
	private ArrayList<Product> listaProduse;

	public Order()
	{
		listaProduse = new ArrayList<Product>();
	}
	
	public void adaugaProdus(Product x)
	{
		listaProduse.add(x);
		pretTotal = pretTotal+x.getCantitate()*x.getPret();
	}
	
	
	public ArrayList<Product> getListaProduse()
	{
		return listaProduse;
	}
	
	public float getPretTotal()
	{
		return pretTotal;
	}


	
	
}
