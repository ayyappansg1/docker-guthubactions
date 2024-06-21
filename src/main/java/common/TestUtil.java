package common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Properties;

public class TestUtil extends BaseTest
{
    private Properties prop;

    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
                + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    public Properties init_Properties(String fileName){
        prop = new Properties();
        try {
            FileInputStream inputStream=new FileInputStream("./src/test/java/resources/propertyFiles/"+ fileName +".properties");
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public void update_Properties(String fileName, String key, String value){
        prop = new Properties();
        try {
            FileInputStream inputStream=new FileInputStream("./src/test/resources/propertyFiles/"+ fileName +".properties");
            prop.load(inputStream);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream("./src/test/resources/propertyFiles/"+ fileName +".properties");
            prop.setProperty(key,value);
            prop.store(outputStream,"Property file has been updated : "+key+" updated");
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRandomString(final Integer size) {
        return RandomStringUtils.randomAlphabetic(size);
    }

    public static String getSerializedJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    public String getExpectedDataFile(String dataFileName) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get("./src/test/resources/"+dataFileName+".json"));
        return new String(jsonData);
    }

    public static void update_listOfProperties(String fileName, HashMap<String, String> hashMap){
        StringBuilder underscore;
        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            System.out.println("The key is :" + key + ", and value is : " + value);
            underscore = new StringBuilder(String.valueOf(Character.toLowerCase(key.charAt(0))));

            for (int i = 1; i < key.length(); i++) {
                underscore.append(Character.isLowerCase(key.charAt(i)) ? String.valueOf(key.charAt(i))
                        : "_" + Character.toLowerCase(key.charAt(i)));
            }
            String key_UpperCase = underscore.toString().toUpperCase().replaceAll("[\\\\.]","");
            new TestUtil().update_Properties(fileName, key_UpperCase, value);
        }
    }

    public static void updateJsonFile(String key,String value,String jsonFileName){
        File file=new File("./src/test/resources/payLoadJSONs/"+jsonFileName+".json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read the JSON file into a JsonNode object
            JsonNode rootNode = objectMapper.readTree(file);

            // Cast the root node to an ObjectNode to add a new property
            ObjectNode objectNode = (ObjectNode) rootNode;

            // Add a new property to the object
            objectNode.put(key, value);

            // Write the updated JSON back to the same file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, objectNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getParticularJsonValue(String key,String jsonFileName) throws IOException {
        File file=new File("./src/test/resources/payLoadJSONs/"+jsonFileName+".json");
        ObjectMapper objectMapper = new ObjectMapper();
        // Read the JSON file into a JsonNode object
        JsonNode rootNode = objectMapper.readTree(file);
        return rootNode.get(key).asText();

    }

}
