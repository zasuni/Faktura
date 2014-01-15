package org.faktura;

import org.faktura.db.EntityBase;

public class stawkiVat extends EntityBase{

	private String nazwa;
	private float wartosc;
	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public float getWartosc() {
		return wartosc;
	}
	public void setWartosc(float wartosc) {
		this.wartosc = wartosc;
	}
	
}
