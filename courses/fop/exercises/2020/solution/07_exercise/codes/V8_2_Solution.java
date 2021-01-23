@Test
public void testProduce() {
	Product normalProduct = plm.produce("Hausuebungen");
	assertNotNull(normalProduct);
	assertTrue(normalProduct.getQuality() >= 89);
}