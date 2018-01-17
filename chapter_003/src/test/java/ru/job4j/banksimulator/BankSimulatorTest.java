package ru.job4j.banksimulator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankSimulatorTest {

    @Test
    public void whenCreateNewClientThenControlKeyExistence() {
        Client client = new Client("John Smith", "HB2785009");
        BankSimulator bankSimulator = new BankSimulator();
        bankSimulator.addClient(client);
        assertThat(bankSimulator.clientListMap.containsKey(client), is(true));
    }

    @Test
    public void whenCreateNewClientAndDeleteHimThenControlKeyExistence() {
        Client client = new Client("John Smith", "HB2785009");
        BankSimulator bankSimulator = new BankSimulator();
        bankSimulator.addClient(client);
        bankSimulator.deleteClient(client);
        assertThat(bankSimulator.clientListMap.containsKey(client), is(false));
    }

    @Test
    public void whenCreateAccountThenControlHisExistence() {
        Client client = new Client("John Smith", "HB2785009");
        Account account = new Account(1000000, "958678938946875687");
        BankSimulator bankSimulator = new BankSimulator();
        bankSimulator.addClient(client);
        bankSimulator.addAccountToClient(client.getPassport(), account);
        assertThat(bankSimulator.clientListMap.get(client).toString(), is("[Account{value=1000000.0, requisites='958678938946875687'}]"));
    }

    @Test
    public void whenCreateAccountThenDeleteItAndThenControlHisExistence() {
        Client client = new Client("John Smith", "HB2785009");
        Account account = new Account(1000000, "958678938946875687");
        BankSimulator bankSimulator = new BankSimulator();
        bankSimulator.addClient(client);
        bankSimulator.addAccountToClient(client.getPassport(), account);
        bankSimulator.deleteAccountFromClient(client.getPassport(), account);
        assertThat(bankSimulator.clientListMap.get(client).isEmpty(), is(true));
    }

    @Test
    public void whenCreateTwoAccountsThenControltheirExistence() {
        Client client = new Client("John Smith", "HB2785009");
        Account firstAccount = new Account(1000000, "958678938946875687");
        Account secondAccount = new Account(2000000, "7983459845879H889N787");
        BankSimulator bankSimulator = new BankSimulator();
        bankSimulator.addClient(client);
        bankSimulator.addAccountToClient(client.getPassport(), firstAccount);
        bankSimulator.addAccountToClient(client.getPassport(), secondAccount);
        String result = bankSimulator.getUserAccounts(client.getPassport()).toString();
        String expected = "[Account{value=1000000.0, requisites='958678938946875687'}, Account{value=2000000.0, requisites='7983459845879H889N787'}]";
        assertThat(result, is(expected));
    }
}
