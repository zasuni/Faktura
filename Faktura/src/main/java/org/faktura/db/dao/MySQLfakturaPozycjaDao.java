package org.faktura.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.faktura.fakturaPozycja;
import org.faktura.db.Dao;
import org.faktura.db.MySQLDaoBase;
import org.faktura.db.MySQLUnitOfWork;

public class MySQLfakturaPozycjaDao extends MySQLDaoBase<fakturaPozycja> {

	private String sql;
	
	public MySQLfakturaPozycjaDao(MySQLUnitOfWork uow) {
		super(uow);
	}

	@Override
	protected void setUpdateQuery(fakturaPozycja ent) throws SQLException {

		update.setInt(1, ent.getFakturaId());
		update.setInt(2, ent.getTowarId());
		update.setInt(3, ent.getStawkaId());
		update.setInt(4, ent.getSposobNaliczaniaVat());
		update.setString(5, ent.getTowarSkrot());
		update.setString(6, ent.getTowarNazwa());
		update.setString(7, ent.getTowarJm());
		update.setFloat(8, ent.getStawkaWartosc());
		update.setString(9, ent.getStawkaNazwa());
		update.setFloat(10, ent.getIlosc());
		update.setFloat(11, ent.getCenaNetto());
		update.setFloat(12, ent.getCenaBrutto());
		update.setFloat(13, ent.getWartoscNetto());
		update.setFloat(14, ent.getWartoscBrutto());
		update.setInt(15, ent.getId());
		
	}

	@Override
	protected fakturaPozycja build(ResultSet rs) throws SQLException {

		fakturaPozycja fp = new fakturaPozycja();
		
		fp.setId(rs.getInt("id"));
		fp.setTowarId(rs.getInt("TowarId"));
		fp.setStawkaId(rs.getInt("StawkaId"));
		fp.setSposobNaliczaniaVat(rs.getInt("SposobNaliczaniaVat"));
		fp.setTowarSkrot(rs.getString("TowarSkrot"));
		fp.setTowarNazwa(rs.getString("TowarNazwa"));
		fp.setTowarJm(rs.getString("TowarJm"));
		fp.setStawkaWartosc(rs.getFloat("StawkaWartosc"));
		fp.setStawkaNazwa(rs.getString("StawkaNazwa"));
		fp.setIlosc(rs.getFloat("Ilosc"));
		fp.setCenaNetto(rs.getFloat("cenaNetto"));
		fp.setCenaBrutto(rs.getFloat("cenaBrutto"));
		fp.setCenaBrutto(rs.getFloat("wartoscNetto"));
		fp.setWartoscBrutto(rs.getFloat("wartoscBrutto"));
		
		return fp;
	}

	@Override
	protected void setInsertQuery(fakturaPozycja ent) throws SQLException {
		
		insert.setInt(1, ent.getFakturaId());
		insert.setInt(2, ent.getTowarId());
		insert.setInt(3, ent.getStawkaId());
		insert.setInt(4, ent.getSposobNaliczaniaVat());
		insert.setString(5, ent.getTowarSkrot());
		insert.setString(6, ent.getTowarNazwa());
		insert.setString(7, ent.getTowarJm());
		insert.setFloat(8, ent.getStawkaWartosc());
		insert.setString(9, ent.getStawkaNazwa());
		insert.setFloat(10, ent.getIlosc());
		insert.setFloat(11, ent.getCenaNetto());
		insert.setFloat(12, ent.getCenaBrutto());
		insert.setFloat(13, ent.getWartoscNetto());
		insert.setFloat(14, ent.getWartoscBrutto());
		
	}

	@Override
	protected String getTableName() {

		sql = "fakturapozycja";
		
		return sql;
	}

	@Override
	protected String getCreateQuery() {

		sql = "CREATE TABLE fakturaPozycja ("
			+ "id int PRIMARY KEY AUTO_INCREMENT,"
			+ "fakturaId int not null,"
			+ "towarId int not null,"
			+ "stawkaId int not null,"
			+ "sposobNaliczaniaVat int,"
			+ "towarSkrot varchar(20),"
			+ "towarNazwa varchar(100),"
			+ "towarJm varchar(4),"
			+ "stawkaWartosc decimal(15,2),"
			+ "stawkaNazwa varchar(4),"
			+ "ilosc decimal(15,3),"
			+ "cenaNetto decimal(15,2),"
			+ "cenaBrutto decimal(15,2),"
			+ "wartoscNetto decimal(15,2),"
			+ "wartoscBrutto decimal(15,2),"
			+ "CONSTRAINT FOREIGN KEY (fakturaId) REFERENCES fakturaNaglowek (id) on delete no action on update no action," 
			+ "CONSTRAINT FOREIGN KEY (towarId) REFERENCES towar (id) on delete no action on update no action,"
			+ "CONSTRAINT FOREIGN KEY (stawkaId) REFERENCES stawkiVat (id) on delete no action on update no action"
			+ ")";
				
		return sql;
	}

	@Override
	protected String getInsertQuery() {

		sql = "INSERT INTO fakturaPozycja (fakturaId, towarId, stawkaId, sposobNaliczaniaVat,"
			+ "towarSkrot, towarNazwa, towarJm, stawkaWartosc, stawkaNazwa, ilosc, cenaNetto,"
			+ "cenaBrutto, wartoscNetto, wartoscBrutto) values (?,?,?,?,?,?)";
				
		return sql;
		
	}

	@Override
	protected String getUpdateQuery() {
		
		sql = "UPDATE fakturaPozycja SET fakturaId=?, towarId=?, stawkaId=?, sposobNaliczaniaVat=?,"
			+ "towarSkrot=?, towarNazwa=?, towarJm=? stawkaWartosc=?, stawkaNazwa=?, ilosc=?,"
			+ "cenaNetto=?, cenaBrutto=?, wartoscNetto=?, wartoscBrutto=? WHERE id=?;";
				
		return sql;
	}
	
}


