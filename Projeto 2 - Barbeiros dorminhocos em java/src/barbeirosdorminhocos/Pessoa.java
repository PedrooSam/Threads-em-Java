public class Pessoa extends Thread{
	
	private final int id;
	
	public Pessoa (int id) {
		this.id = id;
	}


	public long getID () {
		return id;
	}
}
