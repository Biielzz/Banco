package Controller;

import java.util.concurrent.Semaphore;

public class Deposito extends Thread {

	private int Conta;
	private int Saldo;
	private int transacao;
	private Semaphore semaforo;

	public Deposito (int Conta, int Saldo, int transacao, Semaphore semaforo) {
		this.Conta = Conta;
		this.Saldo = Saldo;
		this.transacao = transacao;
		this.semaforo = semaforo;
		}
	
	public void run () {
		try {
			semaforo.acquire();
			Credito();
			sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
				semaforo.release();
			}
		}
	
		public void Credito() {
	System.out.println("Conta " + Conta + "  Saldo Anterior: R$" + Saldo + "  Saque no valor de: R$" + transacao + "  Novo saldo: R$" + Saldo);
			this.Saldo += transacao;
		}

public void Saquee() {
	
}

public void Depositoo() {
	System.out.println("Conta " + Conta +  "  Saldo Anterior: R$" + Saldo + "  Saque no valor de: R$" + transacao + "  Novo saldo: R$" + Saldo);
	this.Saldo += transacao;
}
}


		


