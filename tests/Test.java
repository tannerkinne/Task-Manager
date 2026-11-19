import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private final LocalDate d1 = LocalDate.of(2026, 1, 1);
    private final LocalDate d2 = LocalDate.of(2026, 6, 15);

    @Test
    void gettersReturnConstructorValues() {
        Task t = new Task("Homework", d1, "Chapter 5");
        assertEquals("Homework", t.getName());
        assertEquals(d1, t.getDateTime());
        assertEquals("Chapter 5", t.getNotes());
    }

    @Test
    void toStringIsCsvFormat() {
        Task t = new Task("Homework", d1, "Chapter 5");
        assertEquals("Homework,2026-01-01,Chapter 5", t.toString());
    }

    @Test
    void equalsTrueForSameNameAndDate() {
        Task a = new Task("Homework", d1, "notes A");
        Task b = new Task("Homework", d1, "notes B"); // notes are ignored by equals
        assertEquals(a, b);
    }

    @Test
    void equalsFalseForDifferentNameOrDate() {
        Task a = new Task("Homework", d1, "x");
        assertNotEquals(a, new Task("Laundry", d1, "x"));
        assertNotEquals(a, new Task("Homework", d2, "x"));
    }

    @Test
    void equalsFalseForNonTask() {
        assertNotEquals(new Task("Homework", d1, "x"), "Homework");
        assertNotEquals(new Task("Homework", d1, "x"), null);
    }

    @Test
    void compareToOrdersByDate() {
        Task early = new Task("A", d1, "");
        Task late = new Task("B", d2, "");
        assertTrue(early.compareTo(late) < 0);
        assertTrue(late.compareTo(early) > 0);
        assertEquals(0, early.compareTo(new Task("C", d1, "")));
    }
}



class TaskListTest {
    private TaskList list;

    private final Task early  = new Task("Early",  LocalDate.of(2026, 1, 1),  "first");
    private final Task middle = new Task("Middle", LocalDate.of(2026, 6, 1),  "second");
    private final Task late   = new Task("Late",   LocalDate.of(2026, 12, 1), "third");

    @BeforeEach
    void setUp() {
        list = new TaskList();
        list.tasks.clear(); //ignore anything loaded from an old list.csv
    }

    @Test
    void addToEmptyListAddsTask() {
        list.add(early);
        assertEquals(List.of(early), list.tasks);
    }

    @Test
    void addKeepsTasksSortedByDate() {
        list.add(late);
        list.add(early);
        list.add(middle);
        assertEquals(List.of(early, middle, late), list.tasks);
    }

    @Test
    void addEarliestGoesToFront() {
        list.add(middle);
        list.add(late);
        list.add(early);
        assertSame(early, list.tasks.get(0));
    }

    @Test
    void addLatestGoesToEnd() {
        list.add(early);
        list.add(middle);
        list.add(late);
        assertSame(late, list.tasks.get(2));
    }

    @Test
    void addSameDateGoesAfterExistingTask() {
        Task a = new Task("A", LocalDate.of(2026, 3, 1), "");
        Task b = new Task("B", LocalDate.of(2026, 3, 1), "");
        list.add(a);
        list.add(b);
        assertSame(a, list.tasks.get(0));
        assertSame(b, list.tasks.get(1));
    }

    @Test
    void deleteRemovesTask() {
        list.add(early);
        list.add(middle);
        list.delete(early);
        assertEquals(List.of(middle), list.tasks);
    }

    @Test
    void deleteUsesEqualsNotIdentity() {
        list.add(early);
        list.delete(new Task("Early", early.getDateTime(), "different notes"));
        assertTrue(list.tasks.isEmpty());
    }

    @Test
    void deleteMissingTaskLeavesListUnchanged() {
        list.add(early);
        list.delete(late);
        assertEquals(List.of(early), list.tasks);
    }


}