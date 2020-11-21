package com.helper.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.compress.utils.IOUtils;

/**
 * Super class to provide utilites to help writing API tests
 */
public class APIHelperUtility {

    @Rule
    public TestName testName = new TestName();

    protected static final Logger LOGGER = LoggerFactory.getLogger(APIHelperUtility.class);
    private static String envFile = "env.properties";
    private static Properties prop;

    @BeforeClass
    public static void setup(){
        prop = initProperties();
    }

    @Before
    public void printEachTestName(){
        LOGGER.info("Test Case Name: " + testName.getMethodName());
    }

    public static Properties initProperties(){
        Properties prop = new Properties();
        try{
            prop.load(APIHelperUtility.class.getClassLoader().getResourceAsStream(envFile));
        } catch (IOException e) {
            throw new RuntimeException("Unable to Load Property File " +envFile);
        }
        return prop;
    }

    public static String getValue(String key){
        String value = prop.getProperty(key);
        Assert.assertNotNull(value, String.format("%s key is missing", key));
        return value;
    }

    public static String loadFile(String file){
        try{
            InputStream stream = APIHelperUtility.class.getClassLoader().getResourceAsStream(file);
            return stream.toString();
        } catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Unable load file " + file);
        }
    }

    public static String getRandomString(String length){
        String sources = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars = sources.toCharArray();
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for(int i=0; i<Integer.parseInt(length); i++){
            sb.append(chars[rand.nextInt(chars.length)]);
        }
        return sb.toString();
    }

    public static String getEnvFile(){
        return envFile;
    }

    public static void setEnvFile(String envFile){
        APIHelperUtility.envFile = envFile;
    }
}
