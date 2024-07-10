package api;

import io.restassured.response.Response;
import utils.ApiUtils;

public class ApiClient {
    public Response getGenderByName(String name) {
        return ApiUtils.getRequestWithParam("", "name", name);
    }
}
