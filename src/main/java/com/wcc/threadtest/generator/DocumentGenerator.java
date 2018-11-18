package com.wcc.threadtest.generator;

import com.wcc.threadtest.model.Document;
import com.wcc.threadtest.model.Person;
import com.wcc.threadtest.repository.DocumentRepository;
import com.wcc.threadtest.threadtest.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
public class DocumentGenerator implements Generator {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private RandomService r;

    @Override
    public Person generate(Person person) {
        foo();
        Document document = new Document();
        document.setDocumentStr("setDocumentStr"+r.getRandomInt());
        document.setExpireAt(r.getRandomDate());
        document.setIssuedAt(r.getRandomDate());
        document.setType("DocuTypo"+r.getRandomInt());
        documentRepository.save(document);
        person.getDocument().add(document);
        //System.out.print("T");

        return person;

    }
}
