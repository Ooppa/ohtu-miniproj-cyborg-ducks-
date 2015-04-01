/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.fields;

/**
 * Defines a field which contains one data element with type Integer.
 */
public class SimpleIntField extends Field {

    private int data;

    /**
     * Creates a new field with data element containing String
     *
     * @param fieldName name of the field
     * @param data      data contained in the field
     */
    public SimpleIntField(String fieldName, int data) {
        super(fieldName);
        this.data = data;
    }

    /**
     * Returns the data associated with this Field
     *
     * @return data associated with this field
     */
    public int getData() {
        return data;
    }

    /**
     * Set new data for this Field
     *
     * @param data Integer to set
     */
    public void setData(int data) {
        this.data = data;
    }
    
    
    @Override
    public String toString() {
        return this.getName() + " = "+ "\""+ this.getData() + "\"";
    }
}
