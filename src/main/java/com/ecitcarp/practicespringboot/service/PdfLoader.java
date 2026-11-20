package com.ecitcarp.practicespringboot.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PdfLoader implements CommandLineRunner {

    private final VectorStore vectorStore;

    @Value("classpath:/docs/sample.pdf")
    private Resource pdf;

    public PdfLoader(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Override
    public void run(String... args) {
        List<Document> pages = new PagePdfDocumentReader(pdf).read();   // 1. read
        List<Document> chunks = new TokenTextSplitter().split(pages);   // 2. split
        vectorStore.add(chunks);                                        // 3. store
        System.out.println("Loaded " + chunks.size() + " chunks");
    }
}