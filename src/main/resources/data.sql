INSERT INTO stick_group (group_id, stick_type, number_of_sticks)
VALUES
    ('GRP1', 'Bootstick', 2),
    ('GRP2', 'Bootstick', 1);

INSERT INTO usb_stick (inventarnummer, typ, speicherkapazitaet, hersteller, modell, seriennummer, verfuegbarkeit, zustand, group_id)
VALUES
    ('USB001', 'Bootstick', '16GB', 'SanDisk', 'CruzerBlade', 'SN-12345', 'verfuegbar', 'neu', 'GRP1'),
    ('USB002', 'Bootstick', '32GB', 'Kingston', 'DataTraveler', 'SN-67890', 'ausgeliehen', 'gebraucht', 'GRP1'),
    ('USB003', 'Bootstick', '64GB', 'Samsung', 'FitPlus', 'SN-99999', 'verfuegbar', 'neu', 'GRP2');
