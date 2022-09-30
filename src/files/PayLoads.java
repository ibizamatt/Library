package files;

public class PayLoads {

	public static String AddBook(String isbn, String aisle)
	{
		return "{\r\n" + 
				"\"name\":\"Ragu's New Books\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"Matt McEvoy\"\r\n" + 
				"}";
	}

}
