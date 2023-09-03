package modelo;

import java.util.ArrayList;

public class Combo implements Producto {
	
	private double descuento;
	private String nombre;
	private ArrayList<Producto> itemsCombo;
	
	public Combo (double descuento,String nombre,ArrayList<Producto> items) {
		this.nombre=nombre;
		this.descuento=descuento;
		this.itemsCombo=items;
	}
	
	public void agregarItemACombo(Producto item) {
		this.itemsCombo.add(item);
	}
	
	public double getPrecio() {
		int precio=0;
		for (Producto item:itemsCombo) {
			precio += item.getPrecio();
		}
		return precio *= this.descuento;
	} 
	
	public String generarTextoFactura () {
		String factura = "";
		factura += this.nombre;
		for (Producto item:this.itemsCombo) {
			factura+=item.getNombre()+"		";
			factura+=String.valueOf(item.getPrecio())+"\n";
		}
		factura +="DESCUENTO		" + String.valueOf(this.descuento)+"\n";
		factura +="PRECIO		" + String.valueOf(getPrecio())+"\n";
		
		return factura;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

}
