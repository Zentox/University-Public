private GeoLib g;
private double delta = 0.001;

@BeforeEach
public void setup() {
	g = new GeoLib();
}

@Test
public void testTtiangleArea01() {
	assertEquals(43.301, g.triangleArea(10, 10, 10), delta);
}

@Test
public void testTtiangleArea02() {
	assertEquals(4452.572, g.triangleArea(42, 221, 213), delta);
}

@Test
public void testTtiangleArea03() {
	assertEquals(3901146.591, g.triangleArea(4324, 3242, 2432), delta);
}