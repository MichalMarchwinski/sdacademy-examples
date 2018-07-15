package pl.sdacademy.CircleDraw_Bridge;

public class DrawingAPI2 implements DrawingAPI{
	public void drawCircle(final double x, final double y, final double radius) {
		System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
	}
}
