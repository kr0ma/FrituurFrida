package be.vdab.dao;

import javax.sql.DataSource;

public abstract class abstractDAO {
	public final static String JNDI_NAME = "jdbc/frituurfrida";
	
	protected DataSource dataSource;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	

}
