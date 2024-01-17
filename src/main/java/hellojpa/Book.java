package hellojpa;

import javax.persistence.Entity;

@Entity
public class Book extends Item_ex {
    private String author;
    private String isbn;
}
