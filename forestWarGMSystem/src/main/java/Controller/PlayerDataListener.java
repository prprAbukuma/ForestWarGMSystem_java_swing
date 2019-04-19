package Controller;

import DAO.ScoreDao;
import Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class PlayerDataListener implements ActionListener {
    private JTextField totalCountText;
    private JTextField winCountText;
    private User loginedUser;
    private Connection conn;

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setLoginedUser(User loginedUser) {
        this.loginedUser = loginedUser;
    }

    public void setTotalCountText(JTextField totalCountText) {
        this.totalCountText = totalCountText;
    }

    public void setWinCountText(JTextField winCountText) {
        this.winCountText = winCountText;
    }

    public void actionPerformed(ActionEvent e) {
        //对战绩信息进行修改
        ScoreDao.UpdateScore(conn,loginedUser.getId(),Integer.parseInt(totalCountText.getText()),Integer.parseInt(winCountText.getText()));
        JOptionPane.showMessageDialog(null,"修改成功","结果",JOptionPane.INFORMATION_MESSAGE);
    }
}
