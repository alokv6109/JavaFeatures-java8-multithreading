package junit5AndMockitoPractise;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.swing.text.Utilities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class PractiseJunitClassTest {


    private final PractiseJunitClass practiseJunitClass= new PractiseJunitClass();

    @BeforeAll
    public static void init(){
//        practiseJunitClass= new PractiseJunitClass();
//        System.out.println("lalallal started testing via fdoing ");
    }

    @BeforeEach
    public void beforeEvery(){
        //use case :  best when used with parametrized test cases to do a cleanup before every test is run
        System.out.println("before each test case");
    }



    @org.junit.jupiter.api.Test
    void divide() {

        Assertions.assertThrows(IllegalArgumentException.class, ()->
                practiseJunitClass.divide(5, 0));
    }

    @Test
    @Order(0)
    void divideHApplyFlow(){
        Assertions.assertEquals(5, practiseJunitClass.divide(5, 1));

    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @Tag("parametrijzed")
    void testIsEven_withEvenNumbers(int number) {
        assertTrue(practiseJunitClass.isEven(number), number + " should be even");
    }



    @ParameterizedTest
    @CsvSource({
            "madam, true",
            "hello, false",
            "racecar, true",
            "world, false",
            "radar, true"
    })
    void testIsPalindrome_MixedCases(String word, boolean expected) {
        assertEquals(expected, PractiseJunitClass.isPalindrome(word), word + " palindrome check failed");
    }

    /*
    Explanation
Using @ValueSource:

The test method runs once for each value provided in the @ValueSource annotation.

Example: The method testIsPalindrome_TrueCases is executed for each string in the {"madam", "racecar", "level", "radar", "refer"} array.

Using @CsvSource:

Allows multiple parameters for each test run. Each line in the annotation represents one test case with multiple arguments.

Example: "madam, true" tests if isPalindrome("madam") returns true.
     */



    @Test
    public void testStaticMethodReturningSomeValue(){
        try(MockedStatic<PractiseJunitClass> classMockedStatic = Mockito.mockStatic(PractiseJunitClass.class)){
            classMockedStatic.when(()-> PractiseJunitClass.getGreeting("alok")).thenReturn("alok!");
            String result = PractiseJunitClass.getGreeting("alok");

            assertEquals("alok!", result);


            classMockedStatic.verify(()-> PractiseJunitClass.getGreeting("alok"));
            classMockedStatic.close();
        }
    }

    @Test
    public void testStaticVoidMethod(){
        try(MockedStatic<PractiseJunitClass> classMockedStatic= Mockito.mockStatic(PractiseJunitClass.class)){
            doNothing().when(practiseJunitClass.divide(5, 1));
//            ReflectionUtils.findMethod()

//                    PractiseJunitClass.log("alok");


            classMockedStatic.verify(()->PractiseJunitClass.log("alok"), Mockito.times(1));

        }
    }
}