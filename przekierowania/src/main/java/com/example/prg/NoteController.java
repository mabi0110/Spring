package com.example.prg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Controller
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/save")
    RedirectView saveNote(@RequestParam String id, @RequestParam String text, Model model) {
        Note noteToSave = new Note(id, text);
        boolean saved = noteService.save(noteToSave);
        if (saved) {
            model.addAttribute("note", noteToSave);
            String redirectUri = UriComponentsBuilder
                    .fromPath("note")
                    .queryParam("id", id)
                    .build().toString();
            return new RedirectView(redirectUri, true, false);
        } else {
            return new RedirectView("duplicate", true, false);
        }
    }
    
    @GetMapping("/note")
    String getNote(@RequestParam String id, Model model) {
        Optional<Note> note = noteService.findById(id);
        note.ifPresent(n -> model.addAttribute("note", n));
        return "note";
    }

    @GetMapping("/duplicate")
    String duplicate() {
        return "wrong-data";
    }

}
