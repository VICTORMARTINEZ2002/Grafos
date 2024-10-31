import java.util.Random;

public class App{
    private static Random random = new Random();
    private static Integer qtd_vertices = 10;
    private static Integer qtd_arestas  = 25;

    public static void main(String[] args){
        // Apresentação Projeto
            System.out.printf("+----------------------------------------------+%n");
            System.out.printf("|   Algoritmos para Grafos - Victor Martinez   |%n");
            System.out.printf("|                  out / 2024                  |%n");
            System.out.printf("+----------------------------------------------+%n");

        // Inicialização
        

        Grafo grafo = new Grafo();
        // Criar os Vertices
        Vertice[] vertices = new Vertice[qtd_vertices];
        for(char letra = 'A'; letra<('A' + qtd_vertices); letra++) {
            vertices[letra - 'A'] = new Vertice(String.valueOf(letra));
        }

        // Adicionar os Vertices
        for(Vertice v:vertices){grafo.addVertice(v);}

        // Conectar os Vertices
        for(int i=0; i<qtd_arestas; i++){
            Vertice org;
            Vertice end;
            do{
                org = vertices[random.nextInt(qtd_vertices)];
                end = vertices[random.nextInt(qtd_vertices)];
            }while(org==end || grafo.adjacencias.get(org).contains(end)); // Loop Infinito

            grafo.addAresta(org, end);
        }

        // Imprime o grafo
        grafo.printAdjacencias();
        System.out.println();
        // Realiza a busca em largura a partir do vértice 'A'
        grafo.bfs(vertices[0]);
        grafo.printDistance();
        grafo.printCaminhos(vertices[0]);

    }
}   