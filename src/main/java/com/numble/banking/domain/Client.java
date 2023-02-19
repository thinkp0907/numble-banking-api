package com.numble.banking.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "CLIENT")
@Getter
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Setter
    @Column(unique = true, name = "client_Id", length = 15, nullable = false)
    private String clientId;

    @Setter
    @Column(name = "client_Name", length = 50)
    private String clientName;

    @Setter
    @Column(name = "client_Password", length = 20, nullable = false)
    private String clientPassword;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, name = "created_At")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_At")
    private LocalDateTime updatedAt;

    protected Client() {
    }

    protected Client(String clientId, String clientName, String clientPassword) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientPassword = clientPassword;
    }

    public static Client of(String clientId, String clientName, String clientPassword) {
        return new Client(clientId, clientName, clientPassword);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return id == client.id && clientId.equals(client.clientId) && clientName.equals(client.clientName) && clientPassword.equals(client.clientPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, clientName, clientPassword);
    }
}
