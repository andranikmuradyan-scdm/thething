package thething.core;

import java.io.File;
import java.util.List;

public class Validator {
  public static boolean validateValuationInput(String productsFolder, String mdFolder, String fixingFile, 
      String issuserCUrvePrefix, String resFilePrefix, String valuationDate, List<String> currencies) throws Exception{

    boolean isValid = false;
    
    
    
    return isValid;
  }
  
  public static boolean validateCalibrationInput(String pathToData, boolean isCCX) throws Exception{
    boolean isValid = true;
    
    File fCurves = new File(pathToData + "/curves");
    
    if(!isCCX){
      File fRates = new File(pathToData + "/rates");
      
      if(!fCurves.exists() || !fRates.exists())
        isValid = false;
    } else {
      File fCCXRates = new File(pathToData + "rates-crosscurrency");
      if(!fCurves.exists() || !fCCXRates.exists())
        isValid = false;
    }
    
    return isValid;
  }
  
  public static boolean validateCSVToXLSXConversionInput() {
    boolean isValid = false;
    
    
    
    return isValid;
  }
}
