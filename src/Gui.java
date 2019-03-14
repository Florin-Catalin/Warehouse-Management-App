

import java.awt.Component; 
import java.awt.Dimension; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Iterator;


public class Gui extends JFrame{
	
	private JFrame fereastraPrincipala;
	private JPanel panel, panelClienti, panelDepozit, panelOptiuni;
	private JTextField fieldNume, fieldAdresa, fieldNumar, fieldProdusComanda, fieldCantitateComanda;
	private JTextField fieldProdusDepozit, fieldCantitateDepozit, fieldPret,fieldProdusCautare; 
	private JLabel labelCautare,l1,l2,labelNume, labelAdresa, labelNumar, labelProdusComanda, labelCantitateComanda, labelProdusDepozit, labelCantitateDepozit,labelPret;
	private JButton btnAdaugareComanda, btnReset;
	private JButton btnStock, btnUnderStock, btnOverStock;
	private JButton btnAdaugareDepozit, btnCautare, btnStergere;
	private JTable tabelClienti, tabelDepozit;
	private JScrollPane scrollW,scrollC;
	private JComboBox comboProduse;
	Object data[][] ;
	 Object numeColoanaDepozit[] = { "Produs", "Pret/bucata", "Cantitate"};   
	 private   DefaultTableModel modelDepozit;
	 Object numeColoanaComenzi[] = { "Nume", "Adresa", "Telefon","Pret" };   
	 private   DefaultTableModel modelComenzi;
	 private Warehouse w;
	 OpDep opdep;
	
