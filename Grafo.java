import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;

public class Grafo{
	// Atributos
	public Map<Vertice, List<Vertice>> adjacencias;

	// Construtores
	public Grafo(){
		adjacencias = new HashMap<>();
	}

	// Gets && Sets

	// Methods
	public void addVertice(Vertice v){
		adjacencias.putIfAbsent(v, new ArrayList<>());
	}

	public void addAresta(Vertice org, Vertice end){
		adjacencias.get(org).add(end);
	}

	public boolean contemVertice(Vertice v){
		return adjacencias.containsKey(v);
	}

	// Print
	public void printAdjacencias(){
		for(Vertice v : adjacencias.keySet()){
			System.out.print("Vértice " + v.nome + ": ");
			for(Vertice adj : adjacencias.get(v)){System.out.print(adj.nome + " ");}
			System.out.println();
		}
	}
	public void printDistance(){
		for(Vertice v : adjacencias.keySet()){
			System.out.println("Dist. Vertice " + v.nome + "=" + v.dist);
		}
	}
	public void printCaminhos(Vertice vorg){
		this.bfs(vorg);

		System.out.println("\nImprimindo Caminhos: ");
		for(Vertice v : adjacencias.keySet()){
			System.out.print(v.nome + ":");
			printPath(vorg, v);
		}
	}

	private void printPath(Vertice vorg, Vertice vend){
		if(vend.nome==vorg.nome){
			System.out.print(vend.nome);
		}else if(vend.prev==null){
			System.out.print(String.format("Nenhum caminho de %s para %s existente.", vorg.nome, vend.nome));
		}else{
			printPathAux(vorg, vend.prev);
			System.out.print(vend.nome);	
		} System.out.println();
	}
	private void printPathAux(Vertice vorg, Vertice vend){
		if(vend.nome==vorg.nome){
			System.out.print(vend.nome + " -> ");
		}else{
			printPathAux(vorg, vend.prev);
			System.out.print(vend.nome + " -> ");
		} 
	}

	// BFS
	public void bfs(Vertice vorg){
		if(!contemVertice(vorg)){
			System.out.println("O vertice " + vorg + " não está presente no grafo.");
			return;
		}
		
		Queue<Vertice> queue = new LinkedList<>();
		Set<Vertice> vertSet = new HashSet(adjacencias.keySet()); 
		vertSet.remove(vorg);
		for(Vertice v:vertSet){v.Limpa();}



		vorg.cor = "gray";
		vorg.dist = 0;
		vorg.prev = null;
		queue.add(vorg);
		while(!queue.isEmpty()){
			Vertice curr = queue.poll();
			for(Vertice adj : adjacencias.get(curr)){
				if(adj.cor=="white"){
					adj.cor="gray";
					adj.dist = curr.dist + 1;

					adj.prev = curr;
					queue.add(adj);
				}
			}
			curr.cor="black";
		}
	}

   

}