package com.fmatusiak.libraryapi.controller;

import com.fmatusiak.libraryapi.domain.dto.CopyBookDto;
import com.fmatusiak.libraryapi.mapper.CopyBookMapper;
import com.fmatusiak.libraryapi.service.CopyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/copybook")
public class CopyBookController {

    @Autowired
    private CopyBookService copyBookService;

    @Autowired
    private CopyBookMapper copyBookMapper;

    @PostMapping(value = "createCopyBook", consumes = APPLICATION_JSON_VALUE)
    public CopyBookDto createCopyBook(@RequestBody CopyBookDto copyBookDto) {
        return copyBookMapper.CopyBookToCopyBookDtoMapper(copyBookService.copyBook(copyBookMapper.CopyBookDtoToCopyBookMapper(copyBookDto)));
    }

    @DeleteMapping(value = "deleteCopyBook")
    public void deleteCopyBook(@RequestParam Long copyBookId) {
        copyBookService.deleteCopyBook(copyBookService.findCopyBookById(copyBookId));
    }

    @GetMapping(value = "findCopyBookById")
    public CopyBookDto findCopyBookById(@RequestParam Long copyBookId) {
        return copyBookMapper.CopyBookToCopyBookDtoMapper(copyBookService.findCopyBookById(copyBookId));
    }

    @PostMapping(value = "setCopyBookStatusAsAvailable")
    public void setCopyBookStatusAsAvailable(@RequestParam Long copyBookId) {
        copyBookService.setCopyBookStatusAsAvailable(copyBookId);
    }

    @PostMapping(value = "setCopyBookStatusAsRented")
    public void setCopyBookStatusAsRented(@RequestParam Long copyBookId) {
        copyBookService.setCopyBookStatusAsRented(copyBookId);
    }

    @GetMapping(value = "getCountCopyBooksAvailableByTitle")
    public long getCountCopyBooksAvailableByTitle(@RequestParam String title) {
        return copyBookService.getCountCopyBooksAvailableByTitle(title);
    }
}
