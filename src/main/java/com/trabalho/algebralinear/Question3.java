package com.trabalho.algebralinear;

import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class Question3 extends JFrame {
	private JPanel contentPane;
	private JLabel labelA;
	private JTextField textFieldA, textFieldB, textFieldC, textFieldF;
	private JButton buttonCalcular;
	private JTextArea textAreaResultado;
	private String equacaoTransformada;
	private Double anguloRotacao;
	private double[][] matrizRotacao;
	private JLabel lblNewLabel;
	private JPanel matrixPanel;
	private JLabel lblMatriz;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					Question3 frame = new Question3();
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
	public Question3() {
		setResizable(false);
		setTitle("Identificação de cônicas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 389);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		labelA = new JLabel("A:           B:           C:           F:");
		labelA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelA.setBounds(65, 53, 241, 14);
		contentPane.setLayout(null);
		textFieldF = new JTextField();
		textFieldF.setBounds(252, 50, 37, 20);
		contentPane.add(textFieldF);
		textFieldA = new JTextField();
		textFieldA.setBounds(82, 50, 37, 20);
		contentPane.add(textFieldA);
		textFieldC = new JTextField();
		textFieldC.setBounds(195, 50, 37, 20);
		contentPane.add(textFieldC);
		textFieldB = new JTextField();
		textFieldB.setBounds(139, 50, 37, 20);
		contentPane.add(textFieldB);
		contentPane.add(labelA);

		buttonCalcular = new JButton("Calcular");
		buttonCalcular.setBounds(303, 45, 97, 30);
		contentPane.add(buttonCalcular);
		buttonCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldA.getText().equals("") || textFieldB.getText().equals("")
						|| textFieldC.getText().equals("") || textFieldF.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Por favor, insira valores para os campos A, B, C e F para realizar o calculo.");
				} else {
					lblMatriz.setVisible(true);
					calcular();
					String temp = textAreaResultado.getText();
					textAreaResultado.setText(temp + " Angulo de rotação: " + anguloRotacao
							+ "\n Equação transformada: " + equacaoTransformada);
					gerarMatriz2x2();
				}
			}
		});

		textAreaResultado = new JTextArea();
		textAreaResultado.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textAreaResultado);
		scrollPane.setBounds(10, 254, 452, 85);
		contentPane.add(scrollPane);

		lblNewLabel = new JLabel("Ax² + Bxy + Cy² = F");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(29, 16, 310, 14);
		contentPane.add(lblNewLabel);

		lblMatriz = new JLabel("Matriz Rotação");
		lblMatriz.setVisible(false);
		lblMatriz.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriz.setBounds(167, 110, 128, 14);
		contentPane.add(lblMatriz);

		setVisible(true);
	}

	private void calcular() {

		// calcular discriminante
		double A = Double.parseDouble(textFieldA.getText()), B = Double.parseDouble(textFieldB.getText()),
				C = Double.parseDouble(textFieldC.getText()), F = Double.parseDouble(textFieldF.getText());
		double delta = B * B - 4 * A * C;

		if (delta == 0) {
			textAreaResultado.setText(" Identificação da cônica: parábola\n");
		} else if (delta < 0) {
			textAreaResultado.setText(" Identificação da cônica: elipse\n");
		} else {
			textAreaResultado.setText(" Identificação da cônica: hipérbole\n");
		}

		// calcular ângulo de rotação
		double anguloRotacao = 0.5 * Math.atan2(B, A - C);
		anguloRotacao = Math.toDegrees(anguloRotacao);
		if (anguloRotacao < 0) {
			anguloRotacao += 180;
		}

		// calcular matriz de rotação
		double cos = Math.cos(anguloRotacao);
		double sin = Math.sin(anguloRotacao);
		double[][] matrizRotacao = { { cos, sin }, { -sin, cos } };

		// transformar equação da forma Ax^2 + Bxy + Cy^2 = F para x1y1
		double denominador = A * sin * sin - B * sin * cos + C * cos * cos;
		double a1 = (A * cos * cos - 2 * B * sin * cos + C * sin * sin) / denominador;
		double b1 = (B * (cos * cos - sin * sin) + (C - A) * sin * cos) / denominador;
		double c1 = (A * sin * sin + 2 * B * sin * cos + C * cos * cos) / denominador;
		double f1 = F / denominador;
		String equacaoTransformada = String.format("%.2fx1^2 + %.2fx1y1 + %.2fy1^2 = %.2f", a1, b1, c1, f1);

		// armazenar os resultados na classe
		this.anguloRotacao = anguloRotacao;
		this.matrizRotacao = matrizRotacao;
		this.equacaoTransformada = equacaoTransformada;
	}

	public void gerarMatriz2x2() {
		matrixPanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				int width = getWidth();
				int height = getHeight();
				g.setColor(Color.BLACK);

				// Desenha os colchetes
				// Vertical
				g.drawRect(2, 2, 2, height - 10);
				g.fillRect(2, 2, 2, height - 10);
				g.drawRect(width - 5, 2, 2, height - 10);
				g.fillRect(width - 5, 2, 2, height - 10);
				// Horizontal
				g.drawRect(2, 2, 10, 2);
				g.fillRect(2, 2, 10, 2);
				g.drawRect(height + 2, 2, -10, 2);
				g.fillRect(height + 2, 2, -10, 2);

				g.drawRect(2, height - 10, 10, 2);
				g.fillRect(2, height - 10, 10, 2);
				g.drawRect(height + 2, height - 10, -10, 2);
				g.fillRect(height + 2, height - 10, -10, 2);

				// g.drawRect(width - 5, 2, 2, height - 10);
				// g.fillRect(width - 5, 2, 2, height - 10);

				// Insere os valores da matriz
				DecimalFormat df = new DecimalFormat("#.##");
				for (int i = 0; i < matrizRotacao.length; i++) {
					for (int j = 0; j < matrizRotacao[i].length; j++) {
						g.drawString(df.format(matrizRotacao[i][j]).toString(), width / 3 * (j + 1) - 10,
								height / 3 * (i + 1) + 4);
					}
				}
			}
		};
		matrixPanel.setBackground(new Color(240, 240, 240));
		matrixPanel.setBounds(173, 134, 114, 109);
		contentPane.add(matrixPanel);
		contentPane.updateUI();
	}
}
