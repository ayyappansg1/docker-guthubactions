package common;

import common.Pojo.EmployeePOJO;

import java.util.Properties;

public class MailSacGenerator {
    private static final TestUtil testUtil = new TestUtil();
    static Properties mailProperties = testUtil.init_Properties("MailSac");
    static EmployeePOJO employee = new EmployeePOJO();

    public static String getMailSacMailAddress(String firstName,String lastName){
        return firstName.concat(lastName).concat("1").concat(mailProperties.getProperty("EMAIL_DOMAIN"));
    }
    public static String getYopMailAddress(String firstName,String lastName){
        return firstName.concat(lastName).concat("1").concat(mailProperties.getProperty("Yop_Mail"));
    }
}
