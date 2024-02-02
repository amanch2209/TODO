# TODO
This is a full stack application which allows to create you personalised TODO tasks list. It consists of various components which allows smooth user interaction. It is made up of different layers such as the presentation layer is made using react (module of javascript) and the backend layer is made using springboot (framework of Java). Let us see what are the features that this application offers to its users.

## Application Features

The application allows users to interact and create a list for their TODO tasks along with it's due data. It is not only restricted to creating list but provides following features as well :

### 1) Add Task : 

The application allows you to add multiple tasks to your task and you can create multiple lists.

### 2) Edit Tasks :

Apart from just adding your task to the list you can edit the task as well.

### 3) Delete Tasks :

Upon completion of the task you can even delete the task from the application.

### 4) Marking Tasks as Completed :

The application allows you to change the status of your task as completed or incompleted depending upon your progress.

### Additional Features :

The application has a user authentication system so that the user can login to their session and can maintain their task list. This will allow only the authenticated users to login into the portal.

## Prerequisites 

1) Java Development Kit (prefereably JDK 17)(LTS)

2) Apache Maven (I used version 3.9.6)

3) NodeJS and npm installed to initiate the frontend

## How to run the application locally?

### To run the backend made on Spring-Boot :

Step 1 : Clone The Repository

```bash
https://github.com/amanch2209/TODO.git
```

Step 2 : Change the directory to backend_todo
```bash
cd backend_todo
```

Step 3 : Run the application using maven
```bash
mvn spring-boot:run
```

### To run the frontend made on React :

Step 1 : Install npm if you haven't
```bash
npm install
```

Step 2 : Change the directoty to frontend_todo
```bash
cd frontend_todo
```

Step 3 : Start the application using npm
```bash
npm start
```

## Future Work :
1) Prioritize the task depending on their due dates.
2) Improve the Interactiion process. 
3) Deploy the application.
   

