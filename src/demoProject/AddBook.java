package demoProject;

import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.PayLoads;

public class AddBook {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://216.10.245.166";

		String response = given().log().all().header("Content-Type", "application/json").body(PayLoads.AddPlace())
				.when().post("/Library/Addbook.php").then().assertThat().statusCode(200)
				.body("Msg", equalTo("successfully added")).extract().response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);
		String ZafraanBookID = js.getString("ID");

		System.out.println(ZafraanBookID);
		//could use this to GET/DELETE Zafraan's book.

	}

}
