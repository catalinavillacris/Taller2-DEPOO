package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Restaurante {
	
	private ProductoMenu[] menuBase;
	private Ingrediente[] ingredientes;
	private Combo[] combos;
	

	public Restaurante() {
		// TODO Auto-generated constructor stub
	}
	public void iniciarPedido(String nombre, String direccion, Producto itemPedido) {
		
	}
	public void cerrarYguardarPedido() {
		
	}
	public Pedido getPedidoEnCurso () {
		
		return null;
	}
	public Producto[] getMenuBase() {
		return menuBase;
	}
	public Ingrediente[] getIngrediente () {
		return null;
	}
	public void cargarInformacionRestaurante() {
		cargarIngredientes();
		cargarMenu ();
		cargarCombos ();
	}
	private void cargarIngredientes() {
		FileReader archivoIngredientes=new FileReader ("/Users/catalinavillacris/Desktop/DPOO/Taller2/Taller 2 - Hamburguesas_esqueleto/data/ingredientes.txt");
		BufferedReader br= new BufferedReader (archivoIngredientes);
		HashMap<String,Integer> ingred= new HashMap<String,Integer>();
		String line= br.readLine();
		
		while (line != null) {
			String[] ing =line.split(";");
			ingred.put(ing[0], Integer.valueOf(ing[1]));
			line= br.readLine();	
		}
		br.close();
		
		ingredientes= Ingrediente[ingred.size()];
		
		for (String i: (ingred.keySet())) {
			Ingredientes ingredientes= new Ingrediente(i,(ingred.get(i)));
		}
	}
	private void cargarMenu () {
		
		FileReader archivoMenu= new FileReader ("/Users/catalinavillacris/Desktop/DPOO/Taller2/Taller 2 - Hamburguesas_esqueleto/data/menu.txt");
		BufferedReader br= new BufferedReader (archivoMenu);
		HashMap<String,Integer> menu= new HashMap<String,Integer>();
		String line= br.readLine();
		
		while (line != null) {
			String[] ing =line.split(";");
			menu.put(ing[0], Integer.valueOf(ing[1]));
			line= br.readLine();	
		}
		br.close();
		
		menuBase = ProductoMenu[menu.size()];
		
		for (String i: (menu.keySet())) {
			ProductoMenu menuBase= new ProductoMenu(i,(menu.get(i)));
		}
		
	}
	private void cargarCombos () {
		
		FileReader archivoCombos= new FileReader ("/Users/catalinavillacris/Desktop/DPOO/Taller2/Taller 2 - Hamburguesas_esqueleto/data/combos.txt");
		BufferedReader br= new BufferedReader (archivoCombos);
		HashMap<String,String> comb= new HashMap<String,String>();
		String line= br.readLine();
		
		while (line != null) {
			String[] ing =line.split(";",2);
			comb.put(ing[0], ing[1]);
			line= br.readLine();	
		}
		br.close();
		
		combos = Combo[comb.size()];
		
			for (String i: (comb.keySet())) {
				String[] info = (comb.get(i)).split(";");
				double descuento= (Integer.valueOf(info[0].strip()))/100;
				
				Combo combos= new Combo(i,descuento);
				}
		
	}
}
