package com.yoko.inventory.catalogue;
import junit.framework.*;

/**
 * Created by yokoAlpha on 04/02/2017.
 */

public class RelationshipTests extends TestCase
{
    public InventoryManager manager;

    protected void setUp() throws Exception
    {
        manager = new InventoryManager("src/test/resources/RelatedProducts.csv", "src/test/resources/Products.csv");
    }

    public void testCreatingEntities()
    {
        Relationship association = new Relationship("G109", "RetroGame" ,"G017");
        assertTrue(association.productCode == "G109");
        assertTrue(association.relationshipType == "RetroGame");
        assertTrue(association.secondProductCode == "G017" );
    }

    public void testParsingRelationship()
    {
        assertEquals(DataParser.parseRelationship("src/test/resources/RelatedProducts.csv").size(), 16);
    }

    public void testNumberOfRelationshipsForDonkeyKong()
    {
        Product donkeyKong = this.manager.productList.get(0);
        assertEquals( 4, this.manager.numberOfRelationshipsFor(donkeyKong));
    }

    public void testNumberOfRelationshipsForCathrine()
    {
        Product cathrine = this.manager.productList.get(3);
        assertEquals( 3, this.manager.numberOfRelationshipsFor(cathrine));
    }

    public void testNumberOfRelationshipsForTetris()
    {
        Product tetris = this.manager.productList.get(7);
        assertEquals( 2,this.manager.numberOfRelationshipsFor(tetris));
    }

    public void testNumberOfRelationshipsForDoom()
    {
        Product doom = this.manager.productList.get(10);
        assertEquals(0, this.manager.numberOfRelationshipsFor(doom));
    }

    public void testSizeOfRelatedGamesForCathrine ()
    {
        Product cathrine = this.manager.productList.get(3);
        Product[] returnedProducts = this.manager.relatedProducts(cathrine, "RetroGame");
        assertEquals(0, returnedProducts.length);
    }

    public void testSizeOfRelatedGamesForDonkeyKong ()
    {
        Product donkeyKong = this.manager.productList.get(0);
        Product[] returnedProducts = this.manager.relatedProducts(donkeyKong, "RetroGame");
        assertEquals(4, returnedProducts.length);
    }

    public void testSizeOfRelatedGamesForPokemon()//add new method for Retro
    {
        Product pokemon = this.manager.productList.get(11);
        Product[] returnedProducts = this.manager.relatedProducts(pokemon, "Game");
        assertEquals(1, returnedProducts.length);
    }

    public void testProductsNeedingReplenishment()
    {
        Product[] lowStockProducts = this.manager.lowStockItems();
        assertEquals(2,lowStockProducts.length);
    }
}
