package ru.netology.javaqa.javaqamvn.generics.manager;

import ru.netology.javaqa.javaqamvn.generics.data.Tickets;
import ru.netology.javaqa.javaqamvn.generics.repository.TicketsRepository;
import java.util.Arrays;

public class TicketsManagerSearch {
    private TicketsRepository repo;

    public TicketsManagerSearch(TicketsRepository repo) {
        this.repo = repo;
    }

    public void save(Tickets items) {
        repo.save(items);
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public Tickets[] findAll(String departureAirport, String arrivalAirport) {
        Tickets[] amount = new Tickets[0];
        for (Tickets tickets : repo.findAll()) {
            if (matches(tickets, departureAirport, arrivalAirport)) {
                Tickets[] tmp = new Tickets[amount.length + 1];
                int result = 0;
                for (Tickets results : amount) {
                    tmp[result] = results;
                    result++;
                }
                tmp[amount.length] = tickets;
                amount = tmp;
            }
        }
        Arrays.sort(amount);
        return amount;
    }

    public boolean matches(Tickets ticket, String searchFrom, String searchTo) {
        if (ticket.matches(searchFrom, searchTo)) {
            return true;
        } else {
            return false;
        }
    }
}