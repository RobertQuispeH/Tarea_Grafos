package TareaGrafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo <E>{
	private Nodo root = null;
	private Nodo head = null;
	Queue<Nodo> colaGrafo;
	private class Nodo{
		ArrayList<Nodo> adys = new ArrayList<>();
		private boolean paso = false;
		private E valor = null;
		private Nodo next = null;
		public Nodo(E valor, Nodo next) {
			this.valor = valor;
			this.next = next;
		}
		public void setAdy(Nodo ady) {
			this.adys.add(ady);
		}
	}
	public void AgregarArista(E v1 , E v2) {
		insertAdy(getNodo(v1), getNodo(v2));
		insertAdy(getNodo(v2), getNodo(v1));
	}
	public void AgregarAristaNodo(Nodo v1 , Nodo v2) {
		insertAdy(v1, v2);
		insertAdy(v2, v1);
	}
	public Nodo getNodo(E v) {
		Nodo rt = root;
		while (rt != null) {
			if(rt.valor.equals(v))
				return rt;
			rt = rt.next;
		}
		return null;
	}
	public void AgregarVertice(E v) {
		if(root == null) {
			root = new Nodo(v, null);
			head = root;
		}else {
			head.next = new Nodo(v, null);
			head = head.next;
		}
	}
	public boolean insertAdy(Nodo v1, Nodo v2) {
		Nodo aux = v1;
		for (Nodo nodo : aux.adys) {
			if(nodo.equals(v2))
				return false;
		}
		aux.setAdy(v2);
		return true;
	}
	public void listAdyasencia(String n) {
		Nodo rt = root;
		while (rt != null) {
			System.out.print("Nodo " + rt.valor+" [ ");
			for (Nodo ady : rt.adys) {
				System.out.print(n + ady.valor);
			}
			System.out.print(" ] ");
			System.out.println();
			rt = rt.next;
		}
	}
	public void BFS() {
		colaGrafo = new LinkedList();
		Nodo rt = root;
		while (rt != null) {
			if(!rt.paso) {
				colaGrafo.offer(rt);
				rt.paso = true;
				for (Nodo ady : rt.adys) {
					if(!ady.paso) {
						colaGrafo.offer(ady);
						ady.paso = true;
					}
				}
			}
			rt = rt.next;
		}
		printCola();
		resetPaso();
	}
	public Nodo getRoot() {
		return root;
	}
	public Nodo getHead() {
		return head;
	}
	public void DFS() {
		colaGrafo = new LinkedList();
		Nodo rt = root;
		while (rt != null) {
			if(!rt.paso)
				DFS(rt);
			rt = rt.next;
		}
		printCola();
		resetPaso();
	}
	public void DFS(Nodo rt) {
		Nodo ady = NodoSigDFS(rt);
		colaGrafo.offer(rt);
		rt.paso = true;
		if(ady != null) {
			DFS(ady);
		}
	}
	public void printCola() {
		for (Nodo nodo : colaGrafo) {
			System.out.println(nodo.valor);
		}
	}
	public void resetPaso() {
		Nodo rt = root;
		while (rt != null) {
			rt.paso = false;
			rt = rt.next;
		}
	}
	public Nodo NodoSigDFS(Nodo rt) {
		for (Nodo nodo : rt.adys) {
			if(nodo.paso == false)
				return nodo;
		}
		return null;
	}
	public void comparateChar(Nodo a) {
		Nodo rt = root;
		String aux;
		String pat = (String)a.valor;
		int count;
		while (rt != null) {
			count = 0;
			if(!a.equals(rt)) {
				for (int i = 0; i < pat.length() && count < 2; i++) {
					aux = (String)rt.valor;
					if(pat.charAt(i) != aux.charAt(i)) {
						count++;
					}
				}
				if(count < 2) {
					AgregarAristaNodo(a, rt);
				}
			}
			rt = rt.next;
		}
	}
	public void AristasEjercicio5() {
		Nodo rt = root;
		while (rt != null) {
			comparateChar(rt);
			rt = rt.next;
		}
	}
	public boolean grafoIncluido(Grafo<E> a) {
		Nodo comp = a.root;
		boolean aux = false;
		while (comp != null) {
			aux = comparateIncludo(comp);
			if(aux == false) {
				return false;
			}
			comp = comp.next; 
		}
		return aux;
	}
	public boolean comparateIncludo(Nodo a) {
		Nodo rt = this.root;
		boolean aux;
		while (rt != null) {
			if(a.valor.equals(rt.valor)) {
				for (Nodo nodo : a.adys) {
					aux = false;
					for (Nodo nodo2 : rt.adys) {
						if (nodo.valor.equals(nodo2.valor)) {
							aux = !aux;
						}
					}
					if(aux == false) {
						return false;
					}
				}
				return true;
			}
			rt = rt.next;
		}
		return false;
	}
	
}
