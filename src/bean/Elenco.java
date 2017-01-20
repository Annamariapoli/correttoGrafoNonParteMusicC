package bean;

public class Elenco {
	
	private String nomeArtista;
	private int numeroUtenti;
	public Elenco(String nomeArtista, int numeroUtenti) {
		super();
		this.nomeArtista = nomeArtista;
		this.numeroUtenti = numeroUtenti;
	}
	public String getNomeArtista() {
		return nomeArtista;
	}
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	public int getNumeroUtenti() {
		return numeroUtenti;
	}
	public void setNumeroUtenti(int numeroUtenti) {
		this.numeroUtenti = numeroUtenti;
	}
	
	public String toString(){
		String r ;
		r = nomeArtista+" "+numeroUtenti+" \n";
		return r ;
	}
	

}
