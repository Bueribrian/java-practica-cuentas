package banco;

import banco.Funciones; 
import banco.Banco; 
import banco.Cuenta; 
import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 * La aplicacion va a tener 3 opciones principales
 * --Crear cuenta
 * 		crea la cuenta con un id
 * --Ingresar a cuenta
 * 		ingresa a la cuenta con un id y despliega 2 nuevas opciones
 *  	-- Retirar dinero
 *  	-- Depositar dinero
 
 * --Salir
 * 
 * 
 */

public class aplicacion {
	public static void main(String[] args) {
		Banco.AgregarCuenta(2222);
		Banco.AgregarCuenta(3425);
		Banco.AgregarCuenta(2425);
		boolean running = true;
		int opcion;
		
		while(running) {
			String panel = JOptionPane.showInputDialog("Bievenido al banco digite la operacion a realizar \n -1 Crear cuenta. \n -2 Ingresar a cuenta. \n -3 Salir.");
			if(panel == null) {
				JOptionPane.showMessageDialog(null, "Saliendo...");
				running = false;
				break;
			}else {
				opcion = Integer.parseInt(panel);
			}
			
			switch(opcion){
				case 1: 
						int idCuenta = Integer.parseInt(JOptionPane.showInputDialog("Banco \n Para crear una cuenta ingrese un ID de 4 digitos maximo"));
						int digitos = (int)(Math.log10(idCuenta)+1);
								
						if(digitos != 4) {
							JOptionPane.showMessageDialog(null, "El id debe tener 4 digitos obligatoriamente");
							break;
						}
	
						if(Funciones.searchId(idCuenta, "Usuario existente intente otro ID")) {
							break;
						}else {
							JOptionPane.showMessageDialog(null, "Cuenta creada con exito");
							Banco.AgregarCuenta(idCuenta);
							break;
						}
		
				case 2: 
					
						int ingresarCuenta = Integer.parseInt(JOptionPane.showInputDialog("Bievenido al banco ingrese numero de cuenta"));
						if(Funciones.searchId(ingresarCuenta, "Bienvenido")) {
							boolean cuentaOn = true;
							Cuenta cuentaTempo = Funciones.searchCuenta(ingresarCuenta);
							while(cuentaOn) {
							int opcionCuenta = Integer.parseInt(JOptionPane.showInputDialog("Bievenido cuenta " + cuentaTempo.getId() + " Usted dispone un monto de $"+ cuentaTempo.getDineroDepositado() +" \n Que desea realizar? \n -1 Depositar dinero \n -2 Extraer Dinero \n -3 Salir "));
								switch(opcionCuenta) {
									case 1: 
										int deposito = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que desea depositar"));
										cuentaTempo.setDineroDepositado(deposito);
										break;
									case 2:
										int extraccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que desea estrar \n Su monto actual es de $"+ cuentaTempo.getDineroDepositado()));
										if(extraccion > cuentaTempo.getDineroDepositado()) {
											JOptionPane.showMessageDialog(null,"Usted no dispone de esa cantidad de dinero");
										}else {
											cuentaTempo.setDineroDepositado( cuentaTempo.getDineroDepositado() - extraccion);
										}
										break;
									case 3:
										cuentaOn = false;
										break;
								}
						}
					}else {
						JOptionPane.showMessageDialog(null, "No existe una cuenta con ese ID");
						break;
					}
						
						break;
				case 3:	
						running = false;
						break;
				default: JOptionPane.showMessageDialog(null, "Ingrese una opcion valida.");
				}
	//			
			}
		System.exit(0);
		
	}
}
