package com.fmatusiak.libraryapi.domain;

import com.fmatusiak.libraryapi.domain.enums.RentalStatus;
import com.fmatusiak.libraryapi.service.CopyBookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CopyBookTestSuite {

    @Autowired
    private CopyBookService copyBookService;

    @Test
    public void testSaveAndFindCopyBook() {
        //given
        TitleBook titleBook = new TitleBook("test", "test", 2018);
        CopyBook copyBook = new CopyBook(RentalStatus.AVAILABLE.getStatus(), titleBook);

        copyBookService.copyBook(copyBook);

        //when
        CopyBook readCopyBook = copyBookService.findCopyBookById(copyBook.getId());

        //then
        Assert.assertEquals(RentalStatus.AVAILABLE.getStatus(), readCopyBook.getStatus());
    }

    @Test
    public void testFindAndDeleteCopyBook() {
        //given
        TitleBook titleBook = new TitleBook("test", "test", 2018);
        CopyBook copyBook = new CopyBook(RentalStatus.AVAILABLE.getStatus(), titleBook);

        copyBookService.copyBook(copyBook);

        //when
        CopyBook readCopyBookBeforeDelete = copyBookService.findCopyBookById(copyBook.getId());
        copyBookService.deleteCopyBook(readCopyBookBeforeDelete);
        CopyBook readCopyBookAfterDelete = copyBookService.findCopyBookById(copyBook.getId());

        //then
        Assert.assertEquals(null, readCopyBookAfterDelete);
    }

    @Test
    public void testSetCopyBookStatusRented() {
        //given
        TitleBook titleBook = new TitleBook("test", "test", 2018);
        CopyBook copyBook = new CopyBook(RentalStatus.AVAILABLE.getStatus(), titleBook);

        copyBookService.copyBook(copyBook);
        CopyBook readCopyBook = copyBookService.findCopyBookById(copyBook.getId());
        copyBookService.setCopyBookStatusAsRented(readCopyBook.getId());

        //when
        String statusReadCopyBook = readCopyBook.getStatus();

        //then
        Assert.assertEquals(RentalStatus.RENTED.getStatus(), statusReadCopyBook);
    }

    @Test
    public void testSetCopyBookStatusAvailable() {
        //given
        TitleBook titleBook = new TitleBook("test", "test", 2018);
        CopyBook copyBook = new CopyBook(RentalStatus.RENTED.getStatus(), titleBook);

        copyBookService.copyBook(copyBook);
        CopyBook readCopyBook = copyBookService.findCopyBookById(copyBook.getId());
        copyBookService.setCopyBookStatusAsAvailable(readCopyBook.getId());

        //when
        String statusReadCopyBook = readCopyBook.getStatus();

        //then
        Assert.assertEquals(RentalStatus.AVAILABLE.getStatus(), statusReadCopyBook);
    }

}