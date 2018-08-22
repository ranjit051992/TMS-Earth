/**
 * 
 */
package com.zycus.automation.eproc.databaseutilities;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.SourcingEvent;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.testdata.IConstantsData;

/**
 * @author ankita.sawant
 *
 */
public class DatabaseUtilities
{
	static Logger logger = Logger.getLogger(DatabaseUtilities.class);

	public static void main(String[] args) throws Exception
	{
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try
		{

			/*
			 * AnnotationConfiguration config = new
			 * AnnotationConfiguration().configure();
			 * //config.addAnnotatedClass(MyClass.class); //Use this if config
			 * files are in src folder //config.configure(); //Use this if
			 * config files are in a subfolder of src, such as "resources"
			 * //config.configure("/hibernate.cfg.xml");
			 * config.setProperty("connection.url",
			 * "jdbc:sqlserver://192.168.4.184:1433;databaseName=AUTOMATION_STAGING"
			 * ); config.setProperty("connection.username",
			 * "AUTOMATION_TESTING"); config.setProperty("connection.password",
			 * "AUTOMATION_TESTING");
			 */
			// config.configure();

			/*
			 * Configuration configuration = new Configuration();
			 * //configuration.configure("/hibernate.cfg.xml"); ServiceRegistry
			 * serviceRegistry = new
			 * ServiceRegistryBuilder().applySettings(configuration.
			 * getProperties()) .build(); // .buildServiceRegistry();
			 * sessionFactory =
			 * configuration.configure("/hibernate.cfg.xml").buildSessionFactory
			 * (serviceRegistry);
			 */
			// sessionFactory = config.buildSessionFactory();
			// sessionFactory = new
			// AnnotationConfiguration().configure().buildSessionFactory();

			/*
			 * ServiceRegistry serviceRegistry = new
			 * ServiceRegistryBuilder().applySettings(configuration.
			 * getProperties()) .build();
			 */
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.setProperty("hibernate.connection.url", "jdbc:sqlserver://192.168.4.184:1433;databaseName=AUTOMATION_STAGING");
			configuration.setProperty("hibernate.connection.username", "AUTOMATION_TESTING");
			configuration.setProperty("hibernate.connection.password", "AUTOMATION_TESTING");
			/*
			 * ServiceRegistry serviceRegistry = new
			 * ServiceRegistryBuilder().applySettings(configuration.
			 * getProperties()) .build();
			 * 
			 * sessionFactory =
			 * configuration.buildSessionFactory(serviceRegistry);
			 */

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			SourcingEvent event = new SourcingEvent();
			event.setEventName("Event3");
			event.setEventDesc("Event3");
			event.setEventType("RFQ");
			event.setEventOwner("ankita@zycus.com");
			event.setFlowId("RTC_003");

			List<GuidedItem> guidedItems = new ArrayList<>();
			GuidedItem guidedItem = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);

			guidedItems.add(guidedItem);

			GuidedItem guidedItem1 = ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);

			guidedItems.add(guidedItem1);

			event.setGuidedItems(guidedItems);

			session.save(event);
			System.out.println("Event added successfully....");
			transaction.commit();
		}
		catch (Exception e)
		{
			if (transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
	}
}
