package barbeirosdorminhocos;

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
					
					if (dormindo) {
						dormindo = false;
						System.out.println("Barbeiro " + id + " acordou! Começando os trabalhos!");
					}
					
					System.out.println("Cliente " + cli.getId() + " cortando cabelo com Barbeiro " + id);
					
					Thread.sleep(1);
					
					System.out.println("Cliente " + cli.getId() + " terminou o corte... saindo da barbearia!");
					
					barbearia.corteTerminado(cli);
				}
				else {
					System.out.println("Barbeiro " + id + " indo dormir um pouco... não há clientes na barbearia...");
					dormindo = true;
					
					synchronized(this){
						this.wait();
					}
					
				}
				
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	

}
