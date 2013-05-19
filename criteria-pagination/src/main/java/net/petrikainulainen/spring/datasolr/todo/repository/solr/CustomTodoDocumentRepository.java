package net.petrikainulainen.spring.datasolr.todo.repository.solr;

import net.petrikainulainen.spring.datasolr.todo.document.TodoDocument;
import net.petrikainulainen.spring.datasolr.todo.model.Todo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Petri Kainulainen
 */
public interface CustomTodoDocumentRepository {

    public long count(String searchTerm);

    public List<TodoDocument> search(String searchTerm, Pageable page);

    public void update(Todo todoEntry);
}
