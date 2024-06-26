CREATE TABLE IF NOT EXISTS user_info
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id      UUID         NOT NULL,
    email_id     VARCHAR(255) NOT NULL,
    first_name   VARCHAR(255),
    last_name    VARCHAR(255),
    display_name varchar(255),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    UNIQUE (email_id)
);


CREATE TABLE movies
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title       VARCHAR(255) NOT NULL,
    movie_db_id INT          NOT NULL,
    imdb_id     INT          NOT NULL,
    year        INT,
    description TEXT
);

CREATE TABLE IF NOT EXISTS movie_reviews
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    movie_id    UUID NOT NULL,
    reviewer_id UUID NOT NULL,
    review_text TEXT,
    rating      INT CHECK (rating >= 1 AND rating <= 10),
    review_date TIMESTAMPTZ      DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE,
    FOREIGN KEY (reviewer_id) REFERENCES user_info (id) ON DELETE CASCADE
);
