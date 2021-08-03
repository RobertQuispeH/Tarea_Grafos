package TareaGrafos;

public class Test {
	public static void main(String[] args) {
		Grafo<Integer> grafo= new Grafo();
		grafo.AgregarVertice(1);
		grafo.AgregarVertice(2);
		grafo.AgregarVertice(3);
		grafo.AgregarVertice(4);
		grafo.AgregarVertice(5);
		grafo.AgregarVertice(6);
		grafo.AgregarVertice(7);
		grafo.AgregarArista(1, 2);
		grafo.AgregarArista(1, 3);
		grafo.AgregarArista(2, 4);
		grafo.AgregarArista(2, 3);
		grafo.AgregarArista(3, 4);
		grafo.AgregarArista(3, 5);
		grafo.AgregarArista(5, 7);
		grafo.AgregarArista(5, 6);
		System.out.println("////////////////////lista de lista adyasencia////////////////////");
		grafo.listAdyasencia("--");
		System.out.println("////////////////////Recorido BFS////////////////////");
		grafo.BFS();
		System.out.println("////////////////////Rocorido DFS////////////////////");
		grafo.DFS();
		//EJERCICIO 5
		/*a) Dibuje el grafo definido por las siguientes palabras: words cords corps coops
		crops drops drips grips gripe grape graph*/
		System.out.println("El grafo de palabras se define de la siguiente manera: cada vértice es una palabra\r\n"
				+ "en el idioma Inglés y dos palabras son adyacentes si difieren exactamente en una\r\n"
				+ "posición");
		Grafo<String> grafoEjer= new Grafo();
		grafoEjer.AgregarVertice("words");  
		grafoEjer.AgregarVertice("cords");
		grafoEjer.AgregarVertice("corps");
		grafoEjer.AgregarVertice("coops");
		grafoEjer.AgregarVertice("crops");      
		grafoEjer.AgregarVertice("drops");
		grafoEjer.AgregarVertice("drips");
		grafoEjer.AgregarVertice("grips");
		grafoEjer.AgregarVertice("gripe");
		grafoEjer.AgregarVertice("grape");
		grafoEjer.AgregarVertice("graph");
		grafoEjer.AristasEjercicio5();
		grafoEjer.listAdyasencia(",");
		System.out.println("////////////////////grafo incluido////////////////////");
		Grafo<Integer> grafo2 = new Grafo();
 		grafo2.AgregarVertice(1);
		grafo2.AgregarVertice(2);
		grafo2.AgregarVertice(3);
		grafo2.AgregarArista(1, 2);
		grafo2.AgregarArista(1, 3);
		grafo2.AgregarArista(2, 3);
		Grafo<Integer> grafo3 = new Grafo();
 		grafo3.AgregarVertice(1);
		grafo3.AgregarVertice(2);
		grafo3.AgregarVertice(3);
		grafo3.AgregarVertice(4);
		grafo3.AgregarArista(1, 2);
		grafo3.AgregarArista(1, 3);
		grafo3.AgregarArista(1, 4);
		grafo3.AgregarArista(2, 3);
		System.out.println("lista de adyasencia grafo 1");
		grafo.listAdyasencia("-");
		System.out.println("lista de adyasencia grafo 2");
		grafo2.listAdyasencia("-");
		System.out.println("lista de adyasencia grafo 3");
		grafo3.listAdyasencia("-");
		System.out.println("grafo 2 esta includo en el grafo 1?: " + grafo.grafoIncluido(grafo2));
		System.out.println();
		System.out.println("grafo 3 esta includo en el grafo 1?: " + grafo.grafoIncluido(grafo3));
		System.out.println();
	}
}
