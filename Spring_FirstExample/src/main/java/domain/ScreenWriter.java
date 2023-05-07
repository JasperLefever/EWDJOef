package domain;

public class ScreenWriter implements ResultWriter {

	@Override
	public void showResult(String result) {
		System.out.println(result);
	}

}
