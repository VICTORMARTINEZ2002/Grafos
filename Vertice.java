import java.util.ArrayList;

public class Vertice{
	// Atributos
    public String nome;
    public int dist;
    public String cor;
    public Vertice prev;
    public ArrayList<Vertice> adjacentes;

	// Construtores
    public Vertice(String nome){
        this.nome = nome;
        this.dist = Integer.MAX_VALUE;
        this.cor  = "white";
        this.prev = null;
    }

	// Gets && Sets

	// Methods
    public void Limpa(){
        this.dist = Integer.MAX_VALUE;
        this.cor  = "white";
        this.prev = null;
    }



    // BFS
    

}