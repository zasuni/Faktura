package org.faktura.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.faktura.Kontrahent;
import org.faktura.db.MySQLDaoBase;
import org.faktura.db.MySQLUnitOfWork;

public class MySQLKontrahentDao extends MySQLDaoBase<Kontrahent>{

	private String sql;
	
	public MySQLKontrahentDao(MySQLUnitOfWork uow) {
		super(uow);
	}

	@Override
	protected void setUpdateQuery(Kontrahent ent) throws SQLException {

		update.setString(1, ent.getSkrot());
		update.setString(2, ent.getNazwa());
		update.setString(3, ent.getNip());
		update.setString(4, ent.getAdres());
		update.setString(5, ent.getKodMiasta());
		update.setString(6, ent.getMiasto());
		update.setInt(7, ent.getId());		
		
	}

	@Override
	protected Kontrahent build(ResultSet rs) throws SQLException {

		Kontrahent k = new Kontrahent();
		
		k.setId(rs.getInt("id"));
		k.setSkrot(rs.getString("skrot"));
		k.setNazwa(rs.getString("nazwa"));
		k.setNip(rs.getString("nip"));
		k.setAdres(rs.getString("adres"));
		k.setKodMiasta(rs.getString("kodMiasto"));
		k.setMiasto(rs.getString("Miasto"));

		return k;
	}

	@Override
	protected void setInsertQuery(Kontrahent ent) throws SQLException {

		insert.setString(1, ent.getSkrot());
		insert.setString(2, ent.getNazwa());
		insert.setString(3, ent.getNip());
		insert.setString(4, ent.getAdres());
		insert.setString(5, ent.getKodMiasta());
		insert.setString(6, ent.getMiasto());
		
	}

	@Override
	protected String getTableName() {

		sql = "Kontrahent";
		
		return sql;
	}

	@Override
	protected String getCreateQuery() {

		sql = "CREATE TABLE Kontrahent ("
			+ "id int PRIMARY KEY AUTO_INCREMENT NOT NULL,"
			+ "skrot varchar(20),"
			+ "nazwa varchar(200),"
			+ "nip varchar(14),"
			+ "adres varchar(100),"
			+ "kodMiasto varchar(6),"
			+ "miasto varchar(50));";
		
		return sql;
	}

	@Override
	protected String getInsertQuery() {

		sql = "INSERT INTO Kontrahent (skrot, nazwa, nip, adres, kodMiasto, Miasto)"
			+ "VALUES (?, ?, ?, ?, ?, ?);";
		
		return sql;
	}

	@Override
	protected String getUpdateQuery() {

		sql = "UPDATE Kontrahent SET skrot=?, nazwa=?, nip=?, adres=?, kodMiasto=?, miasto=?"
			+ "WHERE id=?";
		
		return sql;
	}
	
	

}
