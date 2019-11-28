package infos;

public class TestFileInfos {

	public static void main(String[] args) {
		String test = "test.txt";
		FileInfos testClass = new FileInfos();
		System.out.println(testClass.getExtensionUsingApacheCommonLib(test));
		System.out.println(testClass.getMimeUsingTika(test));
	}
}
