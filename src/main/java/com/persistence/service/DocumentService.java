package com.persistence.service;

import java.util.HashMap;
import java.util.Map;

import com.persistence.beans.Document;

/**
 */
public class DocumentService {

    private static int documentIdCounter = 1;

    /**
     * For simplicity HashMap is simulated as a database. It's not difficult to replace the HashMap with back-end database
     *
     * <Key, Value> = <DocumentId, Document>
     */
    private  static Map<String, Document> documentStore = new HashMap<String, Document>();

    public Document addDocument(Document document){
        document.setDocumentId(Integer.toString(documentIdCounter));
        document.setIsMarked(Boolean.toString(isMarked(document)));
        documentStore.put(Integer.toString(documentIdCounter), document);
        documentIdCounter +=1;
        return documentStore.get(Integer.toString(documentIdCounter-1));
    }

    public Document getDocument(String documentId){
        return documentStore.get(documentId);
    }

    public Document deleteDocument(String documentId){
        return documentStore.remove(documentId);
    }

    public Document updateDocument(String documentId, Document document){
        if(documentStore.containsKey(documentId)){
            Document originalDocument = documentStore.get(documentId);
            updateOriginalDocument(document, originalDocument);
            documentStore.put(documentId, originalDocument);
            return documentStore.get(documentId);
        }
        return null;
    }

    private void updateOriginalDocument(Document document, Document originalDocument){
        if(document.getContent() != null){
            originalDocument.setContent(document.getContent());
            if(!originalDocument.getContent().equalsIgnoreCase("Book")){
                originalDocument.setTopic(null);
            }
        }
        if(document.getAuthor() != null){
            originalDocument.setAuthor(document.getAuthor());
        }
        if(document.getTitle() != null){
            originalDocument.setTitle(document.getTitle());
        }
        if(originalDocument.getContent().equalsIgnoreCase("Book") && null != document.getTopic()){
            originalDocument.setTopic(document.getTopic());
        }
        originalDocument.setIsMarked(Boolean.toString(isMarked(originalDocument)));
    }

    private boolean isMarked(Document document){
        if(null == document.getAuthor()){
            return false;
        }
        if(null == document.getContent()){
            return false;
        }
        if(null == document.getAuthor()){
            return false;
        }
        if(document.getContent().equalsIgnoreCase("Book") && null == document.getTopic()){
            return false;
        }
        return true;
    }
}
