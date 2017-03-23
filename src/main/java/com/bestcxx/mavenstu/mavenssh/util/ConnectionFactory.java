package com.bestcxx.mavenstu.mavenssh.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
 
import javax.sql.DataSource;
 
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnection;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
 
public class ConnectionFactory {
	/*final private static String  jdbcurl=CustomizedPropertyPlaceholderConfigurer.getContextProperty("jdbc.url");
	final private static String  jdbcusername=CustomizedPropertyPlaceholderConfigurer.getContextProperty("jdbc.username");
	final private static String  jdbcpassword=CustomizedPropertyPlaceholderConfigurer.getContextProperty("jdbc.password");
	*/
	
	private static interface Singleton {
        final ConnectionFactory INSTANCE = new ConnectionFactory();
    }
 
    private final DataSource dataSource;
 
    private static InputStream inStream = ConnectionFactory.class.getClassLoader().getResourceAsStream(EnumUtil.COMMON_DATABASE_PROPERTIES.toString());
    private static Properties prop = new Properties();

	private ConnectionFactory() {

		try {
			prop.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String jdbcusername = prop.getProperty("jdbc.username");//数据库连接用户名
		String jdbcpassword = prop.getProperty("jdbc.password");//数据库连接密码
		String jdbcurl = prop.getProperty("jdbc.url");//数据库连接url

		Properties properties = new Properties();
		properties.setProperty("user", jdbcusername);
		properties.setProperty("password", jdbcpassword); // or get properties from some configuration file
 
        GenericObjectPool<PoolableConnection> pool = new GenericObjectPool<PoolableConnection>();
        DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
        		jdbcurl, properties
        );
        new PoolableConnectionFactory(
            connectionFactory, pool, null, "SELECT 1", 3, false, false, Connection.TRANSACTION_READ_COMMITTED
        );
 
        this.dataSource = new PoolingDataSource(pool);
    }
 
    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }
}
