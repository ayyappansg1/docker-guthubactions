package common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RestClient {

    public static Response doGet(String baseURI, String contentType, Map<String, String> Token,
                                 Map<String, String> paramMaps, String basePath, boolean log) {
        if (setBaseURI(baseURI)) {
            RequestSpecification request = createRequest(log, contentType, Token, paramMaps);
            return getResponse("GET", request, basePath);
        }
        return null;
    }
    public static Response simpleGet(String baseUri){
        return RestAssured.given().contentType(ContentType.JSON).get(baseUri);

    }
    public static String getTodayDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String formattedDateTime = now.format(formatter);
        System.out.println(formattedDateTime);
        return formattedDateTime;
    }
    public static Response simplePutWithBody(String baseUri,String payload){
        return RestAssured.given().contentType(ContentType.JSON).body(payload).put(baseUri);

    }
    public static Response doPost(String baseURI, String contentType, Map<String, String> Token,
                                  Map<String, String> paramMaps, String basePath, boolean log, String payLoad) throws JsonProcessingException {

        if (setBaseURI(baseURI)) {
            RequestSpecification request = createRequest(log, contentType, Token, paramMaps);
            request.body(payLoad);
            return getResponse("POST", request, basePath);
        }
        return null;
    }

    private static boolean setBaseURI(String baseURI) {
        if (baseURI == null || baseURI.isEmpty()) {
            return false;
        }
        try {
            RestAssured.baseURI = baseURI;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static RequestSpecification createRequest(boolean log, String contentType, Map<String, String> Token,
                                                      Map<String, String> paramMaps) {
        RequestSpecification request;
        if (log) {
            request = RestAssured.given().log().all();
        } else {
            request = RestAssured.given();
        }
        if (contentType != null) {
            if (contentType.equalsIgnoreCase("JSON")) {
                request.contentType(ContentType.JSON);
            } else if (contentType.equalsIgnoreCase("XML")) {
                request.contentType(ContentType.XML);
            } else if (contentType.equalsIgnoreCase("TEXT")) {
                request.contentType(ContentType.TEXT);
            } else if (contentType.equalsIgnoreCase("multipart")) {
                request.multiPart("image", new File(""));
            }
        }
        if (!(Token == null)) {
            request.headers(Token);
        }

        if (!(paramMaps == null)) {
            request.queryParams(paramMaps);
        }

        return request;

    }

    public static void addRequestPayLoad(RequestSpecification request, Object obj) throws JsonProcessingException {
        if (obj instanceof Map) {
            request.formParams((Map<String, String>) obj);
        } else {
            String jsonPayLoad = TestUtil.getSerializedJson(obj);
            request.body(jsonPayLoad);
        }
    }

    private static Response getResponse(String httpMethod, RequestSpecification request, String basePath) {
        return executeAPI(httpMethod, request, basePath);
    }
    private static Response executeAPI(String httpMethod, RequestSpecification request, String basePath) {
        Response response = null;
        switch (httpMethod) {
            case "GET":
                response = request.get(basePath);
                break;
            case "POST":
                response = request.post(basePath);
                break;
            case "PUT":
                response = request.put(basePath);
                break;
            case "DELETE":
                response = request.delete(basePath);
                break;

            default:
                System.out.println("Please pass the valid http method");
                break;
        }
        return response;
    }

    public static String getSerializedJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    public static String getAccessToken(String baseURL, String role) throws IOException {
        TestUtil testUtil = new TestUtil();
        Properties auth = testUtil.init_Properties("restAssured/Base");
        String basePathAccessToken = auth.getProperty("ACCESS_TOKEN_PATH");
        Map<String,Object> jsonBody = new HashMap<>();
        switch (role){
            case "INTERNAL":
                jsonBody.put("userName",auth.getProperty("INTERNAL_USERNAME"));
                jsonBody.put("Password",auth.getProperty("INTERNAL_PASSWORD"));
                break;
            case "EMPLOYEE":
                jsonBody.put("username",auth.getProperty("EMP_2005137_USERNAME"));
                jsonBody.put("password",auth.getProperty("COMMON_PASSWORD"));
                break;
            case "EMPLOYEE_2005144":
                jsonBody.put("username",auth.getProperty("EMP_2005144_USERNAME"));
                jsonBody.put("password",auth.getProperty("COMMON_PASSWORD"));
                break;
        }
        jsonBody.put("clientId",auth.getProperty("CLIENT_ID"));
        jsonBody.put("grantType",auth.getProperty("GRANT_TYPE"));
        jsonBody.put("enableTokenCompression",Boolean.parseBoolean(auth.getProperty("ENABLE_TOKEN_COMPRESSION")));
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(jsonBody);
        Response actualResponse = doPost(baseURL, "JSON", null, null, basePathAccessToken, true, json);
        assert actualResponse != null;
        JsonPath jsonPathEvaluator = actualResponse.jsonPath();
        return "Bearer "+jsonPathEvaluator.get("accessToken");
    }
    public static Response doPut(String baseURI, String contentType, Map<String, String> Token,
                                 Map<String, String> paramMaps, String basePath, boolean log, String payLoad) {

        if (setBaseURI(baseURI)) {
            RequestSpecification request = createRequest(log, contentType, Token, paramMaps);
            if(payLoad!=null){request.body(payLoad);}
            return getResponse("PUT", request, basePath);
        }
        return null;
    }
}
