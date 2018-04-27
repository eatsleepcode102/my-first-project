package howto.converter;

import java.util.function.Function;


public class ChainFunc2String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<String, String> addHeader=ChainFunc2String::addHeader;
		Function<String, String> transformationPipeline= addHeader.andThen(ChainFunc2String::checkSpelling).andThen(ChainFunc2String::addFooter);
		System.out.println(transformationPipeline.apply("this is a test!"));
	}
	
	public static String addHeader(String text) {
		return "From java2s.com:"+text;
	}
	
	public static String addFooter(String text) {
		return text+ "Kind regards";
	}
	
	public static String checkSpelling(String text) {
		return text.replaceAll("a", "*");
	}
}
