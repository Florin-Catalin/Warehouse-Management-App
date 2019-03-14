

public class Customer {
	
	
	private String nume;
	private String adresa;
	private String telefon;
	
	public Customer(String nume, String adresa, String telefon)
	{
		this.nume=nume;
		this.adresa=adresa;
		this.telefon=telefon;
	}
	
	public void setNume(String x)
	{
		nume=x;
	}
	
	public String getNume()
	{
		return nume;
	}
	
	public void setAdresa(String x)
	{
		adresa=x;
	}
	
	public String getAdresa()
	{
		return adresa;
	}
	
	public void setTelefon(String x)
	{
		telefon=x;
	}
	
	public String getTelefon()
	{
		return telefon;
	}
	
}
