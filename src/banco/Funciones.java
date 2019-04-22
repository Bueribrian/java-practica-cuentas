package banco;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Funciones {

	static public boolean isNumeric(String cadena) {
		boolean resultado;
		
		try{
			Integer.parseInt(cadena);
			resultado = true;
		}
		catch(NumberFormatException exception){
			resultado = false;
		}
		
		return resultado;
	}
	
	static public boolean searchId(int id, String message) {
		ArrayList<Cuenta> cuentas= Banco.getListaCuentas();
		for(Cuenta cuenta: cuentas) {
			if(cuenta.getId() == id) {
				JOptionPane.showMessageDialog(null, message);
				return true;
			}
		}
		return false;
		
	}
	static public Cuenta searchCuenta(int id) {
		Cuenta cuentaR = null;
		ArrayList<Cuenta> cuentas= Banco.getListaCuentas();
		for(Cuenta cuenta: cuentas) {
			if(cuenta.getId() == id) {
				cuentaR = cuenta;
				break;
			}
		}
		return cuentaR;
	}
}
