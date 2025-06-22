class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String toString() {
        return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskList {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void displayTasks() {
        Node current = head;
        if (current == null) {
            System.out.println("Task list is empty.");
            return;
        }
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) return;

        if (head.task.taskId == taskId) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.task.taskId != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        taskList.addTask(new Task(101, "Design Frontend", "Pending"));
        taskList.addTask(new Task(102, "Write Backend", "In Progress"));
        taskList.addTask(new Task(103, "Testing", "Pending"));

        System.out.println("\nAll Tasks:");
        taskList.displayTasks();

        System.out.println("\nSearching for Task with ID 102:");
        Task t = taskList.searchTask(102);
        if (t != null) System.out.println(t);
        else System.out.println("Task not found");

        System.out.println("\nDeleting Task with ID 101");
        taskList.deleteTask(101);

        System.out.println("\nUpdated Task List:");
        taskList.displayTasks();
    }
}
