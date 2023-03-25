package principal;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import conversorMonedas.ConvertirMonedas;
import conversorMonedas.ConvertirMonedasAPesos;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConversorDeMoneda extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField montoAConvertir;

	/**
	 * Create the panel.
	 */
	public ConversorDeMoneda() {
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor De Moneda");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(133, 8, 210, 32);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el monto a convertir ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(133, 62, 218, 26);
		add(lblNewLabel_1);
		
		montoAConvertir = new JTextField();
		montoAConvertir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		montoAConvertir.setBounds(156, 98, 120, 26);
		add(montoAConvertir);
		montoAConvertir.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Elije la moneda a la que deseas convertir ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(105, 145, 261, 26);
		add(lblNewLabel_1_1);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccionar...", "De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libras", "De Pesos a Yen", "De Pesos a Won Coreano", "De Dólar a Pesos", "De Euro a Pesos", "De Libras a Pesos", "De Yen a Pesos", "De Won Coreano a Pesos"}));	
		comboBox.setBounds(115, 180, 207, 26);
		add(comboBox);
	
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double monto = Double.parseDouble(montoAConvertir.getText());
				if(monto < 0) {	
                	JOptionPane.showMessageDialog(null, "Valor invalido, debe ingresar numeros mayores a 0");
                	montoAConvertir.setText(null);
                }
				ConvertirMonedas monedas = new ConvertirMonedas();
				ConvertirMonedasAPesos pesos = new ConvertirMonedasAPesos();
			
				String moneda = comboBox.getSelectedItem().toString();
		        switch(moneda) {
		        case "Seleccionar...":
		        	JOptionPane.showMessageDialog(null, "Debes Seleccionar a que moneda desea convertir ");
		        	break;
		        case "De Pesos a Dólar":
		        	monedas.ConvertirPesosADolares(monto);
		        	break;
		        case "De Pesos a Euro":
		        	monedas.ConvertirPesosAEuros(monto);
		        	break;
		        case "De Pesos a Libras":
		        	monedas.ConvertirPesosALibras(monto);
		        	break;
		        case "De Pesos a Yen":
		        	monedas.ConvertirPesosAYen(monto);
		        	break;
		        case "De Pesos a Won Coreano":
		        	monedas.ConvertirPesosAWon(monto);
		        	break;    	    	                          
		        case "De Dólar a Pesos":
		        	pesos.ConvertirDolaresAPesos(monto);
		        	break;
		        case "De Euro a Pesos":
		        	pesos.ConvertirEurosAPesos(monto);
		        	break;
		        case "De Libras a Pesos":
		        	pesos.ConvertirLibrasAPesos(monto);
		        	break;
		        case "De Yen a Pesos":
		        	pesos.ConvertirYenAPesos(monto);
		        	break;
		        case "De Won Coreano a Pesos":
		            pesos.ConvertirWonAPesos(monto);
		            break;
		        }      
							
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(156, 233, 120, 26);
		add(btnNewButton);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				montoAConvertir.setText(null);
				comboBox.setSelectedItem("Seleccionar...");
				
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpiar.setBounds(69, 302, 120, 26);
		add(btnLimpiar);
		

		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setBounds(246, 302, 120, 26);
		add(btnSalir);
		

	}
}
