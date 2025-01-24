INSERT INTO usb_stick (
    inventory_number,
    type,
    storage_capacity,
    manufacturer,
    model,
    serial_number,
    availability,
    stick_condition
)
VALUES
    ('USB123', 'Bootstick', '16GB', 'Kingston', 'DataTraveler', 'SN123456', 'verfügbar', 'neu'),
    ('USB124', 'Datenstick', '32GB', 'SanDisk', 'Ultra Flair', 'SN789101', 'reserviert', 'gebraucht'),
    ('USB125', 'Bootstick', '64GB', 'Corsair', 'Voyager', 'SN111213', 'ausgeliehen', 'gebraucht'),
    ('USB126', 'Datenstick', '128GB', 'Samsung', 'Bar Plus', 'SN456789', 'in Wartung', 'defekt');
