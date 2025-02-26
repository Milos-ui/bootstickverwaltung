-- Testdaten für Gruppen (StickGroup)
INSERT INTO stick_group (group_id, stick_type, number_of_sticks)
VALUES
    ('GRP1', 'Bootstick', 2),
    ('GRP2', 'Datenstick', 2);

-- Testdaten für USB-Sticks (USBStick)
INSERT INTO usb_stick (inventarnummer, typ, speicherkapazitaet, hersteller, modell, seriennummer, verfuegbarkeit, zustand, group_id)
VALUES
    ('USB123', 'Bootstick', '16GB', 'Kingston', 'DataTraveler', 'SN123456', 'verfügbar', 'neu', 'GRP1'),
    ('USB124', 'Datenstick', '32GB', 'SanDisk', 'Ultra Flair', 'SN789101', 'reserviert', 'gebraucht', 'GRP2'),
    ('USB125', 'Bootstick', '64GB', 'Corsair', 'Voyager', 'SN111213', 'ausgeliehen', 'gebraucht', 'GRP1'),
    ('USB126', 'Datenstick', '128GB', 'Samsung', 'Bar Plus', 'SN456789', 'in Wartung', 'defekt', 'GRP2');
