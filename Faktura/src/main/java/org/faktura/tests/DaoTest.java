package org.faktura.tests;

import static org.junit.Assert.*;

import org.faktura.Towar;
import org.faktura.db.MySQLUnitOfWork;
import org.faktura.db.dao.MySQLKontrahentDao;
import org.faktura.db.dao.MySQLTowarDao;
import org.junit.Test;

public class DaoTest {

	@Test
	public void test() {
		
		MySQLUnitOfWork uow = new MySQLUnitOfWork();
		
		MySQLTowarDao tDao = new MySQLTowarDao(uow);
		MySQLKontrahentDao kDao = new MySQLKontrahentDao(uow);
		
		Towar t = new Towar();
		
		t.setSkrot("KOMP1");
		t.setNazwa("Kmputer stacjonarny HP I3");
		t.setJm("SZT");
		t.setStan(0);
		t.setCenaNetto(1350);
		t.setCenaBrutto((float) 1660.5);
				
		tDao.persistAdd(t);

		
		assertTrue("Nie przydzielono id dla towaru !!!",t.getId()>0);
		
		
		
		
		
		//fail("Not yet implemented");
		
	}

}
