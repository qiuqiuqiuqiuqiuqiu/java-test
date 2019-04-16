package com.test.design;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class SimpleConnPool {

    /**
     * 使用docker安装MySQL
     * docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=test -d mysql:latest
     */

    // 使用LinkedList集合存放数据库链接
    private static LinkedList<Connection> connPool = new LinkedList<Connection>();

    // 在静态代码块中加载配置文件，初始化链接
    static {
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < 10; i++) {
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql", "root", "123456");
                // 将创建的链接添加到list中
                System.out.println("初始化数据库连接池，创建第" + (i+1) + "个链接，添加到池中");
                connPool.add(conn);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 获取一个链接
    public static synchronized Connection getConnection() {
        if (connPool.size() > 0) {
            Connection conn = connPool.get(0);
            connPool.remove(0);
            return conn;
        } else {
            throw new RuntimeException("数据库繁忙，售后再试");
        }
    }

    // 关闭链接
    public static synchronized void closeConnection(Connection conn) {
        connPool.add(conn);
    }

}
