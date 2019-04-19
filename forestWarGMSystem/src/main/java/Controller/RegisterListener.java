package Controller;

import DAO.UserDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class RegisterListener implements ActionListener {
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

    //触发该事件的只可能时注册按钮，所以不用e来分辨按钮点击
    public void actionPerformed(ActionEvent e) {
        boolean isSuccessful= UserDao.userRegister(connection,userName.getText(),password.getText());
        if(isSuccessful)
        {
            JOptionPane.showMessageDialog(null,"注册成功","注册结果",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"注册失败","注册结果",JOptionPane.ERROR_MESSAGE);
        }
    }
}
