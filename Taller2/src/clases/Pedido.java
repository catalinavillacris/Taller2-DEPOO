package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Pedido {
	
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private Producto[] itemsPedido;
	private static File archivo;

	public Pedido(String nombre, String direccion, Producto[] itemsPedido) {
		// TODO Auto-generated constructor stub
		this.nombreCliente=nombre;
		this.direccionCliente=direccion;
		this.itemsPedido= itemsPedido;
		numeroPedidos ++;
		idPedido ++;	
		File archivo = new File("/Users/catalinavillacris/Desktop/DPOO/Taller2/Taller 2 - Hamburguesas_esqueleto/data/facturas.txt");

	}
	public int getIdPedido() {
		return idPedido;
	}
	public void agregarProducto (Producto nuevoItem) {
		
	}
	private int getPrecioNetoPedido() {
		int precio= itemsPedido.getPrecio();
		
		return precio;
	}
	private double getPrecioIva() {
		int neto= getPrecioNetoPedido();
		double iva= neto*(0.10);
		
		return iva;
		
	}
	private double getPrecioTotal() {
		int neto= getPrecioNetoPedido();
		double iva= getPrecioIva();
		
		return neto + iva;
	}
	private String generarTextoFactura() {
		
		int neto= getPrecioNetoPedido();
		double iva= getPrecioIva();
		double total= getPrecioTotal();
		
		String Factura = " Factura \n Productos \n ";
		
		for (Producto p : itemsPedido {
			Factura += (itemsPedido.getnombre() + "\n");
			
		}
			
		
		return null;
		
	}
	
	public void guardarFactura(File archivo) {
		BufferedWriter writer= new BufferedWriter(new FileWriter(this.archivo));
		writer.write(String Factura);
		writer.close();
		
	}
	
	

}
