package View;

import Controller.RegisterListener;

import javax.swing.*;
import java.sql.Connection;

public class RegisterPanel extends JPanel {
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton registerButton;
    private RegisterListener registerListener;
    private Connection connection;//数据库链接
    public RegisterPanel(Connection connection)
    {
        this.connection=connection;
        //GUI部分
        usernameLabel=new JLabel("用户名");
        passwordLabel=new JLabel("密码");
        usernameTextField=new JTextField(12);
        passwordTextField=new JTextField(12);
        registerButton=new JButton("注册");
        //使用JPanel的默认布局FlowLayout，从左到右，默认居中，排满换行
        add(usernameLabel);
        add(usernameTextField);
        add(passwordLabel);
        add(passwordTextField);
        add(registerButton);
        //JPanel无法单独显示，所以不用设置什么可显示性

        //设置监听器
        registerListener=new RegisterListener();
        registerListener.setUserName(usernameTextField);
        registerListener.setPassword(passwordTextField);
        registerListener.setConnection(connection);
        //添加监听器
        registerButton.addActionListener(registerListener);
    }
}
