package br.com.erudio.mapper.custom;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.model.Book;
import br.com.erudio.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Service
public class mapperBook {

    @Mapping(source = "key", target = "id")
    public BookVO mapToBookVO(Book book) {
        BookVO bookVO = new BookVO();
        bookVO.setKey(book.getId());
        bookVO.setAuthor(book.getAuthor());
        bookVO.setLaunchDate(book.getLaunchDate());
        bookVO.setPrice(book.getPrice());
        bookVO.setTitle(book.getTitle());
        return bookVO;
    }

    @Mapping(source = "id", target = "key")
    public Book mapToBook(BookVO bookVO) {
        Book book = new Book();
        book.setId(bookVO.getKey());
        book.setAuthor(bookVO.getAuthor());
        book.setLaunchDate(bookVO.getLaunchDate());
        book.setPrice(bookVO.getPrice());
        book.setTitle(bookVO.getTitle());
        return book;
    }

    public List<BookVO> mapToBookVOList(List<Book> book) {
        return book.stream()
                .map(this::mapToBookVO)
                .collect(Collectors.toList());
    }
}
