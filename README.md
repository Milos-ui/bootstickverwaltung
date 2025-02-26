## 1. Voraussetzungen

- **Docker Desktop** (Download: https://www.docker.com/products/docker-desktop)
- **Git** [GitHub - Milos-ui/bootstickverwaltung](https://github.com/Milos-ui/bootstickverwaltung)
- **IDE** IntelliJ Paid ist für eine Anwendung wie SpringBoot erforderlich

## 2. Repository klonen

Öffne in IntlliJ einen neuen Ordner und kopiere mein Repositery hinein.

Oder:

Öffne die Eingabeaufforderung (cmd) oder PowerShell und klone das Repository:

```bash
git clone https://github.com/Milos-ui/bootstickverwaltung.git 
cd bootstickverwaltung
```

---

## 3. MariaDB mit Docker starten

Starte einen MariaDB‑Container. Wir legen das Root‑Passwort auf „root“ fest (du kannst das natürlich anpassen).

Öffne eine Konsole und führe folgenden Befehl aus:

```bash
docker run -d --name mariadb -e MARIADB_ROOT_PASSWORD=root 
-p 3306:3306 mariadb:latest
```

*Hinweis:*

- Der Parameter `-d` startet den Container im Hintergrund.
- `--name mariadb` gibt dem Container einen Namen.
- `-p 3306:3306` macht den Datenbankport auf deinem lokalen Rechner (Port 3306) verfügbar.

Überprüfe, ob der Container läuft:

```bash
docker ps
```

---

### 4. Verbindung zur Datenbank prüfen

Nutze ein Datenbank‑Clienttool wie Datagrip, um eine Verbindung zu deiner MariaDB herzustellen:

- **Host:** `localhost`
- **Port:** `3306`
- **Benutzer:** `root`
- **Passwort:** `root`
- **Datenbank:** Am besten eine Database erstellen und benützen wie `bsvw`
  
  ```sql
  create database bsvw;
  use bsvw; 
  ```

## 5. Datenbank initialisieren

Im Repository befinden sich die SQL‑Dateien  `schema.sql` und `data.sql`. Diese enthalten die Befehle, um die benötigten Tabellen zu erstellen und mit Testdaten zu befüllen.

1. Die Befehle von `schema.sql` kopieren und bei datagrip einfügen und ausführen.

2. Dann die Befehle von `data.sql` ausführen.

Führe die Skripte per Docker‑Exec aus:

1. **Schema erstellen:**
   
   ```bash
   docker exec -i mariadb mysql -u root -proot < schema.sql
   ```

2. **Testdaten einfügen:**
   
   ```bash
   docker exec -i mariadb mysql -u root -proot < data.sql
   ```

*Hinweis:*  
Stelle sicher, dass die Dateien `schema.sql` und `data.sql` im aktuellen Verzeichnis (oder im entsprechenden Pfad) vorhanden sind. Alternativ kannst du den absoluten Pfad angeben.

---

## 5. Verbindung zur Datenbank prüfen

Nutze ein Datenbank‑Clienttool wie Datagrip, um eine Verbindung zu deiner MariaDB herzustellen:

- **Host:** `localhost`
- **Port:** `3306`
- **Benutzer:** `root`
- **Passwort:** `root`
- **Datenbank:** Falls im SQL‑Skript eine spezifische Datenbank (z. B. `test_bsvw`) erstellt wurde, verbinde dich mit dieser.

---

## 6. Anwendung konfigurieren

Öffne in deinem Projekt die Datei `application.properties` (oder `application.yml`) und passe den Datenbankzugriff an. Beispiel (application.properties):

`spring.datasource.url=jdbc:mariadb://localhost:3306/test_bsvw spring.datasource.username=root spring.datasource.password=root spring.datasource.driver-class-name=org.mariadb.jdbc.Driver spring.sql.init.mode=never`

---

## 7. Anwendung starten

Nun kannst du deine Spring Boot Anwendung starten. 

1. `build.gradle` ausführen mit dem gradle tool und den befehl `gradle build` von intellij (vorher am besten isntallieren).

2. Danach die `BootstickverwaltungApplication` einfach ausführen.

3. Unter `localhost:8080/swagger-ui/index.html`
