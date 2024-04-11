import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void endpoint_available(){
        when().get("https://jsonplaceholder.typicode.com/todos").then().statusCode(200);
    }

    @Test
    public void querying4(){
        when().get("https://jsonplaceholder.typicode.com/todos/{id}",4).then().statusCode(200).body("title", equalTo("et porro tempora"));
    }
    
    @Test
    public void all_ids(){
        when().get("https://jsonplaceholder.typicode.com/todos").then().statusCode(200).body("id", hasItems(198,199));
    }

    @Test
    public void all_time(){
        when().get("https://jsonplaceholder.typicode.com/todos").then().time(lessThan(2000L));
    }
}
