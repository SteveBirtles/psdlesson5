package server.controllers;

import server.models.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("message/")
public class MessageController {

    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String newMessage(@FormParam("messageText") String messageText,
                             @FormParam("messageAuthor") String messageAuthor ) {

        int messageId = Message.nextId();
        String messageDate = new Date().toString();

        Message.messages.add(new Message(messageId, messageText, messageDate, messageAuthor));

        StringBuilder messageSummary = new StringBuilder();

        for (Message m: Message.messages) {
            messageSummary.append(m.toJSON().toString());
            messageSummary.append("\n");
        }

        return messageSummary.toString();

    }
}
