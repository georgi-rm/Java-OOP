package person;

import exceptions.InvalidPersonNameException;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    public void setName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("The first name cannot be null or empty");
        }

        for (int i = 0; i < name.length(); i++) {
            if ( !Character.isAlphabetic(name.charAt(i))) {
                throw new InvalidPersonNameException("Name contains invalid symbols");
            }
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (StringUtils.isNullOrEmpty(email)) {
            throw new IllegalArgumentException("The last name cannot be null or empty");
        }
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
