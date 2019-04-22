package banco;

import java.util.ArrayList;

public class Banco {
	private static ArrayList<Cuenta> ListaCuentas = new ArrayList<Cuenta>();
	

	public static void AgregarCuenta(int id) {
		ListaCuentas.add(new Cuenta(id));
	}
	
	public static ArrayList<Cuenta> getListaCuentas() {
		return ListaCuentas;
//		for(int i = 0; i < ListaCuentas.size(); i++) {
//			System.out.println(ListaCuentas.get(i).getId());
//		}
	}
	
	public static void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
		ListaCuentas = listaCuentas;
	} 
	
	
}
