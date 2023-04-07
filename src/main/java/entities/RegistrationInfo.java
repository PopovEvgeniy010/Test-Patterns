package entities;

import lombok.Data;

@Data
public class RegistrationInfo {
    private final String city;
    private final String date;

    private final String fullName;
    private final String phoneNumber;
}
