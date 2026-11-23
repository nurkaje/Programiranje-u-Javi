
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel panel;
    private JTextField unosKM;
    private JComboBox<String> izborIz;
    private JComboBox<String> izborU;
    private JButton konvertDugme;
    private JLabel ispisIznosa;

    public GUI() {

        izborIz.addItem("KM");
        izborIz.addItem("EUR");
        izborIz.addItem("USD");
        izborIz.addItem("GBP");

        izborU.addItem("KM");
        izborU.addItem("EUR");
        izborU.addItem("USD");
        izborU.addItem("GBP");

        izborIz.setSelectedItem("KM");
        izborU.setSelectedItem("EUR");

        konvertDugme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                konvertujValutu();
            }
        });
    }

    private void konvertujValutu() {

        String tekst = unosKM.getText().trim();
        tekst = tekst.replace(',', '.');

        if (tekst.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Unesite ispravan pozitivan iznos!");
            return;
        }

        try {
            double iznos = Double.parseDouble(tekst);

            if (!Double.isFinite(iznos) || iznos < 0) {
                JOptionPane.showMessageDialog(null,
                        "Unesite ispravan pozitivan iznos!");
                return;
            }

            String valutaIz = (String) izborIz.getSelectedItem();
            String valutaU = (String) izborU.getSelectedItem();

            double kursIz = odrediKurs(valutaIz);
            double kursU = odrediKurs(valutaU);

            double iznosKM = iznos / kursIz;
            double rezultat = iznosKM * kursU;

            ispisIznosa.setText(
                    String.format("%.2f %s", rezultat, valutaU)
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,
                    "Unesite ispravan numerički iznos!");
        }
    }

    private double odrediKurs(String valuta) {

        switch (valuta) {
            case "USD":
                return 0.55;
            case "EUR":
                return 0.51;
            case "GBP":
                return 0.43;
            case "KM":
                return 1.0;
            default:
                throw new IllegalArgumentException(
                        "Nepoznata valuta: " + valuta
                );
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter valuta");
        frame.setContentPane(new GUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(420, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
