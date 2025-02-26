SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS usb_stick;
DROP TABLE IF EXISTS stick_group;

CREATE TABLE stick_group (
                             group_id VARCHAR(255) PRIMARY KEY,
                             stick_type VARCHAR(50),
                             number_of_sticks INT
);

CREATE TABLE usb_stick (
                           inventarnummer VARCHAR(255) PRIMARY KEY,
                           typ VARCHAR(50) NOT NULL,
                           speicherkapazitaet VARCHAR(50),
                           hersteller VARCHAR(100),
                           modell VARCHAR(100),
                           seriennummer VARCHAR(100),
                           verfuegbarkeit VARCHAR(50),
                           zustand VARCHAR(50),
                           group_id VARCHAR(255),
                           CONSTRAINT fk_usb_stick_group
                               FOREIGN KEY (group_id)
                                   REFERENCES stick_group (group_id)
                                   ON DELETE CASCADE
                                   ON UPDATE CASCADE
);

SET FOREIGN_KEY_CHECKS = 1;
