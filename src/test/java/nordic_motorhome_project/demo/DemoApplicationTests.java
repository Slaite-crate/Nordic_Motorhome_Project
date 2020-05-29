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

    //Test DriversLicence Pelle
    @Test
    void isDriversLicenceRightLengthWrongChar() {
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isDriversLicence("aaaaaaaa");
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void isDriversLicenceRightLength() {
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isDriversLicence("12345678");
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void isDriversLicenceWrongLength() {
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isDriversLicence("1234567");
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void isDriversLicenceRightLengthWeird() {
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isDriversLicence("1234567?");
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void isDriversLicenceMixed() {
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isDriversLicence("1234abcd");
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void isDriversLicenceTooLong() {
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isDriversLicence("1234567890");
        //assert
        assertEquals(expected, actual);
    }
    //Test Integer Cecilie

    //Test Price Frederic

}
