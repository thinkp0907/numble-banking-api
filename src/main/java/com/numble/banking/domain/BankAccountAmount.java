package com.numble.banking.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Entity(name = "BANK_ACCOUNT_AMOUNT")
public class BankAccountAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountId", unique = true, nullable = false)
    private Long accountId;

    @Setter
    @Column(name = "account_Number", nullable = false)
    private String accountNumber;

    @Column(name = "amount")
    private Long amount;

    @CreatedDate
    @Column(name = "created_At")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "updated_At")
    private LocalDateTime updatedAt;

    public BankAccountAmount(Long accountId, String accountNumber, Long amount) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public static BankAccountAmount of(Long accountId, String accountNumber, Long amount) {
        return new BankAccountAmount(accountId, accountNumber, amount);
    }
}
