import org.testng.Assert;

import files.payload;
import files.reusablemethods;
import io.restassured.path.json.JsonPath;

public class mockordummywaytoautomateAPIbeforedevelpoment {
	
	public static void main (String[] args)
	{
		JsonPath js=reusablemethods.rawToJson(payload.courseAPIResponse());
		
//1. Print no of course present in response
		
		int coursecount=js.getInt("courses.size()"); // size method is used to fetch total no of record in a array. put array name with size method
		System.out.println(coursecount);
		
//2. Print purchase amount from API response
		int totalpurchaseamount=js.getInt("dashboard.purchaseAmount");
		System.out.println(totalpurchaseamount);
//3. Print title of first course
		System.out.println(js.getString("courses.title[0]"));
		//or
	//	System.out.println(js.getString("courses[0].title"));
		
//4. Print all courses name and their respective price
		//write sysout and press ctrl space together to complete syntax
		
		for (int i=0; i<coursecount;i++)
		{
			System.out.println("Course name is : " +js.getString("courses["+i+"].title") +"     "+"Course price is : "+js.getString("courses["+i+"].price"));
			
		
		}

//5. Print no of copies sold by RPA Course
		for (int i=0; i<coursecount;i++)
		{
			if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA"))
			{
				System.out.println("Count of copies is : "+js.getString("courses["+i+"].copies"));
				break;
			}
			
		
		}
		int sum=0;
//6. Verify if Sum of all Course prices matches with Purchase Amount	
		for (int i=0; i<coursecount;i++)
		{
			int courseprice = js.getInt("courses["+i+"].price");
			int coursecopies=js.getInt("courses["+i+"].copies");
			int totalsoldprice = courseprice * coursecopies;
			sum =sum+totalsoldprice;
			
		}
		Assert.assertEquals(sum, totalpurchaseamount);
		 System.out.println("----------------End of Execution--------------------------------");
		   
		
		
		
	}
}