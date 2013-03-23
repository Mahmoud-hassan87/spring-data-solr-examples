package net.petrikainulainen.spring.datasolr.todo.repository.solr;

import net.petrikainulainen.spring.datasolr.todo.document.TodoDocument;
import net.petrikainulainen.spring.datasolr.todo.model.Todo;

import java.util.List;

/**
 * @author Petri Kainulainen
 */
public interface CustomTodoDocumentRepository {

    public List<TodoDocument> search(String searchTerm);

    public void update(Todo todoEntry);
}
