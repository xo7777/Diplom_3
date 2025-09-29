import constants.DataTestGenerate;

public class Main {

    public static void main(String[] args) {
        DataTestGenerate dataTestGenerate = new DataTestGenerate();
        String email = dataTestGenerate.generateEmail();
        String password = dataTestGenerate.generatePassword();
        String name = dataTestGenerate.generateName();
        System.out.println(email);
        System.out.println(password);
        System.out.println(name);

    }
}
