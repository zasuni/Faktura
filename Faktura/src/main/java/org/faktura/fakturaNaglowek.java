package org.faktura;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.faktura.db.EntityBase;

public class fakturaNaglowek extends EntityBase{
	
	private Date dataW;   // Data wystawienia 
	private Date dataS1;  // Sprzeda¿ od...
	private Date dataS2;  // Sprzeda¿ do...
	private Date termin;  // Termin p³atnoœci
	
	// P³atnik:
	private int platnikId;
	private String platnikSkrot;
	private String platnikNazwa;
	private String platnikAdres;
	private String platnikKodMiasta;
	private String platnikMiasto;
	private String platnikNip;	
	
	// Odbiorca:
	private int odbiorcaId;
	private String odbiorcaSkrot;
	private String odbiorcaNazwa;
	private String odbiorcaAdres;
	private String odbiorcaKodMiasta;
	private String odbiorcaMiasto;
	private String odbiorcaNip;

	private float wartoscNetto;   // Ca³kowita wartoœæ netto faktury;
	private float wartoscBrutto;   // Ca³kowita wartoœæ brutto faktury;
	
	private int sposob;    // Sposób zap³aty: 0 - Gotówka, 1 - Karta, 2 - Przelew
	private int sposobNaliczaniaVat;  // 0: z netto licz brutto    1: z brutto licz netto
	
	
	public float getWartoscNetto() 
	{
		return wartoscNetto;
	}
	
	public void setWartoscNetto(float wartoscNetto)
	{
		this.wartoscNetto = wartoscNetto;
	}
	
	public float getWartoscBrutto()
	{
		return wartoscBrutto;
	}
	
	public void setWartoscBrutto(float wartoscBrutto) 
	{
		this.wartoscBrutto = wartoscBrutto;
	}

	public Date getDataW() 
	{
		return dataW;
	}
	
	public void setDataW(Date dataW)
	{
		this.dataW = dataW;
	}
	
	public Date getDataS1()
	{
		return dataS1;
	}
	public void setDataS1(Date dataS1) 
	{
		this.dataS1 = dataS1;
	}
	
	public Date getDataS2() 
	{
		return dataS2;
	}
	
	public void setDataS2(Date dataS2)
	{
		this.dataS2 = dataS2;
	}
	
	public Date getTermin() 
	{
		return termin;
	}
	
	public void setTermin(Date termin)
	{
		this.termin = termin;
	}
	
	public int getPlatnikId()
	{
		return platnikId;
	}	
	
	public void setPlatnikId(int platnikId) 
	{
		this.platnikId = platnikId;
	}
	
	public String getPlatnikSkrot()
	{
		return platnikSkrot;
	}
	
	public void setPlatnikSkrot(String platnikSkrot) 
	{
		this.platnikSkrot = platnikSkrot;
	}
	
	public String getPlatnikNazwa()
	{
		return platnikNazwa;
	}
	
	public void setPlatnikNazwa(String platnikNazwa) 
	{
		this.platnikNazwa = platnikNazwa;
	}
	
	public String getPlatnikAdres()
	{
		return platnikAdres;
	}
	
	public void setPlatnikAdres(String platnikAdres)
	{
		this.platnikAdres = platnikAdres;
	}
	
	public String getPlatnikKodMiasta() 
	{
		return platnikKodMiasta;
	}
	
	public void setPlatnikKodMiasta(String platnikKodMiasta) 
	{
		this.platnikKodMiasta = platnikKodMiasta;
	}
	
	public String getPlatnikMiasto()
	{
		return platnikMiasto;
	}
	
	public void setPlatnikMiasto(String platnikMiasto)
	{
		this.platnikMiasto = platnikMiasto;
	}
	
	public String getPlatnikNip()
	{
		return platnikNip;
	}
	
	public void setPlatnikNip(String platnikNip)
	{
		this.platnikNip = platnikNip;
	}

