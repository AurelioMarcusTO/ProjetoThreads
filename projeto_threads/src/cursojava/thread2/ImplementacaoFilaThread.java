package cursojava.thread2;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {
	
	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = 
			new ConcurrentLinkedQueue<ObjetoFilaThread>();
	
		public static void add(ObjetoFilaThread objetoFilaThread) {
			
			pilha_fila.add(objetoFilaThread);
			
		}
		
		@Override
		public void run() {
			
			System.out.println("Fila rodando !");
			
			while (true) {
				
			synchronized (pilha_fila) { /*Bloquear o acesso a lista por outros processos*/
				
				Iterator iteracao = pilha_fila.iterator();
				
				while (iteracao.hasNext()) { /*Enquanto conter dados na lista ira processar*/
					
					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();
					
					for (int qtd = 0; qtd < 30; qtd ++) {
					/*Processar 10 mil notas fiscais*/
					System.out.println("-----------------------------------------");
					System.out.println(processar.getEmail());
					System.out.println(processar.getNome() + " - " + qtd);
					
					try {
						Thread.sleep(1000); /*Dar um tempo para a descarga de memoria*/
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}									
					}
					
					iteracao.remove();
					
				}
				
				
			}
			
			try {
				Thread.sleep(1000);/*Dar um tempo para descarga de memoria*/
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			}	
		
			
			
		}
		
	
}
