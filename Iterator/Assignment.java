package Iterator;

/**
 * Represents a single assignment with a title, description, and topic
 */
public class Assignment {
    private String title;
    private String description;
    private Topic topic;

    /**
     * Creates a new Assignment
     * 
     * @param title The title of the assignment
     * @param description The description of the assignment
     * @param topic The topic category of the assignment
     */
    public Assignment(String title, String description, Topic topic) {
        this.title = title;
        this.description = description;
        this.topic = topic;
    }

    /**
     * Checks if this assignment belongs to the given topic
     * 
     * @param topic The topic to check
     * @return true if the assignment has this topic or if topic is ALL
     */
    public boolean hasTopic(Topic topic) {
        if (topic == Topic.ALL) {
            return true;
        }
        return this.topic == topic;
    }

    /**
     * Returns a string representation of the assignment
     * 
     * @return A string with the title and description
     */
    @Override
    public String toString() {
        return title + " - " + description;
    }
}