package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Pedido {
	
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> items;
	
	public Pedido(String nombre, String direccion) {
		
		numeroPedidos++;
		Random id= new Random();
		int rand_id = id.nextInt(1000);
		this.idPedido=rand_id;
		this.nombreCliente=nombre;
		this.direccionCliente=direccion;
	}
	
	public int getIdPedido() {
		return this.idPedido;
	}
	
	public void agregarProducto(Producto nuevoItem) {
		this.items.add(nuevoItem);
	}
	
	private int getPrecioNetoPedido() {
		int precio=0;
		
		for (Producto item:this.items)
			precio+=item.getPrecio();
		
		return precio;
	}
	
	private double getPrecioIvaPedido() {
		return getPrecioNetoPedido() * 0.19;
	}
	
	private double getPrecioTotalPedido() {
		return getPrecioNetoPedido() + getPrecioIvaPedido();
	}
	
	public String generarTextoFactura () {
		String factura="";
		factura += "ID FACTURA " + String.valueOf(idPedido) + "\n";
		for (Producto item: this.items){
			factura += item.generarTextoFactura() + "\n";
		}
		factura +="BASE		" + String.valueOf(getPrecioNetoPedido())+"\n";
		factura +="IVA		" + String.valueOf(getPrecioIvaPedido())+"\n";
		factura +="TOTAL		" + String.valueOf(getPrecioTotalPedido())+"\n";
		return factura;
	}
	
	public void guardarFactura(File archivo) {
		try {
		    BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.getName(), true));
		    writer.append(generarTextoFactura());		    
		    writer.close();
		}
		catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}
	
	public String toString() {
		int id=this.idPedido;
		String productos=null;
		for (Producto i:this.items) {
			productos += i.generarTextoFactura() + "\n";
		}
		return id + "\n" + this.nombreCliente + "\n"  +this.direccionCliente + "\n" + productos;
	}

}
