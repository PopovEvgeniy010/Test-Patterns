package utis;

import entities.RegistrationInfo;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

@UtilityClass
public class DataGenerator {
    // private DataGenerator(){}

    @UtilityClass
    public static class Registration {
        public static RegistrationInfo generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationInfo(faker.address().city(), faker.backToTheFuture().date(),
                    faker.name().fullName(), faker.phoneNumber().phoneNumber());
        }
    }

}
