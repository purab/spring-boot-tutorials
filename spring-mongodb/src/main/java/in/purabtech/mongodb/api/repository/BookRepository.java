package in.purabtech.mongodb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.purabtech.mongodb.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
