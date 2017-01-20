package application;

import java.util.LinkedList;
import java.util.List;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import bean.Artist;
import bean.Country;
import bean.Elenco;
import db.Dao;

public class Model {
	
	private Dao dao =new Dao();
	private SimpleWeightedGraph<Artist, DefaultWeightedEdge> grafo ;

	public List<Country> getNaz(){
		List<Country> all= dao.getNazioni();
		return all;
	}

	public List<Elenco> getElenco(int countryId){
		List<Elenco> elenco = dao.getElenco(countryId);
		return elenco;
	}
	
	public List<Artist> getVertici(int c){
	List<Artist> all= dao.getVertici(c);
	System.out.println(all);
	return all;
	}
	
	
	public void buildGraph(int idCountry){
		grafo = new SimpleWeightedGraph<Artist, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo,  getVertici(idCountry));
	}
	
	
	
	
	public static void main(String [] args){
		Model m = new Model();
		m.getVertici(9);
	}
	
	
	
	
	
	
	
	
	
	
	
//	public List<String> getElenco(Country  id){
//		List<String> all= dao.getElencoPunto1(id);
//		return all;
//	}
//
//	public int getNumeroUtenti(Artist a1, Artist a2 , int c ){   //conto numero utenti ke hanno ascoltato i due artisti in quella nazione
//		int num =-1;
//		num = dao.getNumeroUtenti(a1, a2, c);
//		return num;
//	}
	
//	public void buildGraph(int idc ){   //non parte
//		grafo = new SimpleWeightedGraph<Artist, DefaultWeightedEdge>(DefaultWeightedEdge.class);
//		Graphs.addAllVertices(grafo,  getVertici(idc));  // 20 artisti
//		for(Artist a1 : grafo.vertexSet()){
//			for(Artist a2 : grafo.vertexSet()){
//				if(!a1.equals(a2)){
//					int numeroUtentiUguali= getNumeroUtenti(a1, a2, idc);
//					if(numeroUtentiUguali>0){
//						Graphs.addEdge(grafo,  a1,  a2,  numeroUtentiUguali);
//					}
//				}
//			}
//		}
//	}
	
	
	//determino se il grafo è connesso
	//calcolo numero di componenti connesse:
	
//	public int getComponentiConnesse(int c ){  
//		int num =-1;
//		List<Artist> vertici = new LinkedList<>();
//		vertici.addAll(getVertici(c));
//		while(!vertici.isEmpty()){
//			Artist primo = vertici.get(0);
//			BreadthFirstIterator<Artist , DefaultWeightedEdge> visita = new BreadthFirstIterator<Artist, DefaultWeightedEdge>(grafo, primo);
//			while(visita.hasNext()){
//				Artist secondo = visita.next();
//				vertici.remove(vertici.indexOf(secondo));
//			}
//			num++;
//		}
//		return num;
//	}
//	
//	//stampo elenco di una componente connessa
//	
//	public List<Artist> getComponenteConnessa(Artist start){
//		List<Artist > all = new LinkedList<>();
//		BreadthFirstIterator<Artist , DefaultWeightedEdge> visita = new BreadthFirstIterator<Artist, DefaultWeightedEdge>(grafo, start);
//		while(visita.hasNext()){
//			Artist a = visita.next();
//			all.add(a);
//		}
//		return all;
//	}
//	
//	public Artist getVertex(int c){              //x prendere una componente connessa
//		List<Artist> vertici = new LinkedList<>();
//		vertici.addAll(getVertici(c));
//		return vertici.get(0);
//	}
//	
//	public static void main(String [] args){
//		Model m = new Model();
//		//m.buildGraph(18);
//	}
}
