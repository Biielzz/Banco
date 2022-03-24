package Controller;

import java.util.concurrent.Semaphore;

public class Deposito extends Thread {

	private int Conta;
	private int Saldo;
	private int Saque;
	private int transacao;
	
	private Semaphore semaforo;

	public Deposito (int Conta, int Saldo, int Saque, int transacao, Semaphore semaforo) {
		this.Conta = Conta;
		this.Saldo = Saldo;
		this.Saque = Saque;
		this.transacao = transacao;
		this.semaforo = semaforo;
		}
	
	public void Dados() {
		Conta = (int) ((Math.random()*5000)+1000);
		Saldo = (int) ((Math.random()*2000));
		Saque = (int) ((Math.random()*2000));
		transacao = (int) ((Math.random()*2000));
		
	}
	public void Verifica() {
		int temp = 0;
		temp = (int) ((Math.random()*2)+1);
		try {
			semaforo.acquire();
			if (temp %2 == 0) {
				Depositoo();
				sleep(500);
			} else {
				Saquee();
				sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}

	public void run () {
		Verifica();
		}

public void Saquee() {
	Dados();
	int saldnv;
	
	if (Saldo >= Saque) {
		saldnv = Saldo - Saque;
	System.out.println("\n Conta " + Conta + "  Saldo Anterior: R$" + Saldo + "  Saque no valor de: R$" + Saque + "  Novo saldo: R$" + saldnv);
			
}else {
	System.out.println("\n Saque não realizado!!");

	}
		}

public void Depositoo() {
	Dados();
	int saldonv;
	saldonv = Saldo + transacao;
	System.out.println("\n Conta " + Conta +  "  Saldo Anterior: R$" + Saldo + "  Deposito no valor de: R$" + transacao + "  Novo saldo: R$" + saldonv);
	}
		}


		


