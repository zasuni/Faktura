package org.faktura.db;

public interface UnitOfWork {

	public void markNew(EntityBase ent, UnitOfWorkDao dao);
	public void markDeleted(EntityBase ent, UnitOfWorkDao dao);
	public void markUpdate(EntityBase ent, UnitOfWorkDao dao);
	
	public void commit();
	
}
