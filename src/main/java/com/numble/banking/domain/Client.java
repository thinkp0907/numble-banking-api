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

@Entity(name = "client")
@Table(name = "CLIENT")
@Getter
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Setter
    @Column(unique = true, name = "clientId", length = 15, nullable = false)
    private String clientId;

    @Setter
    @Column(name = "clientName", length = 50)
    private String clientName;

    @Setter
    @Column(name = "clientPassword", length = 20, nullable = false)
    private String clientPassword;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    protected Client() {
    }

    public Client(String clientId, String clientName, String clientPassword) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientPassword = clientPassword;
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
