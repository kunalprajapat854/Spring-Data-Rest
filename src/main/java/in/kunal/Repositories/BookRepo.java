package in.kunal.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import in.kunal.binding.Book;

@Repository

// using @RepositoryRestResource annotation to expose our jpa 
//repository to restapi book endpoints 

@RepositoryRestResource(path = "book") 
public interface BookRepo   extends JpaRepository<Book, Integer> {
	
	public List<Book> findBybookname(@Param("bookname") String bookname);

}
