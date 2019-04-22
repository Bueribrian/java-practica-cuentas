package banco;

public class Cuenta {

	private int Id;
	private float dineroDepositado = 0;
	
	public  Cuenta(int id){
		this.Id = id;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
	public float getDineroDepositado() {
		return dineroDepositado;
	}
	
	public void setDineroDepositado(float dineroDepositado) {
		this.dineroDepositado = dineroDepositado;
	}
	
	
}
