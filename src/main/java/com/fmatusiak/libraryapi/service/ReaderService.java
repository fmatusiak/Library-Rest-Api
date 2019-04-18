package com.fmatusiak.libraryapi.service;

import com.fmatusiak.libraryapi.domain.Reader;
import com.fmatusiak.libraryapi.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(Reader reader) {
        readerRepository.delete(reader);
    }

    public Reader findReaderById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public List<Reader> findAllReaders() {
        return readerRepository.findAll();
    }
}
