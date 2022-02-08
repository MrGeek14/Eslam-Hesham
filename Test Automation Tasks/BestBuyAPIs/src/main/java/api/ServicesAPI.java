package api;

import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ServicesAPI {

    private static final String apiURL="http://localhost:3030/services/";

    public static Response getServices(){
        given().get(apiURL).then().log().body();
        return given().get(apiURL);

    }

    public static Response getServiceById(String id){
        given().get(apiURL+id).then().log().body();
        return given().get(apiURL+id);
    }

    public static Response deleteServiceById(String id){
        given().get(apiURL+id).then().log().body();
        return given().delete(apiURL+id);
    }

    public static Response createNewService(String serviceName){
        HashMap serviceData= new HashMap<>();
        serviceData.put("name",serviceName);
        return given().contentType("application/json").body(serviceData).post(apiURL);
    }

    public static Response updateServiceById(String id,String serviceName){
        HashMap serviceData= new HashMap<>();
        serviceData.put("name",serviceName);
        return given().contentType("application/json").body(serviceData).patch(apiURL+id);
    }
}
