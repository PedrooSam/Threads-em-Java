public class Barbeiro extends Pessoa implements Runnable{
	
	private Barbearia barbearia;
	private boolean dormindo = false;
	
	public Barbeiro (int id, Barbearia barbearia) {
		super(id);
		this.barbearia = barbearia;
	}
	
	public void run () {
		while(true) {
			try {
				Cliente cli = barbearia.proximoCliente();

				
				if(cli != null) {
					
					if (dormindo == true) {
						dormindo = false;
						System.out.println("Barbeiro " + this.getId() + " acordou! Começando os trabalhos!");
					}
					
					System.out.println("Cliente " + cli.getId() + " cortando cabelo com Barbeiro " + cli.getId());
					
					Thread.sleep(1);
					
					System.out.println("Cliente " + cli.getId() + " terminou o corte... saindo da barbearia!");
					
					barbearia.corteTerminado(cli);
				}
				else {
					System.out.println("Barbeiro " + this.getId() + " indo dormir um pouco... não há clientes na barbearia...");
					dormindo = true;
					
					synchronized(this){
						this.wait();
					}
					
				}
				
			}catch (InterruptedException IE){
				IE.printStackTrace();
			}
		}
		
	}
	
	

}
