package com.freedom.mebatis.v1;

import com.freedom.mebatis.v1.mapper.Blog;

import java.sql.*;

/**
 * @Description 执行器，真正执行sql的地方
 * @Author Roger
 * @Version V1.0.0
 * @Since 1.0
 * @Date 3/3/21
 */
public class RExecutor {
    public <T> T query(String sql, Object param) {
        Connection connection = null;
        Statement statement = null;
        Blog blog = new Blog();

        try {
            // 注册驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //打开连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mebatis", "root", "kmj123456");
            //执行查询
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format(sql, param));
            //获取结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            System.out.println(blog);

            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {statement.close();}
            } catch (SQLException se2) {
            }
            try {
                if (connection != null) {connection.close();}
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T)blog;
    }
}
