public class Cliente extends Pessoa implements Runnable{
	
	private Barbearia barbearia;
	
	public Cliente (int id, Barbearia barbearia) {
		super(id);
		this.barbearia =  barbearia;
	}
	
	public void run () {
		while (true) {
			try {
				if (barbearia.cortaCabelo(this)) {

					System.out.println("Cliente " + this.getID() + " esperando corte...");

					synchronized (this) {
						this.wait();
					}
					return;
				} else {
					System.out.println("Cliente " + this.getID() + " tentou entrar na barbearia, mas está lotada... indo dar uma voltinha");

				}
			}
			catch(InterruptedException IE){
				IE.printStackTrace();
			}
			
		}
		
	}

}
