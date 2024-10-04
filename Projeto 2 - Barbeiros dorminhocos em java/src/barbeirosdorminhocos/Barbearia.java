package barbeirosdorminhocos;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.LinkedList;

public class Barbearia {
	
	private int barbeirosAtendendo = 0;
	private int quantBarbeiros;
	private int tamanhoFila;
	
	LinkedBlockingQueue<Cliente> fila = new LinkedBlockingQueue<>(tamanhoFila);
	LinkedList<Cliente> clientesCortando = new LinkedList<>();
	
	
	public Barbearia (int quantBarbeiros, int tamanhoFila) {
		this.quantBarbeiros = quantBarbeiros;
		this.tamanhoFila = tamanhoFila;
	}
	
	public boolean cortaCabelo (Cliente c) {
		
		if (fila.size() < tamanhoFila) {
			fila.add(c);
			return true;
		}
		else {
			return false;
		}
	}
	
	public synchronized Cliente proximoCliente () {
		
		if (fila.peek() != null && clientesCortando.size() <= quantBarbeiros) {
			clientesCortando.add(fila.peek());
		}
		return fila.poll();
	}
	
	public synchronized void corteTerminado (Cliente c) {
		
		clientesCortando.remove(c);
	}

}
