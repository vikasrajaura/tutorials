package my;

import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.*;

@RunWith(JMockit.class)
public class ReflectionGeneric {


    private Map<String, Object> outputs;
    private Map<String, Object> inputs;
    private GenericSrrCalculator genericSrrCalculator;

    @Before
    public void setup() {
        inputs = RequestTestUtility.sampleInputGenericSrr(scenarioNo);
        outputs = genericSrrCalculator.calculate(inputs, null, null);
    }

    /**
     *   There are 20 scenarios in RequestTestUtility
     *   in this case valid values of scenarioNo is 1 to 20
     */
    private final int scenarioNo=8;

    /**
     *  This will test all output variables for specific scenarioNo
     */
    @Test
    public void test() {

        int i=0;
        String[] inputValues = RequestTestUtility.TEST_HARNESS_OUTPUT_VALUES[scenarioNo].split(",",-1);
        for (String expectedVariableName : RequestTestUtility.TEST_HARNESS_OUTPUT_COLUMNS) {

            String expectedValue = inputValues[i];

            Object actual = outputs.get(expectedVariableName);
            String expectedVariableType = getType(actual);
            String failureMsg = "Actual and Expected is not equal for Variable : " + expectedVariableName;

            // validate the type of expected and actual variable
            validateType(actual, expectedVariableName, expectedVariableType);

            // compare actual and expected value
            assertExpectedAndActual(failureMsg, expectedVariableType, expectedValue, actual);
            i++;
        }
    }

    private String getType(Object actual) {
        if (actual instanceof Boolean) return "java.lang.Boolean";
        else if(actual ==null || actual instanceof String) return "java.lang.String";
        else if(actual instanceof Double) return "java.lang.Double";
        else if(actual instanceof Integer) return "java.lang.Integer";
        else return null;
    }

    /**
     *  This will test all the output variables which are declared in this class by using reflection
     */

/*
    @Test
    public void test() {
        Field[] fields = this.getClass().getFields();
        for (Field f : fields) {
            f.setAccessible(true);

            String expectedVariableName = f.getName();
            String expectedVariableType = f.getType().getName();
            Object expectedValue;

            Object actual = outputs.get(expectedVariableName);
            String failureMsg = "Actual and Expected is not equal for Variable : " + expectedVariableName;
            try {
                expectedValue = f.get(this);

                // validate the type of expected and actual variable
                validateType(actual, expectedVariableName, expectedVariableType);

                // compare actual and expected value
                //assertExpectedAndActual(failureMsg, expectedVariableType, expectedValue, actual);

                //System.out.println("Passed for: " + expectedVariableName);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
 */

    /**
     * This method will validate the type of expected and actual variable
     * @param actual - this is the actual calculated value
     * @param expectedVariableName - the expected variable name defined in this class
     * @param expectedVariableType - the expected variable type defined in this class
     */
    public void validateType(Object actual, String expectedVariableName, String expectedVariableType) {
        if (actual == null) return;
        boolean isValidType = false;
        if ("java.lang.Boolean".equals(expectedVariableType) && actual instanceof Boolean
                || "java.lang.String".equals(expectedVariableType) && actual instanceof String
                || "java.lang.Double".equals(expectedVariableType) && actual instanceof Double
                || "java.lang.Integer".equals(expectedVariableType) && actual instanceof Integer) {
            isValidType = true;
        }
        if (!isValidType) Assert.fail("Type validation fails for varialbe: " + expectedVariableName + ", expectedType is:" + expectedVariableType);

    }


    public void assertExpectedAndActual(String failureMsg, String expectedVariableType, String expectedValue, Object actualValue){
        if (expectedValue == null && actualValue == null) {
            return;
        } else if ("java.lang.String".equals(expectedVariableType)) {
                if(StringUtils.isEmpty((String) expectedValue) && StringUtils.isEmpty((String) actualValue)) { return;}
                else {
                    assertEquals(failureMsg, (String) expectedValue, (String) actualValue);
                }
        } else if (expectedValue != null && actualValue != null) {
            if ("java.lang.Boolean".equals(expectedVariableType)) {
                assertEquals(failureMsg, Boolean.valueOf(expectedValue), (Boolean) actualValue);
            } else if ("java.lang.Double".equals(expectedVariableType)) {
                Double actValue = round((Double) actualValue, 7);
                assertEquals(failureMsg, Double.valueOf(expectedValue), actValue);
            } else if ("java.lang.Integer".equals(expectedVariableType)) {
                assertEquals(failureMsg, Integer.valueOf(expectedValue), (Integer) actualValue);
            }
        } else {
            Assert.fail(failureMsg + ", expected: " + expectedValue + ", actual: " + actualValue);
        }
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
