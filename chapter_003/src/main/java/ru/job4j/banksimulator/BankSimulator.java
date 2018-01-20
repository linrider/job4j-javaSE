package ru.job4j.banksimulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankSimulator {
    public Map<Client, List<Account>> clientListMap = new HashMap<>();


    public void addClient(Client client) {
        if (!clientListMap.containsKey(client)) {
            clientListMap.put(client, new ArrayList<>());
        }
    }

    public void deleteClient(Client client) {
        if (clientListMap.containsKey(client)) {
            clientListMap.remove(client);
        }
    }

    public void addAccountToClient(String passport, Account account) {
        for (Map.Entry<Client, List<Account>> entry : clientListMap.entrySet()) {
            Client client = entry.getKey();
            if (client.getPassport().equals(passport)) {
                List<Account> accountList = clientListMap.get(client);
                accountList.add(account);
                clientListMap.replace(client, accountList);
                break;
            }
        }

    }

    public void deleteAccountFromClient(String passport, Account account) {
        for (Map.Entry<Client, List<Account>> entry : clientListMap.entrySet()) {
            Client client = entry.getKey();
            if (client.getPassport().equals(passport)) {
                List<Account> accountList = clientListMap.get(client);
                accountList.remove(account);
                clientListMap.replace(client, accountList);
                break;
            }
        }
    }

    public List<Account> getUserAccounts (String passport) {
        Client client = null;
        for (Map.Entry<Client, List<Account>> entry : clientListMap.entrySet()) {
            client = entry.getKey();
            if (client.getPassport().equals(passport)) {
                break;
            }
        }
        return clientListMap.get(client);

    }

    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean successed = false;
        Client srcClient = null;
        Client destClient = null;
        for (Map.Entry<Client, List<Account>> entry : clientListMap.entrySet()) {
            if (srcPassport.equals(entry.getKey().getPassport())) {
                srcClient = entry.getKey();
            } else if (destPassport.equals(entry.getKey().getPassport())) {
                destClient = entry.getKey();
        }

        if (clientListMap.get(srcClient).get()
        return successed;
    }
}
