/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references;

import fi.cyborgducks.biblexrefmanager.fields.Field;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Defines a Reference
 */
public abstract class Reference {

    private final String referenceName;
    private ArrayList<Field> requiredFields;
    private ArrayList<Field> optionalFields;

    /**
     * Creates a new Reference with no required or optional fields
     */
    public Reference(String referenceName) {
        this.referenceName = referenceName;
        requiredFields = new ArrayList<>();
        optionalFields = new ArrayList<>();
    }

    /**
     * Returns the required fields of this Reference
     *
     * @return a list of required fields
     */
    public ArrayList<Field> getRequiredFields() {
        return requiredFields;
    }

    /**
     * Returns the optional fields of this Reference
     *
     * @return a list of optional fields
     */
    public ArrayList<Field> getOptionalFields() {
        return optionalFields;
    }

    @Override
    public String toString() {
        
        // print @name{
        // TODO, foreach requiredFields
        // foreach optionalFields
        // }
        
        return "not yet implemented";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11*hash+Objects.hashCode(this.requiredFields);
        hash = 11*hash+Objects.hashCode(this.optionalFields);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
        if(getClass()!=obj.getClass()) {
            return false;
        }
        final Reference other = (Reference) obj;
        if(!Objects.equals(this.requiredFields, other.requiredFields)) {
            return false;
        }
        if(!Objects.equals(this.optionalFields, other.optionalFields)) {
            return false;
        }
        return true;
    }

}
