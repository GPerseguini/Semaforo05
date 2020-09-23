package controller;
import java.util.concurrent.Semaphore;

public class ThreadOperacoes extends Thread {
	private int id;
	private int calculo;
	private int transacao;
	private Semaphore semaforo;
	public ThreadOperacoes(int idThread,int calculo, int transacao, Semaphore semaforo){
		this.id = idThread;
		this.calculo = calculo;
		this.transacao = transacao;
		this.semaforo = semaforo;
	}
	public void run(){
		simulacaoBanco();
	}
	
	public void simulacaoBanco(){
		for (int i=0;i<2;i++){
			try {
				System.out.println("#"+id+" Realizando cálculos");
				Thread.sleep(calculo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		
			try {
				semaforo.acquire();
				System.out.println("#"+id+"Inicio transação de banco de dados");
				Thread.sleep(transacao);
				System.out.println("#"+id+"Fim transação de banco de dados");
			} catch (InterruptedException e) {
			e.printStackTrace();
			} finally{
				semaforo.release();
			}
		}
		if (id % 3 == 2 || id % 3 == 0){
			try {
				System.out.println("#"+id+"Realizando cálculos");
				Thread.sleep(calculo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	
			try {
				semaforo.acquire();
				System.out.println("#"+id+"Inicio transação de banco de dados");
				Thread.sleep(transacao);
				System.out.println("#"+id+"Fim transação de banco de dados");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}
}