package com.example.bootstickverwaltung.controller;

import com.example.bootstickverwaltung.ldap.entry.UserEntry;
import com.example.bootstickverwaltung.model.USBStick;
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
    private USBStickRepository repository;

    //@Autowired
    //private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

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
    public ResponseEntity<USBStick> createUSBStick(@RequestBody USBStick usbStick) {
        if (repository.existsById(usbStick.getInventoryNumber())) {
            return ResponseEntity.badRequest().body(null);
        }
        USBStick savedStick = repository.save(usbStick);
        return ResponseEntity.ok(savedStick);
    }

    // PUT: Einen bestehenden USB-Stick aktualisieren
    @PutMapping("/{inventarnummer}")
    public ResponseEntity<USBStick> updateUSBStick(@PathVariable String inventarnummer, @RequestBody USBStick updatedStick) {
        return repository.findById(inventarnummer)
                .map(existingStick -> {
                    existingStick.setType(updatedStick.getType());
                    existingStick.setStorageCapacity(updatedStick.getStorageCapacity());
                    existingStick.setManufacturer(updatedStick.getManufacturer());
                    existingStick.setModel(updatedStick.getModel());
                    existingStick.setSerialNumber(updatedStick.getSerialNumber());
                    existingStick.setAvailability(updatedStick.getAvailability());
                    existingStick.setCondition(updatedStick.getCondition());
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
            System.out.println("Passwort: " + password); // Debugging

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
        Optional<UserEntry> userOpt = userService.findByCommonName(username, false);
        if (userOpt.isPresent()) {
            UserEntry user = userOpt.get();
            String email = user.getMail();

            // Falls es 'student' enthält => Rolle STUDENT
            // (und evtl. an anderer Stelle "Admins" checken)
            if (email != null) {
                if (email.toLowerCase().contains("student")) {
                    return Optional.of("ROLE_STUDENT");
                } else {
                    return Optional.of("ROLE_TEACHER");
                }
            }
        }
        return Optional.empty();
    }
     */
}