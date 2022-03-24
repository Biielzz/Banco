package Controller;

import java.util.concurrent.Semaphore;

public class Saque {

	
	public class Saquee extends Thread {
		private int Conta;
		private int Saldo;
		private int transacao;
		private Semaphore semaforo;
		
		public Saquee(int Conta, int Saldo, int transacao, Semaphore semaforo) {
			this.Conta = Conta;
			this.Saldo = Saldo;
			this.transacao = transacao;
			this.semaforo = semaforo;
	}
		public void run () {
			try {
				semaforo.acquire();
				Deposito();
				sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
		}
		public void Deposito() {
			System.out.format("Conta %d - Saldo Anterior: R$ %.2f Saque no valor de: R$ %.2f Novo saldo: R$ %.2f%n", Conta, Saldo, transacao, + Saldo + transacao);
			this.Saldo += transacao;
		}
}
}
