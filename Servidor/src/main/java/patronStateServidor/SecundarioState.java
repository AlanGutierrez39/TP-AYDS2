package patronStateServidor;

import servidor.Servidor;

public class SecundarioState implements IState{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2954678991323697328L;
	private Servidor servidor;
	
	public SecundarioState(Servidor servidor) {
		super();
		this.servidor = servidor;
	}

	@Override
	public void ponerPrimario() {
		this.servidor.setEstado(new PrimarioState(this.servidor));
		this.servidor.setPuerto(5555);
	}


	@Override
	public void ponerSecundario() {
		System.out.println("No corresponde el cambio de estado");
	}

	@Override
	public String toString() {
		return "Secundario";
	}

}
