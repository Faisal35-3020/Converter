

package converter;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class Converter extends JFrame implements ActionListener{

    private Container c;
    private Font f,f2;
    private JLabel converter;
    private JComboBox box;
    private JButton click, clear;
    private JTextField get;
    private JTextArea output;
    private JScrollPane pane;
    
    
    private String[] con = {"BD to USD", "USD to BD", "BD to Euro", "Euro to BD", "Euro to USD", "USD to Euro", "Pound to Euro", "Pound to USD", "Pound to BD", "Pounds to CAD", "BD to Pound", "USD to Pound"};
    
    
    Converter()
    {
        //Frame Create
        this.setBounds(300,200,500,400);
        this.setTitle("Airplane Reservation");
        
        
        
        //Initilize Method in initcomponents to execute file
        initComponents();
    }
    
    
    public void initComponents()
    {
        
        //Container Create
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        
        //font Style Create
        f = new Font("Arial", Font.BOLD, 45);
        f2 = new Font("Arial", Font.BOLD, 22);
        
        
            
        //Set Heading titile Labele Converter
        converter = new JLabel("Airplane Reservation");
        converter.setBounds(0,0,500,80);
        converter.setOpaque(true);
        converter.setFont(f);
        converter.setHorizontalAlignment(JLabel.CENTER);
        converter.setBackground(Color.LIGHT_GRAY);
        converter.setForeground(Color.DARK_GRAY);
        c.add(converter);
        
        
        //Create JComboBox
        box = new JComboBox();
        box.setBounds(25,110,200,50);
        box.setFont(f2);
        box.setEditable(true);
        box.setBackground(Color.LIGHT_GRAY);
        box.setForeground(Color.DARK_GRAY);
        c.add(box);
        
        
        
        //Create JText Field
        
        get = new JTextField();
        get.setBounds(25,180,200,50);
        get.setFont(f2);
        get.setForeground(Color.DARK_GRAY);
        c.add(get);
        
        //Create Button
        click = new JButton("Convert");
        click.setBounds(20,250,220,50);
        click.setFont(f);
        click.setBackground(Color.LIGHT_GRAY);
        click.setForeground(Color.DARK_GRAY);
        c.add(click);
        
        
        //Clear Button
        clear = new JButton("Clear");
        clear.setBounds(245,250,220,50);
        clear.setFont(f);
        clear.setBackground(Color.LIGHT_GRAY);
        clear.setForeground(Color.DARK_GRAY);
        c.add(clear);
        
        
         //Create Label
        output = new JTextArea();
        output.setFont(f2);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setEditable(false);
        output.setBackground(Color.LIGHT_GRAY);
        output.setForeground(Color.DARK_GRAY);
        
        
        pane = new JScrollPane(output);
        pane.setBounds(245,110,220,120);
        c.add(pane);
        
        click.addActionListener(this);
        clear.addActionListener(this);
        get.addActionListener(this);
        
    }
    
    
    
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==click)
        {
            try{
                SetCalculation();
            }
            catch(Exception excep)
            {
                JOptionPane.showMessageDialog(null, excep+"Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()==get)
        {
            try{
                SetCalculation();
            }
            catch(Exception excep)
            {
                JOptionPane.showMessageDialog(null, excep+"Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()== clear)
        {
            output.setText("");
            get.setText("");
        }
        
        
    }
    
    
    
    public void SetCalculation()
    {
        String s = box.getSelectedItem().toString();
        
        DecimalFormat formate = new DecimalFormat("0.00000");
        
        String d = get.getText();
    
        
        if(d.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Enter Any Number", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        else
        {
            if(s == con[0])
            {
            
                double BD = Double.valueOf(get.getText());
            
                double USD = BD * 0.01173;
            
                String output = String.valueOf(formate.format(USD));
                this.output.setText("$"+output);

            }
            else if(s == con[1])
            {
                double USD = Double.valueOf(get.getText());
            
                double BD = USD /0.01173;
            
                String output = String.valueOf(formate.format(BD));
                this.output.setText(output+" Tk");
            }
            
            else if(s == con[2])
            {
                double BD = Double.valueOf(get.getText());
            
                double Euro = BD*0.01042;
            
                String output = String.valueOf(formate.format(Euro));
                this.output.setText(output+" Euro");
                
            }
            else if(s == con[3])
            {
                double Euro = Double.valueOf(get.getText());
            
                double BD = Euro / 0.01042;
            
                String output = String.valueOf(formate.format(BD));
                this.output.setText(output+" Tk");
                
            }
            else if(s == con[4])
            {
                double Euro = Double.valueOf(get.getText());
            
                double USD = Euro * 1.12497;
            
                String output = String.valueOf(formate.format(USD));
                this.output.setText("$ "+output);
                
            }
            
            else if(s == con[5])
            {
                double USD = Double.valueOf(get.getText());
            
                double Euro = USD / 1.12497;
            
                String output = String.valueOf(formate.format(Euro));
                this.output.setText(output+" Euro");
                
            }
            
            else if(s == con[6])
            {
                double pound = Double.valueOf(get.getText());
            
                double Euro = pound * 1.15427;
            
                String output = String.valueOf(formate.format(Euro));
                this.output.setText(output+" EUR");
                
            }
            else if(s == con[7])
            {
                double pound = Double.valueOf(get.getText());
            
                double USD = pound * 1.29864;
            
                String output = String.valueOf(formate.format(USD));
                this.output.setText("$ "+output);
                
                
            }
            
            else if(s == con[8])
            {
                double pound = Double.valueOf(get.getText());
            
                double BD = pound * 108.342;
            
                String output = String.valueOf(formate.format(BD));
                this.output.setText(output+" Tk");
                
            }
            else if(s == con[9])
            {
                double pound = Double.valueOf(get.getText());
            
                double CAD = pound * 1.73454;
            
                String output = String.valueOf(formate.format(CAD));
                this.output.setText(output+" CAD");
                
            }
            else if(s == con[10])
            {
                double BD = Double.valueOf(get.getText());
            
                double pound = BD *0.00903 ;
            
                String output = String.valueOf(formate.format(pound));
                this.output.setText(output+" GBP");
                
            }
            else if(s == con[11])
            {
                double USD = Double.valueOf(get.getText());
            
                double pound = USD * 0.76991 ;
            
                String output = String.valueOf(formate.format(pound));
                this.output.setText(output+" GBP");
                
            }
            
        }
    }
    
    
    
    
    public static void main(String[] args) {

        Converter con = new Converter();
        con.setVisible(true);
        con.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   
    
}
