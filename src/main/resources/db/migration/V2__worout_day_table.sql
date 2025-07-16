CREATE TABLE workout_day (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(100) NOT NULL
);


CREATE TABLE exercise_template (
                           id SERIAL PRIMARY KEY,
                           workout_day_id INT REFERENCES workout_day(id) ON DELETE CASCADE,
                           name VARCHAR(100) NOT NULL
);
