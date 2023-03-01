package com.numble.banking.service;

import com.numble.banking.dto.BankAccountDto;
import com.numble.banking.exception.ErrorCode;
import com.numble.banking.handler.GlobalExceptionHandler;
import com.numble.banking.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;

import java.sql.SQLException;

@RequiredArgsConstructor
@Transactional
@Service
public class TransferService {

    private final Logger logger = LoggerFactory.getLogger(TransferService.class);

    private final BankAccountRepository bankAccountRepository;

    @Transactional
    public boolean makeTransfer(BankAccountDto myAccount, BankAccountDto friendAccount, Long transferAmount) throws Exception {
        boolean isTransferDone = false;
        try {
        String clientId = myAccount.clientId();
        String bankDiv = myAccount.bankDiv();

        // TODO : try ~ catch Global Exception 생성해보자.

        BankAccountDto senderUpdateDto = BankAccountDto.of(
                myAccount.accountId(),
                clientId,
                bankDiv,
                myAccount.bankName(),
                myAccount.accountNumber(),
                myAccount.amount() - transferAmount
        );


        BankAccountDto receiverUpdateDto = BankAccountDto.of(
                friendAccount.accountId(),
                friendAccount.clientId(),
                friendAccount.bankDiv(),
                friendAccount.bankName(),
                friendAccount.accountNumber(),
                friendAccount.amount() + transferAmount
        );


            bankAccountRepository.save(BankAccountDto.toEntity(receiverUpdateDto));

            bankAccountRepository.save(BankAccountDto.toEntity(senderUpdateDto));
            isTransferDone = true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }



        return isTransferDone;

    }
}
