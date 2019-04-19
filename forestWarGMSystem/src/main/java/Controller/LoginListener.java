package Controller;

import DAO.ScoreDao;
import DAO.UserDao;
import Model.Score;
import Model.User;
import View.PlayerDataPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class LoginListener implements ActionListener {
    private JTextField userName;
    private JTextField password;
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setUserName(JTextField userName) {
        this.userName = userName;
    }

    public void setPassword(JTextField password) {
        this.password = password;
    }

    public void actionPerformed(ActionEvent e) {
       User loginedUser= UserDao.userLogin(connection,userName.getText(),password.getText());
       if(loginedUser!=null)
       {

           Score loginedUserScore= ScoreDao.getScoreByUserid(connection,loginedUser.getId());
           if(loginedUserScore!=null)
           {
               // 说明登录成功,打开新面板PlayerDataPanel
                new PlayerDataPanel(loginedUser,loginedUserScore,connection);
           }else {
               //没有存档信息
               JOptionPane.showMessageDialog(null,"没有存档信息","登录结果",JOptionPane.ERROR_MESSAGE);
           }
       }else {
           //登录失败
           JOptionPane.showMessageDialog(null,"登录失败","登录结果",JOptionPane.ERROR_MESSAGE);
       }



    }
}
