CREATE TABLE Users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       name VARCHAR(100) NOT NULL,
                       password VARCHAR(100) NOT NULL
);

CREATE TABLE Topics (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        message VARCHAR(1000) NOT NULL,
                        creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                        author_id INT NOT NULL,
                        FOREIGN KEY (author_id) REFERENCES Users(id)
);

CREATE TABLE Answers (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         message VARCHAR(1000) NOT NULL,
                         creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                         topic_id INT NOT NULL,
                         author_id INT NOT NULL,
                         FOREIGN KEY (topic_id) REFERENCES Topics(id),
                         FOREIGN KEY (author_id) REFERENCES Users(id)
);