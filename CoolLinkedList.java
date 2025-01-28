public class CoolLinkedList{
    private static class Node 
    {
        String payload; // Data stored in this node
        Node nextNode;  // Reference to the next node in the list

        // Constructor to initialize the payload and set the nextNode to null
        Node(String payload) 
        {
            this.payload = payload;
            this.nextNode = null; // Initially, the next node is null
        }
    }

    private Node head; // Points to the first node in the linked list
    private int sizeOfList; // Tracks the size of the linked list

    // Constructor to initialize an empty linked list
    public CoolLinkedList() 
    {
        this.head = null; // Initially, the list has no nodes
        this.sizeOfList = 0; // Size is 0 for an empty list
    }

    // Method to return the size of the linked list
    public int size() 
    {
        return sizeOfList;
    }

    // Method to add a node to the front of the linked list
    public void addToFront(String value) 
    {
        Node newNode = new Node(value); // Create a new node with the given value
        newNode.nextNode = head; // Link the new node to the current head of the list
        head = newNode; // Update the head to point to the new node
        sizeOfList++; // Increment the size of the list
    }

    // Method to add a node to the end of the linked list
    public void addToEnd(String value) 
    {
        Node newNode = new Node(value); // Create a new node with the given value

        // If the list is empty, the new node becomes the head
        if (head == null) {
            head = newNode;
        } 
        else {
            Node current = head; // Start at the head of the list
            // Move through the list node by node until reaching the end
            while (current.nextNode != null) 
            {
                current = current.nextNode;
            }
            // Link the last node to the new node
            current.nextNode = newNode;
        }
        sizeOfList++; // Increment the size of the list
    }

    // Method to get the value (payload) at a specific index
    public String getIndex(int index) 
    {
        // Return null if the index is invalid
        if (index < 0 || index >= sizeOfList) 
        {
            return null;
        }

        Node current = head; // Start at the head of the list

        // Navigate to the specified index in the list
        for (int i = 0; i < index; i++) {
            current = current.nextNode;
        }

        return current.payload; // Return the payload at the specified index
    }

    // Override the toString() method to provide a string representation of the list
    @Override
    public String toString() 
    {
        StringBuilder result = new StringBuilder(); // StringBuilder for efficient string concatenation
        Node current = head; // Start at the head of the list

        // Traverse the list and append each node's payload to the result
        while (current != null) 
        {
            result.append(current.payload); // Add the payload of the current node

            if (current.nextNode != null) 
            { // Add an arrow to separate nodes
                result.append("->");
            }

            current = current.nextNode; // Move to the next node
        }

        return result.toString(); // Return the final string representation
    }

    // Main method to test the CoolLinkedList functionality
    public static void main(String[] args) {
        CoolLinkedList list = new CoolLinkedList(); // Create a new linked list

        // Add nodes to the list
        list.addToFront("C");
        list.addToEnd("A");   
        list.addToFront("B"); 
        list.addToEnd("D");   

        System.out.println("Linked List: " + list); 

        System.out.println("Size of the list: " + list.size()); 

        System.out.println("Value at index 1: " + list.getIndex(3)); 
    }
    
}
