package com.dishtech.utilities;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


//Factory design pattern
public class ConnectionFactory {
	
	private static ConnectionFactory connFactory = new ConnectionFactory();
	
	//Singleton Design pattern
	public static ConnectionFactory getInstance(){
		return connFactory;
	}
	
	
	/**
	 * This method is used to get the connection from the datasource
	 * 
	 * @name getConnection
	 * @return Connection java.sql.Connection
	 * 
	 */
	public Connection getConnection() throws CarKornerException {
		// variable initialization
		// This variable is used to store the Context object.
		Context oInitContext = null;
		Context oEnvContext = null;

		// This variable is used to store the DataSource object.
		DataSource oDsrc = null;

		// This variable is used to store the Connection object.
		Connection oCon = null;

		try {
			oInitContext = new InitialContext();
		} catch (NamingException e) {
			throw new CarKornerException(e);
		}

		try {
			oEnvContext = (Context) oInitContext.lookup("java:/comp/env");
		} catch (NamingException e1) {
			throw new CarKornerException(
					"Failed to obtain a new Connection, Identified a naming exception.",
					e1);
		}

		/* The look up name as specified in the web.xml file */
		try {
			oDsrc = (DataSource) oEnvContext.lookup("jdbc/myoracle");
		} catch (NamingException e2) {
			throw new CarKornerException(
					"Failed to obtain a new Connection, Identified a naming exception.",
					e2);
		}

		try {
			oCon = oDsrc.getConnection();
			oCon.setAutoCommit(false);
		} catch (SQLException sqle) {

			close(oCon);
			throw new CarKornerException(
					"Failed to obtain a new Connection, Got a SQL Exception",
					sqle);
		}

		return oCon;
	}
	
	/**
	 * This method is used to close a connection
	 * 
	 * @name close
	 * @return void
	 * 
	 */
	public void close(Connection oCon) {

		if (oCon != null) {
			try {
				// if (!oCon.isClosed()) {
				oCon.close();
				// }
			} catch (SQLException ex) {

				System.out
						.println("FATAL :: Failed to release the connection, "
								+ ex);
			}
		}
	}

}
