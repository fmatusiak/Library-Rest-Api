package com.fmatusiak.libraryapi.domain;

import com.fmatusiak.libraryapi.service.TitleBookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class TitleBookTestSuite {

    @Autowired
    private TitleBookService titleBookService;

    @Test
    public void titleBookSaveAndFind() {
        //given
        TitleBook titleBook = new TitleBook("test", "test", 2018);

        titleBookService.saveTitleBook(titleBook);

        //when
        TitleBook readTitleBook = titleBookService.findTitleBookById(titleBook.getId());

        //then
        Assert.assertEquals(titleBook.getId(), readTitleBook.getId());
    }

    @Test
    public void findTitleBookByTitle() {
        //given
        TitleBook titleBook = new TitleBook("test", "test", 2018);

        titleBookService.saveTitleBook(titleBook);

        TitleBook readTitleBook = titleBookService.findTitleBookByTitle(titleBook.getTitle());

        //when
        Assert.assertEquals(titleBook.getTitle(), readTitleBook.getTitle());
    }

    @Test
    public void findTitleBookByAuthor() {
        //given
        TitleBook titleBook = new TitleBook("test", "test", 2018);
        TitleBook titleBook1 = new TitleBook("test2", "test", 2018);
        TitleBook titleBook2 = new TitleBook("test3", "test", 2018);

        titleBookService.saveTitleBook(titleBook);
        titleBookService.saveTitleBook(titleBook1);
        titleBookService.saveTitleBook(titleBook2);

        List<TitleBook> readTitleBook = titleBookService.findTitleBooksByAuthor(titleBook.getAuthor());

        //when
        Assert.assertEquals(3, readTitleBook.size());
    }


}