package files;

public class payload {
	
	
	//jira cookies api payload
	public static String jiraCookiesPayload()
	{
	 return	"{ \"username\": \"puneet8085@gmail.com\", \"password\": \"Nikku2021@#\" }";
	}
	
	//Dynamic payload to delete book
	public static String deleteBook(String id)
	{
		String payload = "{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+id+"\"\r\n"
				+ " \r\n"
				+ "} ";
		return payload;
	}
	
	//Dynamic payload for adding book
	
		public static String addBookDynamic(String bookname, String isbnvalue, int aislevalue, String authorname)
		{
			String payload="{\r\n"
					+ "\r\n"
					+ "\"name\": \""+bookname+"\",\r\n"
					+ "\"isbn\":\""+isbnvalue+"\",\r\n"
					+ "\"aisle\":\""+aislevalue+"\",\r\n"
					+ "\"author\":\""+authorname+"\"\r\n"
					+ "}\r\n"
					+ "";
			return payload;
		}
		
	
	//static payload for adding book
	
	public static String addBookStatic()
	{
		String payload="{\r\n"
				+ "\r\n"
				+ "\"name\": \"Yadhya Automation with Java\",\r\n"
				+ "\"isbn\":\"yadh\",\r\n"
				+ "\"aisle\":\"000\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		return payload;
	}
	
	
	
	public static String updatePlace(String placeid,String newaddress)
	{
		return "{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+newaddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String addPlace() {
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n "+"";
	}
	
	public static String courseAPIResponse()
	{
		return "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
	}

}
