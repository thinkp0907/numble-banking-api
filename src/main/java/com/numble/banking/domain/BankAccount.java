package com.numble.banking.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "bank_account")
@Getter
@ToString
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "accountId")
    private Long accountId;

    @Setter
    @Column(name = "clientId", nullable = false, unique = true)
    private String clientId;

    @Setter
    @Column(name = "bank_Div", nullable = false)
    private String bankDiv;

    @Setter
    @Column(name = "bank_Name", nullable = false)
    private String bankName;

    @Setter
    @Column(name = "account_Number", nullable = false)
    private String accountNumber;

    @CreatedDate
    @Column(name = "created_At")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "updated_At")
    private LocalDateTime updatedAt;

    public BankAccount(String clientId, String bankDiv, String bankName, String accountNumber) {
        this.clientId = clientId;
        this.bankDiv = bankDiv;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    public static BankAccount of(String clientId, String bankDiv, String bankName, String accountNumber) {
        return new BankAccount(clientId, bankDiv, bankName, accountNumber);
    }

}
