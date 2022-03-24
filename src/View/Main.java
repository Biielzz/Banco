package View;

import java.util.concurrent.Semaphore;

import Controller.Deposito;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		int Conta = 0;
		int Saldo = 0;
		int transacao = 0;
		
      for (int id = 1; id <= 20; id++) {
    	
		Thread Caixa = new Deposito (Conta, Saldo, transacao, semaforo);
		 Caixa.start();

}
}
}

	


