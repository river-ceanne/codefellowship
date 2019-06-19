# Codefellowship - Spring Authorization

This repository includes some basic implementation of Spring Authorization on a Java Web Application.

## Starter Guide:
1. To run the server application, clone down this repo.
2. 'cd' into the cloned repository in your terminal
3. Run the command: 
    
        ./gradlew bootrun

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

- @GetMapping("/")
      
      public String getCodefellowship(Principal p, Model m)

- @PostMapping("/users")
     
       public RedirectView createUser(String username, String password, String dob, String firstname, String lastname, String bio)

- @GetMapping("/login")
      
        public String getLoginPage() 
        
- @GetMapping("/signup")
     
      public String getSignUpPage()
      
- @GetMapping("/myprofile")
      
      public String getMyProfilePage(Principal p, Model m)
      
- @GetMapping("/users/{id}")
      
      public String getSingleAppUserPage(Model m, @PathVariable String id) 
      
- @PostMapping("/posts")
     
      public RedirectView createPost(Principal p, Model m, String body)
      
- @GetMapping("/post")
      
      public String getPostPage() 
