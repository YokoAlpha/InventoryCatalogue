package com.yoko.inventory.catalogue;

import junit.framework.*;

public class PersonTests extends TestCase
{
	public void testConstructingProduct()
	{
		Product entity = new Product("Popeye", "G990" , 57);
		assertTrue(entity.name == "Popeye");
		assertTrue(entity.productCode == "G990" );
		assertTrue(entity.quantity == 57);
	}

	public void testParsingEntities()
	{
		InventoryManager reader = new InventoryManager("src/test/resources/RelatedProducts.csv", "src/test/resources/Products.csv");
		assertEquals(DataParser.parseProducts("src/test/resources/Products.csv").size(),12);
	}

	public void testIfStockInRange()
	{
		InventoryManager pm = new InventoryManager("src/test/resources/RelatedProducts.csv", "src/test/resources/Products.csv");
		Product Cathrine = pm.findAvailableStockInRange();
		assertEquals(Cathrine.quantity, 52);
		assertEquals(Cathrine.name, "Cathrine");
	}

}