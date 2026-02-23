package Iterator;

/**
 * Represents a course with a collection of assignments
 */
public class Course {
    private Assignment[] assignments;
    private int count;
    private String name;
    private String title;

    /**
     * Creates a new Course
     * 
     * @param name The course code (e.g., "CSCE 247")
     * @param title The course title (e.g., "Software Engineering")
     */
    public Course(String name, String title) {
        this.name = name;
        this.title = title;
        this.assignments = new Assignment[10]; // Start with capacity of 10
        this.count = 0;
    }

    /**
     * Adds a new assignment to the course
     * 
     * @param title The title of the assignment
     * @param description The description of the assignment
     * @param topic The topic category of the assignment
     */
    public void addAssignment(String title, String description, Topic topic) {
        // Check if we need to grow the array
        if (count >= assignments.length) {
            assignments = growArray(assignments);
        }
        
        // Add the new assignment
        assignments[count] = new Assignment(title, description, topic);
        count++;
    }

    /**
     * Creates an iterator for assignments filtered by topic
     * 
     * @param topic The topic to filter by (use Topic.ALL for all assignments)
     * @return An AssignmentIterator for the specified topic
     */
    public Assignmentiterator createIterator(Topic topic) {
        return new Assignmentiterator(assignments, topic);
    }

    /**
     * Returns a string representation of the course
     * 
     * @return The course name and title
     */
    @Override
    public String toString() {
        return name + ": " + title;
    }

    /**
     * Doubles the size of the assignments array when it's full
     * 
     * @param first The original array to grow
     * @return A new array with double the capacity containing all elements
     */
    private Assignment[] growArray(Assignment[] first) {
        Assignment[] newArray = new Assignment[first.length * 2];
        
        // Copy all elements from the old array to the new one
        for (int i = 0; i < first.length; i++) {
            newArray[i] = first[i];
        }
        
        return newArray;
    }
}
