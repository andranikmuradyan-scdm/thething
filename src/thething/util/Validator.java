package thething.util;

import java.io.File;
import java.util.List;

public class Validator {
  public static boolean validateValuationInput(String productsFolder, String mdFolder, String fixingFile, 
      String issuserCUrvePrefix, String resFilePrefix, String valuationDate, List<String> currencies) throws Exception{

    boolean isValid = false;
    
    
    
    return isValid;
  }
  
  public static boolean validateCalibrationInput(String pathToData, boolean isCCX) throws Exception{
    
    File fCurves = new File(pathToData + "/curves");
    
    if(!isCCX){
      File fRates = new File(pathToData + "/rates");
      
      if(!fCurves.exists() || !fRates.exists())
        return false;
    } else {
      File fCCXRates = new File(pathToData + "rates-crosscurrency");
      if(!fCurves.exists() || !fCCXRates.exists())
        return false;
    }
    
    return true;
  }
  
  public static boolean validateCSVToXLSXConversionInput(String pathToCSVs, String pathToXLSXs, String templateXLSX) {
    File folderCSV = new File(pathToCSVs);
    File folderXLSX = new File(pathToXLSXs);
    
    if(!folderCSV.exists() || !folderCSV.isDirectory() || folderCSV.list().length == 0)
      return false;
    
    if(!folderXLSX.exists() || !folderXLSX.isDirectory())
      return false;
    
    if(!templateXLSX.endsWith(".xlsx"))
      return false;
    
    return true;
  }
}
