package DAO;

import Model.User;
import com.sun.corba.se.impl.protocol.INSServerRequestDispatcher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public static boolean userRegister(Connection conn,String username,String password)
    {
        String selectSqlStr="SELECT * FROM user WHERE username=?";
        try {
            PreparedStatement selectPreparedStatement = conn.prepareStatement(selectSqlStr);
            selectPreparedStatement.setString(1,username);
            ResultSet rs= selectPreparedStatement.executeQuery();
            if(rs.next())
            {
                //该用户名已经存在
                rs.close();
                selectPreparedStatement.close();
                return false;
            }
        }catch (SQLException e)
        {
            System.out.println("用户注册时，查找用户名时发生异常。异常信息为:"+e);
            return false;
        }
        String insertSqlStr="INSERT INTO user(username,password) VALUES(?,?)";
        try{
            PreparedStatement insertPreparedStatement=conn.prepareStatement(insertSqlStr);
            insertPreparedStatement.setString(1,username);
            insertPreparedStatement.setString(2,password);
            int isInsert=insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();
            if(isInsert>0)
            {
                //说明用户创建成功
                //todo 建立用户数据档案
                //再查到该用户的id
                String selectSqlStr2="SELECT * FROM user WHERE username=?";
                int uid=-1;
                try {
                    PreparedStatement selectPreparedStatement2 = conn.prepareStatement(selectSqlStr);
                    selectPreparedStatement2.setString(1,username);
                    ResultSet rs= selectPreparedStatement2.executeQuery();
                    if(rs.next())
                    {
                        uid=rs.getInt("id");//获得用户id
                        rs.close();
                        selectPreparedStatement2.close();

                    }
                }catch (SQLException e2)
                {
                    System.out.println("建立用户数据档案查询用户时发生异常"+e2);
                }
                ScoreDao.createUserScoreTable(conn,uid,0,0);
                return true;
            }else{
                //说明创建用户失败
                return false;
            }

        }catch (SQLException e1)
        {
            System.out.println("插入用户到用户表发生异常"+e1);
        }
        return false;

    }

    public static User userLogin(Connection conn,String username,String password)
    {
        String selectSqlStr="SELECT * FROM user WHERE username=? AND password=?";
        try{
            PreparedStatement selectPreparedStatement=conn.prepareStatement(selectSqlStr);
            selectPreparedStatement.setString(1,username);
            selectPreparedStatement.setString(2,password);
            ResultSet resultSet=selectPreparedStatement.executeQuery();
            if(resultSet.next())
            {
                int uid=resultSet.getInt("id");
                resultSet.close();
                selectPreparedStatement.close();
                User loginedUser=new User(uid,username,password);
                return loginedUser;

            }else{
                return null;
            }

        }catch (SQLException e)
        {
            System.out.println("登录时发生异常"+e);
            return null;
        }
    }
}
