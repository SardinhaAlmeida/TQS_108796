import time
import mysql.connector

host = "db_mysql"
port = 3306
user = "user"
password = "password"
database = "homework1_db"
# Connect to MySQL
conn = None

while not conn:
    try:
        conn = mysql.connector.connect(
            host=host, port=port, user=user, password=password, database=database)
        print("Connected to MySQL.")

    except mysql.connector.Error as e:
        print("Error:", e)
        print("Retrying in 5 seconds.")
        time.sleep(5)

cursor = conn.cursor()

# Drop tables
drop_tables = [
    "DROP TABLE IF EXISTS reservation",
    "DROP TABLE IF EXISTS bus",
    "DROP TABLE IF EXISTS person"
]

for query in drop_tables:
    cursor.execute(query)

# Create tables
create_tables = [
    """
    CREATE TABLE IF NOT EXISTS bus (
        bus_number INT PRIMARY KEY,
        origin VARCHAR(100),
        destination VARCHAR(100),
        date VARCHAR(100),
        departure_time VARCHAR(100),
        arrival_time VARCHAR(100),
        price INT,
        capacity INT
    );
    """,
    """
    CREATE TABLE IF NOT EXISTS person (
        person_id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100),
        surname VARCHAR(100),
        email VARCHAR(100),
        phone_number VARCHAR(100),
        address VARCHAR(100),
        city VARCHAR(100),
        postal_code VARCHAR(100),
        country VARCHAR(100)
    );
    """,
    """
    CREATE TABLE IF NOT EXISTS reservation (
        reservation_id INT PRIMARY KEY,
        credit_card_number BIGINT,
        credit_card_mm INT,
        credit_card_yy INT,
        credit_card_cvv INT,
        person_id BIGINT,
        bus_number INT,
        token VARCHAR(100),
        FOREIGN KEY (person_id) REFERENCES person(person_id),
        FOREIGN KEY (bus_number) REFERENCES bus(bus_number)
    );
    """
]

for query in create_tables:
    cursor.execute(query)


        # Insert initial data
insert_data = """
        INSERT INTO bus (bus_number, origin, destination, date, departure_time, arrival_time, price, capacity)
        VALUES 
            (21, 'São Pedro do Sul', 'Aveiro', '2024-04-09', '08:00', '09:20', 7, 30),
            (23, 'São Pedro do Sul', 'Aveiro', '2024-04-09', '13:45', '16:20', 7, 20),
            (22, 'São Pedro do Sul', 'Aveiro', '2024-04-09', '17:00', '18:20', 7, 5),
            (24, 'São Pedro do Sul', 'Aveiro', '2024-04-12', '20:00', '21:20', 7, 18),
            (16, 'Aveiro', 'São Pedro do Sul', '2024-04-09', '13:45', '15:00', 7, 29),
            (17, 'Aveiro', 'São Pedro do Sul', '2024-04-09', '17:00', '18:20', 7, 9),
            (18, 'Aveiro', 'São Pedro do Sul', '2024-04-09', '21:15', '22:30', 7, 32),
            (76, 'Aveiro', 'Porto', '2024-04-09', '21:00', '22:45', 8, 12),
            (42, 'Lisboa', 'Aveiro', '2024-04-09', '14:30', '17:00', 13, 5),
            (77, 'Lisboa', 'Porto', '2024-04-09', '18:30', '22:45', 18, 10),
            (78, 'Aveiro', 'Porto', '2024-04-08', '21:00', '22:45', 8, 12),
            (40, 'Lisboa', 'Aveiro', '2024-04-08', '14:30', '17:00', 13, 5),
            (72, 'Lisboa', 'Porto', '2024-04-08', '18:30', '22:45', 18, 10),
            (71, 'Aveiro', 'Porto', '2024-04-11', '21:00', '22:45', 8, 12),
            (44, 'Lisboa', 'Aveiro', '2024-04-11', '14:30', '17:00', 13, 5),
            (75, 'Lisboa', 'Porto', '2024-04-11', '18:30', '22:45', 18, 10),
            (70, 'Aveiro', 'Porto', '2024-04-12', '21:00', '22:45', 8, 12),
            (41, 'Lisboa', 'Aveiro', '2024-04-12', '14:30', '17:00', 13, 5),
            (79, 'Lisboa', 'Porto', '2024-04-12', '18:30', '22:45', 18, 10),
            (7, 'Aveiro', 'Viseu', '2024-04-11', '21:00', '22:45', 7, 15),
            (10, 'Lisboa', 'Castelo Branco', '2024-04-11', '13:30', '16:00', 11, 13),
            (1, 'Braga', 'Porto', '2024-04-11', '18:30', '20:00', 14, 20),
            (8, 'Aveiro', 'Viseu', '2024-04-12', '21:00', '22:45', 7, 34),
            (9, 'Lisboa', 'Castelo Branco', '2024-04-12', '13:30', '16:00', 11, 24),
            (2, 'Braga', 'Porto', '2024-04-12', '18:30', '20:00', 14, 26);
        """

cursor.execute(insert_data)

print("Tables created successfully.")

conn.commit()
cursor.close()
conn.close()
