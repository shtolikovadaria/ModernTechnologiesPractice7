package lecture.seven.student.greet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
@AutoConfigureMockMvc(addFilters = false)
@Import(EnglishGreetingService.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void greet_returnsEnglishGreeting() throws Exception {
        mvc.perform(get("/api/greet/World"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }
}
