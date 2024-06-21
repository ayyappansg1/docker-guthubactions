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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Authentication {

    Properties auth = new TestUtil().init_Properties("Authorization");
    Properties employee = new TestUtil().init_Properties("Employee");

    Properties mailProperties = new TestUtil().init_Properties("MailSac");
    Properties uatLogin = new TestUtil().init_Properties("common/uatLogin");


    public String getAccessToken(boolean url,String baseURL, String role) throws IOException {
        Map<String,Object> jsonBody = new HashMap<>();
        if(url) {
            switch (role) {
                case "INTERNAL":
                    jsonBody.put("userName", auth.getProperty("INTERNAL"));
                    jsonBody.put("Password", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "INTERNAL2":
                    jsonBody.put("userName", auth.getProperty("INTERNAL2"));
                    jsonBody.put("Password", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "HRSD":
                    jsonBody.put("userName", auth.getProperty("HRSD"));
                    jsonBody.put("Password", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "EMPLOYEE":
                    jsonBody.put("username", auth.getProperty("EMP_2005137_USERNAME"));
                    jsonBody.put("password", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "EMPLOYEE_2005144":
                    jsonBody.put("username", auth.getProperty("EMP_2005144_USERNAME"));
                    jsonBody.put("password", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "EXPERT_MANAGER":
                    jsonBody.put("UserName", auth.getProperty("EXPERT_MANAGER"));
                    jsonBody.put("PassWord", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "EXPERT_MEMBER":
                    jsonBody.put("UserName", auth.getProperty("EXPERT_MEMBER"));
                    jsonBody.put("PassWord", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "CUSTOMER":
                    jsonBody.put("UserName", auth.getProperty("CUSTOMER"));
                    jsonBody.put("PassWord", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "INSIGHTS_ESSENTIAL":
                    jsonBody.put("UserName", auth.getProperty("INSIGHTS_ESSENTIAL"));
                    jsonBody.put("PassWord", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "INSIGHTS_FREE":
                    jsonBody.put("UserName", auth.getProperty("INSIGHTS_FREE"));
                    jsonBody.put("PassWord", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "EMPLOYEE_SELFSERVICE_PROFILE":
                    jsonBody.put("username", mailProperties.getProperty("Recently_Generated_Mail"));
                    jsonBody.put("password", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "OnBoardedEmployee":
                    jsonBody.put("username", employee.getProperty("EMP_OnBoarded_Employee_Mail"));
                    jsonBody.put("password", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "INTERNAL_HR":
                    jsonBody.put("username", auth.getProperty("INTERNAL_HR"));
                    jsonBody.put("password", auth.getProperty("COMMON_PASSWORD"));
                    break;
                default:
                    jsonBody.put("USERNAME", auth.getProperty("ADMIN_USERNAME"));
                    jsonBody.put("PASSWORD", auth.getProperty("ADMIN_PASSWORD"));
                    break;
            }
            return getBearerTokenNew(baseURL, jsonBody);
        }
        else{
            switch (role) {
                case "INTERNAL":
                    jsonBody.put("userName", uatLogin.getProperty("INTERNAL_HR_EMAIL"));
                    jsonBody.put("Password", auth.getProperty("COMMON_PASSWORD"));
                    break;
                case "INTERNAL2":
                    jsonBody.put("userName", uatLogin.getProperty("INTERNAL_HR_EMAIL"));
                    jsonBody.put("Password", auth.getProperty("COMMON_PASSWORD"));
                    break;
            }
            return getBearerToken(url,baseURL, jsonBody);
        }
    }

/*    public String getAccessToken(String baseURL, String username, String password) throws IOException {
//        Map<String, Object> jsonBody = new HashMap<>();
//        jsonBody.put("username",username);
//        jsonBody.put("password",password);
//        return getBearerToken(baseURL, jsonBody);
//    } */
    public String getBearerTokenNew(String baseURL, Map<String, Object> formParams) throws JsonProcessingException {
        String basePathAccessToken = "auth0/openid-connect/token";
        formParams.put("grantType",auth.getProperty("GRANT_TYPE"));
        formParams.put("clientId","web-client");
        Response actualResponse = doPostForTokenGeneration(baseURL, null, null, null, basePathAccessToken, true, formParams);
        System.out.println("REsponse is "+actualResponse.asString());
        assert actualResponse != null;
        JsonPath jsonPathEvaluator = actualResponse.jsonPath();
        return "Bearer "+jsonPathEvaluator.get("accessToken");
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
    public Response doPostForTokenGeneration(String baseURI, String contentType, Map<String, String> Token,
                                                    Map<String, String> paramMaps, String basePath, boolean log, Map<String,Object> formParams) {

        if (setBaseURI(baseURI)) {
            RequestSpecification request = createRequest(log, contentType, Token, paramMaps);
            Map<String, String> cookies = new HashMap<>();
            cookies.put("ApplicationGatewayAffinity", "4d81fa69ff84c43c2edbe62d6e3aa64e");
            cookies.put("ApplicationGatewayAffinityCORS", "4d81fa69ff84c43c2edbe62d6e3aa64e");

            request.cookies(cookies).formParams(formParams);
            return getResponse("POST", request, basePath);
        }
        return null;
    }
    public String getBearerToken(boolean url,String baseURL, Map<String, Object> jsonBody) throws JsonProcessingException {
        String basePathAccessToken = auth.getProperty("ACCESS_TOKEN_PATH");
        if(url) {
            jsonBody.put("clientId", auth.getProperty("CLIENT_ID"));
            jsonBody.put("grantType", auth.getProperty("GRANT_TYPE"));
            jsonBody.put("enableTokenCompression", Boolean.parseBoolean(auth.getProperty("ENABLE_TOKEN_COMPRESSION")));
        }else{
            jsonBody.put("clientId", auth.getProperty("TRAVEL_MATE_UAT"));
            jsonBody.put("grantType", auth.getProperty("GRANT_TYPE"));
            jsonBody.put("enableTokenCompression", Boolean.parseBoolean(auth.getProperty("ENABLE_TOKEN_COMPRESSION")));

        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(jsonBody);
        Response actualResponse = RestClient.doPost(baseURL, "JSON", null, null, basePathAccessToken, true, json);
        System.out.println("REsponse is "+actualResponse.asString());
        assert actualResponse != null;
        JsonPath jsonPathEvaluator = actualResponse.jsonPath();
        return "Bearer "+jsonPathEvaluator.get("accessToken");
    }

    public String getAccessTokenDirectlywithUserNamePassword(boolean url,String baseURL,String userName) throws JsonProcessingException {
        Map<String,Object> jsonBody = new HashMap<>();
        jsonBody.put("userName",userName);
        jsonBody.put("Password",auth.getProperty("COMMON_PASSWORD"));
        return getBearerToken(url,baseURL, jsonBody);
    }
    public String getAccessTokenDirectlywithUserNamePasswordManagerOnly(boolean url,String baseURL,String userName) throws JsonProcessingException {
        Map<String,Object> jsonBody = new HashMap<>();
        jsonBody.put("userName",userName);
        jsonBody.put("Password",auth.getProperty("ManagerOnly"));
        return getBearerToken(url,baseURL, jsonBody);
    }
}
