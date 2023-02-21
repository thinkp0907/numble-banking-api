package com.numble.banking.domain;

import com.numble.banking.common.BaseTimeEntity;
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
