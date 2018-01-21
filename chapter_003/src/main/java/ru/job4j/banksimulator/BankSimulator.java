package ru.job4j.banksimulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * BankSimulator.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 20.01.18
 */
public class BankSimulator {
    public Map<Client, List<Account>> clientListMap = new HashMap<>();


    /**
     * addClient.
     * @param client - Client.
     */
    public void addClient(Client client) {
        if (!clientListMap.containsKey(client)) {
            clientListMap.put(client, new ArrayList<>());
        }
    }

    /**
     * deleteClient.
     * @param client - Client.
     */
    public void deleteClient(Client client) {
        if (clientListMap.containsKey(client) && clientListMap.get(client).isEmpty()) {
            clientListMap.remove(client);
        }
    }

    /**
     * addAccountToClient.
     * @param passport - String.
     * @param account - Account.
     */
    public void addAccountToClient(String passport, Account account) {
        for (Map.Entry<Client, List<Account>> entry : clientListMap.entrySet()) {
            Client client = entry.getKey();
            if (client.getPassport().equals(passport)) {
                clientListMap.get(client).add(account);
                break;
            }
        }

    }

    /**
     * deleteAccountFromClient.
     * @param passport - String.
     * @param account - Account.
     */
    public void deleteAccountFromClient(String passport, Account account) {
        for (Map.Entry<Client, List<Account>> entry : clientListMap.entrySet()) {
            Client client = entry.getKey();
            if (client.getPassport().equals(passport)) {
                clientListMap.get(client).remove(account);
                break;
            }
        }
    }

    /**
     * getUserAccounts.
     * @param passport - String.
     * @return List<Account>.
     */
    public List<Account> getUserAccounts(String passport) {
        Client client = null;
        for (Map.Entry<Client, List<Account>> entry : clientListMap.entrySet()) {
            client = entry.getKey();
            if (client.getPassport().equals(passport)) {
                break;
            }
        }
        return clientListMap.get(client);

    }

    /**
     * transferMoney.
     * @param srcPassport - String.
     * @param srcRequisite - String.
     * @param destPassport - String.
     * @param dstRequisite - String.
     * @param amount - double.
     * @return boolean.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean done = false;
        Client srcClient = null;
        for (Map.Entry<Client, List<Account>> entry : clientListMap.entrySet()) {
            if (entry.getKey().getPassport().equals(srcPassport)) {
                srcClient = entry.getKey();
            }
        }

        Client dstClient = null;
        for (Map.Entry<Client, List<Account>> entry : clientListMap.entrySet()) {
            if (entry.getKey().getPassport().equals(destPassport)) {
                dstClient = entry.getKey();
            }
        }


        for (Account account : clientListMap.get(srcClient)) {
            if (account.getRequisites().equals(srcRequisite)) {
                double newValue = 0;
                if (account.getValue() >= amount) {
                    done = true;
                    newValue = account.getValue() - amount;
                }
                account.setValue(newValue);
            }
        }

        for (Account account : clientListMap.get(dstClient)) {
            if (account.getRequisites().equals(dstRequisite)) {
                double newValue = account.getValue() + amount;
                account.setValue(newValue);
            }
        }
        return done;
    }
}
