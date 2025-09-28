package Base;

import Utilities.utilities;
import org.testng.annotations.BeforeSuite;

import java.util.Map;

public class Base {

    public static Map<String, Object> data;
    @BeforeSuite
    public static void data(){

        data = utilities.generateUserData();

    }
}
