package com.numble.banking.controller;

import com.numble.banking.dto.BankAccountDto;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.service.BankAccountService;
import com.numble.banking.service.NumbleAlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping("/")
    public List<BankAccountDto> getMyAccounts(@RequestBody ClientDto clientDto) {
        return bankAccountService.getMyAccounts(clientDto);
    }

    @GetMapping("/transferTo")
    public ResponseEntity<BankAccountDto> getBankAccountToSend(@RequestBody BankAccountDto bankAccountDto) {
        BankAccountDto accountDto = bankAccountService.getBankAccountToSend(bankAccountDto);
        if (accountDto != null)
            return ResponseEntity.ok(accountDto);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping("/sendMoney")
    public void sendMoney(@RequestBody ClientDto clientDto, BankAccountDto myBankAccount, BankAccountDto friendBankAccount, Long amount) throws Exception {
        try {
            bankAccountService.sendMoney(clientDto, myBankAccount, friendBankAccount, amount);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
