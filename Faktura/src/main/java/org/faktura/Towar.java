package org.faktura;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.faktura.db.EntityBase;

public class Towar extends EntityBase{

	private String skrot;
	private String nazwa;
	private String jm;
	private float stan;
	private float cenaNetto;
	private float cenaBrutto;
	
	public String getSkrot() 
	{
		return skrot;
	}
	
	public void setSkrot(String skrot)
	{
		this.skrot = skrot;
	}
	
	public float getCenaNetto() 
	{
		return cenaNetto;
	}
	
	public void setCenaNetto(float cenaNetto) 
	{
		this.cenaNetto = cenaNetto;
	}
	
	public float getCenaBrutto()
	{
		return cenaBrutto;
	}
	
	public void setCenaBrutto(float cenaBrutto)
	{
		this.cenaBrutto = cenaBrutto;
	}
	
	public void setAll(ResultSet rs) 
	{
		try{
			
			this.setCenaBrutto(rs.getFloat("cenaBrutto"));
			this.setCenaNetto(rs.getFloat("cenaNetto"));
			this.setId(rs.getInt("id"));
			this.setJm(rs.getString("jm"));
			this.setNazwa(rs.getString("nazwa"));
			this.setSkrot(rs.getString("skrot"));
			this.setStan(rs.getFloat("stan"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getJm() {
		return jm;
	}
	public void setJm(String jm) {
		this.jm = jm;
	}
	public float getStan() {
		return stan;
	}
	public void setStan(float stan) {
		this.stan = stan;
	}
	
	
}
