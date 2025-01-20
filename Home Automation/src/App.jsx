import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import Login from './components/login';
import Signup from './components/Signup';
import Dashboard from './components/Dashboard';
import Header from './components/Navbar';  // Import the Navbar

const App = () => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);  // Track user's login state

  // Handle user logout
  const handleLogout = () => {
    setIsAuthenticated(false);
  };

  return (
    <Router>
      <Header isAuthenticated={isAuthenticated} handleLogout={handleLogout} />  {/* Include Header */}
      
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login setIsAuthenticated={setIsAuthenticated} />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/dashboard" element={isAuthenticated ? <Dashboard /> : <Login />} />  {/* Conditional dashboard access */}
      </Routes>
    </Router>
  );
};

export default App;
