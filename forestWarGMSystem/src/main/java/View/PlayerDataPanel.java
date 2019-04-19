package View;

import Controller.PlayerDataListener;
import Model.Score;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

/**
 * 登录成功后展示用户数据
 */
public class PlayerDataPanel extends JFrame {
    private User loginedUser;
    private Score loginedUserScore;
    private JLabel userNameLabel;
    private JLabel totalCountLabel;
    private JLabel winCountLabel;
    private JTextField userNameText;
    private JTextField totalCountText;
    private JTextField winCountText;
    private JButton updateBtn;
    private Connection conn;
    private PlayerDataListener listener;
    public PlayerDataPanel(User loginedUser,Score loginedUserScore,Connection conn)
    {
        this.conn=conn;
        this.loginedUser=loginedUser;
        this.loginedUserScore=loginedUserScore;
        //GUI部分
        setLayout(new FlowLayout());
        userNameLabel=new JLabel("用户名");
        totalCountLabel=new JLabel("总场数");
        winCountLabel=new JLabel("胜利数");
        userNameText=new JTextField(12);
        totalCountText=new JTextField(12);
        winCountText=new JTextField(12);
        updateBtn=new JButton("更新");
        //设置初始显示的值-也就是从数据库中获取的
        userNameText.setText(loginedUser.getUsername());
        totalCountText.setText(String.valueOf(loginedUserScore.getTotalCount()));
        winCountText.setText(String.valueOf(loginedUserScore.getWinCount()));
        add(userNameLabel);
        add(userNameText);
        add(totalCountLabel);
        add(totalCountText);
        add(winCountLabel);
        add(winCountText);
        add(updateBtn);
        setVisible(true);
        setTitle("个人信息");
        setBounds(200,200,600,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //设置监听器
        listener=new PlayerDataListener();
        listener.setTotalCountText(totalCountText);
        listener.setWinCountText(winCountText);
        listener.setLoginedUser(loginedUser);
        listener.setConn(conn);
        //添加监听器
        updateBtn.addActionListener(listener);
    }
}
