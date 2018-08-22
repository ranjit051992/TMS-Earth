/**
 * 
 */
package com.zycus.automation.eproc.databaseutilities;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zycus.automation.exception.DatabaseException;

/**
 * @author ankita.sawant
 *
 */
public class BaseDaoServices
{
	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Insert record in database <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param object </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws DatabaseException
	 */
	public static Object insert(Object object) throws DatabaseException
	{
		Session session = null;
		Transaction transaction = null;
		BaseDao baseDao = new BaseDao();
		try
		{
			session = baseDao.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(object);
			transaction.commit();
		}
		catch (Exception e)
		{
			if (transaction != null)
			{
				transaction.rollback();
			}
			throw new DatabaseException("Exception occurred while inserting record in database : " + e, e);
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return object;
	}
}
