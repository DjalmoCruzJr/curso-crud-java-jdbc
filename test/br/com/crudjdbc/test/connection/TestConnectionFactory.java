package br.com.crudjdbc.test.connection;

import org.apache.log4j.Logger;

import br.com.crudjdbc.database.connection.ConnectionFactory;


public abstract class TestConnectionFactory {

	private static final Logger logger = Logger.getLogger(TestConnectionFactory.class);
	
	public static void testGetConnection() {
		logger.debug(ConnectionFactory.getConnection());
	}
	
	/* Test Main Method */
	public static void main(String[] args) {
		testGetConnection();
		testGetConnection();
	}

}
