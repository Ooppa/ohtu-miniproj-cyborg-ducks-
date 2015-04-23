/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author goalaleo
 */
public class ScandCharFixer {
    
    public static String fixScandsforExport(String path) throws FileNotFoundException, IOException{
        return replaceAllUmlautsForExport(readFileToString(path));
    }

    public static String readFileToString(String path) throws UnsupportedEncodingException, IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        String fileAsString = new String(encoded, "8859_1");
        return fileAsString;
    }
    
    public static String fixScandsForImport(String path) throws IOException{  
        return replaceAllBibUmlautsForImport(readFileToString(path));
    }
    
    public static String replaceAllBibUmlautsForImport(String withBibUmlauts){
        String stringWithoutUmlauts = replaceBibUmlautAsForImport(withBibUmlauts);
        stringWithoutUmlauts = replaceBibUmlaitOsForImport(stringWithoutUmlauts);
              
        return stringWithoutUmlauts;
    }
    
    public static String replaceBibUmlautAsForImport(String withBibUmlauts){
        String stringWithoutUmlauts = withBibUmlauts.replace( "\\" +"\"{a}","ä");
        stringWithoutUmlauts = stringWithoutUmlauts.replace( "\\" +"\"{A}" ,"Ä");
        
        return stringWithoutUmlauts;
    }
    
    public static String replaceBibUmlaitOsForImport(String withBibUmlauts){
        String stringWithoutUmlauts = withBibUmlauts.replace( "\\" +"\"{o}","ö");
        stringWithoutUmlauts = stringWithoutUmlauts.replace( "\\" +"\"{O}" ,"Ö");
              
        return stringWithoutUmlauts;
    }
    
    public static String replaceUmlautAsForExport(String withUmlauts){
        String stringWithoutUmlauts = withUmlauts.replace("ä", "\\" +"\"{a}");
        stringWithoutUmlauts = stringWithoutUmlauts.replace("Ä", "\\" +"\"{A}" );
        
        return stringWithoutUmlauts;
    }
    
    public static String replaceUmlautOsForExport(String withUmlauts){
        String stringWithoutUmlauts = withUmlauts.replace("ö", "\\" +"\"{o}");
        stringWithoutUmlauts = stringWithoutUmlauts.replace("Ö", "\\" +"\"{O}" );
              
        return stringWithoutUmlauts;
    }
    
    public static String replaceAllUmlautsForExport(String withUmlauts){
        String stringWithoutUmlauts = replaceUmlautAsForExport(withUmlauts);
        stringWithoutUmlauts = replaceUmlautOsForExport(stringWithoutUmlauts);
        
        return stringWithoutUmlauts;
    }
    
    
}
