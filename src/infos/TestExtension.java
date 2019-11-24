package infos;

public class TestExtension {

	public static void main(String[] args) {
		String test = "C:\test\test.txt";
		Extension testClass = new Extension();
		System.out.println(testClass.getExtensionByApacheCommonLib(test));
	}
}
