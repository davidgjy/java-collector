package org.genesis.javacollector.mybatis.train.datasource;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

/**
 * @Name: DbcpDataSourceFactory
 * @Description: datasource factory of dhcp
 * @author KG(Kelvin Gu)
 * @date 08-18-2018 10:21:49
*/
public class DbcpDataSourceFactory implements DataSourceFactory {
	private Properties props = null;

	@Override
	public void setProperties(Properties props) {
		this.props = props;
	}

	@Override
	public DataSource getDataSource() {
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dataSource;
	}
}