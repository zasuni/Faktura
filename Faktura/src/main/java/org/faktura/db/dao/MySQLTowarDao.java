package org.faktura.db.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.faktura.Towar;
import org.faktura.db.Dao;
import org.faktura.db.DaoBase;
import org.faktura.db.EntityBase;
import org.faktura.db.MySQLDaoBase;
import org.faktura.db.MySQLUnitOfWork;
import org.faktura.db.UnitOfWork;

public class MySQLTowarDao extends MySQLDaoBase<Towar>
{
	
	private String sql;
	
	public MySQLTowarDao(MySQLUnitOfWork uow)
	{
		super(uow);
	}
	

	@Override
	protected void setUpdateQuery(Towar ent) throws SQLException {
		update.setString(1, ent.getSkrot());
		update.setString(2, ent.getNazwa());
		update.setFloat(3, ent.getStan());
		update.setString(4, ent.getJm());
		update.setFloat(5,  ent.getCenaNetto());
		update.setFloat(6, ent.getCenaBrutto());
		update.setInt(7, ent.getId());				
	}


	@Override
	protected Towar build(ResultSet rs) throws SQLException {
		
		Towar t = new Towar();
		
		t.setId(rs.getInt("id"));
		t.setSkrot(rs.getString("skrot"));
		t.setNazwa(rs.getString("nazwa"));
		t.setStan(rs.getFloat("stan"));
		t.setJm(rs.getString("jm"));
		t.setCenaNetto(rs.getFloat("cenaNetto"));
		t.setCenaBrutto(rs.getFloat("cenaBrutto"));
		
		
		return t;
	}



	@Override
	protected void setInsertQuery(Towar ent) throws SQLException {
		
		insert.setString(1, ent.getSkrot());
		insert.setString(2, ent.getNazwa());
		insert.setFloat(3, ent.getStan());
		insert.setString(4, ent.getJm());
		insert.setFloat(5, ent.getCenaNetto());
		insert.setFloat(6, ent.getCenaBrutto());
		
	}


	@Override
	protected String getTableName() {
		return "Towar";
	}


	@Override
	protected String getCreateQuery() {
		
		sql = "CREATE TABLE Towar ("
			+ "id int PRIMARY KEY AUTO_INCREMENT NOT NULL,"
			+ "skrot varchar(20),"
			+ "nazwa varchar(50),"
			+ "stan decimal(15,3),"
			+ "jm varchar(4),"
			+ "cenaNetto decimal(15,2)"
			+ "cenaBrutto decimal(15,2)"
			+ ");";
		
		return sql;
	}


	@Override
	protected String getInsertQuery() {

		sql = "INSERT INTO towar (skrot, nazwa, stan, jm, cenaNetto, cenaBrutto)"
			+ "VALUES (?, ? ,?, ?, ?, ?)";
		
		return sql;
	}


	@Override
	protected String getUpdateQuery() {
		return "UPDATE towar SET skrot=?, nazwa=?, stan=?, jm=?, cenaNetto=?, cenaBrutto=? "
				+ "WHERE id=?";

	}

}
