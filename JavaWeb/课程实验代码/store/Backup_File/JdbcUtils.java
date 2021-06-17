package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    // 数据库连接池
    public static DataSource ds = null;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    //加载驱动，静态代码块，保证加载类后只加载一次
    static{
        //1.加载配置文件
        InputStream inputStream=null;
        Properties pt = new Properties();
        try {
           inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pt.load(inputStream);
            ds = DruidDataSourceFactory.createDataSource(pt);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // 获取数据源
    public static DataSource getDs() {
        return ds;
    }
    // 获取数据库连接
    public static Connection getConnection()  {
        try {
            return  ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // 获取queryRunner
    public static QueryRunner getQueryRunner(){
        return  new QueryRunner(JdbcUtils.getDs());
    }

    // 判断数据库是否连接成功
    public static void isConnection(Connection conn){
        if (conn != null) {
            System.out.println("数据库能正常连接！");
        } else
            System.out.println("数据库连接失败！");
    }
    public static void close(Connection conn){
        try {
            if (conn!=null) conn.close();
            System.out.println("数据库能正常关闭！");
        } catch (SQLException e) {
            System.out.println("数据库关闭失败!");
            e.printStackTrace();
        }
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection != null) { // 如果不等于null，说明 之前使用过连接，操作过数据库
            try {
                connection.commit(); // 提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close(); // 关闭连接，资源资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则就会出错。（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if (connection != null) { // 如果不等于null，说明 之前使用过连接，操作过数据库
            try {
                connection.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close(); // 关闭连接，资源资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则就会出错。（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }


}