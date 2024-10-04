package barbeirosdorminhocos;

public class Cliente extends Pessoa implements Runnable{
	
	private Barbearia barbearia;
	
	public Cliente (int id) {
		super(id);
	}
	
	public void run (int barbeirosAtendendo, int quantBarbeiros, long[]fila) {
		while (true) {
			if (barbearia.cortaCabelo(this) == true) {
				
				System.out.println("Cliente " + id + " esperando corte...");
				
				synchronized (this) {
					this.wait();
				}
			}
			else {
				System.out.println("Cliente " + id + " tentou entrar na barbearia, mas está lotada... indo dar uma voltinha");
				
			}
			
		}
		
	}

}
