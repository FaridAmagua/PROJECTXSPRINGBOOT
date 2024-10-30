package proyectox.proyectoxcorp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private LocalDateTime createdAt; // Este campo debe coincidir con el constructor

    // Constructor adicional para facilitar la creación de objetos sin ID
    public Contact(String name, String email, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }
}
