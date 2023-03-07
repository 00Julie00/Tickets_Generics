package ru.netology.javaqa.javaqamvn.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.javaqamvn.generics.data.Tickets;
import ru.netology.javaqa.javaqamvn.generics.exeptions.AlreadyExistsException;
import ru.netology.javaqa.javaqamvn.generics.exeptions.NotFoundException;
import ru.netology.javaqa.javaqamvn.generics.repository.TicketsRepository;

public class TicketsRepositoryTest {
    TicketsRepository repo = new TicketsRepository();

    Tickets ticket1 = new Tickets(33, 46, "BGY", "FCO", 65);
    Tickets ticket2 = new Tickets(28, 44, "VCE", "EVN", 235);
    Tickets ticket3 = new Tickets(41, 54, "VCE", "EVN", 470);
    Tickets ticket4 = new Tickets(67, 61, "LIS", "HOR", 165);
    Tickets ticket5 = new Tickets(02, 67, "VCE", "EVN", 655);
    Tickets ticket6 = new Tickets(21, 60, "IST", "VCE", 160);
    Tickets ticket7 = new Tickets(14, 67, "LIS", "HOR", 165);
    Tickets ticket8 = new Tickets(11, 48, "BGY", "FCO", 65);

    @BeforeEach
    void setup() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(67);

        Tickets[] expected = new Tickets[]{ticket1, ticket2, ticket3, ticket5, ticket6, ticket7,};
        Tickets[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByIdNonexistentTicket() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(13);
        });
    }

    @Test
    public void shouldAddNewTicket() {
        repo.save(ticket8);

        Tickets[] expected = new Tickets[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Tickets[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAddNewTicketWithExistentId() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(ticket3);
        });
    }

    @Test
    public void shouldFindAllTickets() {
        Tickets[] expected = new Tickets[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7,};
        Tickets[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}