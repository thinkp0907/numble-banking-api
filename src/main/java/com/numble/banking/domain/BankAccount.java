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
@Table(name = "bank_account")
@Getter
@ToString
public class BankAccount extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "account_Id")
    private Long accountId;

    @Setter
    @Column(name = "client_Id", nullable = false, unique = true)
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

    @Setter
    @Column(name = "amount", nullable = false)
    private Long amount;


    public BankAccount(String clientId, String bankDiv, String bankName, String accountNumber, Long amount) {
        this.clientId = clientId;
        this.bankDiv = bankDiv;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public BankAccount(Long accountId, String clientId, String bankDiv, String bankName, String accountNumber, Long amount) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.bankDiv = bankDiv;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public static BankAccount of(Long accountId, String clientId, String bankDiv, String bankName, String accountNumber, Long amount) {
        return new BankAccount(accountId, clientId, bankDiv, bankName, accountNumber, amount);
    }
    public static BankAccount of(String clientId, String bankDiv, String bankName, String accountNumber, Long amount) {
        return new BankAccount(clientId, bankDiv, bankName, accountNumber, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BankAccount that = (BankAccount) o;
        return accountId != null && Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
