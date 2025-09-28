package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class utilities {

    public static ExtentReports generateExtentReport() {

        ExtentReports extentReports = new ExtentReports();

        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/ExtentReport.html"));

        extentSparkReporter.config().setReportName("API Testing");
        extentSparkReporter.config().setDocumentTitle("Automation exercise");
        extentSparkReporter.config().setTheme(Theme.STANDARD);

        extentReports.attachReporter(extentSparkReporter);


        extentReports.setSystemInfo("Name","Prethumnan");
        extentReports.setSystemInfo("Role","Automation tester");
        extentReports.setSystemInfo("Experience","Fresher");

        return extentReports;

    }

    public static Map<String, Object> generateUserData() {
        Faker faker = new Faker();
        final LinkedHashMap<String, Object> map = new LinkedHashMap<>();

        map.put("name", faker.name().fullName());
        map.put("email", faker.internet().emailAddress());
        map.put("password", faker.internet().password(8, 12));
        map.put("title", "Mr"); // or randomly select from array ["Mr", "Mrs", "Miss"]
        map.put("birth_date", faker.number().numberBetween(1, 28) + "");
        map.put("birth_month", String.format("%02d", faker.number().numberBetween(1, 12)));
        map.put("birth_year", faker.number().numberBetween(1980, 2000) + "");
        map.put("firstname", faker.name().firstName());
        map.put("lastname", faker.name().lastName());
        map.put("company", faker.company().name());
        map.put("address1", faker.address().streetAddress());
        map.put("address2", faker.address().secondaryAddress());
        map.put("country", faker.address().country());
        map.put("zipcode", faker.address().zipCode());
        map.put("state", faker.address().state());
        map.put("city", faker.address().city());
        map.put("mobile_number", faker.phoneNumber().cellPhone());

        return map;
    }

}

