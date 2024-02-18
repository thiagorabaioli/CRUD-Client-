package tfr.CRUD.Client.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import tfr.CRUD.Client.entities.Client;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    @NotBlank(message = "campo não pode ser vazio")
    @Size(min =3, max = 80, message = "tamanho não é valido")
    private String name;
    @NotBlank(message = "campo não pode ser vazio")
    @Size(min =9, max = 9, message = "tamanho deve conter 9 número válido")
    private String cpf;
    private Double income;
    @PastOrPresent(message = "a data não pode ser futura")
    private LocalDate birthDate;

    private Integer children;

    public ClientDTO(){}

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client entity){
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
