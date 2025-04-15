package Model;

import java.time.LocalDate;

public class Client {
    private String CPF;
    private String name;
    private LocalDate birthDate;

    public Client(String CPF, String name, LocalDate birthDate) {
        this.CPF = CPF;
        this.name = name;
        this.birthDate = birthDate;
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
                ", birthDate=" + birthDate +
                '}';
    }
}
