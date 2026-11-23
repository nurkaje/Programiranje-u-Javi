import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JButton izracunajButton;
    private JTextField textImeSt;
    private JTextField textPr1;
    private JTextField textPr2;
    private JTextField textZI;
    private JTextField textUk;
    private JTextField textOcjena;
    private JTextField textUpit;
    private JPanel panel;


    public GUI() {
        izracunajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int m1,m2,m3;
                m1 = Integer.parseInt(textPr1.getText());
                m2 = Integer.parseInt(textPr2.getText());
                m3 = Integer.parseInt(textZI.getText());

                int tot = m1 + m2 + m3;
                textUk.setText(String.valueOf(tot));

                if(tot>55){
                    textUpit.setText("Polozen");
                }else{
                    textUpit.setText("Nije polozen");
                }

                if(tot >= 55 && tot < 65){
                    textOcjena.setText("6");
                }
                if(tot >= 65 && tot < 75){
                    textOcjena.setText("7");
                }
                if(tot >= 75 && tot < 85){
                    textOcjena.setText("8");
                }
                if(tot >= 85 && tot < 95){
                    textOcjena.setText("9");
                }
                if(tot >= 95 && tot < 101){
                    textOcjena.setText("10");
                }
                if (tot > 100){
                    JOptionPane.showMessageDialog(null,"Unesite validne podatke");
                }
                if(tot < 55){
                    textOcjena.setText(" ");
                    JOptionPane.showMessageDialog(null,"Student nije polozio");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
