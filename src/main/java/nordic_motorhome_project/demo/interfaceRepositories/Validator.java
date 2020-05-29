package nordic_motorhome_project.demo.interfaceRepositories;

public class Validator {

    public boolean isName(String s){
        boolean result = s.matches("[a-zA-ZæøåÆØÅ]+");
        return result;
    }
    public boolean isNumberPlate(String s){
        boolean result = s.matches("[A-Z0-9]{1,7}");
        return result;
    }
    public boolean isPhoneNumber(String s){
        boolean result = s.matches("[0-9]{8,8}");
        return result;
    }
    public boolean isDriversLicence(String s){
        boolean result = s.matches("[0-9]{8,8}");
        return result;
    }
    public boolean isInteger(String s){
        boolean result = s.matches("[0-9]+");
        return result;
    }
    public boolean isPrice(String s){
        boolean result = s.matches("[0-9.,]+");
        return result;
    }
}
