package constants;

import java.util.Random;

public class DataTestGenerate {

    public String generateName() {
        Random random = new Random();
        String name = "Kukuruzina" + random.nextInt(99999);
        return name;
    }

    public String generateEmail() {
        Random random = new Random();
        String email = "Kukuruzina" + random.nextInt(99999) + "@ya.ru";
        return email;
    }

    public String generatePassword() {
        Random random = new Random();
        String email = "Kuku" + random.nextInt(999);
        return email;
    }
}
