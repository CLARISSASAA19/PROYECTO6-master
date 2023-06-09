import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private JTabbedPane cita;
    private JPanel panel1;
    private JTextField txtnombrepedia;
    private JTextField txtcedupedia;
    private JButton tbtnpedia;
    private JComboBox cbodoctor;
    private JTextField txtnomder;
    private JTextField txtcederm;
    private JComboBox boxderm;
    private JButton btnderma;
    private JTextField txtnomcardio;
    private JTextField txtcedulacardio;
    private JComboBox boxcardiologia;
    private JButton btncardio;
    private JTextField txtbusq;
    private JButton btnbuscar;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    ArrayList<Paciente> pacientes = new ArrayList<>();

    public Main() {


/////agendar cita pediatrica./////
        tbtnpedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String opcion = cbodoctor.getSelectedItem().toString();
                boolean validar = true;

                for (Paciente p : pacientes) {
                    if (p.getDoctor().equals(opcion)) {
                        validar = false;
                    }
                }

                if (validar) {
                    Paciente p = new Paciente(txtnombrepedia.getText(), txtcedupedia.getText(), cbodoctor.getSelectedItem().toString());
                    pacientes.add(p);
                    JOptionPane.showMessageDialog(null, "Agendado correctamente su cita Pediátrica. ");
                } else {
                    JOptionPane.showMessageDialog(null, "EL DOCTOR SELECCIONADO SE ENCUENTRA OCUPADO, POR FAVOR ELIJA OTRO");
                }


            }
        });


///////buscar cita medica////////
        btnbuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < pacientes.size(); i++) {
                    if (pacientes.get(i).getCedula().equals(txtbusq.getText()) == true) {
                        JOptionPane.showMessageDialog(null, "CITA ENCONTRADA" + pacientes.get(i).toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "OH NO!, NO SE HA ENCONTRADO UNA CITA MEDICA, INTENTE DE NUEVO");
                    }
                }
            }
        });


        ///// agendar cita dermatologica////

        btnderma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcion=boxderm.getSelectedItem().toString();
                boolean validar=true;
                for (Paciente p: pacientes){
                    if (p.getDoctor().equals(opcion)){
                        validar=false;
                    }
                }
                if (validar){
                    Paciente p = new Paciente(txtnomder.getText(), txtcederm.getText(), boxderm.getSelectedItem().toString());
                    pacientes.add(p);
                    JOptionPane.showMessageDialog(null, "Agendado correctamente su cita Dermatológica.");
                }else {
                    JOptionPane.showMessageDialog(null, "EL DOCTOR SELECCIONADO SE ENCUENTRA OCUPADO, POR FAVOR ELIJA OTRO");
                }

            }
        });


//// agendar cita en cardiologia///
        btncardio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcion=boxcardiologia.getSelectedItem().toString();
                boolean validar=true;
                for (Paciente p:pacientes){
                    if (p.getDoctor().equals(opcion)){
                        validar=false;
                    }

                }
                if (validar){
                    Paciente p = new Paciente(txtnomcardio.getText(), txtcedulacardio.getText(), boxcardiologia.getSelectedItem().toString());
                    pacientes.add(p);
                    JOptionPane.showMessageDialog(null, "Agendado correctamente su cita Cardiológica.");

                }else {
                    JOptionPane.showMessageDialog(null,"EL DOCTOR SELECCIONADO SE ENCUENTRA OCUPADO, POR FAVOR ELIJA OTRO");
                }


            }
        });


    }

}

