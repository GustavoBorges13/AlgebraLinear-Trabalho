package com.trabalho.algebralinear;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.formdev.flatlaf.FlatIntelliJLaf;

@SuppressWarnings("serial")
public class Question1 extends JFrame {
	private static int alinhamento = SwingConstants.CENTER;
	private JPanel contentPane;
	private JTextField v1x;
	private JTextField v1y;
	private JTextField w1y;
	private JTextField w1x;
	private JTextField vy;
	private JTextField vx;
	private JTextField v2y;
	private JTextField v2x;
	private JTextField w2y;
	private JTextField w2x;
	private int x2 = 0;
	private int y2 = 0;
	private int x1 = 0;
	private int y1 = 0;
	private double[][] pArray = null;
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private XYSeries series1;
	private XYSeries series2;
	private XYSeriesCollection dataset;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	private JPanel matrixPanel;
	private JButton btnLimpar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					Question1 frame = new Question1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Question1() {
		setResizable(false);
		setTitle("Mudança de base");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 791, 490);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, ": : Output : :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 161, 400, 279);
		contentPane.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 380, 75);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		table = new JTable();
		scrollPane.setViewportView(table);

		dataset = new XYSeriesCollection();
		series1 = new XYSeries("Coordenadas em relação à base B");
		series1.add(x1, y1);
		series2 = new XYSeries("Coordenadas em relação à base C");
		series2.add(x2, y2);
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		chart = ChartFactory.createScatterPlot("Coordenadas do vetor v", "x", "y", dataset, PlotOrientation.VERTICAL,
				true, true, false);
		chartPanel = new ChartPanel(chart);
		chartPanel.setMouseZoomable(true);
		chartPanel.setZoomAroundAnchor(true);
		chartPanel.setBounds(420, 11, 345, 429);
		getContentPane().add(chartPanel);

		JLabel lblNewLabel = new JLabel("Matriz P");
		lblNewLabel.setBounds(144, 129, 114, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblDados = new JLabel("Vetores");
		lblDados.setBounds(10, 23, 114, 14);
		panel.add(lblDados);
		lblDados.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, ": : Input : :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 400, 107);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		w2x = new JTextField();
		w2x.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				btnLimpar.setEnabled(true);
			}

			public void removeUpdate(DocumentEvent e) {
				if (w2x.getText().equals("")) {
					btnLimpar.setEnabled(false);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		w2x.setHorizontalAlignment(SwingConstants.CENTER);
		w2x.setColumns(10);
		w2x.setBounds(245, 51, 41, 20);
		panel_1.add(w2x);

		v2x = new JTextField();
		v2x.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				btnLimpar.setEnabled(true);
			}

			public void removeUpdate(DocumentEvent e) {
				if (v2x.getText().equals("")) {
					btnLimpar.setEnabled(false);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		v2x.setHorizontalAlignment(SwingConstants.CENTER);
		v2x.setColumns(10);
		v2x.setBounds(245, 28, 41, 20);
		panel_1.add(v2x);

		w2y = new JTextField();
		w2y.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				btnLimpar.setEnabled(true);
			}

			public void removeUpdate(DocumentEvent e) {
				if (w2y.getText().equals("")) {
					btnLimpar.setEnabled(false);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		w2y.setHorizontalAlignment(SwingConstants.CENTER);
		w2y.setColumns(10);
		w2y.setBounds(295, 51, 41, 20);
		panel_1.add(w2y);

		v2y = new JTextField();
		v2y.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				btnLimpar.setEnabled(true);
			}

			public void removeUpdate(DocumentEvent e) {
				if (v2y.getText().equals("")) {
					btnLimpar.setEnabled(false);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		v2y.setHorizontalAlignment(SwingConstants.CENTER);
		v2y.setColumns(10);
		v2y.setBounds(295, 28, 41, 20);
		panel_1.add(v2y);

		w1x = new JTextField();
		w1x.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				btnLimpar.setEnabled(true);
			}

			public void removeUpdate(DocumentEvent e) {
				if (w1x.getText().equals("")) {
					btnLimpar.setEnabled(false);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		w1x.setHorizontalAlignment(SwingConstants.CENTER);
		w1x.setColumns(10);
		w1x.setBounds(128, 51, 41, 20);
		panel_1.add(w1x);

		vx = new JTextField();
		vx.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				btnLimpar.setEnabled(true);
			}

			public void removeUpdate(DocumentEvent e) {
				if (vx.getText().equals("")) {
					btnLimpar.setEnabled(false);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		vx.setHorizontalAlignment(SwingConstants.CENTER);
		vx.setOpaque(false);
		vx.setColumns(10);
		vx.setBounds(128, 75, 41, 20);
		panel_1.add(vx);

		vy = new JTextField();
		vy.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				btnLimpar.setEnabled(true);
			}

			public void removeUpdate(DocumentEvent e) {
				if (vy.getText().equals("")) {
					btnLimpar.setEnabled(false);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		vy.setHorizontalAlignment(SwingConstants.CENTER);
		vy.setColumns(10);
		vy.setBounds(178, 75, 41, 20);
		panel_1.add(vy);

		w1y = new JTextField();
		w1y.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				btnLimpar.setEnabled(true);
			}

			public void removeUpdate(DocumentEvent e) {
				if (w1y.getText().equals("")) {
					btnLimpar.setEnabled(false);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		w1y.setHorizontalAlignment(SwingConstants.CENTER);
		w1y.setColumns(10);
		w1y.setBounds(178, 51, 41, 20);
		panel_1.add(w1y);

		v1y = new JTextField();
		v1y.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				btnLimpar.setEnabled(true);
			}

			public void removeUpdate(DocumentEvent e) {
				if (v1y.getText().equals("")) {
					btnLimpar.setEnabled(false);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		v1y.setHorizontalAlignment(SwingConstants.CENTER);
		v1y.setColumns(10);
		v1y.setBounds(178, 28, 41, 20);
		panel_1.add(v1y);

		v1x = new JTextField();
		v1x.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				btnLimpar.setEnabled(true);
			}

			public void removeUpdate(DocumentEvent e) {
				if (v1x.getText().equals("")) {
					btnLimpar.setEnabled(false);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		v1x.setHorizontalAlignment(SwingConstants.CENTER);
		v1x.setBounds(128, 28, 41, 20);
		panel_1.add(v1x);
		v1x.setColumns(10);

		JTextPane txtpnA = new JTextPane();
		txtpnA.setOpaque(false);
		txtpnA.setFocusable(false);
		txtpnA.setEditable(false);
		txtpnA.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtpnA.setText(
				"Base B = {(       ;       ), (       ;       )}\nBase C = {(       ;       ), (       ;       )}\nVetor v =  (       ;       ) ");
		txtpnA.setBounds(23, 22, 354, 79);
		panel_1.add(txtpnA);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setVisible(true);
				if (!v1x.getText().isEmpty() && !v1y.getText().isEmpty() && !v2x.getText().isEmpty()
						&& !v2y.getText().isEmpty() && !w1x.getText().isEmpty() && !w1y.getText().isEmpty()
						&& !w2x.getText().isEmpty() && !w2y.getText().isEmpty() && !vx.getText().isEmpty()
						&& !vy.getText().isEmpty()) {
					try {
						Calcular();
						plotarGrafico();
						gerarMatriz2x2();
					} catch (org.apache.commons.math3.linear.SingularMatrixException e1) {
						table.setVisible(false);
						JOptionPane.showMessageDialog(null,
								"O resultado é: com estes valores, gerou uma matriz singular cujo seu determinante é 0 e também não tem matriz inversa. ");
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"Por favor, preencha todos os campos. Para virgula utilize ponto. E não digite caracteres, apenas números.");
				}
			}
		});
		btnCalcular.setBounds(119, 127, 89, 23);
		contentPane.add(btnCalcular);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v1x.setText("");
				v1y.setText("");
				v2x.setText("");
				v2y.setText("");
				w1x.setText("");
				w1y.setText("");
				w2x.setText("");
				w2y.setText("");
				vx.setText("");
				vy.setText("");
			}
		});
		btnLimpar.setEnabled(false);
		btnLimpar.setBounds(214, 127, 89, 23);
		contentPane.add(btnLimpar);

	}

	public void Calcular() {
		// Definindo as bases B e C
		RealMatrix B = MatrixUtils.createRealMatrix(
				new double[][] { { Double.parseDouble(v1x.getText()), Double.parseDouble(v1y.getText()) },
						{ Double.parseDouble(v2x.getText()), Double.parseDouble(v2y.getText()) } });
		RealMatrix C = MatrixUtils.createRealMatrix(
				new double[][] { { Double.parseDouble(w1x.getText()), Double.parseDouble(w1y.getText()) },
						{ Double.parseDouble(w2x.getText()), Double.parseDouble(w2y.getText()) } });

		// Definindo o vetor v
		RealMatrix v = MatrixUtils.createColumnRealMatrix(
				new double[] { Double.parseDouble(vx.getText()), Double.parseDouble(vy.getText()) });

		// Encontrando a matriz P
		RealMatrix P = MatrixUtils.inverse(B).multiply(C);
		pArray = P.getData();

		// Encontrando as coordenadas do vetor v em relação à base C
		RealMatrix vC = MatrixUtils.inverse(C).multiply(v);
		x2 = (int) Math.floor(vC.getEntry(0, 0));
		y2 = (int) Math.floor(vC.getEntry(1, 0));

		// Encontrando as coordenadas do vetor v em relação à base B
		RealMatrix vB = MatrixUtils.inverse(B).multiply(v);
		x1 = (int) Math.floor(vB.getEntry(0, 0));
		y1 = (int) Math.floor(vB.getEntry(1, 0));
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
				for (int i = 0; i < pArray.length; i++) {
					for (int j = 0; j < pArray[i].length; j++) {
						g.drawString(df.format(pArray[i][j]).toString(), width / 3 * (j + 1) - 10,
								height / 3 * (i + 1) + 4);
					}
				}
			}
		};
		matrixPanel.setBackground(Color.WHITE);
		matrixPanel.setBounds(145, 159, 114, 109);
		panel.add(matrixPanel);
		panel.updateUI();
		contentPane.updateUI();
	}

	public void plotarGrafico() {
		series1.clear();
		series1.add(x1, y1);
		series2.clear();
		series2.add(x2, y2);
		dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		chart = ChartFactory.createScatterPlot("Coordenadas do vetor v", "x", "y", dataset, PlotOrientation.VERTICAL,
				true, true, false);
		chartPanel.removeAll();
		chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(420, 11, 345, 401);
		getContentPane().add(chartPanel);

		String[] columnNames = { "", "vB", "vC" };
		Object[][] data = { { "x", x1, x2 }, { "y", y1, y2 } };
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table.setModel(model);

		// Nao deixa a aumentar a largura das colunas da tabela usando o mouse e realiza
		// os alinhamentos das colunas e linhas!
		table.getColumnModel().getColumn(0).setPreferredWidth(20); // coluna
		table.getColumnModel().getColumn(0).setResizable(true);
		table.getColumnModel().getColumn(0).setHeaderRenderer(new HorizontalAlignmentHeaderRenderer(alinhamento));
		table.getColumnModel().getColumn(1).setPreferredWidth(70); // coluna
		table.getColumnModel().getColumn(1).setResizable(true);
		table.getColumnModel().getColumn(1).setHeaderRenderer(new HorizontalAlignmentHeaderRenderer(alinhamento));
		table.getColumnModel().getColumn(2).setPreferredWidth(50); // coluna
		table.getColumnModel().getColumn(2).setResizable(true);
		table.getColumnModel().getColumn(2).setHeaderRenderer(new HorizontalAlignmentHeaderRenderer(alinhamento));

		// Nao vai reodernar os nomes e titulos do cabeçalho da tabela
		table.getTableHeader().setReorderingAllowed(false);

		// Nao permite aumentar na tabela as colunas
		table.setEnabled(false);
	}

	public static class HorizontalAlignmentHeaderRenderer implements TableCellRenderer {
		private int horizontalAlignment = SwingConstants.CENTER;

		public HorizontalAlignmentHeaderRenderer(int horizontalAlignment) {
			this.horizontalAlignment = horizontalAlignment;
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			TableCellRenderer r = table.getTableHeader().getDefaultRenderer();
			JLabel l = (JLabel) r.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			l.setHorizontalAlignment(horizontalAlignment);
			return l;
		}
	}
}
