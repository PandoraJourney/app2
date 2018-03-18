package lt.egzaminas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.egzaminas.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	void deleteByVardas(String name);

	Book findDistinctByVardas(String vardas);

}
