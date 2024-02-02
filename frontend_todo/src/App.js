import React, { useEffect, useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Header from './Components/header';
import About from './Components/about';
import ViewList from './Components/viewList';
import AddTodo from './Components/addTodo';
import UpdateTodo from './Components/updateTodo';
import Signin from './Components/signin';
import Signup from './Components/signup';
import Signout from './Components/signout';
import Landing from './Components/landing';
import NotFound from './Components/notFound';

import './bootstrap.min.css';
import './App.css';

function App () {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    if(sessionStorage.getItem('token') !== null){
      setIsAuthenticated(true);
    }
  }, [])

  return (
    <BrowserRouter>
    <div className="App">
      <Header isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />
      <div>
        <Routes>
          <Route exact path="/" render={(props) => (<Landing {...props} isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />)} />
          <Route exact path="/signin" render={(props) => (<Signin {...props} isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />)} />
          <Route exact path="/signup" render={(props) => (<Signup {...props} isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />)} />
          <Route exact path="/signout" render={(props) => (<Signout {...props} isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />)} />
          <Route exact path="/todo" render={(props) => (<ViewList {...props} isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />)} />
          <Route exact path="/add" render={(props) => (<AddTodo {...props} isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />)} />
          <Route exact path="/update/:id" render={(props) => (<UpdateTodo {...props} isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />)} />
          <Route exact path="/about" component={About} />
          <Route component={NotFound} />
        </Routes>
      </div>
    </div>
    </BrowserRouter>
  );
}

export default App;