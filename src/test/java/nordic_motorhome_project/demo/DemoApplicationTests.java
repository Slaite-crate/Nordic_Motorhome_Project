package nordic_motorhome_project.demo;

import nordic_motorhome_project.demo.interfaceRepositories.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    Validator validator = new Validator();

    //name tests
    @Test
    void isNameThree(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isName("3");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isNameSpecial(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isName("!?<");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isNameABC(){
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isName("ABC");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isNamehabc(){
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isName("abc");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isNameDanishSmall(){
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isName("øæå");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isNameDanishBig(){
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isName("ÆØÅ");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isNameMixed(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isName("Æa+!");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isNameNull(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isName("");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isNameDouble(){
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isName("aa");
        //assert
        assertEquals(expected,actual);
    }
    //Test numberplate Frederic

    //Test phonenumber Natali
    @Test
    void isPhoneNumberFour(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPhoneNumber("4");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isPhoneNumberSpecial(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPhoneNumber("!?<");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isPhoneNumberEightNumbers(){
        //arrange
        boolean expected = true; //men skal den ikke være true?
        //act
        boolean actual = validator.isPhoneNumber("01234567");
        //assert
        assertEquals(expected,actual);
    }

    @Test
    void isPhoneNumberMixed(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPhoneNumber("01+!");
        //assert
        assertEquals(expected,actual);
    }

    @Test
    void isPhoneNumberNull(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPhoneNumber("");
        //assert
        assertEquals(expected,actual);
        }

    @Test
    void isPhoneNumberDouble() {
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isPhoneNumber("11223344");
        //assert
        assertEquals(expected,actual);
    }




        //Test DriversLicence Pelle

    //Test Integer Cecilie
    @Test
    void isIntegerOneTwoThree(){
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isInteger("123");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isIntegerAbc(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isInteger("abc");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isIntegerSpecial(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isInteger("+?!");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isIntegerNull(){
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isInteger("");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isIntegerMultiple(){
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isInteger("999");
        //assert
        assertEquals(expected,actual);
    }
    //Test Price Frederic

}
