package ru.job4j.start;

/**
 * MenuTracker class.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 07.10.17
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    /**
     * MenuTracker constructor.
     * @param input - Input.
     * @param tracker - Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * select.
     * @param key - int.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * fillActions.
     */
    public void fillActions() {
        this.actions[0] = new AddItem(this.input, this.tracker);
        this.actions[1] = new ShowAllItems(this.input, this.tracker);
        this.actions[2] = new EditItem(this.input, this.tracker);
        this.actions[3] = new DeleteItem(this.input, this.tracker);
        this.actions[4] = new FindItemById(this.input, this.tracker);
        this.actions[5] = new FindItemByName(this.input, this.tracker);
        this.actions[6] = new Exit(this.input, this.tracker);
    }

    /**
     * showMenu.
     */
    public void showMenu() {
        this.fillActions();
        for (UserAction action : this.actions) {
            if (action != null) { System.out.println(action.info()); }
        }
        this.select(Integer.parseInt(input.ask("Enter an action: ")));
    }

    /**
     * AddItem internal class.
     */
    private class AddItem implements UserAction{
        private Input input;
        private Tracker tracker;

        /**
         * AddItem constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public AddItem(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }

        /**
         * key.
         * @return int.
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * execute.
         * @param input - Input.
         * @param tracker Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.add(new Item(input.ask("Enter your name: "), input.ask("Enter description: "), input.ask("Enter a date: "))).getId();
        }
        /**
         * info.
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add a new item: ");
        }
    }
    /**
     * ShowAllItems internal class.
     */
    private class ShowAllItems implements UserAction {
        private Input input;
        private Tracker tracker;
        /**
         * ShowAllItems constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public ShowAllItems(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }
        /**
         * key.
         * @return int.
         */
        @Override
        public int key() {
            return 1;
        }
        /**
         * execute.
         * @param input - Input.
         * @param tracker Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] allItems = tracker.findAll();
            if (allItems.length != 0) {
                for (Item item : allItems) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("List is empty.");
            }
        }
        /**
         * info.
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items: ");
        }
    }

    /**
     * EditItem internal class.
     */
    public  class EditItem implements UserAction {
        private Input input;
        private Tracker tracker;
        /**
         * EditItem constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public EditItem(Input input, Tracker tracker) {
          this.input = input;
          this.tracker = tracker;
        }
        /**
         * key.
         * @return int.
         */
        @Override
        public int key() {
            return 2;
        }
        /**
         * execute.
         * @param input - Input.
         * @param tracker Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.update(new Item(input.ask("Enter Id: "), input.ask("Enter new name: "),
                    input.ask("Enter new description: "), input.ask("Enter new date: ")));
        }
        /**
         * info.
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item: ");
        }
    }

    /**
     * DeleteItem internal class.
     */
    public class DeleteItem implements UserAction {
        private Input input;
        private Tracker tracker;
        /**
         * DeleteItem constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public DeleteItem(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }
        /**
         * key.
         * @return int.
         */
        @Override
        public int key() {
            return 3;
        }
        /**
         * execute.
         * @param input - Input.
         * @param tracker Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
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
         * info.
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item: ");
        }
    }

    /**
     * FindItemById internal class.
     */
    public class FindItemById implements UserAction {
        private Input input;
        private Tracker tracker;
        /**
         * FindItemById constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public FindItemById(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }
        /**
         * key.
         * @return int.
         */
        @Override
        public int key() {
            return 4;
        }
        /**
         * execute.
         * @param input - Input.
         * @param tracker Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Enter searching item's id: "));
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("Nothing was found.");
            }
        }
        /**
         * info.
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id: ");
        }
    }
    /**
     * FindItemByName internal class.
     */
    public class FindItemByName implements UserAction {
        private Input input;
        private Tracker tracker;
        /**
         * FindItemByName constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public FindItemByName(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }
        /**
         * key.
         * @return int.
         */
        @Override
        public int key() {
            return 5;
        }
        /**
         * execute.
         * @param input - Input.
         * @param tracker Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
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
         * info.
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name: ");
        }
    }

    /**
     * Exit internal class.
     */
    public class Exit implements UserAction {
        private Input input;
        private Tracker tracker;
        /**
         * Exit constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public Exit(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }
        /**
         * key.
         * @return int.
         */
        @Override
        public int key() {
            return 6;
        }
        /**
         * execute.
         * @param input - Input.
         * @param tracker Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.exit(0);
        }
        /**
         * info.
         * @return String.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program: ");
        }
    }
}
