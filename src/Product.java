
public class Product implements Comparable{
	
	private String numeProdus;
	private float pret;
	private int cantitate;
	
	
	public Product(String nume, float pret, int cantitate)
	{
		this.numeProdus=nume;
		this.pret=pret;
		this.cantitate=cantitate;
	}
	
	public void setNumeProdus(String x)
	{
		numeProdus=x;
	}
	
	public String getNumeProdus()
	{
		return numeProdus;
	}
	
	public void setPret(float x)
	{
		pret=x;
	}
	
	public float getPret()
	{
		return pret;
	}
	
	public void setCantitate(int x)
	{
		cantitate=x;
	}

	public int getCantitate()
	{
		return cantitate;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 1;
	}
}
