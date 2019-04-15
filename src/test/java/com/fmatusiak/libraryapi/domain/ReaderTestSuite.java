package com.fmatusiak.libraryapi.domain;

import com.fmatusiak.libraryapi.service.ReaderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaderTestSuite {

    @Autowired
    private ReaderService readerService;

    @Test
    public void testSaveReader() {
        //Given
        Reader reader = new Reader("edward", "acki");
        readerService.saveReader(reader);

        //When
        int countReader = readerService.findAllReaders().size();

        //Then
        assertEquals(1, countReader);
    }

    @Test
    public void testDeleteReader() {
        //Given
        Reader reader = new Reader("edward", "acki");
        readerService.saveReader(reader);

        //When
        readerService.deleteReader(reader);
        int countReader = readerService.findAllReaders().size();

        //Then
        assertEquals(0, countReader);
    }

    @Test
    public void testFindAllReader() {
        //Given
        Reader reader = new Reader("edward", "acki");
        Reader reader2 = new Reader("dawid", "dawidowski");
        Reader reader3 = new Reader("filip", "filipowski");

        readerService.saveReader(reader);
        readerService.saveReader(reader2);
        readerService.saveReader(reader3);

        //When
        int countReader = readerService.findAllReaders().size();

        //Then
        assertEquals(3, countReader);
    }

    @Test
    public void testFindByIdReader() {
        //Given
        Reader reader = new Reader("edward", "acki");

        readerService.saveReader(reader);

        //When
        Reader readerRead = readerService.findReaderById(reader.getId());

        //Then
        assertEquals(reader, readerRead);
    }


}