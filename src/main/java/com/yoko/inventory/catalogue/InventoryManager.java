package com.yoko.inventory.catalogue;

import java.util.*;

/**
 * Created by yokoAlpha on 02/02/2017.
 */
public class InventoryManager
{
    ArrayList <Relationship> relationshipList;
    ArrayList <Product> productList;

    public InventoryManager(String relatedProductsCSV, String productsCSV)
    {
        this.relationshipList = DataParser.parseRelationship(relatedProductsCSV);
        this.productList = DataParser.parseProducts(productsCSV);
    }

    public int numberOfRelationshipsFor(Product entity)
    {
        return associatedToProduct(entity).size();
    }

    public ArrayList<Product> associatedToProduct(Product entity)
    {
        ArrayList<Product>relationshipMatch = new ArrayList<Product>();
        for(Relationship relationObject : this.relationshipList)
        {
            if((entity.productCode.equals(relationObject.productCode)) || (entity.productCode.equals(relationObject.secondProductCode)))
            {
                relationshipMatch.add(findProductFromProductCode(relationObject.secondProductCode));
            }
        }
        return relationshipMatch;
    }

    public Product findProductFromProductCode(String code)
    {
        for(Product individual : this.productList)
        {
            if(individual.productCode.equals(code))
            {
                return individual;
            }
        }
        return null;
    }
    // relatedItemsFor(product, category)
    public Product[] relatedProducts(Product entity, String productCategory)
    {
        ArrayList<Product> items = new ArrayList<Product>();
        for(Relationship relationObject : this.relationshipList)
        {
            if(((entity.productCode.equals(relationObject.productCode)) || (entity.productCode.equals(relationObject.secondProductCode))) &&
                    (relationObject.relationshipType.equals (productCategory)))
            {
                items.add(findProductFromProductCode(relationObject.secondProductCode));
            }
        }
        Product names[] = items.toArray(new Product[items.size()]);
        return names;
    }

    public Product findAvailableStockInRange()
    {
        for (Product individual : this.productList)
        {
            if ((individual.quantity >= 50) && (individual.quantity <= 60))
            {
                return individual;
            }
        }
        return null;
    }
    public Product[] lowStockItems()
    {
        ArrayList<Product> items = new ArrayList<Product>();

        for(Product p : this.productList)
        {
            if (p.quantity<=20)
            {
                items.add(p);
            }
        }
        Product products[] = items.toArray(new Product[items.size()]);
        return products;
    }
}