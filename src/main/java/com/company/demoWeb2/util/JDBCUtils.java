package com.company.demoWeb2.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    //声明一个静态私有属性
    private static DataSource dataSource;

    static {
        try {
            //1. 创建一个Properties对象
            Properties properties = new Properties();
            //2. 加载配置文件
            properties.load(
                    JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //3. 根据配置文件创建DataSource,这里用到了druid-1.1.10.jar
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //获取连接的方法
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}