package pl.sdacademy.ProxyPattern_Proxy;

public class ProxyImage implements Image {

	private RealImage image = null;
	private String filename = null;

	public ProxyImage(final String filename) {
		this.filename = filename;
	}

	public void displayImage() {
		if (image == null) {
			image = new RealImage(filename);
		}
		image.displayImage();
	}
}
