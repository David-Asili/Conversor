package principal;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import conversorTemperatura.ConvertirTemperatura;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConversorDeTemperatura extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField montoAConvertir;

	/**
	 * Create the panel.
	 */
	public ConversorDeTemperatura() {
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor De Temperatura");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(115, 10, 210, 32);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el valor de temperatura a convertir ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(99, 50, 248, 26);
		add(lblNewLabel_1);
		
		montoAConvertir = new JTextField();
		montoAConvertir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		montoAConvertir.setColumns(10);
		montoAConvertir.setBounds(158, 98, 120, 26);
		add(montoAConvertir);
		
		JLabel lblNewLabel_1_1 = new JLabel("Seleccione una opcion para covertir");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(83, 148, 261, 26);
		add(lblNewLabel_1_1);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccionar...","Grados Celcius a Grados Farenheit", "Grados Celcius a Kelvin", "Grados Farenheit a Grados Celcius","Kelvin a Grados Celcius","Kelvin a Grados Farenheit"}));
		comboBox.setBounds(99, 193, 248, 26);
		add(comboBox);
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double valor = Double.parseDouble(montoAConvertir.getText());
				
				ConvertirTemperatura temperatura = new ConvertirTemperatura();
				String opcion = comboBox.getSelectedItem().toString();
		        switch(opcion) {
		        case "Grados Celcius a Grados Farenheit":
		        	temperatura.ConvertirCelciusAFarenheit(valor);
		        	break;
		        case "Grados Celcius a Kelvin":
		            temperatura.ConvertirCelciusAKelvin(valor);
		            break;
		        case "Grados Farenheit a Grados Celcius":
		           temperatura.ConvertirFarenheitACelcius(valor);
		           break;
		        case "Kelvin a Grados Celcius":
		           temperatura.ConvertirKelvinACelcius(valor);
		           break;
		        case "Kelvin a Grados Farenheit":
		        	temperatura.ConvertirKelvinAFarenheit(valor);
		        	break;
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(158, 248, 120, 26);
		add(btnNewButton);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				montoAConvertir.setText(null);
				comboBox.setSelectedItem("Seleccionar...");
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpiar.setBounds(69, 315, 120, 26);
		add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setBounds(246, 315, 120, 26);
		add(btnSalir);

	}
}
