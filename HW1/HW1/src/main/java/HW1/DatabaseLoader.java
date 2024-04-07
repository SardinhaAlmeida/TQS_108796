package HW1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseLoader(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        // Execute SQL statements to populate the database
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (21, 'São Pedro do Sul', 'Aveiro', '2024-04-09', '08:00', '09:20', 7, 30)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (23, 'São Pedro do Sul', 'Aveiro', '2024-04-09', '13:45', '16:20', 7, 20)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (22, 'São Pedro do Sul', 'Aveiro', '2024-04-09', '17:00', '18:20', 7, 5)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (24, 'São Pedro do Sul', 'Aveiro', '2024-04-12', '20:00', '21:20', 7, 18)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (16, 'Aveiro', 'São Pedro do Sul', '2024-04-09', '13:45', '15:00', 7, 29)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (17, 'Aveiro', 'São Pedro do Sul', '2024-04-09', '17:00', '18:20', 7, 9)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (18, 'Aveiro', 'São Pedro do Sul', '2024-04-09', '21:15', '22:30', 7, 32)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (76, 'Aveiro', 'Porto', '2024-04-09', '21:00', '22:45', 8, 12)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (42, 'Lisboa', 'Aveiro', '2024-04-09', '14:30', '17:00', 13, 5)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (77, 'Lisboa', 'Porto', '2024-04-09', '18:30', '22:45', 18, 10)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (78, 'Aveiro', 'Porto', '2024-04-08', '21:00', '22:45', 8, 12)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (40, 'Lisboa', 'Aveiro', '2024-04-08', '14:30', '17:00', 13, 5)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (72, 'Lisboa', 'Porto', '2024-04-08', '18:30', '22:45', 18, 10)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (71, 'Aveiro', 'Porto', '2024-04-11', '21:00', '22:45', 8, 12)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (44, 'Lisboa', 'Aveiro', '2024-04-11', '14:30', '17:00', 13, 5)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (75, 'Lisboa', 'Porto', '2024-04-11', '18:30', '22:45', 18, 10)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (70, 'Aveiro', 'Porto', '2024-04-12', '21:00', '22:45', 8, 12)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (41, 'Lisboa', 'Aveiro', '2024-04-12', '14:30', '17:00', 13, 5)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (79, 'Lisboa', 'Porto', '2024-04-12', '18:30', '22:45', 18, 10)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (07, 'Aveiro', 'Viseu', '2024-04-11', '21:00', '22:45', 7, 15)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (10, 'Lisboa', 'Castelo Branco', '2024-04-11', '13:30', '16:00', 11, 13)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (01, 'Braga', 'Porto', '2024-04-11', '18:30', '20:00', 14, 20)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (08, 'Aveiro', 'Viseu', '2024-04-12', '21:00', '22:45', 7, 34)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (09, 'Lisboa', 'Castelo Branco', '2024-04-12', '13:30', '16:00', 11, 24)");
        jdbcTemplate.execute("INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity) VALUES (02, 'Braga', 'Porto', '2024-04-12', '18:30', '20:00', 14, 26)");
        // Add more SQL statements as neede_time
    }
}