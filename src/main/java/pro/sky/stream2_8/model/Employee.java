package pro.sky.stream2_8.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    @JsonProperty("firstname")
    private final String name;

    @JsonProperty("lastname")
    private final String surname;


    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return name.equals(employee.name) && surname.equals(employee.surname);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format(
                "ФИО: %s %s",

                surname,
                name
        );
    }
}
