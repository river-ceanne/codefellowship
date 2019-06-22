# Codefellowship - Spring Authorization

This repository includes some basic implementation of Spring Authorization on a Java Web Application.

## Starter Guide:
1. To run the server application, clone down this repo.
2. 'cd' into the cloned repository in your terminal
3. Make sure you have modified the applicaton.properties file with your own environment variables: 

        spring.datasource.url=${DATABASE_URL}
        spring.datasource.username=${DATABASE_USERNAME}
        spring.datasource.password=${DATABASE_PASSWORD}
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
        server.port=5000
        
4. Run the command: 
    
        ./gradlew bootrun
        
#### Deployed version
    
    http://codefellowship-env.iejaunm2ph.us-east-2.elasticbeanstalk.com/

## Classes
- AppUser
- AppUserController
- CodefellowshipApplication
- CodefellowshipController
- UserDetailServiceImpl
- WebSecurityConfig
- Post
- PostController

## Interfaces
- AppUserRepository
- PostRepository

## Routes/API

#### CodefellowshipController

- @GetMapping("/")
      
      public String getCodefellowship(Principal p, Model m)
      
#### AppUserController

- @PostMapping("/usercreate")
     
       public RedirectView createUser(String username, String password, String dob, String firstname, String lastname, String bio)

- @GetMapping("/login")
      
        public String getLoginPage() 
        
- @GetMapping("/signup")
     
      public String getSignUpPage()
      
- @GetMapping("/myprofile")
      
      public String getMyProfilePage(Principal p, Model m)
      
- @GetMapping("/users/{id}")
      
      public String getSingleAppUserPage(Model m, @PathVariable String id) 

- @GetMapping("/users")

      public String getUsersPage(Principal p, Model m)

-  @GetMapping("/following")

        public String getFollowingPage(Principal p, Model m) 
        
- @PostMapping("/follow/{id}")

      public RedirectView followUser(Principal p, @PathVariable long id)
      
#### PostController      
- @PostMapping("/posts")
     
      public RedirectView createPost(Principal p, Model m, String body)
      
- @GetMapping("/post")
      
      public String getPostPage() 
      
- @GetMapping("/feed")

      public String getFeedPage(Principal p, Model m)
