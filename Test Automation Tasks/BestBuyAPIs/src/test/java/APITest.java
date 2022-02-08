import api.ServicesAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {

    @Test
    public void getAllServicesReturns200(){
        Response response= ServicesAPI.getServices();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void getServiceByIdReturns200(){
        String id="24";
        Response response=ServicesAPI.getServiceById(id);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertTrue(response.andReturn().asString().contains(id));
    }

    @Test
    public void getServiceByNotExistIdReturns404(){
        String id="22";
        Response response=ServicesAPI.getServiceById(id);
        Assert.assertEquals(response.statusCode(),404);
        Assert.assertTrue(response.andReturn().asString().contains("NotFound"));
    }

    @Test
    public void deleteServiceByIdReturns200(){
        String id="23";
        Response response=ServicesAPI.deleteServiceById(id);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertTrue(response.andReturn().asString().contains(id));
    }

    @Test
    public void createNewServiceReturns201(){
        String serviceName="Test Service 2";
        Response response=ServicesAPI.createNewService(serviceName);
        Assert.assertEquals(response.statusCode(),201);
        Assert.assertTrue(response.andReturn().asString().contains(serviceName));
    }

    @Test
    public void updateServiceBasedOnIdReturns200(){
        String id="24";
        String serviceName="Test Service 3";
        Response response=ServicesAPI.updateServiceById(id,serviceName);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertTrue(response.andReturn().asString().contains(serviceName));
    }
}
