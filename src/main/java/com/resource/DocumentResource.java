package com.resource;

import static com.util.PathConstants.SERVICE_PATH;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;

import com.persistence.service.DocumentService;
import com.persistence.beans.Document;


/**
 * This class exposes CRUD operations on document(s) resources.
 */
@Path(SERVICE_PATH)
public class DocumentResource {

    private static final String DOCUMENTS_RESOURCE_PATH = "/documents";
    private static final String DOCUMENT_RESOURCE_PATH = "/{documentId}";

    /**
     * curl -X POST http://127.0.0.1:9090/impression-mark/services/documents
     */
    @POST
    @Path(DOCUMENTS_RESOURCE_PATH)
    @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public Document addDocument(Document document)
    {
        Document  documentAdded = new Document();
        documentAdded = getDocumentService().addDocument(document);
        if(null == documentAdded){
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        return documentAdded;
    }

    /**
     * curl -X GET http://127.0.0.1:9090/impression-mark/services/documents/{documentId}
     */
    @GET
    @Path(DOCUMENTS_RESOURCE_PATH + DOCUMENT_RESOURCE_PATH)
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public Document getDocument(@PathParam("documentId") String documentId)
    {
        Document document = new Document();
        try{
            document = getDocumentService().getDocument(documentId);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        if(null == document){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return document;
    }

    /**
     * curl -X PUT http://127.0.0.1:9090/impression-mark/services/documents/{documentId}
     */
    @PUT
    @Path(DOCUMENTS_RESOURCE_PATH + DOCUMENT_RESOURCE_PATH)
    @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public Document updateDocument(@PathParam("documentId") String documentId, Document document)
    {
        Document documentUpdated = new Document();
        try{
        documentUpdated = getDocumentService().updateDocument(documentId, document);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        if(null == documentUpdated){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return documentUpdated;
    }

    /**
     * curl -X DELETE http://127.0.0.1:9090/impression-mark/services/documents/{documentId}
     */
    @DELETE
    @Path(DOCUMENTS_RESOURCE_PATH + DOCUMENT_RESOURCE_PATH)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public Document deleteDocument(@PathParam("documentId") String documentId)
    {
        Document documentDeleted = new Document();
        try{
        documentDeleted = getDocumentService().deleteDocument(documentId);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        if(null == documentDeleted){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return documentDeleted;
    }

    private DocumentService getDocumentService(){
        return new DocumentService();
    }
}
