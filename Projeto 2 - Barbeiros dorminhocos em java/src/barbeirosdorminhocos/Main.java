import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int tamanhoFila, quantClientes, quantBarbeiros, barbeirosAtendendo = 0, clientesEsperando = 0;

		System.out.println("Digite o tamanho da fila: ");
		tamanhoFila = scan.nextInt();
		System.out.println("Digite a quantidade de barbeiros: ");
		quantBarbeiros = scan.nextInt();
		System.out.println("Digite a quantidade de clientes: ");
		quantClientes = scan.nextInt();

		Barbearia barbearia = new Barbearia(quantBarbeiros, tamanhoFila);
		

		
		Barbeiro[] barbeiros = new Barbeiro[quantBarbeiros];
		Cliente[] clientes = new Cliente[quantClientes];
		
		for (int i=0; i<quantBarbeiros; i++) {
			barbeiros[i] = new Barbeiro(i+1, barbearia);
			barbeiros[i].start();
		}

		for (int i=0; i<quantClientes; i++) {
			clientes[i] = new Cliente(i+1, barbearia);
			clientes[i].start();
			
		}
	}
}
