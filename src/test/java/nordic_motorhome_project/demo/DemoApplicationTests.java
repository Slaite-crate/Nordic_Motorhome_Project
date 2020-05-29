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
    @Test
    void isNumberplateThree() {
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isNumberPlate("3");
        //assert
        assertEquals(expected, actual);
    }
        @Test
        void isNumberplateSpecial(){
            //arrange
            boolean expected = false;
            //act
            boolean actual = validator.isNumberPlate("!?<");
            //assert
            assertEquals(expected,actual);
        }
        @Test
        void isNumberplateABC(){
            //arrange
            boolean expected = true;
            //act
            boolean actual = validator.isNumberPlate("ABC");
            //assert
            assertEquals(expected,actual);
        }
        @Test
        void isNumberplateabc(){
            //arrange
            boolean expected = false;
            //act
            boolean actual = validator.isNumberPlate("abc");
            //assert
            assertEquals(expected,actual);
        }
        @Test
        void isNumberplateDanishSmall(){
            //arrange
            boolean expected = false;
            //act
            boolean actual = validator.isNumberPlate("øæå");
            //assert
            assertEquals(expected,actual);
        }
        @Test
        void isNumberplateDanishBig(){
            //arrange
            boolean expected = false;
            //act
            boolean actual = validator.isNumberPlate("ÆØÅ");
            //assert
            assertEquals(expected,actual);
        }
        @Test
        void isNumberplateMixed(){
            //arrange
            boolean expected = false;
            //act
            boolean actual = validator.isNumberPlate("Æa+!");
            //assert
            assertEquals(expected,actual);
        }
        @Test
        void isNumberplateNull(){
            //arrange
            boolean expected = false;
            //act
            boolean actual = validator.isNumberPlate("");
            //assert
            assertEquals(expected,actual);
        }
        @Test
        void isNumberplateDoubleBig() {
            //arrange
            boolean expected = true;
            //act
            boolean actual = validator.isNumberPlate("AA");
            //assert
            assertEquals(expected, actual);
        }
    @Test
    void isNumberplateDoubleSmall() {
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isNumberPlate("aa");
        //assert
        assertEquals(expected, actual);
    }
    //Test phonenumber Natali

    //Test DriversLicence Pelle

    //Test Integer Cecilie

    //Test Price Frederic
    @Test
    void isPriceThree() {
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isPrice("3");
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void isPriceSpecial(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPrice("!?<");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isPriceABC(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPrice("ABC");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isPriceabc(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPrice("abc");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isPriceDanishSmall(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPrice("øæå");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isPriceDanishBig(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPrice("ÆØÅ");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isPriceMixed(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPrice("3Æa+!");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isPriceZero(){
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isPrice("0");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isPriceNull(){
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPrice("");
        //assert
        assertEquals(expected,actual);
    }
    @Test
    void isPriceDoubleBig() {
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPrice("AA");
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void isPriceDoubleSmall() {
        //arrange
        boolean expected = false;
        //act
        boolean actual = validator.isPrice("aa");
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void isPriceComma() {
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isPrice("7,5");
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void isPriceDot() {
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isPrice("7.5");
        //assert
        assertEquals(expected, actual);
    }
    @Test
    void isPriceCommaDot() {
        //arrange
        boolean expected = true;
        //act
        boolean actual = validator.isPrice(",.");
        //assert
        assertEquals(expected, actual);
    }
}
