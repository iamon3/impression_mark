package com.resource;

import static com.util.PathConstants.DOCUMENT_BASE_PATH;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.beans.Document;


/**
 */
@Path(DOCUMENT_BASE_PATH)
public class DocumentResource {

    //private static final String DOCUMENT_BASE_PATH = "/documents";
    private static final String DOCUMENT_RELATIVE_PATH = "/{ticketId}";

    @POST
    @Path("/post")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN,  MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public String addDocument(JAXBElement<Document> document)
    {
        System.out.println("POST : " + document.getValue());
        return "\n POST \n";
    }

    @GET
    @Path(DOCUMENT_RELATIVE_PATH)
    //@Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN,  MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public String getDocument(@PathParam("ticketId") String ticketId)
    {
        System.out.println("GET : " + ticketId);
        return "\n GET \n";
    }

    @PUT
    @Path(DOCUMENT_RELATIVE_PATH)
    @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public String updateDocument(@PathParam("ticketId") String ticketId, Document document)
    {
        System.out.println("PUT tId : " + ticketId + ", document => " + document);
        return "\n PUT \n";
    }

    @DELETE
    @Path(DOCUMENT_RELATIVE_PATH)
    //@Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public String deleteDocument(@PathParam("ticketId") String ticketId)
    {
        System.out.println("DELETE : " + ticketId);
        return "\n DELETE \n";
    }
}
