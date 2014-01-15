package org.faktura.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.faktura.stawkiVat;
import org.faktura.db.MySQLDaoBase;
import org.faktura.db.MySQLUnitOfWork;

public class MySQLstawkiVatDao extends MySQLDaoBase<stawkiVat>{
	
	private String sql;

	public MySQLstawkiVatDao(MySQLUnitOfWork uow) {
		super(uow);
	}

	@Override
	protected void setUpdateQuery(stawkiVat ent) throws SQLException {

		update.setString(1, ent.getNazwa());
		update.setFloat(2, ent.getWartosc());
		update.setInt(3, ent.getId());
		
	}

	@Override
	protected stawkiVat build(ResultSet rs) throws SQLException {

		stawkiVat sv = new stawkiVat();
		
		sv.setId(rs.getInt("id"));
		sv.setNazwa(rs.getString("nazwa"));
		sv.setWartosc(rs.getFloat("wartosc"));
		
		return sv;
	}

	@Override
	protected void setInsertQuery(stawkiVat ent) throws SQLException {

		insert.setString(1, ent.getNazwa());
		insert.setFloat(2, ent.getWartosc());
		
	}

	@Override
	protected String getTableName() {

		sql = "stawkiVat";
		
		return sql;
	}

	@Override
	protected String getCreateQuery() {
		
		sql = "CREATE TABLE stawkiVat ("
			+ "id int PRIMARY KEY AUTO_INCREMENT NOT NULL,"
			+ "nazwa varchar(20),"
			+ "wartosc decimal(8,1));";
		
		return sql;
	}

	@Override
	protected String getInsertQuery() {

		sql = "INSERT INTO stawkiVat (nazwa, wartosc) VALUES (?, ?);";
		
		return sql;
	}

	@Override
	protected String getUpdateQuery() {
		
		sql = "UPDATE stawkiVat SET nazwa=?, wartosc=? WHERE id=?";
		
		return sql;
	}
	

}
