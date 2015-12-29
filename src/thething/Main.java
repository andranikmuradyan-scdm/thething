package thething;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import javax.swing.JSplitPane;

public class Main {

	private JFrame frmThething;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmThething.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThething = new JFrame();
		frmThething.setResizable(false);
		frmThething.setTitle("thething");
		frmThething.setBounds(100, 100, 657, 659);
		frmThething.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane(){
			private static final long serialVersionUID = 1L;
			private final int location = 530;
		    {
		        setDividerLocation( location );
		    }
		    @Override
		    public int getDividerLocation() {
		        return location ;
		    }
		    @Override
		    public int getLastDividerLocation() {
		        return location ;
		    }
		};
		splitPane.setResizeWeight(1.0);
		splitPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frmThething.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setLeftComponent(tabbedPane);
		JPanel pnlCalibration = new JPanel();
		tabbedPane.addTab("Pricing", null, pnlCalibration, null);
		pnlCalibration.setLayout(null);
		JPanel pnlPricing = new JPanel();
		tabbedPane.addTab("Calibration", null, pnlPricing, null);
		pnlPricing.setLayout(null);
		
		JLabel label = new JLabel("Path to data");
		label.setBounds(10, 184, 82, 14);
		pnlPricing.add(label);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(86, 181, 475, 20);
		pnlPricing.add(textField_6);
		
		JButton button_3 = new JButton("...");
		button_3.setBounds(571, 180, 55, 23);
		pnlPricing.add(button_3);
		
		JButton btnCalibrate = new JButton("Calibrate");
		btnCalibrate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalibrate.setBounds(459, 274, 130, 62);
		pnlPricing.add(btnCalibrate);
		
		JButton btnCalibrateCreosscurrency = new JButton("<HTML>Calibrate \r\n<br>crosscurrency");
		btnCalibrateCreosscurrency.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalibrateCreosscurrency.setBounds(459, 364, 130, 62);
		pnlPricing.add(btnCalibrateCreosscurrency);
		
		JLabel lblCalibratingCurveFile = new JLabel("<HTML>Calibrating curve file from 'rates' folder, <br>\r\nwriting results to 'curves' folder.");
		lblCalibratingCurveFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCalibratingCurveFile.setBounds(10, 274, 439, 62);
		pnlPricing.add(lblCalibratingCurveFile);
		
		JLabel lblcalibratingCurveFile = new JLabel("<HTML>Calibrating curve file from 'rates-crosscurrency'<br>\r\nfolder, writing results to 'curves' folder.");
		lblcalibratingCurveFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblcalibratingCurveFile.setBounds(10, 364, 439, 62);
		pnlPricing.add(lblcalibratingCurveFile);
		JPanel pnlCSVXLSX = new JPanel();
		tabbedPane.addTab("CSV to XLSX", null, pnlCSVXLSX, null);
		pnlCSVXLSX.setLayout(null);
		
		JLabel lblPathToCsvs = new JLabel("Path to CSVs");
		lblPathToCsvs.setBounds(14, 74, 82, 14);
		pnlCSVXLSX.add(lblPathToCsvs);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(102, 71, 463, 20);
		pnlCSVXLSX.add(textField_7);
		
		JButton button_4 = new JButton("...");
		button_4.setBounds(575, 70, 55, 23);
		pnlCSVXLSX.add(button_4);
		
		JLabel lblPathToXlsxs = new JLabel("Path to XLSXs");
		lblPathToXlsxs.setBounds(14, 103, 82, 14);
		pnlCSVXLSX.add(lblPathToXlsxs);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(102, 100, 463, 20);
		pnlCSVXLSX.add(textField_8);
		
		JButton button_5 = new JButton("...");
		button_5.setBounds(575, 99, 55, 23);
		pnlCSVXLSX.add(button_5);
		
		JLabel lblXlsxTemplateFile = new JLabel("XLSX template file");
		lblXlsxTemplateFile.setBounds(14, 132, 125, 14);
		pnlCSVXLSX.add(lblXlsxTemplateFile);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(133, 129, 432, 20);
		pnlCSVXLSX.add(textField_9);
		
		JButton button_6 = new JButton("...");
		button_6.setBounds(575, 128, 55, 23);
		pnlCSVXLSX.add(button_6);
		
		JLabel lblConversionOutput = new JLabel("Conversion output");
		lblConversionOutput.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConversionOutput.setBounds(10, 189, 195, 20);
		pnlCSVXLSX.add(lblConversionOutput);
		
		JButton btnNewButton_1 = new JButton("Start conversion");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(6, 432, 302, 57);
		pnlCSVXLSX.add(btnNewButton_1);
		
		textField_10 = new JTextField();
		textField_10.setForeground(Color.WHITE);
		textField_10.setBackground(Color.BLACK);
		textField_10.setEnabled(false);
		textField_10.setBounds(6, 220, 620, 201);
		pnlCSVXLSX.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnStopConversion = new JButton("Stop conversion");
		btnStopConversion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStopConversion.setBounds(324, 432, 302, 57);
		pnlCSVXLSX.add(btnStopConversion);
		JPanel pnlCoolStuff = new JPanel();
		tabbedPane.addTab("Cool stuff", null, pnlCoolStuff, null);
		
