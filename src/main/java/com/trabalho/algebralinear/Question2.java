package com.trabalho.algebralinear;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Component;

public class Question2 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelA11, labelA12, labelA21, labelA22;
	private JTextField textFieldA11, textFieldA12, textFieldA21, textFieldA22;
	private JTextArea textAreaResultado;
	private JButton buttonCalcular;
	private DefaultStyledDocument doc;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					Question2 frame = new Question2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Question2() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		labelA11 = new JLabel("A11:");
		labelA11.setBounds(20, 20, 50, 25);
		textFieldA11 = new JTextField();
		textFieldA11.setBounds(80, 20, 50, 25);

		labelA12 = new JLabel("A12:");
		labelA12.setBounds(150, 20, 50, 25);
		textFieldA12 = new JTextField();
		textFieldA12.setBounds(210, 20, 50, 25);

		labelA21 = new JLabel("A21:");
		labelA21.setBounds(20, 60, 50, 25);
		textFieldA21 = new JTextField();
		textFieldA21.setBounds(80, 60, 50, 25);

		labelA22 = new JLabel("A22:");
		labelA22.setBounds(150, 60, 50, 25);
		textFieldA22 = new JTextField();
		textFieldA22.setBounds(210, 60, 50, 25);

		textAreaResultado = new JTextArea();
		textAreaResultado.setEditable(false);
		textAreaResultado.setBounds(20, 100, 320, 200);
		textAreaResultado.setLineWrap(true);// Faz com que o texto quebre para a próxima linha
		textAreaResultado.setWrapStyleWord(true);
		textAreaResultado.setAutoscrolls(false);
		doc = new DefaultStyledDocument();
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_JUSTIFIED);
		doc.setParagraphAttributes(0, doc.getLength(), attribs, false);
		textAreaResultado.setDocument(doc);

		buttonCalcular = new JButton("Calcular Autovalores \r\ne Autovetores");
		buttonCalcular.setAlignmentY(Component.TOP_ALIGNMENT);
		buttonCalcular.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonCalcular.setMargin(new Insets(0, 0, 0, 0));
		buttonCalcular.setBounds(350, 176, 213, 36);
		buttonCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldA11.getText().equals("") || textFieldA12.getText().equals("")
						|| textFieldA21.getText().equals("") || textFieldA22.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Por favor, insira valores para A11, A12, A21 e A22 para realizar o calculo.");
				} else {
					double a11 = Double.parseDouble(textFieldA11.getText());
					double a12 = Double.parseDouble(textFieldA12.getText());
					@SuppressWarnings("unused")
					double a21 = Double.parseDouble(textFieldA21.getText());
					double a22 = Double.parseDouble(textFieldA22.getText());

					double delta = (a12 * a12) - 4 * a11 * a22;
					if (delta < 0) {

						textAreaResultado.setText(
								"Não existem autovalores reais nesta matriz inserida.\n\nMotivo: o código verifica se o delta é menor do que zero. Se o delta for menor do que zero, significa que a equação característica tem raízes complexas conjugadas e, portanto, não existem autovalores reais.");
					} else {
						double lambda1 = (-a12 + Math.sqrt(delta)) / (2 * a11);
						double lambda2 = (-a12 - Math.sqrt(delta)) / (2 * a11);
						double x1 = 1;
						double y1 = lambda1;
						double x2 = 1;
						double y2 = lambda2;
						if (lambda1 == lambda2) {
							textAreaResultado
									.setText("AUTOVALOR:   " + lambda1 + "\nAUTOVETOR:   (" + x1 + ", " + y1 + ")");
						} else {
							textAreaResultado.setText("AUTOVALOR 1:   " + lambda1 + "\nAUTOVETOR 1:   (" + x1 + ", "
									+ y1 + ")" + "\n\nAUTOVALOR 2:   " + lambda2 + "\nAUTOVETOR 2:   (" + x2 + ", " + y2
									+ ")");
						}

					}
				}
			}
		});

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		getContentPane().add(labelA11);
		getContentPane().add(textFieldA11);
		getContentPane().add(labelA12);
		getContentPane().add(textFieldA12);
		getContentPane().add(labelA21);
		getContentPane().add(textFieldA21);
		getContentPane().add(labelA22);
		getContentPane().add(textFieldA22);
		getContentPane().add(buttonCalcular);
		getContentPane().add(textAreaResultado);

		setTitle("Autovalores e Autovetores");
		setSize(589, 350);
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
