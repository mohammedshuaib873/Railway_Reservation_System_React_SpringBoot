import React from 'react'
import { Button } from "react-bootstrap";

function Showcase() {
  return (
    <div className='hero-container'>
      <video src='/videos/Railway.mp4' autoPlay loop muted />
    </div>
  );
}

export default Showcase;

