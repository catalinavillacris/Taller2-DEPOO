package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurante {

	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Producto> menu;
	private ArrayList<Producto> bebidas;
	private ArrayList<Combo> combos;
	private Pedido curso;

	public Restaurante() {
		this.ingredientes = new ArrayList<Ingrediente>() ;
		this.menu = new ArrayList<Producto>();
		this.bebidas = new ArrayList<Producto>();
		this.combos = new ArrayList<Combo>();
	}

	public void iniciarPedido(String nombre, String direccion) {
		this.curso = new Pedido(nombre, direccion);

	}

	public Pedido getPedidoEnCurso() {
		return this.curso;
	}

	public boolean cerrarYGuardarPedido(File archivo) {
		curso.guardarFactura(archivo);
		boolean equal=curso.equals(curso);
		curso.guardarPedido(curso);
		this.curso = null;
		
		return equal;
	}

	public ArrayList<Producto> getMenuBase() {
		return this.menu;
	}

	public ArrayList<Combo> getMenuCombos() {
		return this.combos;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public void cargarInformacionRestaurante (File archivoIngredientes,File archivoCombos, File archivoMenu,File bebidas) throws IOException {
		cargarMenu( archivoMenu);
		cargarIngredientes( archivoIngredientes);
		cargarCombos( archivoCombos);
		cargarBebidas(bebidas);
		
	}

	private void cargarIngredientes(File archivoIngredientes) throws IOException {
		try {
			FileReader fr=new FileReader(archivoIngredientes);
			BufferedReader br =new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null) {
				String[] info= linea.split(";");
				Ingrediente ingrediente = new Ingrediente(info[0],Integer.parseInt(info[1]));
				this.ingredientes.add(ingrediente);
			}
		br.close();
		} catch (FileNotFoundException e) {
			System.out.println("\nNo se encontro el archivo");
			e.printStackTrace();
		}

	}
	
	private void cargarMenu(File archivoMenu) throws  IOException {
		
		try {
			FileReader fr=new FileReader(archivoMenu);
			BufferedReader br =new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null) {
				String[] info= linea.split(";");
				ProductoMenu producto= new ProductoMenu(info[0],Double.parseDouble(info[1]),Integer.parseInt(info[2]));
				this.menu.add(producto);
				}
			br.close();
			}catch (FileNotFoundException e) {
				System.out.println("\nNo se encontro el archivo");
				e.printStackTrace();
			}

		
	}
	
	private void cargarBebidas(File bebidas) throws IOException{
		
			
			try {
				FileReader fr=new FileReader(bebidas);
				BufferedReader br =new BufferedReader(fr);
				String linea;
				while((linea=br.readLine())!=null) {
					String[] info= linea.split(";");
					ProductoMenu producto= new ProductoMenu(info[0],Double.parseDouble(info[1]),Integer.parseInt(info[2]));
					this.bebidas.add(producto);
					}
				br.close();
				}catch (FileNotFoundException e) {
					System.out.println("\nNo se encontro el archivo");
					e.printStackTrace();
				}

			
		}

	
		
	private void cargarCombos(File archivoCombos) throws IOException {
		try {
			FileReader fr=new FileReader(archivoCombos);
			BufferedReader br =new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null) {
				String[] info= linea.split(";");
				String[] descuento = info[1].split("%");
				ArrayList<Producto> items =new ArrayList<Producto>();
				ArrayList<Producto> menu= getMenuBase();
				ArrayList<Producto> bebidas= this.bebidas;
				
				for (int i=2;i<=info.length-2;i=i+1) {
					for (Producto p:menu) {
						if(info[i].equals(p.getNombre())) {
							items.add(p);
						}
					}
					for (Producto p:bebidas) {
						if(info[i].equals(p.getNombre())) {
							items.add(p);
						}
				}
				Combo combo = new Combo(Integer.parseInt(descuento[0]),info[0],items);
				this.combos.add(combo);
			}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("\nNo se encontro el archivo");
			e.printStackTrace();
		}
	}
	}
		
