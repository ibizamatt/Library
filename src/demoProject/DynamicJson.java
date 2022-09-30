package demoProject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import files.PayLoads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

public class DynamicJson {


	@Test(dataProvider = "BookData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
				.body(PayLoads.AddBook(isbn, aisle)).when().post("/Library/Addbook.php").then().assertThat()
				.statusCode(200).extract().response().asString();
		

		JsonPath js = new JsonPath(response);
		String id = js.get("ID").toString();
		System.out.println(id);
	}

		@Test(dataProvider = "BookData")
	public void deleteBook(String isbn, String aisle) {
		given().log().all().header("Content-Type", "application/json")
		.when().post("/Library/DeleteBook.php?ID="+isbn+aisle)
		.then().assertThat().statusCode(200);
	}
	

	@DataProvider(name = "BookData")
	public Object[][] getData() {
		return new Object[][] { { "111", "RAGUBOOK1" }, { "222", "RAGUBOOK2" }, { "333", "RAGUBOOK3" } };
	}

}
