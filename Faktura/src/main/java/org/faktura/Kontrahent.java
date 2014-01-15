package org.faktura;

import org.faktura.db.EntityBase;

public class Kontrahent extends EntityBase{
	
	private String skrot;
	private String nazwa;
	private String adres;
	private String kodMiasta;
	private String miasto;
	private String nip;
	
	
	public String getSkrot() {
		return skrot;
	}
	public void setSkrot(String skrot) {
		this.skrot = skrot;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getKodMiasta() {
		return kodMiasta;
	}
	public void setKodMiasta(String kodMiasta) {
		this.kodMiasta = kodMiasta;
	}
	public String getMiasto() {
		return miasto;
	}
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}

}
