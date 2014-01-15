package org.faktura;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.faktura.db.EntityBase;

public class fakturaPozycja extends EntityBase{
	
	private int fakturaId;
	private int towarId;
	private int stawkaId;
	private int sposobNaliczaniaVat;  // 0: z netto licz brutto    1: z brutto licz netto
	private String towarSkrot;
	private String towarNazwa;
	private String towarJm;
	private float stawkaWartosc;
	private String stawkaNazwa;
	private float ilosc;
	private float cenaNetto;
	private float cenaBrutto;
	private float wartoscNetto;
	private float wartoscBrutto;
	
	// pola wirtualne (nie maj¹ce odniesienia w tabeli bazy danych):
	private float podatek;
	
	public fakturaPozycja() {
		sposobNaliczaniaVat = 0;
	}
	
	public void ObliczCeny() {
		
		if(this.sposobNaliczaniaVat==0){
			this.podatek = this.cenaNetto * (1 + this.stawkaWartosc / 100);
			this.cenaBrutto = this.cenaNetto + this.podatek;			
		}else{
			this.podatek = this.cenaBrutto * (this.stawkaWartosc/(100+this.stawkaWartosc));
			this.cenaNetto = this.cenaBrutto - this.podatek;
		}
		
		this.wartoscNetto = this.ilosc * this.cenaNetto;
		this.wartoscBrutto = this.ilosc * this.cenaBrutto;
		
	}
	
	public int getSposobNaliczaniaVat() 
	{
		return sposobNaliczaniaVat;
	}
	
	public void setSposobNaliczaniaVat(int sposobNaliczaniaVat) 
	{
		ObliczCeny();
		this.sposobNaliczaniaVat = sposobNaliczaniaVat;
	}
	
	public int getStawkaId() 
	{
		return stawkaId;
	}
	
	public void setStawkaId(int stawkaId) 
	{
		this.stawkaId = stawkaId;
	}
	
	public float getStawkaWartosc() 
	{
		return stawkaWartosc;
	}
	
	public void setStawkaWartosc(float stawkaWartosc) 
	{
		this.stawkaWartosc = stawkaWartosc;
		ObliczCeny();
	}
	
	public String getStawkaNazwa() 
	{
		return stawkaNazwa;
	}
	
	public void setStawkaNazwa(String stawkaNazwa) 
	{
		this.stawkaNazwa = stawkaNazwa;
	}
	
	public float getIlosc() 
	{
		return ilosc;
	}
	
	public void setIlosc(float ilosc) 
	{
		this.ilosc = ilosc;
		ObliczCeny();
	}
	
	public int getFakturaId() 
	{
		return fakturaId;
	}
	
	public void setFakturaId(int fakturaId) 
	{
		this.fakturaId = fakturaId;
	}
	
	public int getTowarId() 
	{
		return towarId;
	}
	
	public void setTowarId(int towarId) 
	{
		this.towarId = towarId;
	}
	
	public String getTowarSkrot() 
	{
		return towarSkrot;
	}
	
	public void setTowarSkrot(String towarSkrot) 
	{
		this.towarSkrot = towarSkrot;
	}
	
	public String getTowarNazwa() 
	{
		return towarNazwa;
	}
	
	public void setTowarNazwa(String towarNazwa) 
	{
		this.towarNazwa = towarNazwa;
	}
	
	public String getTowarJm() 
	{
		return towarJm;
	}
	
	public void setTowarJm(String towarJm) 
	{
		this.towarJm = towarJm;
	}
	
	public float getCenaNetto()
	{
		return cenaNetto;
	}
	
	public void setCenaNetto(float cenaNetto) 
	{
		ObliczCeny();
		this.cenaNetto = cenaNetto;
	}
	
	public float getCenaBrutto() 
	{
		return cenaBrutto;
	}
	
	public void setCenaBrutto(float cenaBrutto) 
	{
		ObliczCeny();
		this.cenaBrutto = cenaBrutto;
	}
	
	public float getWartoscNetto() 
	{
		return wartoscNetto;
	}
	
	public void setWartoscNetto(float wartoscNetto) 
	{	
		ObliczCeny();
		this.wartoscNetto = wartoscNetto;
	}
	
	public float getWartoscBrutto() 
	{
		return wartoscBrutto;
	}
	
	public void setWartoscBrutto(float wartoscBrutto) 
	{
		ObliczCeny();
		this.wartoscBrutto = wartoscBrutto;
	}
	
	
	public void setALL(ResultSet rs)
	{
		try
		{
			this.setId(rs.getInt("id"));
			this.setFakturaId(rs.getInt("fakturaId"));
			this.setTowarId(rs.getInt("towarId"));
			this.setStawkaId(rs.getInt("stawkaId"));
			this.setSposobNaliczaniaVat(rs.getInt("sposobNaliczaniaVat"));
			this.setTowarSkrot(rs.getString("towarSkrot"));
			this.setTowarNazwa(rs.getString("towarNazwa"));
			this.setTowarJm(rs.getString("towarJm"));
			this.setStawkaWartosc(rs.getFloat("stawkaWartosc"));
			this.setStawkaNazwa(rs.getString("stawkaNazwa"));
			this.setIlosc(rs.getFloat("ilosc"));
			this.setCenaNetto(rs.getFloat("cenaNetto"));
			this.setCenaBrutto(rs.getFloat("cenaBrutto"));
			this.setWartoscNetto(rs.getFloat("wartoscNetto"));
			this.setWartoscBrutto(rs.getFloat("wartoscBrutto"));
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
}
