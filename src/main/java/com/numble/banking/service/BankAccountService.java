package com.numble.banking.service;


import com.numble.banking.domain.BankAccount;
import com.numble.banking.dto.BankAccountDto;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.repository.BankAccountRepository;
import com.numble.banking.repository.FriendsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    private final TransferService transferService;

    private final FriendsRepository friendsRepository;


    public List<BankAccountDto> getMyAccounts(ClientDto clientDto) {
        List<BankAccount> bankAccountList = bankAccountRepository.findBankAccountsByClientId(clientDto.clientId());

        return bankAccountList.stream()
                .map(BankAccountDto::toDto)
                .toList();
    }

    public BankAccountDto getBankAccountToSend(BankAccountDto bankAccountDto) {
        BankAccount bankAccount = bankAccountRepository.findBankAccountByBankDivAndAccountNumber(bankAccountDto.bankDiv(), bankAccountDto.accountNumber());
        if(bankAccount != null)
            return BankAccountDto.toDto(bankAccount);
        else
            return null;
    }

    public boolean  sendMoney (ClientDto clientDto, BankAccountDto myAccount, BankAccountDto friendAccount, Long amount) {
        boolean isSuccess = false;
        boolean isFriend = false;
        boolean isEnoughMoney = false;

        // 1. 계좌 이체는 친구끼리만 가능합니다. - 친구인지 체크
        isFriend = friendsRepository.findFriendsByClientIdAndFriendClientId(clientDto.clientId(), friendAccount.clientId());

        // 2. 충분한 돈이 있는지 체크?
        BankAccount bankAccount = bankAccountRepository.findBankAccountByBankDivAndAccountNumber(myAccount.bankDiv(), myAccount.accountNumber());

        if(bankAccount.getAmount().compareTo(amount) > -1)
            isEnoughMoney = true;

        // 2. 보내주는 대상이 친구 이면서, 내가 충분한 돈을 가지고 있다면
        if(isFriend && isEnoughMoney) {

            isSuccess = transferService.makeTransfer(
                    myAccount,
                    friendAccount,
                    amount
            );
        }

        return isSuccess;
    }


}
