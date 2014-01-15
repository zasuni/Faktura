package org.faktura.db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.faktura.fakturaNaglowek;
import org.faktura.db.MySQLDaoBase;
import org.faktura.db.MySQLUnitOfWork;


public class MySQLfakturaNaglowekDao extends MySQLDaoBase<fakturaNaglowek>{
	
	private String sql;

	public MySQLfakturaNaglowekDao(MySQLUnitOfWork uow) {
		super(uow);
	}

	@Override
	protected void setUpdateQuery(fakturaNaglowek ent) throws SQLException {

		update.setDate(1, (Date) ent.getDataW());
		update.setDate(2, (Date) ent.getDataS1());
		update.setDate(3, (Date) ent.getDataS2());
		update.setDate(4, (Date) ent.getTermin());
		update.setInt(5, ent.getPlatnikId());
		update.setString(6, ent.getPlatnikSkrot());
		update.setString(7, ent.getPlatnikNazwa());
		update.setString(8, ent.getPlatnikAdres());
		update.setString(9, ent.getPlatnikKodMiasta());
		update.setString(10, ent.getPlatnikMiasto());
		update.setString(11, ent.getPlatnikNip());
		update.setInt(12, ent.getOdbiorcaId());
		update.setString(13, ent.getOdbiorcaSkrot());
		update.setString(14, ent.getOdbiorcaNazwa());
		update.setString(15, ent.getOdbiorcaAdres());
		update.setString(16, ent.getOdbiorcaKodMiasta());
		update.setString(17, ent.getOdbiorcaMiasto());
		update.setString(18, ent.getOdbiorcaNip());
		update.setFloat(19, ent.getWartoscNetto());
		update.setFloat(20, ent.getWartoscBrutto());
		update.setInt(21, ent.getSposob());
		update.setInt(22, ent.getSposobNaliczaniaVat());
		update.setInt(23, ent.getId());
		
		
	}

	@Override
	protected fakturaNaglowek build(ResultSet rs) throws SQLException {

		fakturaNaglowek fn = new fakturaNaglowek();
		
		fn.setDataW(rs.getDate("DataW"));
		fn.setDataS1(rs.getDate("DataS1"));
		fn.setDataS2(rs.getDate("DataS2"));
		fn.setTermin(rs.getDate("Termin"));
		fn.setPlatnikId(rs.getInt("PlatnikId"));
		fn.setPlatnikSkrot(rs.getString("getPlatnikSkrot"));
		fn.setPlatnikNazwa(rs.getString("PlatnikNazwa"));
		fn.setPlatnikAdres(rs.getString("PlatnikAdres"));
		fn.setPlatnikKodMiasta(rs.getString("PlatnikKodMiasta"));
		fn.setPlatnikMiasto(rs.getString("PlatnikMiasto"));
		fn.setPlatnikNip(rs.getString("PlatnikNip"));
		fn.setOdbiorcaId(rs.getInt("OdbiorcaId"));
		fn.setOdbiorcaSkrot(rs.getString("OdbiorcaSkrot"));
		fn.setOdbiorcaNazwa(rs.getString("OdbiorcaNazwa"));
		fn.setOdbiorcaAdres(rs.getString("OdbiorcaAdres"));
		fn.setOdbiorcaKodMiasta(rs.getString("OdbiorcaKodMiasta"));
		fn.setOdbiorcaMiasto(rs.getString("OdbiorcaMiasto"));
		fn.setOdbiorcaNip(rs.getString("OdbiorcaNip"));
		fn.setWartoscNetto(rs.getFloat("WartoscNetto"));
		fn.setWartoscBrutto(rs.getFloat("WartoscBrutto"));
		fn.setSposob(rs.getInt("Sposob"));
		fn.setSposobNaliczaniaVat(rs.getInt("SposobNaliczaniaVat"));
		
		return fn;
	}

