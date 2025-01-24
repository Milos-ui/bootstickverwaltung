-- Drop table, falls sie existiert
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS reservation_sticks;
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS usb_stick;
DROP TABLE IF EXISTS stick_group;

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE stick_group (
        group_id          VARCHAR(50) PRIMARY KEY,
        stick_type        VARCHAR(50),
        number_of_sticks  INT
);
CREATE TABLE usb_stick (
                           inventory_number VARCHAR(255) PRIMARY KEY,
                           group_id         VARCHAR(50),
                           type             VARCHAR(50),
                           storage_capacity VARCHAR(50),
                           manufacturer     VARCHAR(100),
                           model            VARCHAR(100),
                           serial_number    VARCHAR(100),
                           availability     VARCHAR(50),
                           stick_condition  VARCHAR(50),
                           CONSTRAINT fk_group FOREIGN KEY (group_id) REFERENCES stick_group(group_id) ON DELETE CASCADE
);

CREATE TABLE reservation (
                             reservation_id  INT AUTO_INCREMENT PRIMARY KEY,
                             group_id        VARCHAR(50),
                             reserved_by     VARCHAR(100),
                             CONSTRAINT fk_reservation_group
                                 FOREIGN KEY (group_id) REFERENCES stick_group(group_id)
                                     ON DELETE CASCADE
);
CREATE TABLE reservation_sticks (
                                    reservation_id  INT,
                                    stick_id        VARCHAR(255),
                                    PRIMARY KEY (reservation_id, stick_id),
                                    CONSTRAINT fk_reservation
                                        FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id)
                                            ON DELETE CASCADE,
                                    CONSTRAINT fk_stick
                                        FOREIGN KEY (stick_id) REFERENCES usb_stick(inventory_number)
                                            ON DELETE CASCADE
);

