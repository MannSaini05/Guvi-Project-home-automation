import React, { useState } from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const Dashboard = () => {
  const [devices, setDevices] = useState([
    { id: 1, name: 'Living Room Light', status: 'On' },
    { id: 2, name: 'Fan', status: 'Off' },
    { id: 3, name: 'Air Conditioner', status: 'On' },
  ]);
  const navigate = useNavigate();

  // Function to handle device state toggling (on/off)
  const toggleDeviceStatus = (deviceId) => {
    setDevices(devices.map(device => 
      device.id === deviceId ? { ...device, status: device.status === 'On' ? 'Off' : 'On' } : device
    ));
  };

  // Simulated Logout function
  const handleLogout = () => {
    // Reset user data or session here if necessary
    navigate('/login');  // Redirect back to login page
  };

  return (
    <Container>
      <Row className="justify-content-md-center">
        <Col xs={12} md={8}>
          <h2 className="text-center mb-4">Dashboard</h2>

          <Card className="mb-4">
            <Card.Header as="h5">Welcome, User</Card.Header>
            <Card.Body>
              <Card.Text>
                This is your home automation dashboard. You can control and monitor all connected appliances here.
              </Card.Text>
            </Card.Body>
          </Card>

          <h4>Your Appliances:</h4>
          {devices.map((device) => (
            <Card key={device.id} className="mb-2">
              <Card.Body className="d-flex justify-content-between align-items-center">
                <div>
                  <Card.Title>{device.name}</Card.Title>
                  <Card.Text>Status: {device.status}</Card.Text>
                </div>
                <Button 
                  variant={device.status === 'On' ? 'danger' : 'success'}
                  onClick={() => toggleDeviceStatus(device.id)}
                >
                  {device.status === 'On' ? 'Turn Off' : 'Turn On'}
                </Button>
              </Card.Body>
            </Card>
          ))}

          <Button variant="secondary" onClick={handleLogout} className="w-100 mt-4">
            Log Out
          </Button>
        </Col>
      </Row>
    </Container>
  );
};

export default Dashboard;
