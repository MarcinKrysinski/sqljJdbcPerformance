package pl.krysinski.sqljdbc.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.krysinski.sqljdbc.service.UserServiceImpl;
import pl.krysinski.sqljdbc.utils.aspects.LogExecutionTime;

import java.io.IOException;

@Component
public class App {

    private UserServiceImpl userService;

    @Autowired
    public App(UserServiceImpl userService) {
        this.userService = userService;
    }

    @EventListener(ApplicationReadyEvent.class)
    @LogExecutionTime
    public void testSaveDao() throws IOException {
        userService.addAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    @LogExecutionTime
    public void testRead() {
        userService.getAll();
//        userService.getAll().forEach(System.out::println);
    }
}