	@Override
	protected void setInsertQuery(fakturaNaglowek ent) throws SQLException {

		insert.setDate(1, (Date) ent.getDataW());
		insert.setDate(2, (Date) ent.getDataS1());
		insert.setDate(3, (Date) ent.getDataS2());
		insert.setDate(4, (Date) ent.getTermin());
		insert.setInt(5, ent.getPlatnikId());
		insert.setString(6, ent.getPlatnikSkrot());
		insert.setString(7, ent.getPlatnikNazwa());
		insert.setString(8, ent.getPlatnikAdres());
		insert.setString(9, ent.getPlatnikKodMiasta());
		insert.setString(10, ent.getPlatnikMiasto());
		insert.setString(11, ent.getPlatnikNip());
		insert.setInt(12, ent.getOdbiorcaId());
		insert.setString(13, ent.getOdbiorcaSkrot());
		insert.setString(14, ent.getOdbiorcaNazwa());
		insert.setString(15, ent.getOdbiorcaAdres());
		insert.setString(16, ent.getOdbiorcaKodMiasta());
		insert.setString(17, ent.getOdbiorcaMiasto());
		insert.setString(18, ent.getOdbiorcaNip());
		insert.setFloat(19, ent.getWartoscNetto());
		insert.setFloat(20, ent.getWartoscBrutto());
		insert.setInt(21, ent.getSposob());
		insert.setInt(22, ent.getSposobNaliczaniaVat());
		
	}

	@Override
	protected String getTableName() {

		sql = "fakturanaglowek";
		
		return sql;
	}

	@Override
	protected String getCreateQuery() {
		
		sql = "CREATE TABLE fakturaNaglowek ("
			+ "id int PRIMARY KEY AUTO_INCREMENT,"
			+ "dataW timestamp not null,"
			+ "dataS1 timestamp not null,"
			+ "dataS2 timestamp not null,"
			+ "termin timestamp not null,"
			+ "platnikId int not null,"
			+ "platnikSkrot Varchar(10),"
			+ "platnikNazwa varchar(100),"
			+ "platnikAdres varchar(60),"
			+ "platnikKodMiasta varchar(6),"
			+ "platnikMiasto varchar(60),"
			+ "platnikNip varchar(14),"
			+ "odbiorcaId int not null,"
			+ "odbiorcaSkrot Varchar(10),"
			+ "odbiorcaNazwa varchar(100),"
			+ "odbiorcaAdres varchar(60),"
			+ "odbiorcaKodMiasta varchar(6),"
			+ "odbiorcaMiasto varchar(60),"
			+ "odbiorcaNip varchar(14),"
			+ "wartoscNetto decimal(15,2),"
			+ "wartoscBrutto decimal(15,2),"
			+ "sposob int,"
			+ "sposobNaliczaniaVat int,"
			+ "CONSTRAINT FOREIGN KEY (platnikId) REFERENCES Kontrahent (id) on delete no action on update no action,"
			+ "CONSTRAINT FOREIGN KEY (odbiorcaId) REFERENCES Kontrahent (id) on delete no action on update no action"
			+")";
		
		return sql;
	}

	@Override
	protected String getInsertQuery() {
		
		sql = "INSERT INTO fakturaNaglowek (dataW, dataS1, dataS2, termin,"
			+ "platnikId, platnikSkrot, platnikNazwa, platnikAdres, platnikKodMiasta, platnikNip,"
			+ "odbiorcaId, odbiorcaSkrot, odbiorcaNazwa, odbiorcaAdres, odbiorcaKodMiasta, odbiorcaMiasto, odbiorcaNip,"
			+ "wartoscNetto, wartoscBrutto, sposob, sposobNaliczaniaVat)"
			+ "VALUES (?, ?, ?, ?,"
			+ "?, ?, ?, ?, ?, ?, "
			+ "?, ?, ?, ?, ?, ?, "
			+ "?, ?, ?, ?);";
		
		return sql;
	}

	@Override
	protected String getUpdateQuery() {
		
		sql = "UPDATE fakturaNaglowek SET dataW=?, dataS1=?, dataS2=?, termin=?,"
			+ "platnikId=?, platnikSkrot=?, platnikNazwa=?, platnikAdres=?, platnikKodMiasta=?, platnikMiasto=?, platnikNip=?,"
			+ "odbiorcaId=?, odbiorcaSkrot=?, odbiorcaNazwa=?, odbiorcaAdres=?, odbiorcaKodMiasta=?, odbiorcaMiasto=?, odbiorcaNip=?"
			+ "wartoscNetto=?, wartoscBrutto=?, sposob=?, sposobNaliczaniaVat=?"
			+ "WHERE id=?;";
				
		return sql;
	}
	

}
