package com.trabalho.algebralinear;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MatrixPanel extends JPanel {

	private double[][] matriz;

	public MatrixPanel(double[][] matriz) {
		this.matriz = matriz;
		this.setBackground(Color.WHITE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int x = 50; // posição x inicial do desenho da matriz
		int y = 50; // posição y inicial do desenho da matriz

		int largura = 70; // largura de cada célula
		int altura = 50; // altura de cada célula

		int linha = matriz.length; // número de linhas da matriz
		int coluna = matriz[0].length; // número de colunas da matriz

		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 20));

		// Desenha os colchetes esquerdos
		g.drawString("[", x, y + altura * linha / 2);
		// Desenha os elementos da matriz
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				g.drawString(String.format("%.2f", matriz[i][j]), x + largura * j + 20, y + altura * (i + 1));
			}
		}
		// Desenha os colchetes direitos
		g.drawString("]", x + largura * coluna + 10, y + altura * linha / 2);
	}
}
