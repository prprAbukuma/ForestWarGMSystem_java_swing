package View;

import Controller.LoginListener;
import Controller.RegisterListener;

import javax.swing.*;
import java.sql.Connection;

public class LoginPanel extends JPanel {
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton loginButton;
    private LoginListener loginListener;
    private Connection connection;//数据库链接
    public LoginPanel(Connection connection)
    {
        this.connection=connection;
        //GUI部分
        usernameLabel=new JLabel("用户名");
        passwordLabel=new JLabel("密码");
        usernameTextField=new JTextField(12);
        passwordTextField=new JTextField(12);
        loginButton=new JButton("登录");
        //使用JPanel的默认布局FlowLayout，从左到右，默认居中，排满换行
        add(usernameLabel);
        add(usernameTextField);
        add(passwordLabel);
        add(passwordTextField);
        add(loginButton);
        //JPanel无法单独显示，所以不用设置什么可显示性

        //设置监听器
        loginListener=new LoginListener();
        loginListener.setUserName(usernameTextField);
        loginListener.setPassword(passwordTextField);
        loginListener.setConnection(connection);
        //添加监听器
        loginButton.addActionListener(loginListener);
    }
}
