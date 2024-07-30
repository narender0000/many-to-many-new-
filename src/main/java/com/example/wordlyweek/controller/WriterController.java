/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.wordlyweek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import com.example.wordlyweek.model.*;
import com.example.wordlyweek.service.WriterJpaService;

@RestController
public class WriterController {
    @Autowired
    public WriterJpaService writerService;

    @GetMapping("/magazines/writers")
    public ArrayList<Writer> getWriters() {
        return writerService.getWriters();
    }

    @GetMapping("magazines/writers/{writerId}")
    public Writer getWriterById(@PathVariable("writerId") int writerId) {
        return writerService.getWriterById(writerId);
    }

    @PostMapping("/magazines/writers")
    public Writer addWirter(@RequestBody Writer writer) {
        return writerService.addWriter(writer);
    }

    @PutMapping("magazines/writers/{writerId}")
    public Writer updateWriter(@PathVariable("writerId") int writerId, @RequestBody Writer writer) {
        return writerService.updateWriter(writerId, writer);
    }

    @DeleteMapping("magazines/writers/{writerId}")
    public void deleteWriter(@PathVariable("writerId") int writerId) {
        writerService.deleteWriter(writerId);
    }

    @GetMapping("/writers/{writerId}/magazines")
    public List<Magazine> getWriterMagazines(@PathVariable("writerId") int writerId) {
        return writerService.getWriterMagazines(writerId);
    }
}