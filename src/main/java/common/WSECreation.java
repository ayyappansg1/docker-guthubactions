package common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import common.Pojo.*;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class WSECreation {
    private final TestUtil testUtil = new TestUtil();
    Authentication authentication = new Authentication();
    EmployeePOJO employee = new EmployeePOJO();
    public Response actualResponse;



    public static String employeeID;
    public static String firstName;
    public static String lastName;
    public static String employeeEmail;

    Properties selfEmpProperties = testUtil.init_Properties("SelfOnBoardingEmployee");

    Properties mailProperties = testUtil.init_Properties("MailSac");
    Faker faker = new Faker();
    private String baseURIAPI;

    Properties prop = testUtil.init_Properties("Employee");
    Properties uatEmployeeprop = testUtil.init_Properties("UATEmployee");
    Properties auth = testUtil.init_Properties("Authorization");
    Properties uatprop = new TestUtil().init_Properties("common/uatLogin");


    public void createWSEthroughAPI(boolean url,String managerormanagerwse) throws IOException, InterruptedException {
        if(url) {
            baseURIAPI = "https://apigw-qa-eu.atlasbyelements.com/";
        }else{
            baseURIAPI = "https://apigw-uat-eu.atlasbyelements.com/";
        }
        //profile stepper
        String basePathInitial = prop.getProperty("BASE_PATH_CREATE_NEW_EMPLOYEE_BY_INTERNAL");

        // Employee Pojo class objects
        employee.setFirstName(faker.name().firstName());
        firstName = employee.getFirstName();
        employee.setLastName(faker.name().lastName());
        lastName = employee.getLastName();

        employee.setEmail(MailSacGenerator.getMailSacMailAddress(employee.getFirstName(), employee.getLastName()));
        employee.setWorkCountry(prop.getProperty("WORKCOUNTRYID"));
        employee.setWorkCountryCode(prop.getProperty("workCountryCode"));
        employee.setResidenceCountry(prop.getProperty("residenceCountry"));
        employee.setResidenceCountryCode(prop.getProperty("residenceCountryCode"));
        if(url){
            employee.setClientId(prop.getProperty("clientId"));
        }else{
            employee.setClientId(auth.getProperty("TRAVEL_MATE_UAT"));

        }

        ObjectMapper objectMapper = new ObjectMapper();
        String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        String token= authentication.getAccessToken(url,baseURIAPI, "INTERNAL");
        // authorization Token
        Map<String, String> authToken = new HashMap<>();
        authToken.put("Authorization",token);
        if(url) {
            authToken.put("customerId", auth.getProperty("TRAVEL-MATE_CUSTOMER_ID"));
        }else{
            authToken.put("customerId", auth.getProperty("TRAVEL_MATE_UAT"));
        }
        Response actualResponseValidID = RestClient.doPost(baseURIAPI, "JSON", authToken, null, basePathInitial, true, employeeJson);
        //Verify status Code
        assert actualResponseValidID != null;

        Assert.assertEquals(actualResponseValidID.statusCode(), 200);

    Configuration config = Configuration.defaultConfiguration();
        config.addOptions(Option.ALWAYS_RETURN_LIST);
        config.addOptions(Option.SUPPRESS_EXCEPTIONS);
        config.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
    Object empId=JsonPath.using(config).parse(actualResponseValidID.asString()).read("$.data.employeeID");

       // String empId = actualResponseValidID.jsonPath().get("data.employeeID");
        System.out.println("Employee id is " + empId);
        employeeID = (String) empId;
        employee.setEmployeeID(employeeID);
        System.out.println(actualResponseValidID.asString());
        testUtil.update_Properties("MailSac", "Recently_Generated_Mail", employee.getEmail());
        employeeEmail = employee.getEmail();
        String empID = employee.getEmployeeID();
      //  testUtil.update_Properties("common/Login", "WSE_Through_API", employee.getEmail());
        //testUtil.update_Properties("common/Login", "WSE_Through_API_ID", empID);

        String basePathCreateNewEmp = prop.getProperty("BASE_PATH_PROFILE_STEPPER");
        EmployeeProfileStepperPojo employeeProfileStepper = new EmployeeProfileStepperPojo();
        employeeProfileStepper.setFirstName(employee.getFirstName());
        employeeProfileStepper.setLastName(employee.getLastName());
        employeeProfileStepper.setTaxId("");
        employeeProfileStepper.setGender(Integer.parseInt(prop.getProperty("gender")));
        employeeProfileStepper.setBirthday(prop.getProperty("birthday"));
        employeeProfileStepper.setMaritalStatus(null);
        employeeProfileStepper.setPreferredName(null);
        employeeProfileStepper.setSuffix(null);
        employeeProfileStepper.setTitle(null);
        HomeAddress homeAddress = new HomeAddress();
        homeAddress.setStreet1("");
        homeAddress.setStreet2("");
        homeAddress.setCity("");
        homeAddress.setState("");
        homeAddress.setPostalCode("");
        homeAddress.setCountry(prop.getProperty("WORK_COUNTRY_NAME"));
        homeAddress.setCountryID(prop.getProperty("WORKCOUNTRYID"));
        homeAddress.setCountryCode(prop.getProperty("workCountryCode"));

        employeeProfileStepper.setHomeAddress(homeAddress);
        employeeProfileStepper.setIsDualCitizen(null);
        employeeProfileStepper.setIsLegallyAuthorized(null);
        employeeProfileStepper.setCitizenship(new ArrayList<Object>());
        ContactDetails contactdetails = new ContactDetails();
        OfficeLandline officeLandline = new OfficeLandline();
        officeLandline.setCountryCode("+93");
        officeLandline.setNumber("");
        contactdetails.setOfficeLandline(officeLandline);
        HomeMobile homeMobile = new HomeMobile();
        homeMobile.setNumber("");
        homeMobile.setCountryCode("+340");
        contactdetails.setHomeMobile(homeMobile);
        HomeLandline homeLandline = new HomeLandline();
        homeLandline.setNumber("");
        homeLandline.setCountryCode("+340");
        homeLandline.setExtension("");
        contactdetails.setHomeLandline(homeLandline);
        contactdetails.setHomeEmail(employee.getEmail());
        employeeProfileStepper.setContactDetails(contactdetails);
        employeeProfileStepper.setEmployeeId(employee.getEmployeeID());
        employeeProfileStepper.setUsers(Integer.parseInt(prop.getProperty("users")));
        employeeProfileStepper.setWseClassification(0);
        Pronoun pronoun = new Pronoun();
        pronoun.setPersonalPronoun("");
        pronoun.setPersonalPronounId("");
        pronoun.setCustomPersonalPronoun("");
        employeeProfileStepper.setPronoun(pronoun);
        EmployeeVerification employeeVerification = new EmployeeVerification();
        employeeVerification.setVerificationRequired(false);
        employeeProfileStepper.setEmployeeVerification(employeeVerification);
        ObjectMapper objectMapper2 = new ObjectMapper();
        String employeeProfileJson = objectMapper2.writerWithDefaultPrettyPrinter().writeValueAsString(employeeProfileStepper);

        Response actualProfileStepperResponseValidID = RestClient.doPut(baseURIAPI, "JSON", authToken, null, basePathCreateNewEmp, true, employeeProfileJson);
        //  assert actualResponseValidID != null;
        Assert.assertEquals(actualProfileStepperResponseValidID.statusCode(), 200);

        String basePathJobdetailsStepper = prop.getProperty("BASE_PATH_JOBDETAILS_STEPPER");

        EmployeeJobDetailsStepper employeeJobDetailsStepper = new EmployeeJobDetailsStepper();

        employeeJobDetailsStepper.setEmployeeId(employee.getEmployeeID());
        CurrentJobDetails currentJobDetails = new CurrentJobDetails();
        currentJobDetails.setJobTitle("");
        ReportsTo reportsTo = new ReportsTo();
        if(url) {
            if(managerormanagerwse.equalsIgnoreCase("managerWSe")) {
                reportsTo.setAtlasId(prop.getProperty("Manager_atlasId"));
                reportsTo.setEmployeeId(prop.getProperty("Manager_employeeId"));
                reportsTo.setEmail(prop.getProperty("Manager"));
                reportsTo.setJobTitle(prop.getProperty("Manager_jobTitle"));
                reportsTo.setName(prop.getProperty("Manager_Name"));
                currentJobDetails.setReportsTo(reportsTo);
            }else{
                reportsTo.setAtlasId(prop.getProperty("Manager_atlasId"));
                reportsTo.setEmployeeId(prop.getProperty("Manager_employeeId"));
                reportsTo.setEmail(prop.getProperty("Manager"));
                reportsTo.setJobTitle(prop.getProperty("Manager_jobTitle"));
                reportsTo.setName(prop.getProperty("Manager_Name"));
                currentJobDetails.setReportsTo(reportsTo);
            }
        }else{
            if(managerormanagerwse.equalsIgnoreCase("managerWSe")) {
                reportsTo.setAtlasId(uatprop.getProperty("ManagerWSE_AtlasID"));
                reportsTo.setEmployeeId(uatprop.getProperty("ManagerWSE_AtlasID"));
                reportsTo.setEmail(uatprop.getProperty("ManagerWSE_Email"));
                reportsTo.setJobTitle(uatprop.getProperty("Manager_jobTitle"));
                reportsTo.setName(uatprop.getProperty("Manager_WSE_Name"));
                currentJobDetails.setReportsTo(reportsTo);
            }else {
                reportsTo.setAtlasId(uatprop.getProperty("Manager_atlasId"));
                reportsTo.setEmployeeId(uatprop.getProperty("Manager_atlasId"));
                reportsTo.setEmail(uatprop.getProperty("MANAGER_TIME_OFF"));
                reportsTo.setJobTitle(uatprop.getProperty("Manager_jobTitle"));
                reportsTo.setName(uatprop.getProperty("Manager_Name"));
                currentJobDetails.setReportsTo(reportsTo);
            }
        }

        currentJobDetails.setDepartment("");
        currentJobDetails.setDivision("");

        WorkAddress workAddress = new WorkAddress();
        workAddress.setStreet1("");
        workAddress.setStreet2("");
        workAddress.setCity("");
        workAddress.setState("");
        workAddress.setPostalCode("");
        workAddress.setCountry(prop.getProperty("WORK_COUNTRY_NAME"));
        workAddress.setCountryID(prop.getProperty("WORKCOUNTRYID"));
        workAddress.setCountryCode(prop.getProperty("workCountryCode"));

        currentJobDetails.setWorkAddress(workAddress);
        if(url) {
            currentJobDetails.setClientId(prop.getProperty("clientId"));
            currentJobDetails.setClientName(prop.getProperty("clientName"));
        }else{
            currentJobDetails.setClientId(auth.getProperty("TRAVEL_MATE_UAT"));
            currentJobDetails.setClientName(prop.getProperty("clientName"));

        }

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setId(prop.getProperty("customerid"));
        customerDetails.setName(prop.getProperty("clientName"));
        customerDetails.setRegion(null);
        customerDetails.setStatusLabel(null);

        currentJobDetails.setCustomerDetails(customerDetails);
        currentJobDetails.setTargetStartDate(null);
        currentJobDetails.setAtlasStartDate("2023-01-04T00:00:00Z");
        currentJobDetails.setTermEndDate(null);
        currentJobDetails.setIsProbationApplicable(null);
        currentJobDetails.setProbationPeriodType(null);
        currentJobDetails.setProbationPeriod(0);
        currentJobDetails.setRetirementAge(0);
        currentJobDetails.setJobDescription("");

        CompensationDetails compensationDetails = new CompensationDetails();
        compensationDetails.setLppId("");
        compensationDetails.setCurrency("971");
        compensationDetails.setPayType(1);
        compensationDetails.setPaymentSchedule(4);
        compensationDetails.setAmount(0);
        compensationDetails.setIsOvertimeApplicable(null);
        compensationDetails.setTotalHours(0);
        compensationDetails.setAdditionalMonthlyInstallmentsRequired(null);
        compensationDetails.setAdditionalMonthlyInstallments();
        compensationDetails.setAdditionalMonthlyInstallmentsDescription("");

        currentJobDetails.setCompensationDetails(compensationDetails);

        currentJobDetails.setIsCollectiveAgreementRequired(null);
        currentJobDetails.setSeniorityDate(null);
        currentJobDetails.setEmployerNoticePeriod(0);
        currentJobDetails.setEmployerNoticePeriod(0);
        currentJobDetails.setEmployeeNoticePeriodType(null);
        currentJobDetails.setEmployeeNoticePeriodType(null);
        currentJobDetails.setEmploymentType(null);
        currentJobDetails.setEmploymentTerm(2);
        currentJobDetails.setWorkingHrsPerWeek(0);
        currentJobDetails.setRegion("string");
        currentJobDetails.setCountryName(prop.getProperty("WORK_COUNTRY_NAME"));
        currentJobDetails.setCountryID(prop.getProperty("WORKCOUNTRYID"));
        currentJobDetails.setCountryCode(prop.getProperty("workCountryCode"));
        currentJobDetails.setWorkSameAsHomeAddress(false);
        currentJobDetails.setTargetDateByClient(false);

        PayGroup payGroup = new PayGroup();
        if(url) {
            payGroup.setPayGroupId(61);
            payGroup.setPayGroupName("AF-ATL-06");
        }else{
            payGroup.setPayGroupId(15);
            payGroup.setPayGroupName("AT-ATL-01");

        }

        currentJobDetails.setPayGroup(payGroup);
        currentJobDetails.setContractEndDate(null);

        employeeJobDetailsStepper.setCurrentJobDetails(currentJobDetails);

        ObjectMapper objectMapperjob = new ObjectMapper();
        String employeeJobJson = objectMapperjob.writerWithDefaultPrettyPrinter().writeValueAsString(employeeJobDetailsStepper);


        Response actualJobResponseValidID = RestClient.doPut(baseURIAPI, "JSON", authToken, null, basePathJobdetailsStepper, true, employeeJobJson);

        //  assert actualResponseValidID != null;
        Assert.assertEquals(actualJobResponseValidID.statusCode(), 200);

        String basePathTimeoffNewEmp = prop.getProperty("BASE_PATH_TIMEOFF_STEPPER");

        TimeoffStepper timeoffStepper = new TimeoffStepper();
        timeoffStepper.setEmployeeId(employee.getEmployeeID());

        PublicHolidayPolicy publicHolidayPolicy = new PublicHolidayPolicy();
        publicHolidayPolicy.setHolidayPolicies(new ArrayList<Object>());
        publicHolidayPolicy.setIsCustomEffectiveDate(false);
        publicHolidayPolicy.setCustomEffectiveDate(null);
        timeoffStepper.setPublicHolidayPolicy(publicHolidayPolicy);

        TimeOffPolicy timeOffPolicy = new TimeOffPolicy();
        if(url) {
            timeOffPolicy.setPolicyId(prop.getProperty("timeoffPolicyid2"));
            timeOffPolicy.setPolicyName(prop.getProperty("timeoff_PolicyName"));
            timeOffPolicy.setPolicyAssignmentDate(null);
            timeOffPolicy.setTimeOffType(prop.getProperty("timeoffPolicytypeName2"));
            timeOffPolicy.setIsCustomEffectiveDate(false);
            timeOffPolicy.setCustomEffectiveDate(null);
            timeOffPolicy.setTimeOffTypeId(prop.getProperty("timeOffTypeId"));
            timeOffPolicy.setTimeOffTypeName(prop.getProperty("timeOffTypeName"));

            ArrayList<TimeOffPolicy> timeOffPolicies = new ArrayList<>();
            timeOffPolicies.add(timeOffPolicy);
            timeoffStepper.setTimeOffPolicies(timeOffPolicies);
        }else{
            timeOffPolicy.setPolicyId(uatEmployeeprop.getProperty("timeoffPolicyid2"));
            timeOffPolicy.setPolicyName(uatEmployeeprop.getProperty("timeoff_PolicyName"));
            timeOffPolicy.setPolicyAssignmentDate(null);
            timeOffPolicy.setTimeOffType(uatEmployeeprop.getProperty("timeoffPolicytypeName2"));
            timeOffPolicy.setIsCustomEffectiveDate(false);
            timeOffPolicy.setCustomEffectiveDate(null);
            timeOffPolicy.setTimeOffTypeId(uatEmployeeprop.getProperty("timeOffTypeId"));
            timeOffPolicy.setTimeOffTypeName(uatEmployeeprop.getProperty("timeOffTypeName"));

            ArrayList<TimeOffPolicy> timeOffPolicies = new ArrayList<>();
            timeOffPolicies.add(timeOffPolicy);
            timeoffStepper.setTimeOffPolicies(timeOffPolicies);
        }

        ObjectMapper objectTimeoffMapper = new ObjectMapper();
        String employeeTimeoffJson = objectTimeoffMapper.writerWithDefaultPrettyPrinter().writeValueAsString(timeoffStepper);


        Response actualTimeoffResponseValidID = RestClient.doPut(baseURIAPI, "JSON", authToken, null, basePathTimeoffNewEmp, true, employeeTimeoffJson);
        assert actualResponseValidID != null;
        Assert.assertEquals(actualTimeoffResponseValidID.statusCode(), 200);

        String basePathTTNewEmp = prop.getProperty("BASE_PATH_TIMETRACKING_ADD");

        TimeTrackingAdd timeTrackingadd = new TimeTrackingAdd();
        if(url) {
            timeTrackingadd.setEmployeeId(employee.getEmployeeID());
            timeTrackingadd.setCustomerId(auth.getProperty("TRAVEL-MATE_CUSTOMER_ID"));
            timeTrackingadd.setIsCustomDate(false);
            timeTrackingadd.setCustomDate(null);
            //TimeTrackingPolicy.generatedTimeTrackingPolicyId
            timeTrackingadd.setPolicyId(prop.getProperty("TT_PolicyId"));
            timeTrackingadd.setPolicyName(prop.getProperty("TT_PolicyName"));
        }else{
            timeTrackingadd.setEmployeeId(employee.getEmployeeID());
            timeTrackingadd.setCustomerId(auth.getProperty("TRAVEL_MATE_UAT"));
            timeTrackingadd.setIsCustomDate(false);
            timeTrackingadd.setCustomDate(null);
            //TimeTrackingPolicy.generatedTimeTrackingPolicyId
            timeTrackingadd.setPolicyId(uatEmployeeprop.getProperty("TT_PolicyId"));
            timeTrackingadd.setPolicyName(uatEmployeeprop.getProperty("TT_PolicyName"));
        }

        ObjectMapper objectMapperTT = new ObjectMapper();
        String employeeTTJson = objectMapperTT.writerWithDefaultPrettyPrinter().writeValueAsString(timeTrackingadd);

        Response actualTTResponseValidID = RestClient.doPut(baseURIAPI, "JSON", authToken, null, basePathTTNewEmp, true, employeeTTJson);

        assert actualTTResponseValidID != null;
        Assert.assertEquals(actualTTResponseValidID.statusCode(), 200);

        String basePathFinishCreateNewEmp = prop.getProperty("BASE_PATH_FINISHSTEPPER");

        FinishStepper finishStepper = new FinishStepper();
        finishStepper.setEmployeeID(employee.getEmployeeID());

        ObjectMapper objectFinishMapper = new ObjectMapper();
        String employeeFinishJson = objectFinishMapper.writerWithDefaultPrettyPrinter().writeValueAsString(finishStepper);

        // authorization Token

        Response actualFinishResponseValidID = RestClient.doPut(baseURIAPI, "JSON", authToken, null, basePathFinishCreateNewEmp, true, employeeFinishJson);

        assert actualFinishResponseValidID != null;
        Assert.assertEquals(actualFinishResponseValidID.statusCode(), 200);


        Thread.sleep(10000);
        String baseMailApiUri = mailProperties.getProperty("BASE_API_URL");
        String recentlyGeneratedMail = employeeEmail;
        System.out.println("Generated Mail is "+recentlyGeneratedMail);
        String basePathMessages = mailProperties.getProperty("BASE_PATH_MESSAGES");

        Map<String, String> paramMapsSacAuthentication = new HashMap<>();
        paramMapsSacAuthentication.put("limit", "1");
        paramMapsSacAuthentication.put("_mailsacKey", mailProperties.getProperty("Mailsac_Key"));
        // Response response=RestAssured.given().baseUri(baseMailApiUri+recentlyGeneratedMail).accept("application/json").get(basePathMessages+"?_mailsacKey=k_n8uUA2zMyhD1ez3CVMFQXd29nvmK5boil5g8acb&limit=1");

        actualResponse = RestClient.doGet(baseMailApiUri, "JSON", null, paramMapsSacAuthentication, recentlyGeneratedMail+basePathMessages, true);
        Assert.assertEquals(actualResponse.statusCode(), 200);
        System.out.println("This is the Mailsac Response received "+actualResponse.asString());
      //  Configuration configm = Configuration.defaultConfiguration();
        Object fromMail = JsonPath.using(config).parse(actualResponse.asString()).read("$.[0].from.[0].address");

        if(((String) fromMail).equalsIgnoreCase("no-reply@atlashxm.com") || ((String) fromMail).equalsIgnoreCase("noreply@atlashxm.com")){
            Assert.assertTrue(true,"Mail Verified Successfully");
        } else {
            Assert.fail("Mail Verification Failed");
        }


        String thirdPartyRedirectApi = mailProperties.getProperty("Third_Party_API_For_Mail_reading");
        Configuration configs = Configuration.defaultConfiguration();
        configs.addOptions(Option.ALWAYS_RETURN_LIST);
        configs.addOptions(Option.SUPPRESS_EXCEPTIONS);
        configs.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        System.out.println("Response before Set Password "+actualResponse.asString());
        Object fromMailAnother= JsonPath.using(configs).parse(actualResponse.asString()).read("$.[0].links[0]");

        /*//*HTTPStatusMailPojo httpStatusMailPojo=new HTTPStatusMailPojo();

        ArrayList<String> list=new ArrayList<String>();
        list.add((String)fromMail);
        httpStatusMailPojo.setUrls(list);
        httpStatusMailPojo.setAdditionalSubdomains(new ArrayList<>());
        httpStatusMailPojo.setCanonicalDomain(false);
        httpStatusMailPojo.setEscapeCharacters(false);
        httpStatusMailPojo.setThrottleRequests(100);
        httpStatusMailPojo.setFollowRedirect(true);
        httpStatusMailPojo.setUserAgent("browser");
        httpStatusMailPojo.setUserName("");
        httpStatusMailPojo.setPassWord("");
        httpStatusMailPojo.setHeaderName("");
        httpStatusMailPojo.setHeaderValue("");
        httpStatusMailPojo.setStrictSSL(true);
        ArrayList<String> li= new ArrayList<String>();
        li.add("www");
        httpStatusMailPojo.setAdditionalSubdomains(li);

        ObjectMapper objectMapper = new ObjectMapper();
        String httpStatusJsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(httpStatusMailPojo);

        Response thirdPartyMailResponse= RestClient.simplePostWithBody(thirdPartyRedirectApi,httpStatusJsonString);

        Object redirectionURl= JsonPath.using(config).parse(thirdPartyMailResponse.asString()).read("$.[0].redirects[0].redirectUri");
*/
        URLConnection con = new URL((String)fromMailAnother).openConnection();
        System.out.println( "orignal url: " + con.getURL() );
        con.connect();
        System.out.println( "connected url: " + con.getURL() );
        InputStream is = con.getInputStream();
        String redirectedURL=con.getURL().toString();
        System.out.println( "redirected url: " +redirectedURL);
        is.close();
        String finalOnboardingUrl=(String)redirectedURL;
        String tokenWSE=finalOnboardingUrl.split("token=")[1].split("&")[0];

        SetPassword setPassword=new SetPassword();
        setPassword.setUserName(employeeEmail);
        setPassword.setPassWord(mailProperties.getProperty("SetPassword"));

        ObjectMapper objectMapperSetPassword2 = new ObjectMapper();
        String setPasswordJson = objectMapperSetPassword2.writerWithDefaultPrettyPrinter().writeValueAsString(setPassword);
        String newPasswordJson=setPasswordJson.replaceAll(" ","");
        Response decryptUser;
        if(url) {
            decryptUser = RestClient.simpleGet(mailProperties.getProperty("BaseUriDecryptUser") + tokenWSE);
        }else{
            decryptUser = RestClient.simpleGet(mailProperties.getProperty("BaseUriDecryptUserUAt") + tokenWSE);

        }
        Assert.assertEquals(decryptUser.statusCode(), 200,"Validation of Decrypt User");
        Response setPasswordResponse;
        if(url) {
            setPasswordResponse = RestClient.simplePutWithBody(mailProperties.getProperty("SetPasswordUri") + tokenWSE, newPasswordJson);
        }else{
            setPasswordResponse = RestClient.simplePutWithBody(mailProperties.getProperty("SetPasswordUriUAt") + tokenWSE, newPasswordJson);

        }
        Assert.assertEquals(setPasswordResponse.statusCode(), 200,"Validation of Setting Password");

        Map<String, String> authTokenWSE = new HashMap<>();

        authTokenWSE.put("Authorization", authentication.getAccessTokenDirectlywithUserNamePassword(url,baseURIAPI, employeeEmail));
        if(url) {
            authTokenWSE.put("customerId", auth.getProperty("TRAVEL-MATE_CUSTOMER_ID"));
        }else{
            authTokenWSE.put("customerId", auth.getProperty("TRAVEL_MATE_UAT"));

        }

        ProfileStepper profileStepper=new ProfileStepper();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        //Date date= dateFormat.parse(selfEmpProperties.getProperty("Birthday"));
        profileStepper.setFirstName(firstName);
        profileStepper.setLastName(lastName);
        profileStepper.setBirthday(selfEmpProperties.getProperty("Birthday"));
        profileStepper.setEmployeeId(employeeID);
        profileStepper.setMaritalStatus(1);
        profileStepper.setGender(1);
        HomeAddress address=new HomeAddress();
        address.setCountry(prop.getProperty("WORK_COUNTRY_NAME"));
        address.setCountryCode(prop.getProperty("workCountryCode"));
        address.setCountryID(prop.getProperty("WORKCOUNTRYID"));
        address.setStreet1(faker.address().streetAddress());
        address.setCity("Dummy City");

        profileStepper.setHomeAddress(address);

        ContactDetails contactDetails=new ContactDetails();
        OfficeLandline officeLandlineWSE=new OfficeLandline();
        officeLandlineWSE.setCountryCode("+43");
        officeLandlineWSE.setNumber("1111555");
        officeLandlineWSE.setExtension("");
        contactDetails.setOfficeLandline(officeLandlineWSE);
        HomeLandline homeLandlineWSE=new HomeLandline();
        homeLandlineWSE.setNumber("");
        homeLandlineWSE.setCountryCode("+43");
        homeLandlineWSE.setExtension("");
        contactDetails.setHomeLandline(homeLandlineWSE);
        HomeMobile homeMobileWSe=new HomeMobile();
        homeMobileWSe.setCountryCode("+340");
        homeMobileWSe.setNumber("12333344");
        contactDetails.setHomeMobile(homeMobileWSe);
        contactDetails.setHomeEmail(employeeEmail);
        profileStepper.setContactDetails(contactDetails);

        Citizenship citizenship=new Citizenship();
        citizenship.setCountry(prop.getProperty("WORKCOUNTRYID"));
        citizenship.setCountryCode(prop.getProperty("workCountryCode"));
        ArrayList<String> ar=new ArrayList<String>();
        ar.add(mailProperties.getProperty("NationalId"));
        citizenship.setNationalIds(ar);
        citizenship.setNationalId("");

        ArrayList<Citizenship> ci=new ArrayList<Citizenship>();
        ci.add(citizenship);
        profileStepper.setCitizenship(ci);

        ObjectMapper objectMapperWSEProfile = new ObjectMapper();
        String profileStepperPayload = objectMapperWSEProfile.writerWithDefaultPrettyPrinter().writeValueAsString(profileStepper);

        String basePathofSelfOnboardingProfileStepper = selfEmpProperties.getProperty("BASE_PATH_EMPLOYEESELFSERVICE_PROFILESTEPPER");

        Response actualResponse = RestClient.doPut(baseURIAPI, "JSON", authTokenWSE, null, basePathofSelfOnboardingProfileStepper, true,profileStepperPayload);

        Assert.assertEquals(actualResponse.statusCode(), 200,"Validation of Profile Stepper");

        String basePathofSelfOnboardingEmergencyStepper = selfEmpProperties.getProperty("BASE_PATH_EMPLOYEESELFSERVICE_EMERGENCYSTEPPER");

        EmergencyStepper emergencyStepper=new EmergencyStepper();
        emergencyStepper.setEmployeeId(employeeID);
        emergencyStepper.setContactFirstName(faker.name().firstName());
        emergencyStepper.setContactLastName(faker.name().lastName());
        emergencyStepper.setContactRelationship(1);

        ContactMobilePhone contactMobilePhone=new ContactMobilePhone();
        contactMobilePhone.setCountryCode(null);
        contactMobilePhone.setNumber("1234566789");
        emergencyStepper.setContactMobilePhone(contactMobilePhone);
        emergencyStepper.setContactEmail(faker.name().firstName()+"@gmail.com");

        ContactHomePhone contactHomePhone=new ContactHomePhone();
        contactHomePhone.setNumber("");
        contactHomePhone.setCountryCode(null);
        contactHomePhone.setExtension(null);
        emergencyStepper.setContactHomePhone(contactHomePhone);

        ContactWorkPhone contactWorkPhone=new ContactWorkPhone();
        contactWorkPhone.setNumber("");
        contactWorkPhone.setCountryCode(null);
        contactWorkPhone.setExtension(null);
        emergencyStepper.setContactWorkPhone(contactWorkPhone);

        ContactHomeAddress contactHomeAddress=new ContactHomeAddress();
        contactHomeAddress.setStreet1(faker.address().streetAddress());
        contactHomeAddress.setCity(faker.address().cityName());
        contactHomeAddress.setPostalCode(faker.address().zipCode());
        contactHomeAddress.setCountry(prop.getProperty("WORK_COUNTRY_NAME"));
        contactHomeAddress.setCountryCode(prop.getProperty("workCountryCode"));
        contactHomeAddress.setCountryID(prop.getProperty("WORKCOUNTRYID"));
        emergencyStepper.setContactHomeAddress(contactHomeAddress);

        ObjectMapper objectMapperWSEEmergency = new ObjectMapper();
        String emergencyStepperPayload = objectMapperWSEEmergency.writerWithDefaultPrettyPrinter().writeValueAsString(emergencyStepper);

        Response actualWSEEmergencyResponse = RestClient.doPut(baseURIAPI, "JSON", authTokenWSE, null, basePathofSelfOnboardingEmergencyStepper, true,emergencyStepperPayload);
        Assert.assertEquals(actualWSEEmergencyResponse.statusCode(), 200,"Validation of Emergency Stepper");
        String basePathofSelfOnboardingSubmitStepper = selfEmpProperties.getProperty("BASE_PATH_EMPLOYEESELFSERVICE_SUBMIT");

        SubmitStepper submitStepper=new SubmitStepper();
        submitStepper.setEmployeeID(employeeID);
        ObjectMapper objectMapperWSESubmit = new ObjectMapper();
        String submitStepperPayload = objectMapperWSESubmit.writerWithDefaultPrettyPrinter().writeValueAsString(submitStepper);

        Response actualResponseWSESubmit = RestClient.doPut(baseURIAPI, "JSON", authTokenWSE, null, basePathofSelfOnboardingSubmitStepper, true,submitStepperPayload);
        Assert.assertEquals(actualResponseWSESubmit.statusCode(), 200,"Validation of Submit Stepper");



        String basePathStatusChangeEmployee = selfEmpProperties.getProperty("BASE_PATH_EMPLOYEESTATUSCHANGETOACTIVE");

        ChangeStatusOfEmployee changeStatusOfEmployee=new ChangeStatusOfEmployee();
        changeStatusOfEmployee.setEmployeeId(employeeID);
        changeStatusOfEmployee.setNewStatus(5);
        changeStatusOfEmployee.setComments("");
        changeStatusOfEmployee.setEffectiveDate(selfEmpProperties.getProperty("AtlasStartDate"));
        changeStatusOfEmployee.setAtlasStartDate(selfEmpProperties.getProperty("AtlasStartDate"));
        changeStatusOfEmployee.setCurrentStatus(9);

        ObjectMapper objectMapperChangeStatus = new ObjectMapper();
        String changeStatusJson = objectMapperChangeStatus.writerWithDefaultPrettyPrinter().writeValueAsString(changeStatusOfEmployee);

        Response actualResponseStatusChangeValidID = RestClient.doPut(baseURIAPI,"JSON",authToken,null,basePathStatusChangeEmployee,true,changeStatusJson);
        Assert.assertEquals(actualResponseStatusChangeValidID.statusCode(), 200);
        System.out.println(actualResponseStatusChangeValidID.asString());
        Assert.assertEquals(actualResponseStatusChangeValidID.jsonPath().get("message[0]"), "Employment Status changed successfully");
        if(url) {
            testUtil.update_Properties("common/Login", "WSE_Through_API", employee.getEmail());
            testUtil.update_Properties("common/Login", "WSE_Through_API_ID", empID);
        }else{
            testUtil.update_Properties("common/uatLogin", "WSE_Through_API", employee.getEmail());
            testUtil.update_Properties("common/uatLogin", "WSE_Through_API_ID", empID);
        }
    }


}
