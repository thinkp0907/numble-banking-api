package com.numble.banking.domain;

import com.numble.banking.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@NoArgsConstructor
@Entity
@Table(name = "CLIENT")
@Getter
@ToString
public class Client extends BaseTimeEntity {

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

    @Setter
    @Column(name = "email")
    private String clientEmail;


    protected Client(String clientId, String clientName, String clientPassword, String clientEmail) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientPassword = clientPassword;
        this.clientEmail = clientEmail;
    }

    public static Client of(String clientId, String clientName, String clientPassword, String clientEmail) {
        return new Client(clientId, clientName, clientPassword, clientEmail);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
