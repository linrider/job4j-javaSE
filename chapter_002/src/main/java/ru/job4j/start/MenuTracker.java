package ru.job4j.start;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuTracker class.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 07.10.17
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private int[] range = {0, 1, 2, 3, 4, 5, 6};

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
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**"Enter an action: "
     * fillActions.
     */
    public void fillActions() {
        this.actions.add(new AddItem(this.input, this.tracker));
        this.actions.add(new ShowAllItems(this.input, this.tracker));
        this.actions.add(new EditItem(this.input, this.tracker));
        this.actions.add(new DeleteItem(this.input, this.tracker));
        this.actions.add(new FindItemById(this.input, this.tracker));
        this.actions.add(new FindItemByName(this.input, this.tracker));
        this.actions.add(new Exit(this.input, this.tracker));
    }

    /**
     * showMenu.
     */
    public void showMenu() {
        actions.forEach(action -> System.out.println(action.info()));
//        for (UserAction action : this.actions) {
//            if (action != null) {
//                System.out.println(action.info());
//            }
//        }
        this.select(input.ask(("Enter an action: "), range));
    }

    /**
     * AddItem internal class.
     */
    private class AddItem extends BaseAction {
        private Input input;
        private Tracker tracker;

        /**
         * AddItem constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public AddItem(Input input, Tracker tracker) {
            super(0, "Add a new item: ");
            this.input = input;
            this.tracker = tracker;
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
    }
    /**
     * ShowAllItems internal class.
     */
    private class ShowAllItems extends BaseAction {
        private Input input;
        private Tracker tracker;
        /**
         * ShowAllItems constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public ShowAllItems(Input input, Tracker tracker) {
            super(1, "Show all items: ");
            this.input = input;
            this.tracker = tracker;
        }
        /**
         * execute.
         * @param input - Input.
         * @param tracker Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> allItems = tracker.findAll();
            if (allItems.size() != 0) {
                for (Item item : allItems) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("List is empty.");
            }
        }
    }

    /**
     * EditItem internal class.
     */
    public  class EditItem extends BaseAction {
        private Input input;
        private Tracker tracker;
        /**
         * EditItem constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public EditItem(Input input, Tracker tracker) {
          super(2, "Edit item: ");
          this.input = input;
          this.tracker = tracker;
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
    }

    /**
     * DeleteItem internal class.
     */
    public class DeleteItem extends BaseAction {
        private Input input;
        private Tracker tracker;
        /**
         * DeleteItem constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public DeleteItem(Input input, Tracker tracker) {
            super(3, "Delete item: ");
            this.input = input;
            this.tracker = tracker;
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
    }

    /**
     * FindItemById internal class.
     */
    public class FindItemById extends BaseAction {
        private Input input;
        private Tracker tracker;
        /**
         * FindItemById constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public FindItemById(Input input, Tracker tracker) {
            super(4, "Find item by id: ");
            this.input = input;
            this.tracker = tracker;
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
    }
    /**
     * FindItemByName internal class.
     */
    public class FindItemByName extends BaseAction {
        private Input input;
        private Tracker tracker;
        /**
         * FindItemByName constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public FindItemByName(Input input, Tracker tracker) {
            super(5, "Find item by name: ");
            this.input = input;
            this.tracker = tracker;
        }
        /**
         * execute.
         * @param input - Input.
         * @param tracker Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> items = tracker.findByName(input.ask("Enter searching name: "));
            if (items.size() != 0) {
                for (Item item : items) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("Nothing was found.");
            }
        }
    }

    /**
     * Exit internal class.
     */
    public class Exit extends BaseAction {
        private Input input;
        private Tracker tracker;
        /**
         * Exit constructor.
         * @param input - Input.
         * @param tracker - Tracker.
         */
        public Exit(Input input, Tracker tracker) {
            super(6, "Exit Program: ");
            this.input = input;
            this.tracker = tracker;
        }
        /**
         * execute.
         * @param input - Input.
         * @param tracker Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            if (input.ask("Are you sure? (y/n): ").equals("y")) {
                System.exit(0);
            }
        }
    }
}
