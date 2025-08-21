package com.example.pubsub;

import com.example.pubsub.model.Team;
import com.example.pubsub.repository.TeamRepository;

import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ApiTest {

    @Test
    public void testCallToTeams() throws InterruptedException {
        TeamRepository repository = TeamRepository.getInstance();
        final List<Team> teams = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(1);

        repository.getAllTeams().observe(new MockContext(), t -> {
            teams.clear();
            teams.addAll(t);
            latch.countDown();
        });

        latch.await(5, TimeUnit.SECONDS);

        assertTrue("não veio objetos", teams != null && teams.size() > 0);

        teams.stream().map(Team::getName).forEach(System.out::println);
    }
}
