package com.fmatusiak.libraryapi.domain;

import com.fmatusiak.libraryapi.domain.enums.RentalStatus;
import com.fmatusiak.libraryapi.service.CopyBookService;
import com.fmatusiak.libraryapi.service.ReaderService;
import com.fmatusiak.libraryapi.service.RentalBookService;
import com.fmatusiak.libraryapi.service.TitleBookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalBookTestSuite {

    @Autowired
    private RentalBookService rentalBookService;

    @Autowired
    private CopyBookService copyBookService;

    @Autowired
    private TitleBookService titleBookService;

    @Autowired
    private ReaderService readerService;

    @Test
    public void testDeleteRentalBook() {
        //Given
        TitleBook titleBook = new TitleBook("Wiedzmin", "edward", 2004);
        titleBookService.saveTitleBook(titleBook);

        CopyBook copyBook = new CopyBook("true", titleBook);
        copyBookService.copyBook(copyBook);

        Reader reader = new Reader("edward", "acki");
        readerService.saveReader(reader);

        RentalBook rentalBook = new RentalBook(
                LocalDate.now().plusDays(5),
                copyBookService.findCopyBookById(copyBook.getId()),
                readerService.findReaderById(reader.getId()));

        rentalBookService.rentalBook(rentalBook);

        rentalBookService.returnRentalBook(rentalBook);
        //When
        RentalBook readRentalBook = rentalBookService.findRentalBookById(rentalBook.getId());

        //Then
        assertEquals(null, readRentalBook);
    }

    @Test
    public void testSaveAndFindRentalBook() {
        //Given
        TitleBook titleBook = new TitleBook("Wiedzmin", "edward", 2004);
        titleBookService.saveTitleBook(titleBook);

        CopyBook copyBook = new CopyBook("true", titleBook);
        copyBookService.copyBook(copyBook);

        Reader reader = new Reader("edward", "acki");
        readerService.saveReader(reader);

        RentalBook rentalBook = new RentalBook(
                LocalDate.now().plusDays(5),
                copyBookService.findCopyBookById(copyBook.getId()),
                readerService.findReaderById(reader.getId()));

        rentalBookService.rentalBook(rentalBook);

        //When
        RentalBook rentalBookRead = rentalBookService.findRentalBookById(rentalBook.getId());

        //Then
        assertEquals(rentalBook, rentalBookRead);
    }

    @Test
    public void returnRentalBook() {
        //Given
        TitleBook titleBook = new TitleBook("Wiedzmin", "edward", 2004);
        titleBookService.saveTitleBook(titleBook);

        CopyBook copyBook = new CopyBook(RentalStatus.AVAILABLE.getStatus(), titleBook);
        copyBookService.copyBook(copyBook);

        Reader reader = new Reader("edward", "acki");
        readerService.saveReader(reader);

        RentalBook rentalBook = new RentalBook(
                LocalDate.now().plusDays(5),
                copyBookService.findCopyBookById(copyBook.getId()),
                readerService.findReaderById(reader.getId()));

        rentalBookService.rentalBook(rentalBook);

        String readStatusCopyBookBeforeReturn =
                copyBookService.findCopyBookById(copyBook.getId()).getStatus();

        rentalBookService.returnRentalBook(rentalBook);

        String readStatuscopyBookAfterReturn =
                copyBookService.findCopyBookById(copyBook.getId()).getStatus();

        //then
        Assert.assertEquals(RentalStatus.RENTED.getStatus(), readStatusCopyBookBeforeReturn);
        Assert.assertEquals(RentalStatus.AVAILABLE.getStatus(), readStatuscopyBookAfterReturn);
    }


}