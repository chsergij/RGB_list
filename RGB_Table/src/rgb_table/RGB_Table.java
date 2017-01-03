package rgb_table;

/**
 *
 * @author Chupyra Sergij
 */
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RGB_Table extends JFrame {
   
    private final JTable table = new JTable();
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private final JScrollPane scrollPane = new JScrollPane(this.table);    
    private final ArrayList<Color> colorsList = new ArrayList();
    
    private void init_RGB_Table_Compoments(){       
        this.table.setModel(tableModel);        
        Object[] columnNames = new Object[]{"index", "R", "G", "B"};
        this.tableModel.setColumnIdentifiers(columnNames);        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(this.scrollPane);
        this.setPreferredSize(new Dimension(450, 220));
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
    private void createRGBList(){
        int g;        
        for (int r = 51; r < 256; r += 51) {
            for (int b = 255; b > 0; b -= 51) {
                g = r + b;
                if (g > 255) {
                    g %= 255;
                }               
                this.colorsList.add(new Color(r,g,b));                
            }
        }
    }
    
    private void addColorsIntoTable(int count) {
        Color color;
        Object[] row = new Object[4];
        
        for (int i = 0; i < count; i++) {
            color = this.colorsList.get(i);
            row[0] = Integer.toString(i + 1);
            row[1] = Integer.toString(color.getRed());
            row[2] = Integer.toString(color.getGreen());
            row[3] = Integer.toString(color.getBlue());   
            this.tableModel.addRow(row);
        }
    }
    
    public RGB_Table(){       
        super("RGB_Table");        
        this.init_RGB_Table_Compoments();
        
        this.createRGBList(); 
        this.addColorsIntoTable(9);
    }
    
    public static void main(String[] args) {
        RGB_Table app = new RGB_Table();
        app.setVisible(true);
    }
}
