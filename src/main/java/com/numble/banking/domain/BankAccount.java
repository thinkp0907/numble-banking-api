package com.numble.banking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

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
    @Column(name = "bankDiv", nullable = false)
    private String bankDiv;

    @Setter
    @Column(name = "bankName", nullable = false)
    private String bankName;

    @Setter
    @Column(name = "accountNumber", nullable = false)
    private String accountNumber;

    @CreatedDate
    @Column(name = "createdAt")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    public BankAccount(String clientId, String bankDiv, String bankName, String accountNumber) {
        this.clientId = clientId;
        this.bankDiv = bankDiv;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    public BankAccount() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount that)) return false;
        return accountId == that.accountId && clientId.equals(that.clientId) && bankDiv.equals(that.bankDiv) && bankName.equals(that.bankName) && accountNumber.equals(that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, clientId, bankDiv, bankName, accountNumber);
    }
}