	public int getOdbiorcaId() 
	{
		return odbiorcaId;
	}
	
	public String getOdbiorcaSkrot()
	{
		return odbiorcaSkrot;
	}
	
	public void setOdbiorcaSkrot(String odbiorcaSkrot)
	{
		this.odbiorcaSkrot = odbiorcaSkrot;
	}
	
	public String getOdbiorcaNazwa()
	{
		return odbiorcaNazwa;
	}
	
	public void setOdbiorcaNazwa(String odbiorcaNazwa) 
	{
		this.odbiorcaNazwa = odbiorcaNazwa;
	}
	
	public String getOdbiorcaAdres() 
	{
		return odbiorcaAdres;
	}
	
	public void setOdbiorcaAdres(String odbiorcaAdres)
	{
		this.odbiorcaAdres = odbiorcaAdres;
	}
	
	public String getOdbiorcaKodMiasta()
	{
		return odbiorcaKodMiasta;
	}
	
	public void setOdbiorcaKodMiasta(String odbiorcaKodMiasta)
	{
		this.odbiorcaKodMiasta = odbiorcaKodMiasta;
	}
	
	public String getOdbiorcaMiasto()
	{
		return odbiorcaMiasto;
	}
	
	public void setOdbiorcaMiasto(String odbiorcaMiasto)
	{
		this.odbiorcaMiasto = odbiorcaMiasto;
	}
	
	public String getOdbiorcaNip() 
	{
		return odbiorcaNip;
	}
	
	public void setOdbiorcaNip(String odbiorcaNip) 
	{
		this.odbiorcaNip = odbiorcaNip;
	}
	
	public void setOdbiorcaId(int odbiorcaId)
	{
		this.odbiorcaId = odbiorcaId;
	}
	
	public int getSposob() {
		return sposob;
	}
	public void setSposob(int sposob) {
		this.sposob = sposob;
	}
	
	public int getSposobNaliczaniaVat()
	{
		return sposobNaliczaniaVat;
	}
	
	public void setSposobNaliczaniaVat(int sposobNaliczaniaVat)
	{
		this.sposobNaliczaniaVat = sposobNaliczaniaVat;
	}
	
	public void setALL(ResultSet rs)
	{
		try
		{
			this.setId(rs.getInt("id"));
			this.setDataW(rs.getDate("dataW"));
			this.setDataS1(rs.getDate("dataS1"));
			this.setDataS2(rs.getDate("dataS2"));
			this.setTermin(rs.getDate("termin"));
			this.setPlatnikId(rs.getInt("platnikId"));
			this.setPlatnikSkrot(rs.getString("platnikSkrot"));
			this.setPlatnikNazwa(rs.getString("platnikNazwa"));
			this.setPlatnikAdres(rs.getString("platnikAdres"));
			this.setPlatnikAdres(rs.getString("platnikKodMiasto"));
			this.setPlatnikMiasto(rs.getString("platnikMiasto"));
			this.setPlatnikNip(rs.getString("platnikNip"));
			this.setOdbiorcaId(rs.getInt("odbiorcaId"));
			this.setOdbiorcaSkrot(rs.getString("odbiorcaSkrot"));
			this.setOdbiorcaNazwa(rs.getString("odbiorcaNazwa"));
			this.setOdbiorcaAdres(rs.getString("odbiorcaAdres"));
			this.setOdbiorcaAdres(rs.getString("odbiorcaKodMiasto"));
			this.setOdbiorcaMiasto(rs.getString("odbiorcaMiasto"));
			this.setOdbiorcaNip(rs.getString("odbiorcaNip"));
			this.setWartoscNetto(rs.getFloat("wartoscNetto"));
			this.setWartoscBrutto(rs.getFloat("wartoscBrutto"));
			this.setSposob(rs.getInt("sposob"));
			this.setSposobNaliczaniaVat(rs.getInt("sposobNaliczaniaVat"));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
}
