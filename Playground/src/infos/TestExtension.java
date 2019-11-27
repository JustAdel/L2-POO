package infos;

public class TestExtension {

	public static void main(String[] args) {
		String test = "C:/test/nicetry.html";
		Extension testClass = new Extension();
		System.out.println(testClass.getExtensionUsingApacheCommonLib(test));
		System.out.println(testClass.getMimeUsingTika(test));
	}
}
