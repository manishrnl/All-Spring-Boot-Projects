package springai.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class TravellingTools {
    /*
    The AI relies entirely on the text inside the @Tool and @ToolParam annotations to understand context.
    If you name the tool func1 and give no description, the AI will likely never call it because it doesn't know what it does.
    e.g.,  @Tool(description = "abc")
     public String getWeather(@ToolParam(description = "abc") String city) {.}
    By writing "Get the weather of a city", you are giving the AI the "manual" it needs to know when that specific tool is appropriate.
     */
    @Tool(description = "Get the weather of a city")
    public String getWeather(@ToolParam(description = "City name for which to get the weather information") String city) {
        return switch (city) {
            case "Delhi" -> "Sunny, 26 Degrees";
            case "London" -> "Cloudy, 2 Degrees";
            default -> "Cannot identify the city";
        };
    }
}
