import Tool.ConnHelper;
import View.MainPanel;
import View.RegisterPanel;

import java.sql.Connection;

public class Main {
    public static void main(String[] args)
    {
        Connection conn= ConnHelper.ConnectToMySql();
        new MainPanel(conn);
    }
}
