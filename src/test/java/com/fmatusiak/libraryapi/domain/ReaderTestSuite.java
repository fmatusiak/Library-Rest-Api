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
    public void testSaveAndFindReader() {
        //Given
        Reader reader = new Reader("edward", "acki");
        readerService.saveReader(reader);

        //When
        Reader readReader = readerService.findReaderById(reader.getId());

        //Then
        assertEquals(reader.getId(), readReader.getId());
    }

    @Test
    public void testDeleteReader() {
        //Given
        Reader reader = new Reader("edward", "acki");
        readerService.saveReader(reader);

        //When
        Reader readReaderBeforeDelete = readerService.findReaderById(reader.getId());
        readerService.deleteReader(readReaderBeforeDelete);
        Reader readReaderAfterDelete = readerService.findReaderById(reader.getId());

        //Then
        assertEquals(null, readReaderAfterDelete);
    }

}