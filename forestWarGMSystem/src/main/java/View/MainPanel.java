package View;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class MainPanel extends JFrame {
    //该窗口包含两个面板，登录面板和注册面板。这两个面版用选项卡布局
    private JTabbedPane tabbedPane;
    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;

    private Connection connection;//mysql数据库链接
    public MainPanel(Connection connection)
    {
        this.connection=connection;
        //JFrame默认就是BorderLayout布局，可省略
        setLayout(new BorderLayout());
        loginPanel=new LoginPanel(connection);
        registerPanel=new RegisterPanel(connection);
        tabbedPane=new JTabbedPane();//选项卡面板
        tabbedPane.add("我要登录",loginPanel);//添加选项进去
        tabbedPane.add("我要注册",registerPanel);
        add(tabbedPane,BorderLayout.CENTER);//选项卡面板加入窗口
        setVisible(true);
        setBounds(100,100,600,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
}
