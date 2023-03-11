package com.trabalho.algebralinear;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	private Image img_logo = new ImageIcon(
			Principal.class.getResource("/resources/UFCAT_-_Identidade_Visual_Original.png")).getImage()
			.getScaledInstance(164, 123, Image.SCALE_SMOOTH);
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					Principal frame = new Principal();
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
	public Principal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/Course_Icon_LinAlgebra.png")));
		setTitle("Trabalho Algebra Linear");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 398);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.requestFocus();

		JLabel lblNewLabel = new JLabel("ÁLGEBRA LINEAR - TRABALHO 28/02/2023");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 108, 607, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Universidade Federal de Catalão");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 133, 607, 27);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Gustavo Borges Peres da Silva");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(10, 158, 607, 27);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Matricula: 202109747");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 182, 607, 27);
		contentPane.add(lblNewLabel_1_1_1_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 209, 607, 2);
		contentPane.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Selecione o exercício (cada questão é uma interface diferente)");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 220, 607, 14);
		contentPane.add(lblNewLabel_1);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(img_logo));
		logo.setBounds(232, 11, 159, 98);
		contentPane.add(logo);

		JButton btnExerccio_1 = new JButton("Exercício 1");
		btnExerccio_1.setFocusable(false);
		btnExerccio_1.setRequestFocusEnabled(false);
		btnExerccio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question1 questao1Frame = new Question1();
				questao1Frame.setVisible(true);
			}
		});
		btnExerccio_1.setBounds(10, 255, 181, 58);
		contentPane.add(btnExerccio_1);

		JButton btnExerccio_2 = new JButton("Exercício 2");
		btnExerccio_2.setFocusable(false);
		btnExerccio_2.setRequestFocusEnabled(false);
		btnExerccio_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question2 questao2Frame = new Question2();
				questao2Frame.setVisible(true);
			}
		});
		btnExerccio_2.setBounds(223, 255, 181, 58);
		contentPane.add(btnExerccio_2);

		JButton btnExerccio_3 = new JButton("Exercício 3");
		btnExerccio_3.setFocusable(false);
		btnExerccio_3.setRequestFocusEnabled(false);
		btnExerccio_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question3 questao3Frame = new Question3();
				questao3Frame.setVisible(true);
			}
		});
		btnExerccio_3.setBounds(436, 255, 181, 58);
		contentPane.add(btnExerccio_3);

		JLabel lblNewLabel_2 = new JLabel("Status: finalizado");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(10, 315, 181, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Status: finalizado");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setBounds(223, 315, 181, 14);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Status: finalizado");
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setBounds(436, 315, 181, 14);
		contentPane.add(lblNewLabel_2_2);
		logo.requestFocus();
	}
}
