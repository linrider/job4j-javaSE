package ru.job4j.start;

/**
 * StartUI.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 19.09.17
 */
public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DEL = "3";
    private static final String ID = "4";
    private static final String NAME = "5";
    private static final String EXIT = "6";

    /**
     * Main.
     * @param args - String[].
     */
    public static void main(String[] args) {
        StartUI startUI = new StartUI();
        ConsoleInput input = new ConsoleInput();
        String action;
        Tracker tracker = new Tracker();

        while (true) {
            startUI.showMenu();
            action = input.ask("Select: ");

            if (action.equals(ADD)) {
                startUI.addNewItem(tracker, input);
            } else if (action.equals(SHOW_ALL)) {
                startUI.showAllItems(tracker);
            } else if (action.equals(EDIT)) {
                startUI.editItem(tracker, input);
            } else if (action.equals(DEL)) {
                startUI.deleteItem(tracker, input);
            } else if (action.equals((ID))) {
                startUI.findItemById(tracker, input);
            } else if (action.equals(NAME)) {
                startUI.findItemsByName(tracker, input);
            } else if (action.equals((EXIT))) {
                break;
            } else {
                System.out.println("Invalid symbol. Try again.");
            }
        }
    }

    /**
     * showMenu.
     */
    private void showMenu() {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * addNewItem.
     * @param tracker - Tracker.
     * @param input   - ConsoleInput.
     */
    private void addNewItem(Tracker tracker, ConsoleInput input) {
        String id = tracker.add(new Item(input.ask("Enter your name: "), input.ask("Enter description: "),
                Long.parseLong(input.ask("Enter a date: ")))).getId();
        System.out.println("Your ID: " + id);
    }

    /**
     * editItem.
     * @param tracker - Tracker.
     * @param input   - ConsoleInput.
     */
    private void editItem(Tracker tracker, ConsoleInput input) {
        tracker.add(new Item(input.ask("Enter your name: "), input.ask("Enter description: "),
                Long.parseLong(input.ask("Enter a date: ")))).setId(input.ask("Enter item's Id: "));
    }

    /**
     * deleteItem.
     * @param tracker - Tracker.
     * @param input   - ConsoleInput.
     */
    private void deleteItem(Tracker tracker, ConsoleInput input) {
        String id = input.ask("Enter deleting item's Id: ");
        if (tracker.findById(id) != null) {
            Item item = tracker.findById(id);
            tracker.delete(item);
            System.out.println("Item was deleted.");
        } else {
            System.out.println("Nothing was found.");
        }
    }

    /**
     * findItemById.
     * @param tracker - Tracker.
     * @param input   - ConsoleInput.
     */
    private void findItemById(Tracker tracker, ConsoleInput input) {
        Item item = tracker.findById(input.ask("Enter searching item's Id: "));
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Nothing was found.");
        }
    }

    /**
     * findItemsByName.
     *
     * @param tracker - Tracker.
     * @param input   - ConsoleInput.
     */
    private void findItemsByName(Tracker tracker, ConsoleInput input) {
        Item[] items = tracker.findByName(input.ask("Enter searching name: "));
        if (items.length != 0) {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Nothing was found.");
        }
    }

    /**
     * showAllItems.
     * @param tracker - Tracker.
     */
    private void showAllItems(Tracker tracker) {
        Item[] allItems = tracker.findAll();
        if (allItems.length != 0) {
            for (Item item : allItems) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("List is empty.");
        }
    }
}
