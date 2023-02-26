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

    private final NumbleAlarmService numbleAlarmService;


    @GetMapping("/{clientId}")
    public List<BankAccountDto> getMyAccounts(@RequestBody ClientDto clientDto) {
        return bankAccountService.getMyAccounts(clientDto);
    }

    @GetMapping("/{clientId}/transferTo")
    public ResponseEntity<BankAccountDto> getBankAccountToSend(@RequestBody BankAccountDto bankAccountDto) {
        BankAccountDto accountDto = bankAccountService.getBankAccountToSend(bankAccountDto);
        if (accountDto != null)
            return ResponseEntity.ok(accountDto);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping("/sendMoney")
    public ResponseEntity<String> sendMoney(@RequestBody ClientDto clientDto, BankAccountDto myBankAccount, BankAccountDto friendBankAccount, Long amount) {
        boolean isSuccess = bankAccountService.sendMoney(clientDto, myBankAccount, friendBankAccount, amount);

        if(isSuccess) {
            numbleAlarmService.notify(clientDto, "이체가 정상적으로 완료되었습니다.");
            return ResponseEntity.ok("이체가 정상적으로 완료되었습니다.");
        } else {
            numbleAlarmService.notify(clientDto, "이체에 실패하였습니다.");
        }
        return ResponseEntity.internalServerError().build();

    }

}
