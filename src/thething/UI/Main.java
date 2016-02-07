package thething.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.LineBorder;

import net.finmath.applications.spreadsheets.CSV2XLSX;
import net.finmath.applications.spreadsheets.CalibrateCCSCurveSheets;
import net.finmath.applications.spreadsheets.CalibrateCurveSheets;
import thething.util.UIOutputStream;
import thething.util.Validator;

import javax.swing.JScrollPane;

public class Main {

  private JFrame frmThething;
  private JSplitPane splitPane;
  private JTextField txtProductsFolder;
  private JTextField txtMDFolder;
  private JTextField txtFixingFile;
  private JTextField txtIssuerCurveFile;
  private JTextField txtResultFilePrefix;
  private JTextField txtPathToCalibrationData;
  private JTextField txtCSVFilePath;
  private JTextField txtXLSXFilePath;
  private JTextField txtXLSXTemplateFile;
  private JTextArea txtConversionOutput;
  private JCheckBox chbEur;
  private JCheckBox chbGbp;
  private JCheckBox chbJpy;
  private JCheckBox chbUsd;
  private JSpinner dtpValuationDate;

  private final JFileChooser fc = new JFileChooser();

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

    splitPane = new JSplitPane() {
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
    lblPathToCalibrationData.setBounds(12, 88, 120, 14);
    lblPathToCalibrationData.setFont(new Font("Tahoma", Font.BOLD, 12));
    pnlPricing.add(lblPathToCalibrationData);

    txtPathToCalibrationData = new JTextField();
    txtPathToCalibrationData.setColumns(10);
    txtPathToCalibrationData.setBounds(112, 85, 450, 20);
    pnlPricing.add(txtPathToCalibrationData);

    JButton btnOpenCalibrationPathToData = new JButton("...");
    btnOpenCalibrationPathToData.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Handle open button action.
        fc.setDialogTitle("Select the calibration data folder");

        txtPathToCalibrationData.setText(getSelectedFileOrFolder(true));
      }
    });
    btnOpenCalibrationPathToData.setBounds(573, 84, 55, 23);
    pnlPricing.add(btnOpenCalibrationPathToData);

    JButton btnStopCalibration = new JButton("Stop calibration");
    btnStopCalibration.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    btnStopCalibration.setFont(new Font("Tahoma", Font.BOLD, 14));
    btnStopCalibration.setBounds(445, 234, 183, 42);
    pnlPricing.add(btnStopCalibration);

    JButton btnStartCrosscurrencyCalibration = new JButton(
        "Start crosscurrency calibration");
    btnStartCrosscurrencyCalibration.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String pathToData = txtPathToCalibrationData.getText();

        try {
          if (Validator.validateCalibrationInput(pathToData, true))
            CalibrateCCSCurveSheets.main(new String[] { pathToData });
        } catch (Exception ex) {
        }
      }
    });
    btnStartCrosscurrencyCalibration.setFont(new Font("Tahoma", Font.BOLD, 14));
    btnStartCrosscurrencyCalibration.setBounds(12, 388, 301, 42);
    pnlPricing.add(btnStartCrosscurrencyCalibration);

    JLabel lblCalibratingCurveFile = new JLabel(
        "<HTML>Calibrating curve file from 'rates' folder, writing results <br>to 'curves' folder.");
    lblCalibratingCurveFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblCalibratingCurveFile.setBounds(12, 165, 616, 62);
    pnlPricing.add(lblCalibratingCurveFile);

    JLabel lblcalibratingCurveFile = new JLabel(
        "<HTML>Calibrating curve file from 'rates-crosscurrency' folder, <br>writing results to 'curves' folder.");
    lblcalibratingCurveFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblcalibratingCurveFile.setBounds(12, 304, 616, 72);
    pnlPricing.add(lblcalibratingCurveFile);

    JButton btnStartCalibration = new JButton("Start calibration");
    btnStartCalibration.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        final String pathToData = txtPathToCalibrationData.getText();

        try {
          if (Validator.validateCalibrationInput(pathToData, false)) {
            CalibrateCurveSheets.main(new String[] { pathToData + "/" });
          }
//            calibrationThread = new Thread(new Runnable() {
//
//              public void run() {
//                try {
//                } catch (Exception e) {
//                }
//              }
//            });
//
//            calibrationThread.start();
//          } else {
//            MessageBox.show("Unable to validate input for calibration.",
//                "Calibration", JOptionPane.ERROR_MESSAGE);
//          }
        } catch (Exception ex) {
        }
      }
    });
    btnStartCalibration.setFont(new Font("Dialog", Font.BOLD, 14));
    btnStartCalibration.setBounds(12, 234, 183, 42);
    pnlPricing.add(btnStartCalibration);

    JButton btnStopCrosscurrencyCalibration = new JButton(
        "Stop crosscurrency calibration");
    btnStopCrosscurrencyCalibration.setFont(new Font("Dialog", Font.BOLD, 14));
    btnStopCrosscurrencyCalibration.setBounds(327, 388, 301, 42);
    pnlPricing.add(btnStopCrosscurrencyCalibration);
    JPanel pnlCSVXLSX = new JPanel();
    tabbedPane.addTab("CSV to XLSX", null, pnlCSVXLSX, null);
    pnlCSVXLSX.setLayout(null);

    JLabel lblPathToCsvs = new JLabel("Path to CSVs");
    lblPathToCsvs.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblPathToCsvs.setBounds(14, 74, 100, 14);
    pnlCSVXLSX.add(lblPathToCsvs);

    txtCSVFilePath = new JTextField();
    txtCSVFilePath.setColumns(10);
    txtCSVFilePath.setBounds(112, 71, 453, 20);
    pnlCSVXLSX.add(txtCSVFilePath);

    JButton btnOpenPathToCSVs = new JButton("...");
    btnOpenPathToCSVs.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("Select the CSV to convert");
        txtCSVFilePath.setText(getSelectedFileOrFolder(true));
      }
    });
    btnOpenPathToCSVs.setBounds(575, 70, 55, 23);
    pnlCSVXLSX.add(btnOpenPathToCSVs);

    JLabel lblPathToXlsxs = new JLabel("Path to XLSXs");
    lblPathToXlsxs.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblPathToXlsxs.setBounds(14, 103, 100, 14);
    pnlCSVXLSX.add(lblPathToXlsxs);

    txtXLSXFilePath = new JTextField();
    txtXLSXFilePath.setColumns(10);
    txtXLSXFilePath.setBounds(117, 100, 448, 20);
    pnlCSVXLSX.add(txtXLSXFilePath);

    JButton btnOpenPathToXLSX = new JButton("...");
    btnOpenPathToXLSX.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("Select the XLSX to convert");
        txtXLSXFilePath.setText(getSelectedFileOrFolder(true));
      }
    });
    btnOpenPathToXLSX.setBounds(575, 99, 55, 23);
    pnlCSVXLSX.add(btnOpenPathToXLSX);

    JLabel lblXlsxTemplateFile = new JLabel("XLSX template file");
    lblXlsxTemplateFile.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblXlsxTemplateFile.setBounds(14, 132, 135, 14);
    pnlCSVXLSX.add(lblXlsxTemplateFile);

    txtXLSXTemplateFile = new JTextField();
    txtXLSXTemplateFile.setColumns(10);
    txtXLSXTemplateFile.setBounds(148, 129, 417, 20);
    pnlCSVXLSX.add(txtXLSXTemplateFile);

    JButton btnOpenXLSXTemplateFile = new JButton("...");
    btnOpenXLSXTemplateFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("Select the XLSX conversion template");
        txtXLSXTemplateFile.setText(getSelectedFileOrFolder(false));
      }
    });
    btnOpenXLSXTemplateFile.setBounds(575, 128, 55, 23);
    pnlCSVXLSX.add(btnOpenXLSXTemplateFile);

    JLabel lblConversionOutput = new JLabel("Conversion output");
    lblConversionOutput.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblConversionOutput.setBounds(10, 189, 195, 20);
    pnlCSVXLSX.add(lblConversionOutput);

    JButton btnStartConversion = new JButton("Start conversion");
    btnStartConversion.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String CSVPath = txtCSVFilePath.getText();
        String XLSXPath = txtXLSXFilePath.getText();
        String XLSXTemplate = txtXLSXTemplateFile.getText();
        
        try {
          if(Validator.validateCSVToXLSXConversionInput(CSVPath, XLSXPath, XLSXTemplate)) {
            PrintStream ps = new PrintStream(new UIOutputStream(txtConversionOutput));
            System.setOut(ps);
            System.setErr(ps);
            CSV2XLSX.convertAll(CSVPath, XLSXPath, XLSXTemplate);
          }
        } catch (IOException e1) {
        }
      }
    });
    btnStartConversion.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnStartConversion.setBounds(6, 432, 302, 57);
    pnlCSVXLSX.add(btnStartConversion);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(6, 220, 620, 201);
    pnlCSVXLSX.add(scrollPane);

    txtConversionOutput = new JTextArea();
    scrollPane.setViewportView(txtConversionOutput);
    txtConversionOutput.setForeground(Color.WHITE);
    txtConversionOutput.setBackground(Color.BLACK);
    txtConversionOutput.setEnabled(false);
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
    lblProductsFolder.setBounds(10, 92, 120, 14);
    pnlCalibration.add(lblProductsFolder);

    JLabel lblMdFolder = new JLabel("MD folder");
    lblMdFolder.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblMdFolder.setBounds(10, 117, 85, 14);
    pnlCalibration.add(lblMdFolder);

    JLabel lblValuationDate = new JLabel("Valuation date");
    lblValuationDate.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblValuationDate.setBounds(164, 357, 130, 14);
    pnlCalibration.add(lblValuationDate);

    JLabel lblFixingFile = new JLabel("Fixing file");
    lblFixingFile.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblFixingFile.setBounds(10, 142, 120, 14);
    pnlCalibration.add(lblFixingFile);

    JLabel lblIssuerCurveFile = new JLabel("Issuer curve file prefix");
    lblIssuerCurveFile.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblIssuerCurveFile.setBounds(10, 167, 158, 14);
    pnlCalibration.add(lblIssuerCurveFile);

    JLabel lblResultFilePrefix = new JLabel("Result file prefix");
    lblResultFilePrefix.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblResultFilePrefix.setBounds(10, 324, 121, 14);
    pnlCalibration.add(lblResultFilePrefix);

    JLabel lblItsATrap = new JLabel(
        "<HTML>IT'S A TRAP!!!!!!<br>\r\n<br>\r\n1.&nbsp;Date format: YYYYMMDD, \te.g. 19120623, 19540607, 20151214<br>\r\n2.&nbsp;Good filename: ISSUER_CURVES - FSPC MEAN (EUR II) - 20150331.xlsx<br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bad filename: ISSUER_CURVES - FSPC MEAN - 20150331 - (EUR II).xlsx<br>");
    lblItsATrap.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblItsATrap.setBounds(56, 204, 541, 106);
    pnlCalibration.add(lblItsATrap);

    txtProductsFolder = new JTextField();
    txtProductsFolder.setColumns(10);
    txtProductsFolder.setBounds(126, 89, 435, 20);
    pnlCalibration.add(txtProductsFolder);

    txtMDFolder = new JTextField();
    txtMDFolder.setColumns(10);
    txtMDFolder.setBounds(96, 114, 465, 20);
    pnlCalibration.add(txtMDFolder);

    txtFixingFile = new JTextField();
    txtFixingFile.setColumns(10);
    txtFixingFile.setBounds(82, 139, 479, 20);
    pnlCalibration.add(txtFixingFile);

    txtIssuerCurveFile = new JTextField();
    txtIssuerCurveFile.setColumns(10);
    txtIssuerCurveFile.setBounds(171, 164, 390, 20);
    pnlCalibration.add(txtIssuerCurveFile);

    txtResultFilePrefix = new JTextField();
    txtResultFilePrefix.setColumns(10);
    txtResultFilePrefix.setBounds(133, 321, 428, 20);
    pnlCalibration.add(txtResultFilePrefix);

    JButton btnOpenProductsFolder = new JButton("...");
    btnOpenProductsFolder.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("Select the path to products folder");
        txtProductsFolder.setText(getSelectedFileOrFolder(false));
      }
    });
    btnOpenProductsFolder.setBounds(571, 88, 55, 23);
    pnlCalibration.add(btnOpenProductsFolder);

    JButton btnOpenMDFolder = new JButton("...");
    btnOpenMDFolder.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("Select the path to market data");
        txtMDFolder.setText(getSelectedFileOrFolder(true));
      }
    });
    btnOpenMDFolder.setBounds(571, 113, 55, 23);
    pnlCalibration.add(btnOpenMDFolder);

    JButton btnOpenFixingFile = new JButton("...");
    btnOpenFixingFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("Select the file with fixings");
        txtFixingFile.setText(getSelectedFileOrFolder(false));
      }
    });
    btnOpenFixingFile.setBounds(571, 138, 55, 23);
    pnlCalibration.add(btnOpenFixingFile);

    JButton btnStopPricing = new JButton("Stop pricing");
    btnStopPricing.setBounds(10, 428, 130, 62);
    pnlCalibration.add(btnStopPricing);

    JButton btnStartPricing = new JButton("Start pricing");
    btnStartPricing.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String productsFolder = txtProductsFolder.getText();
        String mdFolder = txtMDFolder.getText();
        String fixingFile = txtFixingFile.getText();
        String issuserCUrvePrefix = txtIssuerCurveFile.getText();
        String resFilePrefix = txtResultFilePrefix.getText();

        String valuationDate = new SimpleDateFormat("yyyy-MM-dd")
            .format(dtpValuationDate.getValue());

        List<String> currencies = new ArrayList<String>();

        if (chbEur.isSelected())
          currencies.add("EUR");

        if (chbGbp.isSelected())
          currencies.add("GBP");

        if (chbJpy.isSelected())
          currencies.add("JPY");

        if (chbUsd.isSelected())
          currencies.add("USD");

        try {
          if (Validator.validateValuationInput(productsFolder, mdFolder, fixingFile, issuserCUrvePrefix, 
              resFilePrefix, valuationDate, currencies)) {
          }
        } catch (Exception ex) {
        }
      }
    });
    btnStartPricing.setBounds(10, 359, 130, 62);
    pnlCalibration.add(btnStartPricing);

    JPanel panel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.LEFT);
    panel.setBorder(new LineBorder(new Color(0, 0, 0)));
    panel.setBounds(330, 374, 231, 32);
    pnlCalibration.add(panel);

    chbEur = new JCheckBox("EUR");
    panel.add(chbEur);

    chbGbp = new JCheckBox("GBP");
    panel.add(chbGbp);

    chbJpy = new JCheckBox("JPY");
    panel.add(chbJpy);

    chbUsd = new JCheckBox("USD");
    panel.add(chbUsd);

    JLabel lblValuationCurrencies = new JLabel("Valuation currencies");
    lblValuationCurrencies.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblValuationCurrencies.setBounds(329, 356, 130, 14);
    pnlCalibration.add(lblValuationCurrencies);

    dtpValuationDate = new JSpinner();
    dtpValuationDate.setModel(new SpinnerDateModel(new Date(), null, null,
        Calendar.DAY_OF_WEEK_IN_MONTH));
    dtpValuationDate.setBounds(164, 382, 130, 20);
    JSpinner.DateEditor de = new JSpinner.DateEditor(dtpValuationDate,
        "dd-MMM-yyyy");
    dtpValuationDate.setEditor(de);
    pnlCalibration.add(dtpValuationDate);

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
    btnEcit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    btnEcit.setBounds(524, 5, 105, 68);
    pnlConfigurationPanel.add(btnEcit);
    splitPane.setDividerLocation(530);
  }

  private String getSelectedFileOrFolder(boolean isFolder) {
    String path = "";

    if (isFolder) {
      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      fc.setAcceptAllFileFilterUsed(false);
    } else {
      fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      fc.setAcceptAllFileFilterUsed(true);
    }

    int returnVal = fc.showOpenDialog(frmThething);

    if (returnVal == JFileChooser.APPROVE_OPTION) {
      path = fc.getSelectedFile().getAbsolutePath();
    }

    return path;
  }
}
