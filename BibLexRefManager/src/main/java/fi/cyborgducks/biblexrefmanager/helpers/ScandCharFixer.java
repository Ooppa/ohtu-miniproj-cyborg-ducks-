/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author goalaleo
 */
public class ScandCharFixer {
    
    public static String fixScands(String path) throws FileNotFoundException, IOException{
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        String fileAsString = new String(encoded, "8859_1");
        fileAsString = replaceAllUmlauts(fileAsString);
//        System.out.println(fileAsString);
        
        return fileAsString;
    }
    
    public static String replaceUmlautAs(String umlauts){
        String stringWithoutUmlauts = umlauts.replace("ä", "\\" +"\"{a}");
        stringWithoutUmlauts = stringWithoutUmlauts.replace("Ä", "\\" +"\"{A}" );
        
        return stringWithoutUmlauts;
    }
    
    public static String replaceUmlautOs(String umlauts){
        String stringWithoutUmlauts = umlauts.replace("ö", "\\" +"\"{o}");
        stringWithoutUmlauts = stringWithoutUmlauts.replace("Ö", "\\" +"\"{O}" );
        
        
        return stringWithoutUmlauts;
    }
    
    public static String replaceAllUmlauts(String umlauts){
        String stringWithoutUmlauts = replaceUmlautAs(umlauts);
        stringWithoutUmlauts = replaceUmlautOs(stringWithoutUmlauts);
        
        return stringWithoutUmlauts;
    }
    
    
}
