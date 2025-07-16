CREATE TABLE workout_day (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(100) NOT NULL
);

CREATE TABLE exercise_template (
                                   id SERIAL PRIMARY KEY,
                                   workout_day_id INT REFERENCES workout_day(id) ON DELETE CASCADE,
                                   name VARCHAR(100) NOT NULL,
                                   set_reps VARCHAR(50) NOT NULL,
                                   description VARCHAR(200)
);

CREATE TABLE media (
                           id SERIAL PRIMARY KEY,
                           url VARCHAR(100) NOT NULL
);

CREATE TABLE exercise_template_media (
                       exercise_template_id INT REFERENCES exercise_template(id) ON DELETE CASCADE,
                       media_id INT REFERENCES media(id) ON DELETE CASCADE
);



