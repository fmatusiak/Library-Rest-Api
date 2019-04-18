package com.fmatusiak.libraryapi.controller;

import com.fmatusiak.libraryapi.domain.CopyBook;
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

    @PostMapping(value = "saveCopyBook", consumes = APPLICATION_JSON_VALUE)
    public void saveCopyBook(@RequestBody CopyBook copyBook) {
        copyBookService.saveCopyBook(copyBook);
    }

    @DeleteMapping(value = "deleteCopyBook")
    public void deleteCopyBook(@RequestParam Long copyBookId) {
        copyBookService.deleteCopyBook(copyBookService.findCopyBookById(copyBookId));
    }

    @GetMapping(value = "findCopyBookById")
    public CopyBookDto findCopyBookById(@RequestParam Long copyBookId) {
        return copyBookMapper.CopyBookToCopyBookDtoMapper(copyBookService.findCopyBookById(copyBookId));
    }

    @PutMapping(value = "changeOfStatusCopyBook")
    public void changeOfStatusCopyBook(@RequestParam Long copyBookId, @RequestParam String status) {
        CopyBookDto copyBookDtoRead = copyBookMapper
                .CopyBookToCopyBookDtoMapper(copyBookService.findCopyBookById(copyBookId));
        copyBookDtoRead.getStatus().replace(copyBookDtoRead.getStatus(), status);
        copyBookService.saveCopyBook(copyBookMapper.CopyBookDtoToCopyBookMapper(copyBookDtoRead));
    }
}
