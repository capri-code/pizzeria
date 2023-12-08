CREATE TABLE IF NOT EXISTS pizza (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    size VARCHAR(100) NOT NULL,
    cheesycrust BOOLEAN,
    timetodeliever TIME
);

CREATE TABLE IF NOT EXISTS pizzatoppings (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    pizzaid INTEGER REFERENCES pizza(id)
);

INSERT INTO pizza (size, cheesycrust, timetodeliever) VALUES ('M', TRUE, '12:12');
INSERT INTO pizza (size, cheesycrust, timetodeliever) VALUES ('S', FALSE, '13:30');
INSERT INTO pizza (size, cheesycrust, timetodeliever) VALUES ('L', FALSE, '16:10');

INSERT INTO pizzatoppings (name, pizzaid) VALUES ('mushrooms', 1);
INSERT INTO pizzatoppings (name, pizzaid) VALUES ('ham', 2);
INSERT INTO pizzatoppings (name, pizzaid) VALUES ('ananas', 3);
