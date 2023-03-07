import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.javaqamvn.generics.data.Tickets;
import ru.netology.javaqa.javaqamvn.generics.manager.TicketsManagerSearch;
import ru.netology.javaqa.javaqamvn.generics.repository.TicketsRepository;

public class TicketsManagerTest {
    TicketsRepository repo = new TicketsRepository();
    TicketsManagerSearch manager = new TicketsManagerSearch(repo);

    Tickets ticket1 = new Tickets(33, 46, "BGY", "FCO", 65);
    Tickets ticket2 = new Tickets(28, 44, "VCE", "EVN", 235);
    Tickets ticket3 = new Tickets(41, 54, "VCE", "EVN", 470);
    Tickets ticket4 = new Tickets(67, 61, "LIS", "HOR", 165);
    Tickets ticket5 = new Tickets(02, 67, "VCE", "EVN", 655);
    Tickets ticket6 = new Tickets(21, 60, "IST", "VCE", 160);
    Tickets ticket7 = new Tickets(14, 67, "LIS", "HOR", 165);
    Tickets ticket8 = new Tickets(11, 48, "BGY", "FCO", 65);

    @Test
    public void shouldNotFindTicketsFromToRequestInEmptyRepo() {
        Tickets[] expected = new Tickets[]{ };
        Tickets[] actual = manager.findAll("IST", "VCE");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTicketsFromToRequest() {
        manager.save(ticket2);
        manager.save(ticket3);

        Tickets[] expected = new Tickets[]{ticket2, ticket3};
        Tickets[] actual = manager.findAll("VCE", "EVN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralTicketsFromToRequest() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        manager.save(ticket6);
        manager.save(ticket7);
        manager.save(ticket8);

        Tickets[] expected = new Tickets[]{ticket2, ticket3, ticket5};
        Tickets[] actual = manager.findAll("VCE", "EVN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindNonexistentTicketsFromToRequest() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        manager.save(ticket6);
        manager.save(ticket7);
        manager.save(ticket8);

        Tickets[] expected = new Tickets[]{ };

        Tickets[] actual = manager.findAll("IST", "YUL");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTicketFromToRequest() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        manager.save(ticket6);
        manager.save(ticket7);
        manager.save(ticket8);

        Tickets[] expected = new Tickets[]{ticket6};

        Tickets[] actual = manager.findAll("IST", "VCE");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTwoTicketsFromToRequestRepoMoreThanTwo() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        manager.save(ticket6);
        manager.save(ticket7);
        manager.save(ticket8);

        Tickets[] expected = new Tickets[]{ticket4, ticket7};

        Tickets[] actual = manager.findAll("LIS", "HOR");

        Assertions.assertArrayEquals(expected, actual);
    }
}
