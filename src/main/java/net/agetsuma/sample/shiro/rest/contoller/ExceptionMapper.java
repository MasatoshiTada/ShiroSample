package net.agetsuma.sample.shiro.rest.contoller;

import net.agetsuma.sample.shiro.rest.thymeleaf.ThymeleafViewable;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.HashMap;

/**
 * Created by tada on 2016/10/29.
 */
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        exception.printStackTrace();
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", exception.getMessage());
        ThymeleafViewable viewable = new ThymeleafViewable("exception.html", map);
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                .entity(viewable).build();
    }
}
