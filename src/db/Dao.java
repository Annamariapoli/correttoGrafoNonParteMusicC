package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import bean.Artist;
import bean.Country;
import bean.Elenco;

public class Dao {
	
	public List<Country> getNazioni(){                                           //ok   //x la combo
		String query="select *  from country c   order by c.country ";
		Connection conn = DBConnect.getConnection();
		List<Country> naz = new LinkedList<>();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet res = st.executeQuery();
			while(res.next()){
				Country c = new Country(res.getInt("id"), res.getString("country"));
				naz.add(c);
			}
			conn.close();
			return naz;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}
	}

	public List<Elenco> getElenco (int countryId){                         //ok
		Connection conn = DBConnect.getConnection();
		String query="select a1.artist, count(distinct  l.userid) as num  "
				+ "from artist a1, listening l   "
				+ "where a1.id=l.artistid and l.countryid=?  "
				+ "group by a1.id  "
				+ "order by num DESC  "
				+ "limit 20";
		List<Elenco> elenco = new LinkedList<>();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1,  countryId);
			ResultSet res = st.executeQuery();
			while(res.next()){
				Elenco e = new Elenco ( res.getString("artist"), res.getInt("num"));
				elenco.add(e);	
			}
			conn.close();
			return elenco;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Artist> getVertici(int c ){                                          //ok
		String query="select a1.id, a1.artist, count(distinct l.userid) as num  "
				+ "from artist a1, listening l  	"
				+ "where a1.id=l.artistid and l.countryid=?  "
				+ "group by a1.id  "
				+ "order by num DESC"
				+ "	limit 20";
	
		Connection conn = DBConnect.getConnection();
		List<Artist> all = new LinkedList<>();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1,  c);
			ResultSet res = st.executeQuery();
			while(res.next()){
				Artist a = new Artist(res.getInt("id"), res.getString("artist"));
				all.add(a);
			}
			conn.close();
			return all;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	public List<String> getElencoPunto1(Country id){
//		String query="select a.artist, count(distinct l.userid) as num  "
//				+ "from listening l, country c, artist a  "
//				+ "where l.countryid=c.id and c.id=?  "
//				+ "and a.id=l.artistid  "
//				+ "group by l.artistid  "
//				+ "order by num DESC  limit 20";
//		Connection conn = DBConnect.getConnection();
//		List<String> all = new LinkedList<>();
//		try{
//			PreparedStatement st = conn.prepareStatement(query);
//			st.setInt(1,  id.getId());
//			ResultSet res = st.executeQuery();
//			while(res.next()){
//				all.add("Artista :  " +res.getString("artist")+"; Numero utenti: " +res.getInt("num")+" \n");
//				
//			}
//			conn.close();
//			return all;
//		}catch(SQLException e ){
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
//	public List<Artist> getVertici(int c ){  //ok
//		String query="select a.id, a.artist, count(l.userid) as num  "
//				+ " from listening l, country c, artist a  "
//				+ "where l.countryid=c.id and c.id=? "
//				+ "and a.id=l.artistid   "
//				+ "group by l.artistid   "
//				+ "order by num DESC limit 20";
//		Connection conn = DBConnect.getConnection();
//		List<Artist> all = new LinkedList<>();
//		try{
//			PreparedStatement st = conn.prepareStatement(query);
//			st.setInt(1,  c);
//			ResultSet res = st.executeQuery();
//			while(res.next()){
//				Artist a = new Artist(res.getInt("id"), res.getString("artist"));
//				all.add(a);
//				
//			}
//			conn.close();
//			//System.out.println(all.toString());
//			return all;
//		}catch(SQLException e ){
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
//	public int getNumeroUtenti(Artist a1 , Artist a2 , int c){  //Num utenti ke hanno ascoltato quei brani in quella nazione
//		int numero=-1;
//		String query="select count(distinct (l1.userid)) as numero  "
//				+ "from listening l1, listening l2  "
//				+ "where  l1.userid=l2.userid and  l1.artistid=?  and l2.artistid=? "
//				+ "and l1.countryid=l2.countryid and l1.countryid =?";
//		Connection conn = DBConnect.getConnection();
//		try{
//			PreparedStatement st = conn.prepareStatement(query);
//			st.setInt(1,  a1.getId());
//			st.setInt(2,  a2.getId());
//			st.setInt(3,  c);
//			ResultSet res = st.executeQuery();
//			if(res.next()){
//			numero= res.getInt("numero");
//			}
//			conn.close();
//			return numero;
//		}catch(SQLException e ){
//			e.printStackTrace();
//			return -1;
//		}
//	}
//
//	
}
