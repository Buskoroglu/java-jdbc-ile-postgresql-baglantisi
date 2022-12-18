package com.jdbc;
import java.sql.*;

public class connect {

public static void main(String[] args) {
	
        Connection connection;
		
		try {
			
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Filmler","postgres","Bus4korogl.");
			if(connection != null)
				System.out.println("Veritabanina baglanti basarili.\n\n\n");
			else
				System.out.println("Veritabanina baglanti basarisiz.");
			Statement st = connection.createStatement();
			String query = "SELECT * FROM filmler INNER JOIN senarist ON filmler.senarist_id=senarist.senarist_id INNER JOIN oyuncu ON filmler.oyuncu_id=oyuncu.oyuncu_id INNER JOIN yonetmen ON filmler.yonetmen_id=yonetmen.yonetmen_id";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
			
					System.out.println("Film adi: "+ rs.getString("film_adi")+"\n" +"Senaristi : "+ rs.getString("senarist_ad") +" "+ rs.getString("senarist_soyad") +"\n" +  "Yayinlanma tarihi: " + rs.getString("yayinlanma_tarihi")+"\n"+"Oyuncu: "+rs.getString("oyuncu_ad") +" "+ rs.getString("oyuncu_soyad")+"\n"+"Yonetmeni: "+rs.getString("yonetmen_ad")+" "+rs.getString("yonetmen_soyad")+"\n");	
			}
			
			st.executeUpdate(query);
		}catch(Exception e){
			
		}
	}
	}
