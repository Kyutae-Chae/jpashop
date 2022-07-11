package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.item.Movie;
import jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class ItemServiceTest {

    @Autowired ItemRepository itemRepository;
    @Autowired ItemService itemService;

    public ItemServiceTest() {
    }

    @Test
    public void saveItem() {
        Item item = new Movie();
        item.setName("itemMovie");

        Long savedId = itemService.saveItem(item);
        Assertions.assertThat(item).isEqualTo(itemService.findOne(savedId));
    }

    @Test
    public void findOne() {
        Item item = new Book();
        item.setName("BookA");
        item.setPrice(1500);

        Long savedId = itemService.saveItem(item);
        Assertions.assertThat(item).isEqualTo(itemService.findOne(savedId));
    }
}