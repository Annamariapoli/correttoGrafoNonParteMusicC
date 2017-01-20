package bean;

public class ArtistiArtistiUtenti {
	
	private  int artistId1;
	private   int artistId2;
	private int numeroUtenti;
	
	public ArtistiArtistiUtenti(int artistId1, int artistId2, int numeroUtenti) {
		super();
		this.artistId1 = artistId1;
		this.artistId2 = artistId2;
		this.numeroUtenti = numeroUtenti;
	}
	public int getArtistId1() {
		return artistId1;
	}
	public void setArtistId1(int artistId1) {
		this.artistId1 = artistId1;
	}
	public int getArtistId2() {
		return artistId2;
	}
	public void setArtistId2(int artistId2) {
		this.artistId2 = artistId2;
	}
	public int getNumeroUtenti() {
		return numeroUtenti;
	}
	public void setNumeroUtenti(int numeroUtenti) {
		this.numeroUtenti = numeroUtenti;
	}
	
	public String toString(){
		String r;
		r = artistId1+" "+artistId2+" "+numeroUtenti+" \n";
		return r;
	}

}
