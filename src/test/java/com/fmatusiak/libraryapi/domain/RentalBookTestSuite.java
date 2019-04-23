package com.fmatusiak.libraryapi.domain;

import com.fmatusiak.libraryapi.service.CopyBookService;
import com.fmatusiak.libraryapi.service.ReaderService;
import com.fmatusiak.libraryapi.service.RentalBookService;
import com.fmatusiak.libraryapi.service.TitleBookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

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
    public void testSaveRentalBook() {
        //Given
        TitleBook titleBook = new TitleBook("Wiedzmin", "edward", 2004);
        titleBookService.saveTitleBook(titleBook);

        CopyBook copyBook = new CopyBook("true", titleBook);
        copyBookService.saveCopyBook(copyBook);

        Reader reader = new Reader("edward", "acki");
        readerService.saveReader(reader);

        RentalBook rentalBook = new RentalBook(
                LocalDate.now().plusDays(5),
                copyBookService.findCopyBookById(copyBook.getId()),
                readerService.findReaderById(reader.getId()));

        rentalBookService.saveRentalBook(rentalBook);

        //When
        int countRentalBooks = rentalBookService.findAllRentalBooks().size();

        //Then
        assertEquals(1, countRentalBooks);
    }

    @Test
    public void testDeleteRentalBook() {
        //Given
        TitleBook titleBook = new TitleBook("Wiedzmin", "edward", 2004);
        titleBookService.saveTitleBook(titleBook);

        CopyBook copyBook = new CopyBook("true", titleBook);
        copyBookService.saveCopyBook(copyBook);

        Reader reader = new Reader("edward", "acki");
        readerService.saveReader(reader);

        RentalBook rentalBook = new RentalBook(
                LocalDate.now().plusDays(5),
                copyBookService.findCopyBookById(copyBook.getId()),
                readerService.findReaderById(reader.getId()));

        rentalBookService.saveRentalBook(rentalBook);

        rentalBookService.deleteRentalBook(rentalBook);
        //When
        int countRentalBooks = rentalBookService.findAllRentalBooks().size();

        //Then
        assertEquals(0, countRentalBooks);
    }

    @Test
    public void testFindByIdRentalBook() {
        //Given
        TitleBook titleBook = new TitleBook("Wiedzmin", "edward", 2004);
        titleBookService.saveTitleBook(titleBook);

        CopyBook copyBook = new CopyBook("true", titleBook);
        copyBookService.saveCopyBook(copyBook);

        Reader reader = new Reader("edward", "acki");
        readerService.saveReader(reader);

        RentalBook rentalBook = new RentalBook(
                LocalDate.now().plusDays(5),
                copyBookService.findCopyBookById(copyBook.getId()),
                readerService.findReaderById(reader.getId()));

        rentalBookService.saveRentalBook(rentalBook);

        //When
        RentalBook rentalBookRead = rentalBookService.findRentalBookById(rentalBook.getId());

        //Then
        assertEquals(rentalBook, rentalBookRead);
    }

    @Test
    public void testFindAllRentalBooks() {
        //Given
        TitleBook titleBook = new TitleBook("Wiedzmin", "edward", 2004);
        titleBookService.saveTitleBook(titleBook);

        CopyBook copyBook = new CopyBook("true", titleBook);
        copyBookService.saveCopyBook(copyBook);

        Reader reader = new Reader("edward", "acki");
        readerService.saveReader(reader);

        TitleBook titleBook2 = new TitleBook("patyczek", "dawid", 1995);
        titleBookService.saveTitleBook(titleBook2);

        CopyBook copyBook2 = new CopyBook("false", titleBook2);
        copyBookService.saveCopyBook(copyBook2);

        Reader reader2 = new Reader("edward", "acki");
        readerService.saveReader(reader2);

        RentalBook rentalBook = new RentalBook(
                LocalDate.now().plusDays(5),
                copyBookService.findCopyBookById(copyBook.getId()),
                readerService.findReaderById(reader.getId()));

        RentalBook rentalBook2 = new RentalBook(
                LocalDate.now().plusDays(5),
                copyBookService.findCopyBookById(copyBook2.getId()),
                readerService.findReaderById(reader2.getId()));

        rentalBookService.saveRentalBook(rentalBook);
        rentalBookService.saveRentalBook(rentalBook2);

        //When
        List<RentalBook> rentalBookList = rentalBookService.findAllRentalBooks();

        //Then
        assertEquals(2, rentalBookList.size());
    }

}