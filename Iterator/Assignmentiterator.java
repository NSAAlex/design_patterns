package Iterator;

import java.util.Iterator;

/**
 * Iterator for looping through assignments filtered by topic
 */
public class Assignmentiterator implements Iterator<Assignment> {
    private Assignment[] assignments;
    private int position;
    private Topic topic;

    /**
     * Creates a new AssignmentIterator
     * 
     * @param assignments The array of all assignments
     * @param topic The topic to filter by (use Topic.ALL for no filter)
     */
    public Assignmentiterator(Assignment[] assignments, Topic topic) {
        this.assignments = assignments;
        this.topic = topic;
        this.position = 0;
    }

    /**
     * Checks if there are more assignments to iterate through
     * 
     * @return true if there are more assignments matching the topic
     */
    @Override
    public boolean hasNext() {
        // Find the next assignment that matches the topic
        while (position < assignments.length) {
            if (assignments[position] != null && assignments[position].hasTopic(topic)) {
                return true;
            }
            position++;
        }
        return false;
    }

    /**
     * Returns the next assignment that matches the topic
     * 
     * @return The next Assignment, or null if no more assignments
     */
    @Override
    public Assignment next() {
        if (hasNext()) {
            Assignment assignment = assignments[position];
            position++;
            return assignment;
        }
        return null;
    }
}
