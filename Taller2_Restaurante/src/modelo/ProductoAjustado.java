package modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	
	private Producto base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	public ProductoAjustado(Producto base, ArrayList<Ingrediente> agregados,ArrayList<Ingrediente> eliminados) {
		this.base=base;
		this.agregados=agregados;
		this.eliminados=eliminados;
	}
	
	public String getNombre() {
		return this.base.getNombre()+" Ajustado";
	}
	
	public double getPrecio() {
		double precio=this.base.getPrecio();
		if (agregados.isEmpty()) {
		return precio;
		}else {
			for(Ingrediente add:agregados) {
				precio += add.getCostoAdicional();
			}
		return precio;	
		}
	}
	
	public String generarTextoFactura() {
		String factura="";
		factura += getNombre()+"	";
		factura += String.valueOf(base.getPrecio())+"\n";
		
		if (this.agregados!=null) {
			for (Ingrediente item:this.agregados) {
				factura+=item.getNombre()+"		";
				factura+=String.valueOf(item.getCostoAdicional())+"\n";
			}
		}else if (this.eliminados!=null) {
			for (Ingrediente item:this.eliminados)
				factura+=item.getNombre()+"\n";
		}
		factura +="PRECIO		" + String.valueOf(getPrecio())+"\n";
		
		return factura;
	}

	@Override
	public int getCalorias() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
