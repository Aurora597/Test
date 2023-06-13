import com.fasterxml.jackson.databind.ObjectMapper;
import com.theokanning.openai.OpenAiApi;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        System.out.println(1);
        getModles();
    }
//    }
    public static void getModles(){
//        System.out.println('2');

        ObjectMapper mapper = OpenAiService.defaultObjectMapper();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1",33210));
        Duration timeout = Duration.ofMillis(100000000);
        OkHttpClient client = OpenAiService.defaultClient("", timeout)
                .newBuilder()
                .proxy(proxy)
                .build();
        Retrofit retrofit = OpenAiService.defaultRetrofit(client, mapper);
        OpenAiApi api = retrofit.create(OpenAiApi.class);
        OpenAiService service = new OpenAiService(api);

        List<ChatMessage> messageList = new ArrayList<>();
        ChatMessage chatMessage = new ChatMessage("user","Generate a resume for me to apply for java engineer.");
        messageList.add(chatMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(messageList)
                .build();

        service.createChatCompletion(chatCompletionRequest).getChoices().forEach(System.out::println);
//        CompletionRequest completionRequest = CompletionRequest.builder().model("ada").echo(true)
//                .prompt("Generate resume.").build();
//        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
//        CompletionRequest completionRequest = CompletionRequest.builder().prompt("I am lxs, say Who am i.").temperature(0.0d).model("ada").echo(true).build();
//        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
//        CompletionRequest completionRequest = CompletionRequest.builder()
//                .prompt("Now I am searching for a job. The job description is: We are looking for highly skilled programmers with experience building web applications in Java. Java Developers are responsible for analyzing user requirements and business objectives, determining application features and functionality, and recommending changes to existing Java-based applications, among other duties.\n" +
//                        "Java Developers need to compile detailed technical documentation and user assistance material, requiring excellent written communication.\n" +
//                        "Java Developer Responsibilities:\n" +
//                        "Designing and implementing Java-based applications.\n" +
//                        "Analyzing user requirements to inform application design.\n" +
//                        "Defining application objectives and functionality.\n" +
//                        "Aligning application design with business goals.\n" +
//                        "Developing and testing software.\n" +
//                        "Debugging and resolving technical problems that arise.\n" +
//                        "Producing detailed design documentation.\n" +
//                        "Recommending changes to existing Java infrastructure.\n" +
//                        "Developing multimedia applications.\n" +
//                        "Developing documentation to assist users.\n" +
//                        "Ensuring continuous professional self-development.\n" +
//                        "Java Developer Requirements:\n" +
//                        "Degree in Computer Science or related field.\n" +
//                        "Experience with user interface design, database structures, and statistical analyses.\n" +
//                        "Analytical mindset and good problem-solving skills.\n" +
//                        "Excellent written and verbal communication.\n" +
//                        "Good organizational skills.\n" +
//                        "Ability to work as part of a team.\n" +
//                        "Attention to detail.\n" +
//                        "The information I can provide includes personal information,links,skills,skills,projects,work experience,education,etc.\n" +
//                        "\"firstname\":\"K\",\n" +
//                        "\"lastname\":\"K\",\n" +
//                        "\"phone\":\"123-456-7890\",\n" +
//                        "\"email\":\"aauwwpuc@gmail.com\",\n" +
//                        "\"address\":\"123 Main St, San Francisco, CA 94122\",\n" +
//                        "\"links\":[\n" +
//                        "    {\"name\":\"LinkedIn\",\"url\":\"https://www.linkedin.com/in/duong-hoang-/\"},\n" +
//                        "    {\"name\":\"GitHub\",\"url\":\"https://github.com/Aurora597/\"}\n" +
//                        "],\n" +
//                        "\"skills\":[\n" +
//                        "    {\"category\":\"Programming Languages\",\"items\":[\"Python\",\"Java\",\"JavaScript/ES6\",\"C++/C\",\"SQL\",\"Shell\"]},\n" +
//                        "    {\"category\":\"Frameworks\",\"items\":[\"Spring\",\"Spring Boot\",\"Django\",\"Express.js\",\"Next.js\",\"FastAPI\"]},\n" +
//                        "    {\"category\":\"Platform & Tools\",\"items\":[\"AWS\",\"git\",\"maven\",\"Nginx\",\"Docker\",\"Kubernetes\",\"Spark\",\"Kafka\"]},\n" +
//                        "    {\"category\":\"Databases\",\"items\":[\"PostgreSQL\",\"MySQL\",\"Redis\",\"MongoDB\",\"Neo4j\"]},\n" +
//                        "    {\"category\":\"Knowledges\",\"items\":[\"OOP/OOD\",\"Agile\",\"Scrum\",\"Linux\",\"CI/CD\",\"Algorithms\",\"Design Patterns\"]}\n" +
//                        "],\n" +
//                        "\"projects\":[\n" +
//                        "    {\"title\":\"CVCopilot\",\"techStack\":[\"React\",\"Node.js\",\"MongoDB\",\"AWS\"],\"startDate\":\"June 2020\",\"endDate\":\"Present\",\"description\":\"A web application that helps you create a professional CV and cover letter in minutes\",\"link\":\"https://www.cvcopilot.com\"},\n" +
//                        "    {\"title\":\"YelpCamp\",\"techStack\":[\"Express.js\",\"MongoDB\",\"Bootstrap\"],\"startDate\":\"June 2020\",\"endDate\":\"August 2020\",\"description\":\"A web application that allows users to create and review campgrounds\"},\n" +
//                        "    {\"title\":\"codeShare\",\"techStack\":[\"React\",\"Node.js\",\"Socket.io\"],\"startDate\":\"June 2020\",\"endDate\":\"August 2020\",\"description\":\"A web application that allows users to share code in real-time\"}\n" +
//                        "],\n" +
//                        "\"workExperience\":[\n" +
//                        "    {\"title\":\"Software Development Engineer\",\"company\":\"Amazon\",\"type\":\"Full-time\",\"startDate\":\"June 2021\",\"endDate\":\"September 2021\",\"description\":\"Developed a web application to automate the process of creating and managing Amazon's internal documentation using React, Node.js, and AWS Lambda             Improved the user experience by implementing a new UI design and adding new features             Increased the efficiency of the application by 50% by optimizing the backend code\"},\n" +
//                        "    {\"title\":\"Software Engineer Intern\",\"company\":\"Google\",\"type\":\"Internship\",\"startDate\":\"June 2020\",\"endDate\":\"September 2020\",\"description\":\"Develop and maintain web applications using React, Node.js, and Firebase             Collaborate with cross-functional teams to design and implement new features             Optimize application performance and scalability\"}\n" +
//                        "    ],\n" +
//                        "\"education\":[\n" +
//                        "    {\"school\":\"Harvard University\",\"degree\":\"MS in Computer Science\",\"start\":\"2019\",\"end\":\"2021\"},\n" +
//                        "    {\"school\":\"Stanford University\",\"degree\":\"BS in Computer Science\",\"start\":\"2015\",\"end\":\"2019\"}\n" +
//                        "]" +
//                        "according to the job description and the information i provided, generate and polish a resume to me." +
//                        "The resume should include education, skills, work Experience, and my project from my information and best match the job description."+
//                        "Generate resume.{}")
//                .prompt("who am i")
//                .model("ada")
//                .echo(true)
//                .build();
//        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
//        System.out.println(service.listModels());
    }
}