		JLabel lblNewLabel = new JLabel("Configuration name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 21, 616, 32);
		pnlCalibration.add(lblNewLabel);
		
		JLabel lblProductsFolder = new JLabel("Products folder");
		lblProductsFolder.setBounds(10, 114, 100, 14);
		pnlCalibration.add(lblProductsFolder);
		
		JLabel lblMdFolder = new JLabel("MD folder");
		lblMdFolder.setBounds(10, 139, 65, 14);
		pnlCalibration.add(lblMdFolder);
		
		JLabel lblValuationDate = new JLabel("Valuation date");
		lblValuationDate.setBounds(164, 357, 89, 14);
		pnlCalibration.add(lblValuationDate);
		
		JLabel lblPathToData = new JLabel("Path to data");
		lblPathToData.setBounds(10, 89, 82, 14);
		pnlCalibration.add(lblPathToData);
		
		JLabel lblFixingFile = new JLabel("Fixing file");
		lblFixingFile.setBounds(10, 164, 65, 14);
		pnlCalibration.add(lblFixingFile);
		
		JLabel lblIssuerCurveFile = new JLabel("Issuer curve file prefix");
		lblIssuerCurveFile.setBounds(10, 189, 138, 14);
		pnlCalibration.add(lblIssuerCurveFile);
		
		JLabel lblResultFilePrefix = new JLabel("Result file prefix");
		lblResultFilePrefix.setBounds(10, 324, 121, 14);
		pnlCalibration.add(lblResultFilePrefix);
		
		JLabel lblItsATrap = new JLabel("<HTML><blink>IT'S A TRAP!!!!!!<br></blink>\r\n<br>\r\n1.&nbsp;Date format: YYYYMMDD, \te.g. 19120623, 19540607, 20151214<br>\r\n2.&nbsp;Good filename: ISSUER_CURVES - FSPC MEAN (EUR II) - 20150331.xlsx<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bad filename: ISSUER_CURVES - FSPC MEAN - 20150331 - (EUR II).xlsx<br>");
		lblItsATrap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItsATrap.setBounds(56, 214, 541, 96);
		pnlCalibration.add(lblItsATrap);
		
		textField = new JTextField();
		textField.setBounds(86, 86, 475, 20);
		pnlCalibration.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(106, 111, 455, 20);
		pnlCalibration.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(76, 136, 485, 20);
		pnlCalibration.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(76, 161, 485, 20);
		pnlCalibration.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(151, 186, 410, 20);
		pnlCalibration.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(113, 321, 448, 20);
		pnlCalibration.add(textField_5);
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.setBounds(571, 85, 55, 23);
		pnlCalibration.add(btnNewButton);
		
		JButton button = new JButton("...");
		button.setBounds(571, 110, 55, 23);
		pnlCalibration.add(button);
		
		JButton button_1 = new JButton("...");
		button_1.setBounds(571, 135, 55, 23);
		pnlCalibration.add(button_1);
		
		JButton button_2 = new JButton("...");
		button_2.setBounds(571, 160, 55, 23);
		pnlCalibration.add(button_2);
		
		JButton btnStopPricing = new JButton("Stop pricing");
		btnStopPricing.setBounds(10, 428, 130, 62);
		pnlCalibration.add(btnStopPricing);
		
		JButton btnStartPricing = new JButton("Start pricing");
		btnStartPricing.setBounds(10, 359, 130, 62);
		pnlCalibration.add(btnStartPricing);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(330, 374, 231, 32);
		pnlCalibration.add(panel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("EUR");
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxGbp = new JCheckBox("GBP");
		panel.add(chckbxGbp);
		
		JCheckBox chckbxJpy = new JCheckBox("JPY");
		panel.add(chckbxJpy);
		
		JCheckBox chckbxUsd = new JCheckBox("USD");
		panel.add(chckbxUsd);
		
		JLabel lblValuationCurrencies = new JLabel("Valuation currencies");
		lblValuationCurrencies.setBounds(329, 356, 130, 14);
		pnlCalibration.add(lblValuationCurrencies);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_WEEK_IN_MONTH));
		spinner.setBounds(164, 382, 108, 20);
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "dd-MMM-yyyy");
		spinner.setEditor(de);
		pnlCalibration.add(spinner);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblConfigurationOperations = new JLabel("Configuration operations");
		lblConfigurationOperations.setBounds(7, 5, 163, 14);
		panel_1.add(lblConfigurationOperations);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(7, 30, 105, 43);
		panel_1.add(btnSave);
		
		JButton btnSaveAs = new JButton("Save as");
		btnSaveAs.setBounds(122, 30, 105, 43);
		panel_1.add(btnSaveAs);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(237, 30, 105, 43);
		panel_1.add(btnLoad);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(352, 30, 105, 43);
		panel_1.add(btnDelete);
		
		JButton btnEcit = new JButton("Exit");
		btnEcit.setBounds(524, 5, 105, 68);
		panel_1.add(btnEcit);
		splitPane.setDividerLocation(530);
	}
}
