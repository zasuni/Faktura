import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.faktura.Towar;
import org.faktura.fakturaPozycja;
import org.faktura.db.MySQLUnitOfWork;
import org.faktura.db.dao.MySQLKontrahentDao;
import org.faktura.db.dao.MySQLTowarDao;
import org.faktura.db.dao.MySQLfakturaNaglowekDao;
import org.faktura.db.dao.MySQLfakturaPozycjaDao;
import org.faktura.db.dao.MySQLstawkiVatDao;


public class Main {


	public static void main(String[] args) {

		
		MySQLUnitOfWork uow = new MySQLUnitOfWork();
		
		
		MySQLTowarDao tdao = new MySQLTowarDao(uow);
		MySQLKontrahentDao kdao = new MySQLKontrahentDao(uow);
		MySQLstawkiVatDao svdao = new MySQLstawkiVatDao(uow);
		MySQLfakturaNaglowekDao fndao = new MySQLfakturaNaglowekDao(uow);
		MySQLfakturaPozycjaDao fpdao = new MySQLfakturaPozycjaDao(uow);


	}

}
