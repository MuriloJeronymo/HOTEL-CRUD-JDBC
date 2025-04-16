package Model;

import java.time.LocalDate;

public class Client {
    private String CPF;
    private String name;
    private LocalDate birthDate;
    private String email;

    public Client(String CPF, String name, LocalDate birthDate,String email) {
        this.CPF = CPF;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "CPF='" + CPF + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
