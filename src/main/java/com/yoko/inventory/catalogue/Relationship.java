package com.yoko.inventory.catalogue;

/**
 * Created by yokoAlpha on 04/02/2017.
 */
public class Relationship
{
        String productCode;
        String relationshipType;
        String secondProductCode;


        public Relationship(String productCode, String relationshipType, String secondProductCode)
        {
            this.productCode = productCode;
            this.relationshipType = relationshipType;
            this.secondProductCode = secondProductCode;
        }

}
