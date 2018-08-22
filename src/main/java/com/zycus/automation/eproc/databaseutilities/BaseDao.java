/**
 * 
 */
package com.zycus.automation.eproc.databaseutilities;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zycus.automation.eproc.testdata.IConstantsData;

/**
 * @author ankita.sawant
 *
 */
public class BaseDao
{
	static Logger					logger			= Logger.getLogger(BaseDao.class);
	private static SessionFactory	sessionFactory	= null;
	public static Configuration		configuration	= null;

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get configuration object and session
	 * factory object <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param url </font><b><br>
	 * @param username </font><b><br>
	 * @param password </font><b><br>
	 * @return </b> <br>
	 */
	static
	{
		try
		{
			// update configuration at runtime
			configuration = new Configuration();
			configuration.configure();
			configuration.setProperty("hibernate.connection.url", IConstantsData.connection_url);
			configuration.setProperty("hibernate.connection.username", IConstantsData.connection_username);
			configuration.setProperty("hibernate.connection.password", IConstantsData.connection_password);

			/*
			 * //create session factory ServiceRegistry serviceRegistry = new
			 * ServiceRegistryBuilder().applySettings(configuration.
			 * getProperties()) .build(); sessionFactory =
			 * configuration.buildSessionFactory(serviceRegistry);
			 */
		}
		catch (Throwable e)
		{
			logger.error("Failed to create session factory object..." + e, e);
			throw new ExceptionInInitializerError(e);
		}
	}

}
