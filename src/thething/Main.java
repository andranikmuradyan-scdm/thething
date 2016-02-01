package thething;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.LineBorder;

public class Main {

  private JFrame frmThething;
  private JTextField txtPathToPricingData;
  private JTextField txtProductsFolder;
  private JTextField txtMDFolder;
  private JTextField txtFixingFile;
  private JTextField txtIssuerCurveFile;
  private JTextField txtResultFilePrefix;
  private JTextField txtPathToCalibrationData;
  private JTextField txtPathToCSV;
  private JTextField txtPathToXLSX;
  private JTextField txtXLSXTemplateFile;
  private JTextField txtConversionOutput;

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

    JSplitPane splitPane = new JSplitPane() {
      private static final long serialVersionUID = 1L;
      private final int location = 530;
      {
        setDividerLocation(location);
      }

      @Override
      public int getDividerLocation() {
        return location;
      }

      @Override
      public int getLastDividerLocation() {
        return location;
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

    // ---------------------------------------------------------------
    // CALIBRATION TAB -----------------------------------------------
    // ---------------------------------------------------------------
    
    JLabel lblPathToCalibrationData = new JLabel("Path to data");
    lblPathToCalibrationData.setBounds(10, 184, 120, 14);
    lblPathToCalibrationData.setFont(new Font("Tahoma", Font.BOLD, 12));
    pnlPricing.add(lblPathToCalibrationData);

    txtPathToCalibrationData = new JTextField();
    txtPathToCalibrationData.setColumns(10);
    txtPathToCalibrationData.setBounds(110, 181, 450, 20);
    pnlPricing.add(txtPathToCalibrationData);

    JButton button_3 = new JButton("...");
    button_3.setBounds(571, 180, 55, 23);
    pnlPricing.add(button_3);

    JButton btnCalibrate = new JButton("Calibrate");
    btnCalibrate.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnCalibrate.setBounds(459, 274, 130, 62);
    pnlPricing.add(btnCalibrate);

    JButton btnCalibrateCreosscurrency = new JButton(
        "<HTML>Calibrate \r\n<br>crosscurrency");
    btnCalibrateCreosscurrency.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnCalibrateCreosscurrency.setBounds(459, 364, 130, 62);
    pnlPricing.add(btnCalibrateCreosscurrency);

    JLabel lblCalibratingCurveFile = new JLabel(
        "<HTML>Calibrating curve file from 'rates' folder, <br>\r\nwriting results to 'curves' folder.");
    lblCalibratingCurveFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblCalibratingCurveFile.setBounds(10, 274, 439, 62);
    pnlPricing.add(lblCalibratingCurveFile);

    JLabel lblcalibratingCurveFile = new JLabel(
        "<HTML>Calibrating curve file from 'rates-crosscurrency'<br>\r\nfolder, writing results to 'curves' folder.");
    lblcalibratingCurveFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblcalibratingCurveFile.setBounds(10, 364, 439, 62);
    pnlPricing.add(lblcalibratingCurveFile);
    JPanel pnlCSVXLSX = new JPanel();
    tabbedPane.addTab("CSV to XLSX", null, pnlCSVXLSX, null);
    pnlCSVXLSX.setLayout(null);

    JLabel lblPathToCsvs = new JLabel("Path to CSVs");
    lblPathToCsvs.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblPathToCsvs.setBounds(14, 74, 100, 14);
    pnlCSVXLSX.add(lblPathToCsvs);

    txtPathToCSV = new JTextField();
    txtPathToCSV.setColumns(10);
    txtPathToCSV.setBounds(112, 71, 453, 20);
    pnlCSVXLSX.add(txtPathToCSV);

    JButton button_4 = new JButton("...");
    button_4.setBounds(575, 70, 55, 23);
    pnlCSVXLSX.add(button_4);

    JLabel lblPathToXlsxs = new JLabel("Path to XLSXs");
    lblPathToXlsxs.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblPathToXlsxs.setBounds(14, 103, 100, 14);
    pnlCSVXLSX.add(lblPathToXlsxs);

    txtPathToXLSX = new JTextField();
    txtPathToXLSX.setColumns(10);
    txtPathToXLSX.setBounds(117, 100, 448, 20);
    pnlCSVXLSX.add(txtPathToXLSX);

    JButton button_5 = new JButton("...");
    button_5.setBounds(575, 99, 55, 23);
    pnlCSVXLSX.add(button_5);

    JLabel lblXlsxTemplateFile = new JLabel("XLSX template file");
    lblXlsxTemplateFile.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblXlsxTemplateFile.setBounds(14, 132, 135, 14);
    pnlCSVXLSX.add(lblXlsxTemplateFile);

    txtXLSXTemplateFile = new JTextField();
    txtXLSXTemplateFile.setColumns(10);
    txtXLSXTemplateFile.setBounds(148, 129, 417, 20);
    pnlCSVXLSX.add(txtXLSXTemplateFile);

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

    txtConversionOutput = new JTextField();
    txtConversionOutput.setForeground(Color.WHITE);
    txtConversionOutput.setBackground(Color.BLACK);
    txtConversionOutput.setEnabled(false);
    txtConversionOutput.setBounds(6, 220, 620, 201);
    pnlCSVXLSX.add(txtConversionOutput);
    txtConversionOutput.setColumns(10);

    JButton btnStopConversion = new JButton("Stop conversion");
    btnStopConversion.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnStopConversion.setBounds(324, 432, 302, 57);
    pnlCSVXLSX.add(btnStopConversion);
    JPanel pnlCoolStuff = new JPanel();
    tabbedPane.addTab("Cool stuff", null, pnlCoolStuff, null);

    JLabel lblConfigurationName = new JLabel("Configuration name:");
    lblConfigurationName.setFont(new Font("Tahoma", Font.PLAIN, 24));
    lblConfigurationName.setBounds(10, 21, 616, 32);
    pnlCalibration.add(lblConfigurationName);

    JLabel lblProductsFolder = new JLabel("Products folder");
    lblProductsFolder.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblProductsFolder.setBounds(10, 114, 120, 14);
    pnlCalibration.add(lblProductsFolder);

    JLabel lblMdFolder = new JLabel("MD folder");
    lblMdFolder.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblMdFolder.setBounds(10, 139, 85, 14);
    pnlCalibration.add(lblMdFolder);

    JLabel lblValuationDate = new JLabel("Valuation date");
    lblValuationDate.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblValuationDate.setBounds(164, 357, 130, 14);
    pnlCalibration.add(lblValuationDate);

    JLabel lblPathToPricingData = new JLabel("Path to data");
    lblPathToPricingData.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblPathToPricingData.setBounds(10, 89, 120, 14);
    pnlCalibration.add(lblPathToPricingData);

    JLabel lblFixingFile = new JLabel("Fixing file");
    lblFixingFile.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblFixingFile.setBounds(10, 164, 120, 14);
    pnlCalibration.add(lblFixingFile);

    JLabel lblIssuerCurveFile = new JLabel("Issuer curve file prefix");
    lblIssuerCurveFile.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblIssuerCurveFile.setBounds(10, 189, 158, 14);
    pnlCalibration.add(lblIssuerCurveFile);

    JLabel lblResultFilePrefix = new JLabel("Result file prefix");
    lblResultFilePrefix.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblResultFilePrefix.setBounds(10, 324, 121, 14);
    pnlCalibration.add(lblResultFilePrefix);

    JLabel lblItsATrap = new JLabel(
        "<HTML><blink>IT'S A TRAP!!!!!!<br></blink>\r\n<br>\r\n1.&nbsp;Date format: YYYYMMDD, \te.g. 19120623, 19540607, 20151214<br>\r\n2.&nbsp;Good filename: ISSUER_CURVES - FSPC MEAN (EUR II) - 20150331.xlsx<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bad filename: ISSUER_CURVES - FSPC MEAN - 20150331 - (EUR II).xlsx<br>");
    lblItsATrap.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblItsATrap.setBounds(56, 214, 541, 96);
    pnlCalibration.add(lblItsATrap);

    txtPathToPricingData = new JTextField();
    txtPathToPricingData.setBounds(106, 86, 455, 20);
    pnlCalibration.add(txtPathToPricingData);
    txtPathToPricingData.setColumns(10);

    txtProductsFolder = new JTextField();
    txtProductsFolder.setColumns(10);
    txtProductsFolder.setBounds(126, 111, 435, 20);
    pnlCalibration.add(txtProductsFolder);

    txtMDFolder = new JTextField();
    txtMDFolder.setColumns(10);
    txtMDFolder.setBounds(96, 136, 465, 20);
    pnlCalibration.add(txtMDFolder);

    txtFixingFile = new JTextField();
    txtFixingFile.setColumns(10);
    txtFixingFile.setBounds(82, 161, 479, 20);
    pnlCalibration.add(txtFixingFile);

    txtIssuerCurveFile = new JTextField();
    txtIssuerCurveFile.setColumns(10);
    txtIssuerCurveFile.setBounds(171, 186, 390, 20);
    pnlCalibration.add(txtIssuerCurveFile);

    txtResultFilePrefix = new JTextField();
    txtResultFilePrefix.setColumns(10);
    txtResultFilePrefix.setBounds(133, 321, 428, 20);
    pnlCalibration.add(txtResultFilePrefix);

    JButton btnNewButton = new JButton("321");
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

    JCheckBox chckbxEur = new JCheckBox("EUR");
    panel.add(chckbxEur);

    JCheckBox chckbxGbp = new JCheckBox("GBP");
    panel.add(chckbxGbp);

    JCheckBox chckbxJpy = new JCheckBox("JPY");
    panel.add(chckbxJpy);

    JCheckBox chckbxUsd = new JCheckBox("USD");
    panel.add(chckbxUsd);

    JLabel lblValuationCurrencies = new JLabel("Valuation currencies");
    lblValuationCurrencies.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblValuationCurrencies.setBounds(329, 356, 130, 14);
    pnlCalibration.add(lblValuationCurrencies);

    JSpinner spinner = new JSpinner();
    spinner.setModel(new SpinnerDateModel(new Date(), null, null,
        Calendar.DAY_OF_WEEK_IN_MONTH));
    spinner.setBounds(164, 382, 108, 20);
    JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "dd-MMM-yyyy");
    spinner.setEditor(de);
    pnlCalibration.add(spinner);

    JPanel pnlConfigurationPanel = new JPanel();
    splitPane.setRightComponent(pnlConfigurationPanel);
    pnlConfigurationPanel.setLayout(null);

    JLabel lblConfigurationOperations = new JLabel("Configuration operations");
    lblConfigurationOperations.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblConfigurationOperations.setBounds(7, 5, 220, 17);
    pnlConfigurationPanel.add(lblConfigurationOperations);

    JButton btnSave = new JButton("Save");
    btnSave.setBounds(7, 30, 105, 43);
    pnlConfigurationPanel.add(btnSave);

    JButton btnSaveAs = new JButton("Save as");
    btnSaveAs.setBounds(122, 30, 105, 43);
    pnlConfigurationPanel.add(btnSaveAs);

    JButton btnLoad = new JButton("Load");
    btnLoad.setBounds(237, 30, 105, 43);
    pnlConfigurationPanel.add(btnLoad);

    JButton btnDelete = new JButton("Delete");
    btnDelete.setBounds(352, 30, 105, 43);
    pnlConfigurationPanel.add(btnDelete);

    JButton btnEcit = new JButton("Exit");
    btnEcit.setBounds(524, 5, 105, 68);
    pnlConfigurationPanel.add(btnEcit);
    splitPane.setDividerLocation(530);
  }
}
