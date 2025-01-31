package com.example.bootstickverwaltung.controller;

import com.example.bootstickverwaltung.ldap.entry.UserEntry;
import com.example.bootstickverwaltung.model.StickGroup;
import com.example.bootstickverwaltung.model.USBStick;
import com.example.bootstickverwaltung.repository.StickGroupRepository;
import com.example.bootstickverwaltung.repository.USBStickRepository;
import com.example.bootstickverwaltung.ldap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usb")
public class USBStickController {
    @Autowired
    private StickGroupRepository groupRepository;

    @Autowired
    private USBStickRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    // GET /api/groups
    @GetMapping("/groups")
    public List<StickGroup> getAllGroups() {
        return groupRepository.findAll();
    }

    // GET /api/groups/{groupId}
    @GetMapping("/groups/{groupId}")
    public ResponseEntity<StickGroup> getGroupById(@PathVariable String groupId) {
        Optional<StickGroup> groupOpt = groupRepository.findById(groupId);
        if (groupOpt.isPresent()) {
            return ResponseEntity.ok(groupOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /api/groups/{groupId}
    @PutMapping("/groups/{groupId}")
    public ResponseEntity<StickGroup> updateGroup(@PathVariable String groupId,
                                                  @RequestBody StickGroup updated) {
        return groupRepository.findById(groupId)
                .map(existing -> {
                    existing.setStickType(updated.getStickType());
                    existing.setNumberOfSticks(updated.getNumberOfSticks());
                    // Optional: vorhandene Sticks anpassen, etc.
                    StickGroup saved = groupRepository.save(existing);
                    return ResponseEntity.ok(saved);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE /api/groups/{groupId}
    @DeleteMapping("/groups/{groupId}")
    public ResponseEntity<?> deleteGroup(@PathVariable String groupId) {
        return groupRepository.findById(groupId)
                .map(g -> {
                    groupRepository.delete(g);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/groups
    @PostMapping("/groups")
    public ResponseEntity<StickGroup> createGroup(@RequestBody StickGroup newGroup) {
        if (groupRepository.existsById(newGroup.getGroupId())) {
            // Falls bereits vorhanden -> 400 oder 409 zurück
            return ResponseEntity.badRequest().build();
        }
        StickGroup saved = groupRepository.save(newGroup);
        return ResponseEntity.ok(saved);
    }

    // GET: Alle USB-Sticks abrufen
    @GetMapping
    public List<USBStick> getAll() {
        return repository.findAll();
    }

    // GET: Einen USB-Stick nach Inventarnummer abrufen
    @GetMapping("/{inventarnummer}")
    public ResponseEntity<USBStick> getUSBStickById(@PathVariable String inventarnummer) {
        Optional<USBStick> usbStick = repository.findById(inventarnummer);
        return usbStick.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Neuen USB-Stick hinzufügen
    @PostMapping
    public ResponseEntity<USBStick> addUSBStick(@RequestBody USBStick newStick) {
        if (repository.existsById(newStick.getInventarnummer())) {
            return ResponseEntity.badRequest().build();
        }
        // 1) Stick speichern
        USBStick savedStick = repository.save(newStick);

        // 2) Zugehörige Gruppe updaten
        StickGroup grp = savedStick.getGroup();
        if (grp != null) {
            // Im Zweifel nochmal aus der DB laden (falls das Objekt 'half-attached' ist)
            StickGroup freshGroup = groupRepository.findById(grp.getGroupId()).orElse(null);
            if (freshGroup != null) {
                // 3) optional: freshGroup.getSticks().add(savedStick);
                //    (cascade = ALL übernimmt das i.d.R., aber wenn du sicher gehen willst, kannst du's manuell hinzufügen)
                freshGroup.recalcStickCount();
                groupRepository.save(freshGroup);
            }
        }

        return ResponseEntity.ok(savedStick);
    }



    // PUT: Einen bestehenden USB-Stick aktualisieren
    @PutMapping("/{inventarnummer}")
    public ResponseEntity<USBStick> updateUSBStick(@PathVariable String inventarnummer, @RequestBody USBStick updatedStick) {
        return repository.findById(inventarnummer)
                .map(existingStick -> {
                    existingStick.setTyp(updatedStick.getTyp());
                    existingStick.setSpeicherkapazitaet(updatedStick.getSpeicherkapazitaet());
                    existingStick.setHersteller(updatedStick.getHersteller());
                    existingStick.setModell(updatedStick.getModell());
                    existingStick.setSeriennummer(updatedStick.getSeriennummer());
                    existingStick.setVerfuegbarkeit(updatedStick.getVerfuegbarkeit());
                    existingStick.setZustand(updatedStick.getZustand());
                    repository.save(existingStick);
                    return ResponseEntity.ok(existingStick);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE: Einen USB-Stick löschen
    @DeleteMapping("/{inventarnummer}")
    public ResponseEntity<Object> deleteUSBStick(@PathVariable String inventarnummer) {
        return repository.findById(inventarnummer)
                .map(usbStick -> {
                    repository.delete(usbStick);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        try {
            System.out.println("Benutzername: " + username); // Debugging

            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            SecurityContextHolder.getContext().setAuthentication(auth);

            System.out.println("Login erfolgreich für Benutzer: " + username);
            return Map.of(
                    "status", "success",
                    "message", "Login erfolgreich",
                    "username", username
            );
        } catch (Exception e) {
            e.printStackTrace(); // Stacktrace ausgeben
            return Map.of(
                    "status", "failure",
                    "message", "Ungültige Anmeldedaten: " + e.getMessage()
            );
        }
    }



    // POST: Logout
    @PostMapping("/logout")
    public Map<String, Object> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        SecurityContextHolder.clearContext();
        return Map.of(
                "status", "success",
                "message", "Logout erfolgreich."
        );
    }

    private Optional<String> determineUserRole(String username) {
        Optional<UserEntry> userOpt = userService.findByCommonName(username, false); // false = Keine Gruppen laden

        if (userOpt.isPresent()) {
            UserEntry user = userOpt.get();
            String email = user.getMail();

            // Nur Lehrer und Admins erlauben
            if (email != null && !email.toLowerCase().contains("student")) {
                return Optional.of("ROLE_TEACHER");
            }
        }

        return Optional.empty();
    }
    */

}
