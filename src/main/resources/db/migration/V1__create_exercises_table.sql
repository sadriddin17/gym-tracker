CREATE TABLE exercises (
                           id SERIAL PRIMARY KEY,
                           date DATE NOT NULL,
                           name VARCHAR(100) NOT NULL,
                           sets INT NOT NULL,
                           reps INT NOT NULL,
                           weight DOUBLE PRECISION NOT NULL,
                           notes TEXT
);
