package org.faktura.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySQLUnitOfWork implements UnitOfWork{
	
	private Map<EntityBase, UnitOfWorkDao> added;
	private Map<EntityBase, UnitOfWorkDao> deleted;
	private Map<EntityBase, UnitOfWorkDao> updated;

	Connection connection;
	
	public MySQLUnitOfWork()
	{
		added = new HashMap<EntityBase, UnitOfWorkDao>();
		deleted = new HashMap<EntityBase, UnitOfWorkDao>();
		updated = new HashMap<EntityBase, UnitOfWorkDao>();
		
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/faktura?user=root&password=123456");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection()
	{
		
		try
		{
			if(connection==null || connection.isClosed())
			{
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/faktura?user=root&password=123456");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	@Override
	public void markNew(EntityBase ent, UnitOfWorkDao dao) {
		
		added.put(ent,  dao);
		
	}

	@Override
	public void markDeleted(EntityBase ent, UnitOfWorkDao dao) {
		
		deleted.put(ent, dao);
	}

	@Override
	public void markUpdate(EntityBase ent, UnitOfWorkDao dao) {
		
		updated.put(ent, dao);
	}

	@Override
	public void commit() {
		
		Connection connection = getConnection();
		try
		{
			connection.setAutoCommit(false);
			
			for(EntityBase ent : added.keySet())
			{
				added.get(ent).persistAdd(ent);
			}
			
			for(EntityBase ent : deleted.keySet())
			{
				deleted.get(ent).persistAdd(ent);
			}

			for(EntityBase ent : added.keySet())
			{
				updated.get(ent).persistAdd(ent);
			}

			connection.commit();
			
			added.clear();
			deleted.clear();
			updated.clear();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(connection!=null && !connection.isClosed())
				{
					connection.close();
					connection=null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
