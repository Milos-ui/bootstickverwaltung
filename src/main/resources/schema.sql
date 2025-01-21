-- Drop table, falls sie existiert
DROP TABLE IF EXISTS usb_stick;

-- Tabelle neu erstellen
CREATE TABLE usb_stick (
       Inventarnummer     VARCHAR(255) PRIMARY KEY, -- Eindeutige Kennzeichnung
       Typ                VARCHAR(50) NOT NULL,     -- Bootstick oder Datenstick
       Speicherkapazitaet VARCHAR(50),              -- Größe des Speichers, z.B. 16GB
       Hersteller         VARCHAR(100),             -- Hersteller des Sticks
       Modell             VARCHAR(100),             -- Modellbezeichnung
       Seriennummer       VARCHAR(100),             -- Seriennummer zur Identifikation
       Verfuegbarkeit     VARCHAR(50),              -- Status: verfügbar, ausgeliehen, reserviert, in Wartung
       Zustand            VARCHAR(50)               -- Zustand: neu, gebraucht, defekt
);
