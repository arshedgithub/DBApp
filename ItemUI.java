import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class ItemUI extends JFrame {
    JTable table;
    ItemUI(){
        setTitle("App");
        setLocation(300,200);
        setSize(250, 300);

        Container con = getContentPane();
        FlowLayout layout = new FlowLayout();
        con.setLayout(layout);

        Vector titles = new Vector();
        titles.add("Id");
        titles.add("Name");
        titles.add("NIC");
        titles.add("Gender");

        Vector data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data, titles);

        table = new JTable();
        table.setModel(dataModel);
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        JScrollPane jsp = new JScrollPane();
        jsp.setPreferredSize(new Dimension(200, 140));
        jsp.setViewportView(table);

        con.add(jsp);

        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/euc1", "root", "1234");
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM employee");

            while(result.next()){
                Vector r = new Vector();

                r.add(result.getInt("id"));
                r.add(result.getString("name"));
                r.add(result.getString("nic"));
                r.add(result.getInt("gender_id"));

                model.addRow(r);
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String args[]){
        ItemUI ui = new ItemUI();
        ui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}