import React, { useState } from 'react';
import { Button, Form, Container, Row, Col } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { validateEmail, validatePassword } from "../../utils/validation";


const Login = ({ setIsAuthenticated }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await fetch("http://localhost:8080/signup", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded",
        },
        body: new URLSearchParams(formData), // Converts object to form-encoded string
    });
    const result = await response.json();
    console.log(result);



    if (!email || !password) {
      setLoading(false);
      setError('Both fields are required!');
      return;
    }

    // Simulating backend authentication (use real API call for production)
    setTimeout(() => {
      if (email === 'user@example.com' && password === 'password123') {
        setLoading(false);
        setIsAuthenticated(true);  // Mark user as authenticated
        navigate('/dashboard');     // Redirect to dashboard
      } else {
        setLoading(false);
        setError('Invalid email or password');
      }
    }, 1500);  // Simulating network delay
  };

  return (
    <Container>
      <Row className="justify-content-md-center">
        <Col xs={12} md={6}>
          <h2 className="text-center mb-4">Login</h2>
          {error && <p className="text-danger text-center">{error}</p>}

          <Form onSubmit={handleLoginSubmit}>
            <Form.Group controlId="formEmail">
              <Form.Label>Email address</Form.Label>
              <Form.Control 
                type="email" 
                placeholder="Enter email" 
                value={email}
                onChange={(e) => setEmail(e.target.value)} 
                required
              />
            </Form.Group>

            <Form.Group controlId="formPassword">
              <Form.Label>Password</Form.Label>
              <Form.Control 
                type="password" 
                placeholder="Enter password" 
                value={password}
                onChange={(e) => setPassword(e.target.value)} 
                required
              />
            </Form.Group>

            <Button variant="primary" type="submit" className="w-100" disabled={loading}>
              {loading ? 'Logging in...' : 'Log In'}
            </Button>
          </Form>
        </Col>
      </Row>
    </Container>
  );
};

export default Login;
ag