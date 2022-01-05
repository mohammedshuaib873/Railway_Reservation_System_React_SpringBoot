import "bootstrap/dist/css/bootstrap.min.css";
import React from 'react'
import { Link } from 'react-router-dom'

const Header = () => {
  return (
    <header className='header'>
      <div>
        <Link className='links' to='/'>
          <p className="train-icon"><b>TRAINMANTRA.COM <i class="fa fa-train" aria-hidden="true"></i></b>  </p>
        </Link>
      </div>
      <nav className='navbar'>
        <ul>
        <Link className='links' to='/'>
            HOME
          </Link>
          <Link className='links' to='/login'>
            ADMIN
          </Link>

          <Link className='links' to='/search'>
            SEARCH
          </Link>

          <Link className='links' to='/userregistration'>
            REGISTER
          </Link>

          <Link className='links' to='/userlogin'>
            LOGIN
          </Link>
    
        </ul>
      </nav>
    </header>
  )
}

export default Header
