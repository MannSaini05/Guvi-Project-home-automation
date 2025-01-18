import React from 'react';
import { Container, Row, Col, Button, Jumbotron } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';  // Navigation for redirects

const Home = () => {
  const navigate = useNavigate();

  const handleLoginRedirect = () => {
    navigate('/login');  // Navigate to the login page
  };

  const handleSignupRedirect = () => {
    navigate('/signup');  // Navigate to the signup page
  };

  return (
    <Container fluid>
      {/* Jumbotron-style hero section */}
      <Row className="justify-content-center align-items-center" style={{ height: '100vh' }}>
        <Col xs={12} md={8} className="text-center">
          <Jumbotron>
            <h1>Welcome to Your Home Automation System</h1>
            <p>
              Manage your home appliances with ease, monitor energy usage, and automate tasks in real-time.
            </p>
            <p>
              Take control of your smart devices like lights, fans, and air conditioners from anywhere.
            </p>
            <div>
              {/* Call-to-action buttons */}
              <Button variant="primary" size="lg" className="mx-2" onClick={handleLoginRedirect}>
                Login
              </Button>
              <Button variant="secondary" size="lg" className="mx-2" onClick={handleSignupRedirect}>
                Sign Up
              </Button>
            </div>
          </Jumbotron>
        </Col>
      </Row>

      {/* Footer */}
      <footer style={{ textAlign: 'center', padding: '20px', backgroundColor: '#f1f1f1' }}>
        <p>&copy; 2025 Home Automation System. All Rights Reserved.</p>
      </footer>
    </Container>
  );
};

export default Home;
