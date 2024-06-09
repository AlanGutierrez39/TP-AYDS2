package patronStateServidor;

import servidor.Servidor;

public class PrimarioState implements IState{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8006364235598048877L;
	private Servidor servidor;
	
	public PrimarioState(Servidor servidor) {
		super();
		this.servidor = servidor;
	}

	@Override
	public void ponerPrimario() {
		System.out.println("No corresponde el cambio de estado");
	}
	
	@Override
	public void ponerSecundario() {
		System.out.println("No corresponde el cambio de estado");
		//this.servidor.setEstado(new SecundarioState(this.servidor));
		//this.servidor.setPuerto(7777);
	}

	@Override
	public String toString() {
		return "Primario";
	}

}
