INSERT INTO Client (name) VALUES
    ('Client 1'),
    ('Client 2'),
    ('Client 3'),
    ('Client 4'),
    ('Client 5'),
    ('Client 6'),
    ('Client 7'),
    ('Client 8'),
    ('Client 9'),
    ('Client 10');

INSERT INTO Planet (id, name) VALUES
    ('MARS4', 'Mars'),
    ('VEN2', 'Venus'),
    ('EARTH3', 'Earth'),
    ('JUP5', 'Jupiter'),
    ('SAT6', 'Saturn');

DO $$
BEGIN
    FOR i IN 1..30 LOOP
        INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES
            (ceil(random() * 10), (SELECT id FROM Planet ORDER BY RANDOM() LIMIT 1), (SELECT id FROM Planet ORDER BY RANDOM() LIMIT 1));
    END LOOP;
END $$;
