import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entities.RegistrationInfo;
import org.junit.platform.commons.util.StringUtils;
import utis.DataGenerator;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;

public class TestFaker {
    private  static Faker faker;

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }
    @BeforeAll void setUpAll() {faker = new Faker(new Locale("ru"));}

    @Test void generateTest () {
        String city = faker.address().city();
        String date = faker.backToTheFuture().date();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
       //String cardNumber = faker.finance().creditCard(CreditCardType.MASTERCARD);
        System.out.println(name);
        System.out.println(phone);
        System.out.println(date);
        System.out.println(city);
        //System.out.println(cardNumber);
    }
    @Test void generateTestUtils(){
        RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");
        printTestData(info);
    }
    private  void printTestData (String city, String date, String fullName, String phoneNumber){
        System.out.println(StringUtils.replaceWhitespaceCharacters( "=", String.valueOf(30)));
        System.out.println(city + "\n" + date + "\n" + fullName + "\n" + phoneNumber);
        System.out.println(StringUtils.replaceWhitespaceCharacters("=", String.valueOf(30)));
    }
    private void printTestData(entities.RegistrationInfo registrationInfo){
        printTestData(registrationInfo.getCity(),registrationInfo.getDate(),registrationInfo.getFullName(),registrationInfo.getPhoneNumber());
    }
}
