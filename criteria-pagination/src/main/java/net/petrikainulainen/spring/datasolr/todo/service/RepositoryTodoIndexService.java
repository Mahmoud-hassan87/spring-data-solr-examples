package net.petrikainulainen.spring.datasolr.todo.service;

import net.petrikainulainen.spring.datasolr.todo.document.TodoDocument;
import net.petrikainulainen.spring.datasolr.todo.model.Todo;
import net.petrikainulainen.spring.datasolr.todo.repository.solr.TodoDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Petri Kainulainen
 */
@Service
public class RepositoryTodoIndexService implements TodoIndexService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTodoIndexService.class);

    @Resource
    private TodoDocumentRepository repository;

    @Transactional
    @Override
    public void addToIndex(Todo todoEntry) {
        LOGGER.debug("Saving a todo entry with information: {}", todoEntry);
        TodoDocument document = TodoDocument.getBuilder(todoEntry.getId(), todoEntry.getTitle())
                .description(todoEntry.getDescription())
                .build();

        LOGGER.debug("Saving document with information: {}", document);

        repository.save(document);
    }

    @Transactional
    @Override
    public void deleteFromIndex(Long id) {
        LOGGER.debug("Deleting an existing document with id: {}", id);
        repository.delete(id.toString());
    }

    @Override
    public List<TodoDocument> search(String searchTerm) {
        LOGGER.debug("Searching documents with search term: {}", searchTerm);
        return repository.search(searchTerm);
    }

    @Transactional
    @Override
    public void update(Todo todoEntry) {
        LOGGER.debug("Updating the information of a todo entry: {}", todoEntry);
        repository.update(todoEntry);
    }
}