	public Gui() throws Exception
	{
		opdep = new OpDep(new Warehouse());
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse1","root","");
        PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from products");
        ResultSet result2 = statement.executeQuery();

       
		fereastraPrincipala = new JFrame("Management comenzi");
		fereastraPrincipala.setVisible(true);
		fereastraPrincipala.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fereastraPrincipala.setPreferredSize(new Dimension(1300,500));
		fereastraPrincipala.setResizable(true);
		
		
		panel = new JPanel();
		panelClienti = new JPanel();
		panelDepozit = new JPanel();
		panelOptiuni = new JPanel();
		
		comboProduse = new JComboBox();
		 fieldNume = new JTextField();
		 fieldAdresa = new JTextField();
		 fieldNumar = new JTextField();
		 fieldProdusComanda = new JTextField();
		 fieldCantitateComanda = new JTextField();
		 fieldProdusDepozit = new JTextField();
		 fieldCantitateDepozit = new JTextField();
		 fieldPret = new JTextField(); 
		 fieldProdusCautare = new JTextField();
		
		 l1 = new JLabel("Adauga produs in depozit");
		 l2 = new JLabel("Cauta produs in depozit");
		 labelNume = new JLabel("Nume");
		 labelAdresa = new JLabel("Adresa");
		 labelNumar = new JLabel("Telefon");
		 labelProdusComanda = new JLabel("Produs");
		 labelCantitateComanda = new JLabel("Cantitate"); 
		 labelProdusDepozit = new JLabel("Produs");
		 labelCantitateDepozit = new JLabel("Cantitate");
		 labelPret = new JLabel("Pret");
		 labelCautare = new JLabel("Produs");
		 
		 btnAdaugareComanda = new JButton("Adauga");
		 btnReset = new JButton("Reset");
		 btnStock = new JButton("Stock");
		 btnUnderStock = new JButton("Under-stock");
		 btnOverStock = new JButton("Over-stock");
		 btnAdaugareDepozit = new JButton("Adaugare");
		 btnCautare = new JButton("Cautare");
		 btnStergere = new JButton("Stergere");
		
		 panel.setLayout(null);
		 panelClienti.setLayout(null);
		 panelDepozit.setLayout(null);
		 panelOptiuni.setLayout(null);
		
		 labelNume.setBounds(25, 100, 250, 25);
		 panel.add(labelNume);
		 fieldNume.setBounds(90, 100, 200, 25);
		 panel.add(fieldNume);
		 labelAdresa.setBounds(25, 140, 250, 25);
		 panel.add(labelAdresa);
		 fieldAdresa.setBounds(90, 140, 200, 25);
		 panel.add(fieldAdresa);
		 labelNumar.setBounds(25, 180, 250, 25);
		 panel.add(labelNumar);
		 fieldNumar.setBounds(90, 180, 200, 25);
		 panel.add(fieldNumar);
		 labelProdusComanda.setBounds(25, 220, 250, 25);
		 panel.add(labelProdusComanda);
		 comboProduse.setBounds(90, 220, 200, 25);
		 panel.add(comboProduse);
		 labelCantitateComanda.setBounds(25, 260, 250, 25);
		 panel.add(labelCantitateComanda);
		 fieldCantitateComanda.setBounds(90, 260, 200, 25);
		 panel.add(fieldCantitateComanda);
		 btnAdaugareComanda.setBounds(80, 320, 80, 25);
		 panel.add(btnAdaugareComanda);
		 btnReset.setBounds(180, 320, 80, 25);
		 panel.add(btnReset);
		 
		 
		 modelComenzi=new DefaultTableModel(data,numeColoanaComenzi);
		 tabelClienti = new JTable(modelComenzi);
		 scrollC = new JScrollPane(tabelClienti);
		 scrollC.setBounds(325, 100, 250, 250);
		 panel.add(scrollC);
		 
		 
		 btnStock.setBounds(600,100,80,25);
		 panel.add(btnStock);
		 btnUnderStock.setBounds(680,100,120,25);
		 panel.add(btnUnderStock);
		 btnOverStock.setBounds(800,100,100,25);
		 panel.add(btnOverStock);
		 
		 modelDepozit = new DefaultTableModel(data,numeColoanaDepozit);
		 tabelDepozit = new JTable(modelDepozit);
		 scrollW = new JScrollPane(tabelDepozit);
		 scrollW.setBounds(600, 140, 300, 250);
		 panel.add(scrollW);
		 
		 l1.setBounds(1000,40,150,25);
		 panel.add(l1);
		 
		 labelProdusDepozit.setBounds(950,100,100,25);
		 panel.add(labelProdusDepozit);
		 fieldProdusDepozit.setBounds(1010, 100, 200, 25);
		 panel.add(fieldProdusDepozit);
		 labelPret.setBounds(950,140,100,25);
		 panel.add(labelPret);
		 fieldPret.setBounds(1010, 140, 200, 25);
		 panel.add(fieldPret);
		 labelCantitateDepozit.setBounds(950,180,100,25);
		 panel.add(labelCantitateDepozit);
		 fieldCantitateDepozit.setBounds(1010, 180, 200, 25);
		 panel.add(fieldCantitateDepozit);
	     
		 btnAdaugareDepozit.setBounds(1045, 230, 100, 25);
		 panel.add(btnAdaugareDepozit);
		 
		 l2.setBounds(1000,280,150,25);
		 panel.add(l2);
		 labelCautare.setBounds(950,320,100,25);
		 panel.add(labelCautare);
		 fieldProdusCautare.setBounds(1010, 320, 200, 25);
		 panel.add(fieldProdusCautare);
		 
		 btnCautare.setBounds(1045, 370, 100, 25);
		 panel.add(btnCautare);
		 btnStergere.setBounds(1045, 410, 100, 25);
		 panel.add(btnStergere);
		
		 fereastraPrincipala.add(panel);
		
		 
		 while(result2.next())
	        {
	        	Product q = new Product(result2.getString(1),result2.getFloat(2),result2.getInt(3));
	        	comboProduse.addItem(result2.getString(1));
	        	Warehouse.depozit.add(q);
	        	
	        	
	        }
		
		 
		 btnAdaugareComanda.addActionListener(new ActionListener(){
	    		
				public void actionPerformed(ActionEvent e) {
	    			
	    			Statement stm = null;
	    			try{
	    		        stm = (Statement) con.createStatement();    
	    		        System.out.println(Warehouse.depozit.size());
	    		        int ok=0;
	    		        float pret=1;
	    		       int c=0;
	    		       c=Integer.parseInt(fieldCantitateComanda.getText());
	    		      
	    		      Product p = new Product(comboProduse.getSelectedItem().toString(),0,c);
	    		       Product z;
	    		      if(Warehouse.produsDisponibil(p,c )==1){
	    		    	  z = Warehouse.getProdus(p.getNumeProdus());
	    		    	  pret = z.getPret()*Integer.parseInt(fieldCantitateComanda.getText());
	    		    	  System.out.println(p.getCantitate());
	    		        stm.executeUpdate("insert into comenzi (Nume, Adresa, Telefon, Pret) values ('"+fieldNume.getText()+"','"+fieldAdresa.getText()+"','"+fieldNumar.getText()+"','"+pret+"')");
	    		       JOptionPane.showMessageDialog(null, "Comanda a fost procesata cu succes");
	    		      } 
	    		       PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from comenzi");
	    		        ResultSet result = statement.executeQuery();
	    		        modelComenzi.setRowCount(0);
	    		        
	    		        while(result.next())
	    		        {
	    		        	float d4;
	    		        	String d1, d2, d3;	
	    		        	d1 = result.getString("Nume");
	    		        	d2 = result.getString("Adresa");
	    		        	d3 = result.getString("Telefon");
	    		        	d4 = result.getFloat("Pret");	             
	    		           modelComenzi.addRow(new Object[]{d1,d2,d3,d4});
	    		          // System.out.println(result.getString(1)+ " " + result.getString(2)+ " " + result.getString(3));
	    		      	        	
	    		        }
	    		        	
	    		        result.close();
	    		        //con.close();
	    		        
	    			}catch(Exception ex){
	    				
	    			}
	    			
	    		}	    	    
	    	});
		 
		 
		 
		 btnAdaugareDepozit.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e) {
	    			
	    			//Connection con = null;
	    			Statement stm = null;
	    			try{
						
	    				 stm = (Statement) con.createStatement();   
	    				 PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from Depozit");
		    		        ResultSet result = statement.executeQuery();
		    		        modelDepozit.setRowCount(0);
		    		        int ok=0;
		    		        int c;
		    		        while(result.next())
		    		        {
		    		        	String d1, d2, d3;
		    		        	
		    		        	d1 = result.getString("Produs");
		    		        	d2 = result.getString("Pret");
		    		        	d3 = result.getString("Cantitate");
		    		        	
		    		        	if(fieldProdusDepozit.getText().equals(d1)) 
		    		        	{
		    		        		System.out.println("000000000000");
		    		        		c = result.getInt("Cantitate")+ Integer.parseInt(fieldCantitateDepozit.getText());
		    		        		ok=1;
		    		        		String a = fieldPret.getText();
		    		        		String b = fieldProdusDepozit.getText();
		    		        		 stm.executeUpdate("update depozit set pret = "+fieldPret.getText()+", Cantitate = "+c+" where Produs = '"+fieldProdusDepozit.getText()+"'");
		    		        		 JOptionPane.showMessageDialog(null, "Produsul a fost modificat cu succes");
		    		        	}
		    		        }
		    		        if(ok==0){
		    		        stm.executeUpdate("insert into depozit (Produs, Pret, Cantitate) values ('"+fieldProdusDepozit.getText()+"','"+fieldPret.getText()+"','"+fieldCantitateDepozit.getText()+"')");
	    		       JOptionPane.showMessageDialog(null, "Produsul a fost adaugat cu succes");
		    		        }
	    		        String produs = fieldProdusDepozit.getText();
	    		        int pret = Integer.parseInt(fieldPret.getText());
	    		        int cantitate = Integer.parseInt(fieldCantitateDepozit.getText());
	    		        Product p = new Product(produs,pret,cantitate);
	    		      
	    		        //con.close();
	    		        
	    			}catch(Exception ex){
	    				
	    			}
	    			
	    		}	    	    
	    	});
		 
		 
		 
		
		 
		 
		 
		 btnStock.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e) {
	    			try{
	    				//System.out.println(Warehouse.depozit.size());
	    		        PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from Depozit");
	    		        ResultSet result = statement.executeQuery();
	    		        modelDepozit.setRowCount(0);
	    		        
	    		        while(result.next())
	    		        {
	    		        	String d1, d2, d3;
	    		        	
	    		        	d1 = result.getString("Produs");
	    		        	d2 = result.getString("Pret");
	    		        	d3 = result.getString("Cantitate");
	    		        	
	    		        	Product y = new Product(result.getString(1),result.getFloat(2),result.getInt(3));
	    		        	Warehouse.depozit.add(y);
	    		        	//adaugaInDepozit(y);
	    		             
	    		            modelDepozit.addRow(new Object[]{d1,d2,d3});
	    		        	//tabelDepozit.add((Component) result.getObject(1));
	    		        	
	    		        	//System.out.println(result.getString(1)+ " " + result.getInt(2)+ " " + result.getInt(3));	    		        	
	    		        }
	    		        Iterator itr =  Warehouse.depozit.iterator();
	    		        System.out.println(Warehouse.depozit.size());
	    		        Product q;
	    		        while(itr.hasNext())
	    		        {  
	    		        	q = (Product) itr.next();
	    		        	System.out.println(q.getNumeProdus());
	    		        	System.out.println(q.getCantitate());
	    		        }
	    		       // con.close();
	    		        result.close();
	    			}catch(Exception ex){
	    				
	    			}
	    			
	    		}	    	    
	    	});
		 
		 
		 btnOverStock.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e) {
	    			
	    			System.out.println(Warehouse.depozit.size());
	    			try{
		    			Class.forName("com.mysql.jdbc.Driver");
	    		        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root","");
	    		        PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from Depozit");
	    		        ResultSet result = statement.executeQuery();
	    		        
	    		        
	    		        modelDepozit.setRowCount(0);
	    		        while(result.next())
	    		        {
	    		        	int d;
	    		        	
	    		        	String d1, d2;
	    		        	
	    		        	d = result.getInt("Cantitate");
	    		        	d1 = result.getString("Produs");
	    		        	d2 = result.getString("Pret");
	    		        	
	    		        	
	    		        	if(d>=50)
	    		        		modelDepozit.addRow(new Object[]{d1,d2,d});
	    		        }
	    		        
		    			}catch(Exception ex)
		    			{
		    				
		    			}
		    			
	    			
	    			
	    		}	    	    
	    	});
		 
		 btnUnderStock.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e) {
	    			
	    			try{
	    			//Class.forName("com.mysql.jdbc.Driver");
    		       // Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root","");
    		        PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from Depozit");
    		        ResultSet result = statement.executeQuery();
    		        
    		        
    		        modelDepozit.setRowCount(0);
    		        while(result.next())
    		        {
    		        	int d;
    		        	
    		        	String d1, d2;
    		        	
    		        	d = result.getInt("Cantitate");
    		        	d1 = result.getString("Produs");
    		        	d2 = result.getString("Pret");
    		        	
    		        	
    		        	if(d<50)
    		        		modelDepozit.addRow(new Object[]{d1,d2,d});
    		        }
    		        
	    			}catch(Exception ex)
	    			{
	    				
	    			}
	    			
	    		}	    	    
	    	});
		 
		 btnCautare.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e) {
	    			
	    			try{
	    		Class.forName("com.mysql.jdbc.Driver");
 		       Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root","");
 		        PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from depozit");
 		        ResultSet result = statement.executeQuery();
 		        
 		        int ok=0;
 		        modelDepozit.setRowCount(0);
 		        while(result.next())
 		        {
 		        	int d;
 		        	
 		        	String d1;
					float d2;
 		        	
 		        	d1 = result.getString("Produs");
 		        	d2 = result.getFloat("Pret");
 		        	
 		        	d = result.getInt("Cantitate");
 		        	if(d1.equals(fieldProdusCautare.getText()))
 		        	{
 		        		modelDepozit.addRow(new Object[]{d1,d2,d});
 		        		ok=1;
 		        	}
 		        }
 		        if(ok==0)
 		        	JOptionPane.showMessageDialog(null, "Produsul nu mai este in stoc");
 		        
	    			}catch(Exception ex)
	    			{
	    				
	    			}
	    			
	    		}	    	    
	    	});
		 
		
		 
		 btnStergere.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e) {
	    			Statement stm = null;
	    			try{
	    		Class.forName("com.mysql.jdbc.Driver");
		       Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root","");
		       stm = (Statement) con.createStatement();    
		       String nume = modelDepozit.getValueAt(0, 0).toString();
		       System.out.println(nume);
		        stm.executeUpdate("delete from depozit where produs = '"+nume+"'");
	    			}catch(Exception ex)
	    			{
	    				
	    			}
	    			
	    		}	    	    
	    	});
		 
		 
		 
		 fereastraPrincipala.pack();
		 fereastraPrincipala.repaint();
		 fereastraPrincipala.validate();
		
	}

}
