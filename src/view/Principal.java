package view;
import controller.ThreadOperacoes;
import java.util.Random;
import java.util.concurrent.Semaphore;
public class Principal {

	public static void main(String[] args) {
		Random random = new Random();
		int calculo, transacao;
		Semaphore semaforo = new Semaphore(1);
		for (int idThread=0;idThread<21;idThread++){
			switch(idThread%3){
			case 0:
				calculo = random.nextInt(1000)+1000;
				transacao = 1500;
				Thread thread0 = new ThreadOperacoes(idThread,calculo,transacao, semaforo);
				thread0.start();
				break;
			case 1:
				calculo = random.nextInt(800)+200;
				transacao = 1000;
				Thread thread1 = new ThreadOperacoes(idThread, calculo, transacao, semaforo);
				thread1.start();
				break;
			case 2:
				calculo = random.nextInt(1000)+500;
				transacao = 1500;
				Thread thread2 = new ThreadOperacoes(idThread,calculo,transacao,semaforo);
				thread2.start();
				break;
			}
			

		}

	}

}
